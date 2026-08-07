
use axum::{routing::get, Router};
use serde_json::{json, Value};
use teaql_runtime::UserContext;
use teaql_web_integration_axum::{ContextProvider, WebResponse};

#[derive(Clone)]
struct AppState;

impl ContextProvider for AppState {
    fn build_context(&self) -> UserContext {
        enterprise_erp_system_core::module_with_behaviors_and_checkers().into_context()
    }
}

#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    let runtime = enterprise_erp_system_core::service_runtime_from_env().await?;
    runtime.ensure_schema().await?;
    let bind_addr = std::env::var("ENTERPRISE_ERP_SYSTEM_CORE_BIND_ADDR")
        .unwrap_or_else(|_| "127.0.0.1:3000".to_owned());

    let app = Router::new()
        .route("/health", get(health))
        .with_state(AppState);

    let listener = tokio::net::TcpListener::bind(&bind_addr).await?;
    println!("listening on http://{bind_addr}");
    axum::serve(listener, app).await?;
    Ok(())
}

async fn health() -> WebResponse<Value> {
    WebResponse::of_single(json!({
        "status": "ok",
        "service": "enterprise-erp-system-core-web-axum"
    }))
}