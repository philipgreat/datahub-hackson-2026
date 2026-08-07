
use teaql_runtime::EntityDataServiceBehavior;

#[derive(Clone, Debug, Default)]
pub struct PaymentBehavior;

impl EntityDataServiceBehavior for PaymentBehavior {
    // --- 自动生成的拦截器逻辑 (由 TeaQL 引擎根据 _idempotency_key 和 _max_amount 标签生成) ---
    /*
    async fn pre_save(&self, ctx: &teaql_runtime::Context, entity: &mut super::entity::PaymentTransaction) -> teaql_runtime::Result<()> {
        let redis_url = std::env::var("REDIS_URL").unwrap_or_else(|_| "redis://127.0.0.1/".to_string());
        let client = redis::Client::open(redis_url).unwrap();
        let mut con = client.get_connection().unwrap();

        // 1. 交易限额拦截 (_max_amount="10000")
        if entity.transaction_amount.unwrap_or_default() > rust_decimal::Decimal::new(10000, 0) {
            return Err(teaql_runtime::Error::business("Exceeds max amount allowed (10000)"));
        }

        // 2. 幂等性拦截 (_idempotency_key="reference_number")
        if let Some(ref_num) = &entity.reference_number {
            let key = format!("idempotency:payment:{}", ref_num);
            let exists: bool = redis::cmd("EXISTS").arg(&key).query(&mut con).unwrap_or(false);
            if exists {
                return Err(teaql_runtime::Error::business("Duplicate payment transaction detected (Idempotency Key Conflict)"));
            } else {
                // Set lock for 24 hours
                let _: () = redis::cmd("SETEX").arg(&key).arg(86400).arg("locked").query(&mut con).unwrap_or(());
            }
        }
        Ok(())
    }
    */
}