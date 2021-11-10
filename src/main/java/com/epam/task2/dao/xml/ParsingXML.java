package com.epam.task2.dao.xml;

import com.epam.task2.service.ServiceException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public interface ParsingXML {

    void startParsing() throws SAXException, ParserConfigurationException, IOException, ServiceException;
}