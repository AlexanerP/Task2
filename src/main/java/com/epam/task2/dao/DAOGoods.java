package com.epam.task2.dao;

import com.epam.task2.entity.Goods;
import com.epam.task2.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public interface DAOGoods {

    List<Goods> find(Criteria criteria) throws IOException, SAXException, ParserConfigurationException;

    boolean add(Goods goods) throws ParserConfigurationException, IOException, SAXException, TransformerException;

}
