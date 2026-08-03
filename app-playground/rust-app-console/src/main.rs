use payment_service_core::teaql_core::{Entity, SmartList};
use payment_service_core::{Q, AuditedSave};

#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    println!("[{}] Starting application...", chrono::Local::now().format("%Y-%m-%d %H:%M:%S%.3f"));
    let ctx = payment_service_core::service_runtime_from_env().await?;
    ctx.ensure_schema().await?;

    println!("Creating payment account...");
    let mut account = Q::payment_accounts()
        .purpose("why: Create a new payment account")
        .new_entity(&ctx);
    account.update_id(1);
    account.update_account_name("Test Corporate Account");
    account.update_account_number("9876543210");
    account.update_currency_code("USD");
    account.update_create_time("2026-08-03T10:00:00Z");
    account.update_update_time("2026-08-03T10:00:00Z");
    
    let _account = account
        .audit_as("Create account for testing")
        .save(&ctx).await?;

    println!("Creating payment method...");
    let mut method = Q::payment_methods()
        .purpose("why: Create a new payment method")
        .new_entity(&ctx);
    method.update_id(1);
    method.update_payment_account_id(1);
    method.update_method_type("CREDIT_CARD");
    method.update_last_four_digits("1234");
    method.update_create_time("2026-08-03T10:00:00Z");
    method.update_update_time("2026-08-03T10:00:00Z");
    
    let _method = method
        .audit_as("Create method for testing")
        .save(&ctx).await?;

    println!("Creating payment transaction...");
    let mut txn = Q::payment_transactions()
        .purpose("why: Create a new payment transaction")
        .new_entity(&ctx);
    txn.update_id(1);
    txn.update_payment_account_id(1);
    txn.update_payment_method_id(1);
    txn.update_payment_status_to_pending();
    txn.update_transaction_amount("150.00");
    txn.update_currency_code("USD");
    txn.update_reference_number("TXN-111222333");
    txn.update_create_time("2026-08-03T10:00:00Z");
    txn.update_update_time("2026-08-03T10:00:00Z");
    
    let _txn = txn
        .audit_as("Create transaction for testing")
        .save(&ctx).await?;

    println!("Querying payment transactions...");
    let rows = Q::payment_transactions_minimal()
        .select_payment_account()
        .select_payment_method()
        .select_payment_status()
        .select_transaction_amount()
        .select_currency_code()
        .select_reference_number()
        .limit(20)
        .comment("what: Query test transactions")
        .purpose("why: Validate creation")
        .execute_for_list(&ctx)
        .await?;
        
    println!("Found {} transactions.", rows.len());

    Ok(())
}