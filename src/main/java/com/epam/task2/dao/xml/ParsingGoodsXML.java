package com.epam.task2.dao.xml;

import com.epam.task2.dao.DAOFactory;
import com.epam.task2.service.ServiceException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @author Alexander Pishchala
 *
 * This is the 'SAXParsingXML' class. It describes parsing a file.
 */
public final class ParsingGoodsXML implements ParsingXML {

    private Constant constant = new Constant();
    private SAXHandlerParser handler = DAOFactory.getInstance().getHandler();

    @Override
    public void startParsing() throws SAXException, ParserConfigurationException, IOException, ServiceException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        xmlReader.setContentHandler(handler);
        xmlReader.parse(getPathFile());
    }

    private String getPathFile() throws ServiceException {
        String path = ParsingGoodsXML.class.getClassLoader().getResource(constant.getFILE_NAME()).getPath();
        return path;
    }
}
