package com.epam.task2.dao.xml;

import com.epam.task2.entity.Goods;
import com.epam.task2.service.ServiceException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface WriteXML {

    boolean update(Goods goods) throws ParserConfigurationException, IOException, SAXException, TransformerException, ServiceException;
}