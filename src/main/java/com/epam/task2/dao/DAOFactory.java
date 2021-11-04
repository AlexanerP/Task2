package com.epam.task2.dao;

import com.epam.task2.dao.impl.DAOGoodsImpl;
import com.epam.task2.dao.impl.WriteToConsoleImpl;
import com.epam.task2.dao.xml.SAXHandlerParser;
import com.epam.task2.dao.xml.SAXParserXML;
import com.epam.task2.dao.xml.UpdateXML;

/**
 * @author Alexander Pishchala
 *
 * This is a ffbrika of the DAO package. Here we distribute instances of the DAO package classes.
 */
public class DAOFactory {

    private static DAOFactory instance = new DAOFactory();
    private static SAXHandlerParser handler = new SAXHandlerParser();
    private static SAXParserXML saxParserXML = new SAXParserXML();
    private static UpdateXML writeXML = new UpdateXML();
    private static DAOGoods daoGoods = new DAOGoodsImpl();
    private static Write write = new WriteToConsoleImpl();

    public static DAOFactory getInstance() {
        return instance;
    }

    public SAXHandlerParser getHandler() {
        return handler;
    }

    public SAXParserXML getSaxParserXML() {
        return saxParserXML;
    }

    public DAOGoods getDaoGoods() {
        return daoGoods;
    }

    public Write getWrite() {
        return write;
    }

    public UpdateXML getWriteXML() {
        return writeXML;
    }
}
