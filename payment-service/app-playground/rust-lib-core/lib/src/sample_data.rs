
use std::collections::BTreeMap;
use crate::TeaqlRuntime;
use crate::Q;
use teaql_core::Entity;
use crate::request_support::TeaqlUserContextExt;
use crate::request_support::AuditedSave;

pub trait IntoU64 {
    fn into_u64(self) -> u64;
}

impl IntoU64 for u64 {
    fn into_u64(self) -> u64 {
        self
    }
}

impl IntoU64 for Option<&teaql_core::Value> {
    fn into_u64(self) -> u64 {
        self.and_then(|v| v.try_u64()).unwrap_or_default()
    }
}

#[derive(Debug, Copy, Clone)]
pub enum SampleDataScale {
    Tiny,
    Small,
    Medium,
}

pub struct SampleDataPlan {
    pub scale: SampleDataScale,
    pub seed: u64,
}

impl SampleDataPlan {
    pub fn small() -> Self {
        Self {
            scale: SampleDataScale::Small,
            seed: 0,
        }
    }
}

pub struct SampleDataReport {
    pub generated: BTreeMap<&'static str, usize>,
    pub skipped: Vec<SampleDataSkipped>,
}

pub struct SampleDataSkipped {
    pub entity: &'static str,
    pub reason: String,
}

pub struct SampleDataState {
    pub plan: SampleDataPlan,
    pub references: BTreeMap<&'static str, Vec<u64>>,
    pub generated: BTreeMap<&'static str, usize>,
    pub skipped: Vec<SampleDataSkipped>,
}

impl SampleDataState {
    pub fn new(plan: SampleDataPlan) -> Self {
        Self {
            plan,
            references: BTreeMap::new(),
            generated: BTreeMap::new(),
            skipped: Vec::new(),
        }
    }

    pub fn add_reference(&mut self, entity: &'static str, id: u64) {
        self.references.entry(entity).or_default().push(id);
    }

    pub fn ids(&self, entity: &'static str) -> &[u64] {
        self.references.get(entity).map(|v| v.as_slice()).unwrap_or(&[])
    }

    pub fn pick_id(&self, entity: &'static str, salt: usize) -> Option<u64> {
        let ids = self.ids(entity);
        if ids.is_empty() {
            None
        } else {
            Some(ids[salt % ids.len()])
        }
    }

    pub fn pick_unused_id(&self, entity: &'static str, salt: usize, used: &std::collections::HashSet<u64>) -> Option<u64> {
        let ids = self.ids(entity);
        if ids.is_empty() {
            return None;
        }

        let best_id = ids[salt % ids.len()];
        if !used.contains(&best_id) {
            return Some(best_id);
        }

        for id in ids {
            if !used.contains(id) {
                return Some(*id);
            }
        }

        Some(best_id)
    }

    pub fn record_generated(&mut self, entity: &'static str) {
        *self.generated.entry(entity).or_default() += 1;
    }

    pub fn record_skipped(&mut self, entity: &'static str, reason: String) {
        self.skipped.push(SampleDataSkipped { entity, reason });
    }

    pub fn into_report(self) -> SampleDataReport {
        SampleDataReport {
            generated: self.generated,
            skipped: self.skipped,
        }
    }
}

pub async fn generate_sample_data<C>(
    ctx: &C,
    plan: SampleDataPlan,
) -> Result<SampleDataReport, String>
where
    C: TeaqlRuntime + ?Sized + crate::TeaqlRepositoryProvider,
{
    log::info!("Starting sample data generation. Scale: {:?}, Seed: {}", plan.scale, plan.seed);
    let mut state = SampleDataState::new(plan);

    load_root_companies(ctx, &mut state).await?; //depth: 0

    load_constant_move_order_statuses(ctx, &mut state).await?;

    ctx.user_context().transaction_data(|| async {
        Box::pin(generate_customers(ctx, &mut state)).await.map_err(|e| {
            teaql_runtime::DataServiceError::Runtime(teaql_runtime::RuntimeError::Graph(e))
        })
    }).await.map_err(|e| e.to_string())?;

    ctx.user_context().transaction_data(|| async {
        Box::pin(generate_drivers(ctx, &mut state)).await.map_err(|e| {
            teaql_runtime::DataServiceError::Runtime(teaql_runtime::RuntimeError::Graph(e))
        })
    }).await.map_err(|e| e.to_string())?;

    ctx.user_context().transaction_data(|| async {
        Box::pin(generate_vehicles(ctx, &mut state)).await.map_err(|e| {
            teaql_runtime::DataServiceError::Runtime(teaql_runtime::RuntimeError::Graph(e))
        })
    }).await.map_err(|e| e.to_string())?;

    ctx.user_context().transaction_data(|| async {
        Box::pin(generate_move_orders(ctx, &mut state)).await.map_err(|e| {
            teaql_runtime::DataServiceError::Runtime(teaql_runtime::RuntimeError::Graph(e))
        })
    }).await.map_err(|e| e.to_string())?;

    ctx.user_context().transaction_data(|| async {
        Box::pin(generate_invoices(ctx, &mut state)).await.map_err(|e| {
            teaql_runtime::DataServiceError::Runtime(teaql_runtime::RuntimeError::Graph(e))
        })
    }).await.map_err(|e| e.to_string())?;

    ctx.user_context().transaction_data(|| async {
        Box::pin(generate_reviews(ctx, &mut state)).await.map_err(|e| {
            teaql_runtime::DataServiceError::Runtime(teaql_runtime::RuntimeError::Graph(e))
        })
    }).await.map_err(|e| e.to_string())?;


    let report = state.into_report();
    log::info!("Sample data generation completed successfully. Generated: {} tables, Skipped: {} tables.", report.generated.len(), report.skipped.len());
    Ok(report)
}

async fn load_root_companies<C>(
    ctx: &C,
    state: &mut SampleDataState,
) -> Result<(), String>
where
    C: TeaqlRuntime + ?Sized + crate::TeaqlRepositoryProvider,
{
    let list = Q::companies().purpose("Init Sample Data").execute_for_list(ctx).await.unwrap_or_default();
    for item in list {
        state.add_reference("Moving Company", item.id().into_u64());
    }
    Ok(())
}

async fn load_constant_move_order_statuses<C>(
    ctx: &C,
    state: &mut SampleDataState,
) -> Result<(), String>
where
    C: TeaqlRuntime + ?Sized + crate::TeaqlRepositoryProvider,
{
    let list = Q::move_order_statuses().purpose("Init Sample Data").execute_for_list(ctx).await.unwrap_or_default();
    for item in list {
        state.add_reference("Move Order Status", item.id().into_u64());
    }
    Ok(())
}

async fn generate_customers<C>(
    ctx: &C,
    state: &mut SampleDataState,
) -> Result<(), String>
where
    C: TeaqlRuntime + ?Sized + crate::TeaqlRepositoryProvider,
{
        if state.ids("Moving Company").is_empty() {
            state.record_skipped("Customer", "Required dependency Moving Company is missing in reference pool".to_string());
            log::info!("Skipped generating Customer: Required dependency Moving Company is missing in reference pool.");
            return Ok(());
        }


    let object_fields_count = 0 + 1;
    let base_fanout = std::cmp::max(1, object_fields_count) * 20;

    let fanout = match state.plan.scale {
        SampleDataScale::Tiny => base_fanout,
        SampleDataScale::Small => base_fanout * 5,
        SampleDataScale::Medium => base_fanout * 50,
    };

    log::info!("Generating sample data for Customer (expected: {})...", fanout);

    for i in 0..fanout {
        let mut entity = Q::customers().purpose("Init Sample Data").new_entity(ctx);
        let mut used_refs = std::collections::HashSet::new();

                if let Some(ref_id) = state.pick_unused_id("Moving Company", i as usize, &used_refs) {
                    entity.update_company_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                entity.update_full_name(format!("{} {}", "Jane Doe", i + 1));

                entity.update_email(format!("{} {}", "jane.doe@example.com", i + 1));

                entity.update_phone(format!("{} {}", "555-0201", i + 1));

                entity.update_address(format!("{} {}", "456 Oak Street", i + 1));

                entity.update_password_hash(format!("{} {}", "hashed_secret_value", i + 1));

                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_create_time(past.format("%Y-%m-%d").to_string());
                }

                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_update_time(past.format("%Y-%m-%d").to_string());
                }



        let entity = entity.audit_as("Init Sample Data").save(ctx).await.map_err(|e| e.to_string())?;

        state.record_generated("Customer");

        if i % 20 == 0 {
            log::info!("Generating Customer: {}/{}", i, fanout);
        }

        state.add_reference("Customer", entity.id().into_u64());
    }

    log::info!("Successfully generated sample records for Customer.");
    Ok(())
}


async fn generate_drivers<C>(
    ctx: &C,
    state: &mut SampleDataState,
) -> Result<(), String>
where
    C: TeaqlRuntime + ?Sized + crate::TeaqlRepositoryProvider,
{
        if state.ids("Moving Company").is_empty() {
            state.record_skipped("Driver", "Required dependency Moving Company is missing in reference pool".to_string());
            log::info!("Skipped generating Driver: Required dependency Moving Company is missing in reference pool.");
            return Ok(());
        }


    let object_fields_count = 0 + 1;
    let base_fanout = std::cmp::max(1, object_fields_count) * 20;

    let fanout = match state.plan.scale {
        SampleDataScale::Tiny => base_fanout,
        SampleDataScale::Small => base_fanout * 5,
        SampleDataScale::Medium => base_fanout * 50,
    };

    log::info!("Generating sample data for Driver (expected: {})...", fanout);

    for i in 0..fanout {
        let mut entity = Q::drivers().purpose("Init Sample Data").new_entity(ctx);
        let mut used_refs = std::collections::HashSet::new();

                if let Some(ref_id) = state.pick_unused_id("Moving Company", i as usize, &used_refs) {
                    entity.update_company_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                entity.update_full_name(format!("{} {}", "John Smith", i + 1));

                entity.update_email(format!("{} {}", "john.smith@swiftmovers.example.com", i + 1));

                entity.update_phone(format!("{} {}", "555-0301", i + 1));

                entity.update_license_number(format!("{} {}", "IL-DRV-12345", i + 1));

                entity.update_password_hash(format!("{} {}", "hashed_driver_secret", i + 1));

                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_create_time(past.format("%Y-%m-%d").to_string());
                }

                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_update_time(past.format("%Y-%m-%d").to_string());
                }



        let entity = entity.audit_as("Init Sample Data").save(ctx).await.map_err(|e| e.to_string())?;

        state.record_generated("Driver");

        if i % 20 == 0 {
            log::info!("Generating Driver: {}/{}", i, fanout);
        }

        state.add_reference("Driver", entity.id().into_u64());
    }

    log::info!("Successfully generated sample records for Driver.");
    Ok(())
}


async fn generate_vehicles<C>(
    ctx: &C,
    state: &mut SampleDataState,
) -> Result<(), String>
where
    C: TeaqlRuntime + ?Sized + crate::TeaqlRepositoryProvider,
{
        if state.ids("Moving Company").is_empty() {
            state.record_skipped("Vehicle", "Required dependency Moving Company is missing in reference pool".to_string());
            log::info!("Skipped generating Vehicle: Required dependency Moving Company is missing in reference pool.");
            return Ok(());
        }


    let object_fields_count = 0 + 1;
    let base_fanout = std::cmp::max(1, object_fields_count) * 20;

    let fanout = match state.plan.scale {
        SampleDataScale::Tiny => base_fanout,
        SampleDataScale::Small => base_fanout * 5,
        SampleDataScale::Medium => base_fanout * 50,
    };

    log::info!("Generating sample data for Vehicle (expected: {})...", fanout);

    for i in 0..fanout {
        let mut entity = Q::vehicles().purpose("Init Sample Data").new_entity(ctx);
        let mut used_refs = std::collections::HashSet::new();

                if let Some(ref_id) = state.pick_unused_id("Moving Company", i as usize, &used_refs) {
                    entity.update_company_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                entity.update_plate_number(format!("{} {}", "IL-MV-1234", i + 1));

                entity.update_vehicle_type(format!("{} {}", "box truck", i + 1));

                {
                    let max_val: u64 = "1200".parse().unwrap_or(1000);
                    let rand_val = (i as u64 + state.plan.seed) % max_val.max(1) + 1;
                    entity.update_capacity_cubic_feet(rand_val as i64);
                }


                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_create_time(past.format("%Y-%m-%d").to_string());
                }

                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_update_time(past.format("%Y-%m-%d").to_string());
                }



        let entity = entity.audit_as("Init Sample Data").save(ctx).await.map_err(|e| e.to_string())?;

        state.record_generated("Vehicle");

        if i % 20 == 0 {
            log::info!("Generating Vehicle: {}/{}", i, fanout);
        }

        state.add_reference("Vehicle", entity.id().into_u64());
    }

    log::info!("Successfully generated sample records for Vehicle.");
    Ok(())
}


async fn generate_move_orders<C>(
    ctx: &C,
    state: &mut SampleDataState,
) -> Result<(), String>
where
    C: TeaqlRuntime + ?Sized + crate::TeaqlRepositoryProvider,
{
        if state.ids("Moving Company").is_empty() {
            state.record_skipped("Move Order", "Required dependency Moving Company is missing in reference pool".to_string());
            log::info!("Skipped generating Move Order: Required dependency Moving Company is missing in reference pool.");
            return Ok(());
        }

        if state.ids("Customer").is_empty() {
            state.record_skipped("Move Order", "Required dependency Customer is missing in reference pool".to_string());
            log::info!("Skipped generating Move Order: Required dependency Customer is missing in reference pool.");
            return Ok(());
        }

        if state.ids("Driver").is_empty() {
            state.record_skipped("Move Order", "Required dependency Driver is missing in reference pool".to_string());
            log::info!("Skipped generating Move Order: Required dependency Driver is missing in reference pool.");
            return Ok(());
        }

        if state.ids("Vehicle").is_empty() {
            state.record_skipped("Move Order", "Required dependency Vehicle is missing in reference pool".to_string());
            log::info!("Skipped generating Move Order: Required dependency Vehicle is missing in reference pool.");
            return Ok(());
        }

        if state.ids("Move Order Status").is_empty() {
            state.record_skipped("Move Order", "Required dependency Move Order Status is missing in reference pool".to_string());
            log::info!("Skipped generating Move Order: Required dependency Move Order Status is missing in reference pool.");
            return Ok(());
        }


    let object_fields_count = 0 + 1 + 1 + 1 + 1 + 1;
    let base_fanout = std::cmp::max(1, object_fields_count) * 20;

    let fanout = match state.plan.scale {
        SampleDataScale::Tiny => base_fanout,
        SampleDataScale::Small => base_fanout * 5,
        SampleDataScale::Medium => base_fanout * 50,
    };

    log::info!("Generating sample data for Move Order (expected: {})...", fanout);

    for i in 0..fanout {
        let mut entity = Q::move_orders().purpose("Init Sample Data").new_entity(ctx);
        let mut used_refs = std::collections::HashSet::new();

                if let Some(ref_id) = state.pick_unused_id("Moving Company", i as usize, &used_refs) {
                    entity.update_company_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                if let Some(ref_id) = state.pick_unused_id("Customer", i as usize, &used_refs) {
                    entity.update_customer_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                if let Some(ref_id) = state.pick_unused_id("Driver", i as usize, &used_refs) {
                    entity.update_driver_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                if let Some(ref_id) = state.pick_unused_id("Vehicle", i as usize, &used_refs) {
                    entity.update_vehicle_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                if let Some(ref_id) = state.pick_unused_id("Move Order Status", i as usize, &used_refs) {
                    entity.update_status_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                entity.update_origin_address(format!("{} {}", "456 Oak Street", i + 1));

                entity.update_destination_address(format!("{} {}", "789 Pine Avenue", i + 1));

                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_scheduled_date(past.format("%Y-%m-%d").to_string());
                }

                {
                    let max_val: u64 = "6".parse().unwrap_or(1000);
                    let rand_val = (i as u64 + state.plan.seed) % max_val.max(1) + 1;
                    entity.update_estimated_hours(rand_val as i64);
                }

                entity.update_special_instructions(format!("{} {}", "Piano requires special handling", i + 1));

                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_create_time(past.format("%Y-%m-%d").to_string());
                }

                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_update_time(past.format("%Y-%m-%d").to_string());
                }



        let entity = entity.audit_as("Init Sample Data").save(ctx).await.map_err(|e| e.to_string())?;

        state.record_generated("Move Order");

        if i % 20 == 0 {
            log::info!("Generating Move Order: {}/{}", i, fanout);
        }

        state.add_reference("Move Order", entity.id().into_u64());
    }

    log::info!("Successfully generated sample records for Move Order.");
    Ok(())
}


async fn generate_invoices<C>(
    ctx: &C,
    state: &mut SampleDataState,
) -> Result<(), String>
where
    C: TeaqlRuntime + ?Sized + crate::TeaqlRepositoryProvider,
{
        if state.ids("Moving Company").is_empty() {
            state.record_skipped("Invoice", "Required dependency Moving Company is missing in reference pool".to_string());
            log::info!("Skipped generating Invoice: Required dependency Moving Company is missing in reference pool.");
            return Ok(());
        }

        if state.ids("Move Order").is_empty() {
            state.record_skipped("Invoice", "Required dependency Move Order is missing in reference pool".to_string());
            log::info!("Skipped generating Invoice: Required dependency Move Order is missing in reference pool.");
            return Ok(());
        }

        if state.ids("Customer").is_empty() {
            state.record_skipped("Invoice", "Required dependency Customer is missing in reference pool".to_string());
            log::info!("Skipped generating Invoice: Required dependency Customer is missing in reference pool.");
            return Ok(());
        }


    let object_fields_count = 0 + 1 + 1 + 1;
    let base_fanout = std::cmp::max(1, object_fields_count) * 20;

    let fanout = match state.plan.scale {
        SampleDataScale::Tiny => base_fanout,
        SampleDataScale::Small => base_fanout * 5,
        SampleDataScale::Medium => base_fanout * 50,
    };

    log::info!("Generating sample data for Invoice (expected: {})...", fanout);

    for i in 0..fanout {
        let mut entity = Q::invoices().purpose("Init Sample Data").new_entity(ctx);
        let mut used_refs = std::collections::HashSet::new();

                if let Some(ref_id) = state.pick_unused_id("Moving Company", i as usize, &used_refs) {
                    entity.update_company_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                if let Some(ref_id) = state.pick_unused_id("Move Order", i as usize, &used_refs) {
                    entity.update_move_order_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                if let Some(ref_id) = state.pick_unused_id("Customer", i as usize, &used_refs) {
                    entity.update_customer_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                entity.update_invoice_number(format!("{} {}", "INV-2025-0001", i + 1));

                {
                    let max_val: u64 = "1500.00".parse().unwrap_or(1000);
                    let rand_val = (i as u64 + state.plan.seed) % max_val.max(1) + 1;
                    entity.update_total_amount(rand_val as i64);
                }

                {
                    let max_val: u64 = "0.00".parse().unwrap_or(1000);
                    let rand_val = (i as u64 + state.plan.seed) % max_val.max(1) + 1;
                    entity.update_paid_amount(rand_val as i64);
                }


                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_due_date(past.format("%Y-%m-%d").to_string());
                }

                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_create_time(past.format("%Y-%m-%d").to_string());
                }

                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_update_time(past.format("%Y-%m-%d").to_string());
                }



entity.audit_as("Init Sample Data").save(ctx).await.map_err(|e| e.to_string())?;

        state.record_generated("Invoice");

        if i % 20 == 0 {
            log::info!("Generating Invoice: {}/{}", i, fanout);
        }

    }

    log::info!("Successfully generated sample records for Invoice.");
    Ok(())
}


async fn generate_reviews<C>(
    ctx: &C,
    state: &mut SampleDataState,
) -> Result<(), String>
where
    C: TeaqlRuntime + ?Sized + crate::TeaqlRepositoryProvider,
{
        if state.ids("Moving Company").is_empty() {
            state.record_skipped("Review", "Required dependency Moving Company is missing in reference pool".to_string());
            log::info!("Skipped generating Review: Required dependency Moving Company is missing in reference pool.");
            return Ok(());
        }

        if state.ids("Move Order").is_empty() {
            state.record_skipped("Review", "Required dependency Move Order is missing in reference pool".to_string());
            log::info!("Skipped generating Review: Required dependency Move Order is missing in reference pool.");
            return Ok(());
        }

        if state.ids("Customer").is_empty() {
            state.record_skipped("Review", "Required dependency Customer is missing in reference pool".to_string());
            log::info!("Skipped generating Review: Required dependency Customer is missing in reference pool.");
            return Ok(());
        }


    let object_fields_count = 0 + 1 + 1 + 1;
    let base_fanout = std::cmp::max(1, object_fields_count) * 20;

    let fanout = match state.plan.scale {
        SampleDataScale::Tiny => base_fanout,
        SampleDataScale::Small => base_fanout * 5,
        SampleDataScale::Medium => base_fanout * 50,
    };

    log::info!("Generating sample data for Review (expected: {})...", fanout);

    for i in 0..fanout {
        let mut entity = Q::reviews().purpose("Init Sample Data").new_entity(ctx);
        let mut used_refs = std::collections::HashSet::new();

                if let Some(ref_id) = state.pick_unused_id("Moving Company", i as usize, &used_refs) {
                    entity.update_company_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                if let Some(ref_id) = state.pick_unused_id("Move Order", i as usize, &used_refs) {
                    entity.update_move_order_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                if let Some(ref_id) = state.pick_unused_id("Customer", i as usize, &used_refs) {
                    entity.update_customer_id(ref_id);
                    used_refs.insert(ref_id);
                } else {
                    // Optional relation was missing in reference pool
                }
                {
                    let max_val: u64 = "5".parse().unwrap_or(1000);
                    let rand_val = (i as u64 + state.plan.seed) % max_val.max(1) + 1;
                    entity.update_rating(rand_val as i64);
                }

                entity.update_comment(format!("{} {}", "Excellent service", i + 1));

                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_create_time(past.format("%Y-%m-%d").to_string());
                }

                {
                    let days = ((i as u64 + state.plan.seed) % (365 * 3)) as i64;
                    let past = chrono::Utc::now().naive_utc() - chrono::Duration::try_days(days).unwrap_or_default();
                    entity.update_update_time(past.format("%Y-%m-%d").to_string());
                }



entity.audit_as("Init Sample Data").save(ctx).await.map_err(|e| e.to_string())?;

        state.record_generated("Review");

        if i % 20 == 0 {
            log::info!("Generating Review: {}/{}", i, fanout);
        }

    }

    log::info!("Successfully generated sample records for Review.");
    Ok(())
}
