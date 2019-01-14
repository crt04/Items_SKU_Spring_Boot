package com.hd.items.constants;

/**
 * Description : This class contains Constants.
 */
public interface UrlConstants {
	// Class Path
	String GET_COMMON_PROPERTIES = "/get-system-properties";

	String VENDOR_CONTROLLER="/vendor";
	String COMMON_CONTROLLER="/common";
	String CATALOG_CONTROLLER="/catalog";
	String PICKLIST_CONTROLLER="/picklist";
	String SCHEDULE_QUEUE_CONTROLLER="/schedule-queue";
	String REPORTS_CONTROLLER="/reports";
	String ITEMS_CONTROLLER="/items";
	String AUXILIARY_CONTROLLER="/items-auxilary";
	String SAVE_UPDATE = "save-update";
	
	
	String GET_COMMON_LANGCD = "/get-langcd";
	String GET_COMMON_CATALOG_TYPE= "/get-catalog-type";
	String DELETE = "delete" ;
    String LIST = "list";
    String LIST_ITEMS_BY_SKU = "list-items-by-sku";
    String LIST_AUX_ITEMS_BY_SKU = "list-auxilary-items-by-sku";
    String GET_VERSION_LIST = "version-list";
    String VERSION_DELETE = "version-delete" ;
	String VERSION_SAVE = "version-save-update";
	String GET_BYO_MKT_STORES= "/get-byo-mkt-stores";
	String STORE_SCHEDULE_LIST = "store-schedule-list";
	String UPDATE_STATUS = "update-status";
	String SCHEDULE_STATUS = "status";
	String SCHEDULE_CHECK = "schedule-check";
	String CATALOG_REPORT = "/catalog-report";
	String EXPORT_STORE_DB_TO_AZURE = "export-store-db-to-azure";
	
	String GET_STORES_BY_ID =  "get-stores-list";
	String GET_STORES_STATUS_BY_DLEVENT_ID = "get-stores-status";

	String GET_CATALOG_BY_DELIVERY_EVENT = "catalog-info-by-dlvryevent" ;
}
