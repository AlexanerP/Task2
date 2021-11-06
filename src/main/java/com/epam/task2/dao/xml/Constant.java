package com.epam.task2.dao.xml;

/**
 * @author Alexander Pishchala
 *
 * This is the class for constants. The tags of the xml file and also the name of the xml file are described here.
 */
public class Constant {

    private final String FILE_NAME = "Storage.xml";

    static final String TYPE_TAG = "type";
    static final String ID_TAG = "id";
    static final String COMPANY_TAG = "company";
    static final String NAME_TAG = "name";
    static final String PRICE_TAG = "price";
    static final String COUNT_MODE_TAG = "count-mode";
    static final String MAX_TEMPERATURE_TAG = "max-temperature";
    static final String VOLUME_FREEZER_TAG = "volume-freezer";
    static final String VOLUME_NOT_FREEZER_TAG = "volume-not-freezer";
    static final String TYPE_GOODS_REFRIGERATOR = "Refrigerator";
    static final String TYPE_GOODS_SMOOTHING_IRON = "Smoothing Iron";
    static final String N_GOODS_TAG = "n:goods";
    static final String ITEMS_TAG = "items";
    static final String XMLN_N = "xmlns:n";
    static final String XMLN_XSI = "xmlns:xsi";
    static final String XSI_SCHEMA = "xsi:schemaLocation";
    static final String XMLN_N_VALUE = "http://www.epam.by/goods";
    static final String XMLN_XSI_VALUE = "http://www.w3.org/2001/XMLSchema-instance";
    static final String XSI_SCHEMA_VALUE = "http://www.epam.by/goods schema.xsd";

    static final String TYPE_ELEMENT_REFRIGERATOR = "refrigerator";
    static final String TYPE_ELEMENT_SMOOTHING_IRON = "smoothing-iron";


    public String getFILE_NAME() {
        return FILE_NAME;
    }
}
