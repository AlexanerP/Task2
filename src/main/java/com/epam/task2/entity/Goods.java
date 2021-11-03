package com.epam.task2.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Goods implements Serializable {

    private long idGoods;
    private String name;
    private String type;
    private String company;
    private BigDecimal price;


    public Goods() {
    }

    public Goods(long idGoods, String company, String name, String type, BigDecimal price) {
        this.idGoods = idGoods;
        this.name = name;
        this.type = type;
        this.company = company;
        this.price = price;
    }

    public long getIdGoods() {
        return idGoods;
    }

    public void setIdGoods(long idGoods) {
        this.idGoods = idGoods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Goods goods = (Goods) obj;
        return idGoods == goods.idGoods &&
                Objects.equals(name, goods.name) &&
                Objects.equals(type, goods.type) &&
                Objects.equals(company, goods.company) &&
                Objects.equals(price, goods.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGoods, name, type, company, price);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Goods{").append("id='").append(idGoods).append("', company='").append(company)
                .append(", name='").append(name).append(", type='").append(type).append(", price=")
                .append(price).append("'}'");
        return stringBuilder.toString();
    }
}
