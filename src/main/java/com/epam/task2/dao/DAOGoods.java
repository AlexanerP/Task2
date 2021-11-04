package com.epam.task2.dao;

/**
 * @author Alexander Pishchala
 *
 * This is DAOGoods receiving interface. There are methods here that are responsible for working with goods
 * search data by criterion and adding a product to a file.
 */

import com.epam.task2.entity.Goods;
import com.epam.task2.entity.criteria.CriteriaSearch;
import com.epam.task2.service.ServiceException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public interface DAOGoods {

    List<Goods> find(CriteriaSearch criteriaSearch) throws IOException, SAXException, ParserConfigurationException, ServiceException;

    boolean add(Goods goods) throws ParserConfigurationException, IOException, SAXException, TransformerException, ServiceException;

}
