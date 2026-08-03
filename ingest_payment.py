from datahub.emitter.rest_emitter import DatahubRestEmitter
from datahub.emitter.mcp import MetadataChangeProposalWrapper
from datahub.metadata.schema_classes import (
    DatasetPropertiesClass,
    SchemaMetadataClass,
    SchemaFieldClass,
    SchemaFieldDataTypeClass,
    StringTypeClass,
    NumberTypeClass,
    GlobalTagsClass,
    TagAssociationClass,
    OtherSchemaClass
)

emitter = DatahubRestEmitter("http://localhost:8080")
dataset_urn = "urn:li:dataset:(urn:li:dataPlatform:snowflake,prod.finance.payment_transactions,PROD)"

# 1. 发送表的基本属性 (Properties)
props = DatasetPropertiesClass(
    name="payment_transactions",
    description="【黑客松专用】企业核心支付流水表。包含高度敏感的用户支付账号信息，必须接入审计与脱敏模块。"
)
emitter.emit(MetadataChangeProposalWrapper(entityUrn=dataset_urn, aspect=props))

# 2. 发送表的字段结构和 PII 隐私标签 (Schema & Tags)
pii_tag = TagAssociationClass(tag="urn:li:tag:PII")
high_sens_tag = TagAssociationClass(tag="urn:li:tag:HighSensitivity")

fields = [
    SchemaFieldClass(
        fieldPath="payment_account",
        type=SchemaFieldDataTypeClass(type=StringTypeClass()),
        nativeDataType="VARCHAR",
        description="Linked user account ID",
        globalTags=GlobalTagsClass(tags=[pii_tag, high_sens_tag])
    ),
    SchemaFieldClass(
        fieldPath="payment_method",
        type=SchemaFieldDataTypeClass(type=StringTypeClass()),
        nativeDataType="VARCHAR",
        description="Method used (e.g. CREDIT_CARD)",
    ),
    SchemaFieldClass(
        fieldPath="transaction_amount",
        type=SchemaFieldDataTypeClass(type=NumberTypeClass()),
        nativeDataType="DECIMAL",
        description="Total transaction amount",
    ),
    SchemaFieldClass(
        fieldPath="currency_code",
        type=SchemaFieldDataTypeClass(type=StringTypeClass()),
        nativeDataType="VARCHAR",
        description="Currency (e.g. USD, CNY)",
    )
]

schema = SchemaMetadataClass(
    schemaName="payment_transactions",
    platform="urn:li:dataPlatform:snowflake",
    version=0,
    hash="",
    platformSchema=OtherSchemaClass(rawSchema=""), 
    fields=fields
)

emitter.emit(MetadataChangeProposalWrapper(entityUrn=dataset_urn, aspect=schema))
print("Successfully ingested mock payment data into DataHub!")
