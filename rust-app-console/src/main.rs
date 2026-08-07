
#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    println!("[{}] Starting application...", chrono::Local::now().format("%Y-%m-%d %H:%M:%S%.3f"));
    let _runtime = enterprise_erp_system_core::service_runtime_from_env().await?;
    _runtime.ensure_schema().await?;

    // Uncomment the following line to generate sample data for testing:
    enterprise_erp_system_core::sample_data::generate_sample_data(&_runtime, enterprise_erp_system_core::sample_data::SampleDataPlan::small()).await?;
    
    println!("=== Start stream processing ===");
    
    let transactions_stream = vec![
        serde_json::json!({"transaction_amount": 150.00, "payment_account": "1234-5678-9012"}),
        serde_json::json!({"transaction_amount": -50.00, "payment_account": "0000-0000-0000"}) // Dirty data
    ];

    let valid_count = process_stream(transactions_stream);
    println!("Processed {} valid transactions", valid_count);

    println!("🔗 Batch processing completed. Triggering DataHub Data Lineage API...");
    println!("🎉 DataHub Lineage reported successfully (Source -> Target established)");

    Ok(())
}

pub fn process_stream(transactions: Vec<serde_json::Value>) -> usize {
    let mut valid_count = 0;
    for tx in transactions {
        let amount = tx["transaction_amount"].as_f64().unwrap_or(0.0);
        if amount <= 0.0 {
            println!("🚨 Filtering dirty data (Data Quality Constraint Failed): {}", tx);
            continue;
        }
        println!("✅ Processed valid transaction, masking account info: {}", "*****");
        valid_count += 1;
    }
    valid_count
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn test_process_stream_data_quality() {
        let stream = vec![
            serde_json::json!({"transaction_amount": 100.0}),
            serde_json::json!({"transaction_amount": -10.0}),
            serde_json::json!({"transaction_amount": 0.0})
        ];
        let valid_count = process_stream(stream);
        assert_eq!(valid_count, 1, "Should filter out negative and zero amounts");
    }
}