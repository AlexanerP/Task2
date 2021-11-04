package com.epam.task2.service;

import com.epam.task2.entity.Goods;
import com.epam.task2.entity.criteria.CriteriaSearch;

import java.util.List;

/**
 * @author Alexander Pishchala
 *
 * This is the interface GoodsService. Basic methods are described here.
 */
public interface GoodsService {

    List<Goods> findGoods(CriteriaSearch criteriaSearch);

    boolean addGoods(Goods goods);
}
