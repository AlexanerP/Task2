package com.epam.task2.dao.impl;

import com.epam.task2.dao.DAOFactory;
import com.epam.task2.dao.DAOGoods;
import com.epam.task2.dao.GoodsRepository;
import com.epam.task2.dao.xml.SAXParserXML;
import com.epam.task2.dao.xml.UpdateXML;
import com.epam.task2.entity.Goods;
import com.epam.task2.entity.criteria.Criteria;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DAOGoodsImpl implements DAOGoods {

    public DAOGoodsImpl() {
        saxParserXML = DAOFactory.getInstance().getSaxParserXML();
    }

    private SAXParserXML saxParserXML;
    private GoodsRepository goodsRepository = GoodsRepository.getInstance();
    private UpdateXML updateXML = DAOFactory.getInstance().getWriteXML();

    @Override
    public List<Goods> find(Criteria criteria) throws IOException, SAXException, ParserConfigurationException {
        saxParserXML.startParsing();
        List<Goods> goodsList = new ArrayList<>();
        List<Goods> repositoryGoodsList = goodsRepository.getRepositoryGoodsList();
        for (Goods goods : repositoryGoodsList) {
            for (String lineSearchWord : criteria.getListSearchWord()) {
                if (goods.toString().contains(lineSearchWord)) {
                    long idGoods = goods.getIdGoods();
                    if (isRedial(idGoods, goodsList)) {
                        goodsList.add(goods);
                    }
                }
            }
        }
        return goodsList;
    }

    @Override
    public boolean add(Goods goods) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        updateXML.update(goods);
        return true;
    }

    private boolean isRedial(long id, List<Goods> goods) {
        boolean isUnique = true;
        for(Goods goods1 : goods) {
            if(goods1.getIdGoods() == id) {
                isUnique = false;
            }
        }
        return isUnique;
    }
}
