package com.epam.task2.dao.xml;

import com.epam.task2.entity.Goods;
import com.epam.task2.entity.Refrigerator;
import com.epam.task2.entity.SmoothingIron;
import com.epam.task2.service.ServiceException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class UpdateXML {

    private Constant constant = new Constant();
    private final String TYPE_TAG = Constant.TYPE_TAG;
    private final String ITEM_TAG = Constant.ITEM_TAG;
    private final String ITEM_ID_TAG = Constant.ITEM_ID_TAG;
    private final String COMPANY_TAG = Constant.COMPANY_TAG;
    private final String TYPE_REFRIGERATOR = Constant.TYPE_REFRIGERATOR;
    private final String TYPE_SMOOTHING_IRON = Constant.TYPE_SMOOTHING_IRON;
    private final String TYPE_UNKNOWN = Constant.TYPE_UNKNOWN;
    private final String NAME_TAG = Constant.NAME_TAG;
    private final String PRICE_TAG = Constant.PRICE_TAG;
    private final String COUNT_MODE_TAG = Constant.COUNT_MODE_TAG;
    private final String MAX_TEMPERATURE_TAG = Constant.MAX_TEMPERATURE_TAG;
    private final String VOLUME_FREEZER_TAG = Constant.VOLUME_FREEZER_TAG;
    private final String VOLUME_NOT_FREEZER_TAG = Constant.VOLUME_NOT_FREEZER_TAG;

    public boolean update(Goods goods) throws ParserConfigurationException, IOException, SAXException, TransformerException, ServiceException {

        String file = getPathFile();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        Element root = document.getDocumentElement();

        Element newGoods = document.createElement(ITEM_TAG);
        newGoods.setAttribute(ITEM_ID_TAG, goods.getIdGoods() + "");

        Element type = document.createElement(TYPE_TAG);
        type.appendChild(document.createTextNode(goods.getType()));
        newGoods.appendChild(type);

        Element company = document.createElement(COMPANY_TAG);
        company.appendChild(document.createTextNode(goods.getCompany()));
        newGoods.appendChild(company);

        Element name = document.createElement(NAME_TAG);
        name.appendChild(document.createTextNode(goods.getName()));
        newGoods.appendChild(name);

        Element price = document.createElement(PRICE_TAG);
        price.appendChild(document.createTextNode(goods.getPrice() + ""));
        newGoods.appendChild(price);

        if(goods.getType().equalsIgnoreCase(TYPE_REFRIGERATOR)) {
            addRefrigerator(goods, newGoods, document);
        } else if (goods.getType().equalsIgnoreCase(TYPE_SMOOTHING_IRON)) {
            addSmoothingIron(goods, newGoods, document);
        } else {
            Element unknown = document.createElement(TYPE_UNKNOWN);
            unknown.appendChild(document.createTextNode(TYPE_UNKNOWN));
            newGoods.appendChild(unknown);
        }

        root.appendChild(newGoods);

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(file);
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");

        transformer.transform(source, result);
        return true;
    }

    private void addRefrigerator(Goods goods, Element newGoods, Document document) {
        Refrigerator refrigerator = (Refrigerator) goods;

        Element volumeFreezer = document.createElement(VOLUME_FREEZER_TAG);
        volumeFreezer.appendChild(document.createTextNode(refrigerator.getVolumeFreezer() + ""));
        newGoods.appendChild(volumeFreezer);

        Element volumeNotFreezer = document.createElement(VOLUME_NOT_FREEZER_TAG);
        volumeNotFreezer.appendChild(document.createTextNode(refrigerator.getVolumeNotFreezer() + ""));
        newGoods.appendChild(volumeNotFreezer);
    }

    private void addSmoothingIron(Goods goods, Element newGoods, Document document) {
        SmoothingIron smoothingIron = (SmoothingIron) goods;

        Element maxTemperature = document.createElement(MAX_TEMPERATURE_TAG);
        maxTemperature.appendChild(document.createTextNode(smoothingIron.getMaxTemperature() + ""));
        newGoods.appendChild(maxTemperature);

        Element countMode = document.createElement(COUNT_MODE_TAG);
        countMode.appendChild(document.createTextNode(smoothingIron.getCountMode() + ""));
        newGoods.appendChild(countMode);
    }

    private String getPathFile() throws ServiceException {
            String pathFile = UpdateXML.class.getClassLoader().getResource(constant.getFILE_NAME()).getPath();
            StringBuffer path = new StringBuffer(pathFile);
            return path.deleteCharAt(0).toString();
        }
}
