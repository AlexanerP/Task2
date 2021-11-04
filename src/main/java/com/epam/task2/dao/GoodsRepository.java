package com.epam.task2.dao;

import com.epam.task2.entity.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexander Pishchala
 *
 * This is the goods repository class. All products are stored here after receiving from the xml file.
 */
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
