package com.epam.task2.dao.xml;

public class Constant {

    private final String FILE_NAME = "Storage.xml";

    static final String TYPE_TAG = "type";
    static final String ITEM_TAG = "item";
    static final String ITEM_ID_TAG = "id";
    static final String COMPANY_TAG = "company";
    static final String NAME_TAG = "name";
    static final String PRICE_TAG = "price";
    static final String COUNT_MODE_TAG = "countMode";
    static final String MAX_TEMPERATURE_TAG = "maxTemperature";
    static final String VOLUME_FREEZER_TAG = "volumeFreezer";
    static final String VOLUME_NOT_FREEZER_TAG = "volumeNotFreezer";

    static final String TYPE_REFRIGERATOR = "refrigerator";
    static final String TYPE_SMOOTHING_IRON = "Smoothing iron";
    static final String TYPE_UNKNOWN = "Unknown";


    public String getFILE_NAME() {
        return FILE_NAME;
    }
}
