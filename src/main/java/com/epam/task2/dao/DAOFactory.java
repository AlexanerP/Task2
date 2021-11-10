package com.epam.task2.dao;

import com.epam.task2.dao.impl.DAOGoodsImpl;
import com.epam.task2.dao.impl.WriteToConsoleImpl;
import com.epam.task2.dao.xml.SAXHandlerParser;
import com.epam.task2.dao.xml.ParsingGoodsXML;
import com.epam.task2.dao.xml.WriteGoodsXML;
import com.epam.task2.dao.xml.WriteXML;

/**
 * @author Alexander Pishchala
 *
 * This is a fabrika of the DAO package. Here we distribute instances of the DAO package classes.
 */
public class DAOFactory {

    private static DAOFactory instance = new DAOFactory();
    private static SAXHandlerParser handler = new SAXHandlerParser();
    private static ParsingGoodsXML parsingGoodsFile = new ParsingGoodsXML();
    private static WriteXML writeXML = new WriteGoodsXML();
    private static DAOGoods daoGoods = new DAOGoodsImpl();
    private static Write write = new WriteToConsoleImpl();

    public static DAOFactory getInstance() {
        return instance;
    }

    public SAXHandlerParser getHandler() {
        return handler;
    }

    public ParsingGoodsXML getSaxParserXML() {
        return parsingGoodsFile;
    }

    public DAOGoods getDaoGoods() {
        return daoGoods;
    }

    public Write getWrite() {
        return write;
    }

    public WriteXML getWriteXML() {
        return writeXML;
    }
}
