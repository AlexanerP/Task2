package com.epam.task2.dao.xml;

import com.epam.task2.dao.GoodsRepository;
import org.xml.sax.helpers.DefaultHandler;
import com.epam.task2.entity.Goods;
import com.epam.task2.entity.Refrigerator;
import com.epam.task2.entity.SmoothingIron;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SAXHandlerParser extends DefaultHandler{

    private final String TYPE_TAG = Constant.TYPE_TAG;
    private final String ITEM_TAG = Constant.ITEM_TAG;
    private final String ITEM_ID_TAG = Constant.ITEM_ID_TAG;
    private final String COMPANY_TAG = Constant.COMPANY_TAG;
    private final String TYPE_REFRIGERATOR = Constant.TYPE_REFRIGERATOR;
    private final String TYPE_SMOOTHING_IRON = Constant.TYPE_SMOOTHING_IRON;
    private final String NAME_TAG = Constant.NAME_TAG;
    private final String PRICE_TAG = Constant.PRICE_TAG;
    private final String COUNT_MODE_TAG = Constant.COUNT_MODE_TAG;
    private final String MAX_TEMPERATURE_TAG = Constant.MAX_TEMPERATURE_TAG;
    private final String VOLUME_FREEZER_TAG = Constant.VOLUME_FREEZER_TAG;
    private final String VOLUME_NOT_FREEZER_TAG = Constant.VOLUME_NOT_FREEZER_TAG;

    private final String REGEX_NUMBER = "^[0-9]*[.,]?[0-9]+$";

    private String currentElement;

    private long idGoods;
    private String name, type, company;
    private BigDecimal price;
    private int countMode, maxTemperature;
    private double volumeFreezer, volumeNotFreezer;

    private GoodsRepository goodsRepository = GoodsRepository.getInstance();

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            currentElement = qName;
            switch (currentElement) {
                case ITEM_TAG:
                    if (isNumber(attributes.getValue(ITEM_ID_TAG), REGEX_NUMBER)) {
                        idGoods = Long.parseLong(attributes.getValue(ITEM_ID_TAG));
                    }
                    break;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if(qName.equalsIgnoreCase(ITEM_TAG)) {
                if(type.equalsIgnoreCase(TYPE_REFRIGERATOR)) {
                    goodsRepository.add(new Refrigerator(idGoods, company, name, type, price, volumeFreezer, volumeNotFreezer));
                } else if(type.equalsIgnoreCase(TYPE_SMOOTHING_IRON)) {
                    goodsRepository.add(new SmoothingIron(idGoods, company, name, type, price, maxTemperature, countMode));
                } else {
                    goodsRepository.add(new Goods(idGoods, company, name, type, price));
                }
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String text = new String(ch, start, length);

            if(text.contains("<") || currentElement == null || text.contains("\n")) {
                return;
            }

            switch (currentElement) {
                case COMPANY_TAG:
                    company = text;
                    break;
                case TYPE_TAG:
                    type = text;
                    break;
                case NAME_TAG:
                    name = text;
                    break;
                case PRICE_TAG:
                    if(isNumber(text, REGEX_NUMBER)) {
                        price = new BigDecimal(text);
                    } else {
                        price = null;
                    }
                    break;
                case COUNT_MODE_TAG:
                    if(isNumber(text, REGEX_NUMBER)) {
                        countMode = Integer.valueOf(text);
                    }
                    break;
                case MAX_TEMPERATURE_TAG:
                    if(isNumber(text, REGEX_NUMBER)) {
                        maxTemperature = Integer.valueOf(text);
                    }
                    break;
                case VOLUME_FREEZER_TAG:
                    if(isNumber(text, REGEX_NUMBER)) {
                        volumeFreezer = Double.parseDouble(text);
                    }
                    break;
                case VOLUME_NOT_FREEZER_TAG:
                    if(isNumber(text, REGEX_NUMBER)) {
                        volumeNotFreezer = Double.parseDouble(text);
                    }
                    break;
                }
        }

        private boolean isNumber(String text, String regex) {
            if(text.trim().matches(regex)) {
                return true;
            }
            return false;
    }
}
