
package com.example.enterpriseerpsystem;

import com.example.enterpriseerpsystem.account.Account;
import com.example.enterpriseerpsystem.campaign.Campaign;
import com.example.enterpriseerpsystem.catalog.Catalog;
import com.example.enterpriseerpsystem.category.Category;
import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.department.Department;
import com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase;
import com.example.enterpriseerpsystem.lead.Lead;
import com.example.enterpriseerpsystem.position.Position;
import com.example.enterpriseerpsystem.promotion.Promotion;
import com.example.enterpriseerpsystem.salesterritory.SalesTerritory;
import com.example.enterpriseerpsystem.sla.Sla;
import com.example.enterpriseerpsystem.supplier.Supplier;
import com.example.enterpriseerpsystem.taxrate.TaxRate;
import com.example.enterpriseerpsystem.warehouse.Warehouse;

public interface Constants  {
  public static final long DEPARTMENT_ID = 1l;
  public static final Department DEPARTMENT = Department.refer(DEPARTMENT_ID);
  public static final long POSITION_ID = 1l;
  public static final Position POSITION = Position.refer(POSITION_ID);
  public static final long CUSTOMER_ID = 1l;
  public static final Customer CUSTOMER = Customer.refer(CUSTOMER_ID);
  public static final long LEAD_ID = 1l;
  public static final Lead LEAD = Lead.refer(LEAD_ID);
  public static final long CAMPAIGN_ID = 1l;
  public static final Campaign CAMPAIGN = Campaign.refer(CAMPAIGN_ID);
  public static final long SALES_TERRITORY_ID = 1l;
  public static final SalesTerritory SALES_TERRITORY = SalesTerritory.refer(SALES_TERRITORY_ID);
  public static final long CATEGORY_ID = 1l;
  public static final Category CATEGORY = Category.refer(CATEGORY_ID);
  public static final long CATALOG_ID = 1l;
  public static final Catalog CATALOG = Catalog.refer(CATALOG_ID);
  public static final long PROMOTION_ID = 1l;
  public static final Promotion PROMOTION = Promotion.refer(PROMOTION_ID);
  public static final long ACCOUNT_ID = 1l;
  public static final Account ACCOUNT = Account.refer(ACCOUNT_ID);
  public static final long TAX_RATE_ID = 1l;
  public static final TaxRate TAX_RATE = TaxRate.refer(TAX_RATE_ID);
  public static final long SUPPLIER_ID = 1l;
  public static final Supplier SUPPLIER = Supplier.refer(SUPPLIER_ID);
  public static final long WAREHOUSE_ID = 1l;
  public static final Warehouse WAREHOUSE = Warehouse.refer(WAREHOUSE_ID);
  public static final long SLA_ID = 1l;
  public static final Sla SLA = Sla.refer(SLA_ID);
  public static final long KNOWLEDGE_BASE_ID = 1l;
  public static final KnowledgeBase KNOWLEDGE_BASE = KnowledgeBase.refer(KNOWLEDGE_BASE_ID);
}