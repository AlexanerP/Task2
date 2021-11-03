package com.epam.task2.service;

import com.epam.task2.service.impl.GoodsServiceImpl;

public class ServiceFactory {

    private static ServiceFactory instance = new ServiceFactory();
    private static GoodsService goodsService = new GoodsServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public GoodsService getGoodsService() {
        return goodsService;
    }

}
