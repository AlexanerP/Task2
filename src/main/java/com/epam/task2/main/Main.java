package com.epam.task2.main;

import com.epam.task2.dao.DAOFactory;
import com.epam.task2.dao.Write;
import com.epam.task2.entity.Goods;
import com.epam.task2.entity.Refrigerator;
import com.epam.task2.entity.criteria.CriteriaSearch;
import com.epam.task2.service.GoodsService;
import com.epam.task2.service.ServiceFactory;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Alexander Pishchala
 *
 * This is my main class. This is where I start.
 * Step one. First, I search for a goods one word at a time and then I output the result to the console.
 * Step two. I search for a goods by two words and then I output the result to the console.
 * Step three. I add the goods to the xml file and output the result to the console 'true' if the goods is added
 * or 'false' if the goods is not added
 */
public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        Write outConsole = DAOFactory.getInstance().getWrite();
        GoodsService service = ServiceFactory.getInstance().getGoodsService();

        CriteriaSearch criteriaSearch = new CriteriaSearch();
        /**
         * Step one.
         */
        String firstNameGoods = "LG";
        criteriaSearch.add(firstNameGoods);

        List<Goods> goodsResult = service.findGoods(criteriaSearch);
        /**
         * Output the result to the console
         */
        outConsole.write("Поиск товаров по слову: " + firstNameGoods + "\nРезультат:");
        for (Goods goods : goodsResult) {
            outConsole.write(goods);
        }
        goodsResult = null;

        /**
         * Step two.
         */
        outConsole.write("\n\n************************************\n\n");

        String secondNameGoods = "Indesit";
        criteriaSearch.add(secondNameGoods);
        goodsResult = service.findGoods(criteriaSearch);

        /**
         * Output the result to the console
         */
        outConsole.write("Поиск товаров по словам: " + firstNameGoods + ", " + secondNameGoods + "\nРезультат:");
        for (Goods goods : goodsResult) {
            outConsole.write(goods);
        }

        /**
         * Step three.
         */
        String name, type, company;
        double volumeFreezer, volumeNotFreezer;

        name = "AlG 458";
        company = "AlG";
        type = "refrigerator";
        volumeFreezer = 3.3;
        volumeNotFreezer = volumeFreezer + 1;

        Refrigerator refrigerator = new Refrigerator(777777, company, name, type, new BigDecimal(77),
                volumeFreezer, volumeNotFreezer);
        boolean result = service.addGoods(refrigerator);
        outConsole.write("Goods added - " + result);
    }
}
