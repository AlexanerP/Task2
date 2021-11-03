package com.epam.task2.main;

import com.epam.task2.dao.DAOFactory;
import com.epam.task2.dao.Write;
import com.epam.task2.entity.Goods;
import com.epam.task2.entity.Refrigerator;
import com.epam.task2.entity.criteria.Criteria;
import com.epam.task2.service.GoodsService;
import com.epam.task2.service.ServiceFactory;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        Write outConsole = DAOFactory.getInstance().getWrite();
        GoodsService service = ServiceFactory.getInstance().getGoodsService();

        Criteria criteria = new Criteria();
        String searchWord1 = "LG";
        criteria.add(searchWord1);

        List<Goods> goodsListResult = service.findGoods(criteria);

        for (Goods goods : goodsListResult) {
            outConsole.write(goods);
        }
        goodsListResult = null;

        //*******************************************
        outConsole.write("\n\n************************************\n\n");

        String searchWord2 = "Indesit";
        criteria.add(searchWord2);
        goodsListResult = service.findGoods(criteria);

        for (Goods goods : goodsListResult) {
            outConsole.write(goods);
        }

//         add goods to xml
        String name, type, company;
        double volumeFreezer, volumeNotFreezer;

        name = "test name";
        company = "test company";
        type = "refrigerator";
        volumeFreezer = 3.3;
        volumeNotFreezer = volumeFreezer + 1;

        Refrigerator refrigerator = new Refrigerator(777777, company, name, type, new BigDecimal(77), volumeFreezer, volumeNotFreezer);
        boolean result = service.addGoods(refrigerator);
        outConsole.write("Goods added - " + result);

    }
}
