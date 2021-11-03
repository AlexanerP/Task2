package com.epam.task2.service.impl;

import com.epam.task2.dao.DAOFactory;
import com.epam.task2.dao.DAOGoods;
import com.epam.task2.entity.Goods;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.service.GoodsService;
import com.epam.task2.service.ServiceException;
import com.epam.task2.service.Validator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class GoodsServiceImpl implements GoodsService {

    private DAOGoods daoGoods;

    public GoodsServiceImpl() {
        daoGoods = DAOFactory.getInstance().getDaoGoods();
    }

    @Override
    public List<Goods> findGoods(Criteria criteria) {
        try {
            if (!(criteria == null)) {
                if(!criteria.getListSearchWord().isEmpty()) {
                    return daoGoods.find(criteria);
                }
            }
        }catch (SAXException | ParserConfigurationException | IOException  e) {
           e.printStackTrace();
            // log
        }
        return null;
    }

    @Override
    public boolean addGoods(Goods goods) {
        try {
            if (!(goods == null)) {
                if (Validator.isNumber(goods.getIdGoods() + "") && Validator.validatorText(goods.getType())
                        && Validator.validatorText(goods.getCompany()) && Validator.validatorText(goods.getName())
                        && Validator.validatorText(goods.getPrice() + "")) {
                    return daoGoods.add(goods);
                }
            }
        }catch (ServiceException | ParserConfigurationException | IOException | SAXException | TransformerException e) {
            e.printStackTrace();
            // log
        }
        return false;
    }
}
