package com.epam.task2.dao;

import com.epam.task2.entity.Goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsRepository {

    private static GoodsRepository instance = new GoodsRepository();

    private static List<Goods> repositoryGoodsList = new ArrayList<>();

    public static GoodsRepository getInstance() {
        return instance;
    }

    public void add(Goods goods) {
        repositoryGoodsList.add(goods);
    }

    public List<Goods> getRepositoryGoodsList() {
        return repositoryGoodsList;
    }
}
