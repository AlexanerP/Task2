package com.epam.task2.dao.xml;

import com.epam.task2.dao.DAOFactory;
import com.epam.task2.dao.GoodsRepository;
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
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Alexander Pishchala
 *
 * This xml file update class. It adds a new goods to the xml file.
 */
public class UpdateXML {

    private Constant constant = new Constant();
    private final String TYPE_TAG = Constant.TYPE_TAG;
    private final String ID_TAG = Constant.ID_TAG;
    private final String COMPANY_TAG = Constant.COMPANY_TAG;
    private final String NAME_TAG = Constant.NAME_TAG;
    private final String PRICE_TAG = Constant.PRICE_TAG;
    private final String COUNT_MODE_TAG = Constant.COUNT_MODE_TAG;
    private final String MAX_TEMPERATURE_TAG = Constant.MAX_TEMPERATURE_TAG;
    private final String VOLUME_FREEZER_TAG = Constant.VOLUME_FREEZER_TAG;
    private final String VOLUME_NOT_FREEZER_TAG = Constant.VOLUME_NOT_FREEZER_TAG;
    private final String TYPE_GOODS_REFRIGERATOR = Constant.TYPE_GOODS_REFRIGERATOR;
    private final String TYPE_GOODS_SMOOTHING_IRON = Constant.TYPE_GOODS_SMOOTHING_IRON;
    private final String N_GOODS_TAG = Constant.N_GOODS_TAG;
    private final String ITEMS_TAG = Constant.ITEMS_TAG;
    private final String XMLN_N = Constant.XMLN_N;
    private final String XMLN_XSI = Constant.XMLN_XSI;
    private final String XSI_SCHEMA = Constant.XSI_SCHEMA;
    private final String XMLN_N_VALUE = Constant.XMLN_N_VALUE;
    private final String XMLN_XSI_VALUE = Constant.XMLN_XSI_VALUE;
    private final String XSI_SCHEMA_VALUE = Constant.XSI_SCHEMA_VALUE;

    private final String TYPE_ELEMENT_REFRIGERATOR = Constant.TYPE_ELEMENT_REFRIGERATOR;
    private final String TYPE_ELEMENT_SMOOTHING_IRON = Constant.TYPE_ELEMENT_SMOOTHING_IRON;

    public boolean update(Goods goods) throws ParserConfigurationException, IOException, SAXException, TransformerException, ServiceException {

        String file = getPathFile();
        ParsingGoodsFile parsingGoodsFile = DAOFactory.getInstance().getSaxParserXML();
        GoodsRepository goodsRepository = GoodsRepository.getInstance();

        parsingGoodsFile.startParsing();
        List<Goods> goodsList = goodsRepository.getRepositoryGoodsList();
        goodsList.add(goods);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element goodsElement = document.createElement(N_GOODS_TAG);

        goodsElement.setAttribute(XMLN_N, XMLN_N_VALUE);
        goodsElement.setAttribute(XMLN_XSI, XMLN_XSI_VALUE);
        goodsElement.setAttribute(XSI_SCHEMA, XSI_SCHEMA_VALUE);
        Element itemsElement = document.createElement(ITEMS_TAG);

        addAllGoods(goodsList, document, itemsElement);

        goodsElement.appendChild(itemsElement);
        document.appendChild(goodsElement);

        TransformerFactory trans = TransformerFactory.newInstance();

        Transformer transformer = trans.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new FileWriter(file));
        transformer.transform(source, result);
        return true;
    }

    private void addAllGoods(List<Goods> goodsList, Document document, Element itemsElement) {
        for (Goods product : goodsList) {
            Element typeGoodsElement = null;
            if (product.getType().equalsIgnoreCase(TYPE_GOODS_REFRIGERATOR)) {
                typeGoodsElement = document.createElement(TYPE_ELEMENT_REFRIGERATOR);
            } else if (product.getType().equalsIgnoreCase(TYPE_GOODS_SMOOTHING_IRON)) {
                typeGoodsElement = document.createElement(TYPE_ELEMENT_SMOOTHING_IRON);
            }
            Element type = document.createElement(TYPE_TAG);
            type.appendChild(document.createTextNode(product.getType()));
            typeGoodsElement.appendChild(type);

            Element id = document.createElement(ID_TAG);
            id.appendChild(document.createTextNode(product.getIdGoods() + ""));
            typeGoodsElement.appendChild(id);

            Element company = document.createElement(COMPANY_TAG);
            company.appendChild(document.createTextNode(product.getCompany()));
            typeGoodsElement.appendChild(company);

            Element name = document.createElement(NAME_TAG);
            name.appendChild(document.createTextNode(product.getName()));
            typeGoodsElement.appendChild(name);

            Element price = document.createElement(PRICE_TAG);
            price.appendChild(document.createTextNode(product.getPrice() + ""));
            typeGoodsElement.appendChild(price);

            if (product.getType().equalsIgnoreCase(TYPE_GOODS_REFRIGERATOR)) {
                addRefrigerator(product, typeGoodsElement, document, itemsElement);
            } else if (product.getType().equalsIgnoreCase(TYPE_GOODS_SMOOTHING_IRON)) {
                addSmoothingIron(product, typeGoodsElement, document, itemsElement);
            }
        }
    }

    private void addRefrigerator(Goods goods, Element typeGoodsElement, Document document, Element itemsElement) {
        Refrigerator refrigerator = (Refrigerator) goods;

        Element volumeFreezer = document.createElement(VOLUME_FREEZER_TAG);
        volumeFreezer.appendChild(document.createTextNode(refrigerator.getVolumeFreezer() + ""));
        typeGoodsElement.appendChild(volumeFreezer);

        Element volumeNotFreezer = document.createElement(VOLUME_NOT_FREEZER_TAG);
        volumeNotFreezer.appendChild(document.createTextNode(refrigerator.getVolumeNotFreezer() + ""));
        typeGoodsElement.appendChild(volumeNotFreezer);

        itemsElement.appendChild(typeGoodsElement);
    }

    private void addSmoothingIron(Goods goods, Element typeGoodsElement, Document document, Element itemsElement) {
        SmoothingIron smoothingIron = (SmoothingIron) goods;

        Element countMode = document.createElement(COUNT_MODE_TAG);
        countMode.appendChild(document.createTextNode(smoothingIron.getCountMode() + ""));
        typeGoodsElement.appendChild(countMode);

        Element maxTemperature = document.createElement(MAX_TEMPERATURE_TAG);
        maxTemperature.appendChild(document.createTextNode(smoothingIron.getMaxTemperature() + ""));
        typeGoodsElement.appendChild(maxTemperature);

        itemsElement.appendChild(typeGoodsElement);
    }

    private String getPathFile() throws ServiceException {
        String pathFile = UpdateXML.class.getClassLoader().getResource(constant.getFILE_NAME()).getPath();
        StringBuffer path = new StringBuffer(pathFile);
        return path.deleteCharAt(0).toString();
    }

}
