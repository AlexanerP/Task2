package com.epam.task2.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Alexander Pishchala
 *
 * This class is the entity 'Smoothing Iron' and extends the Goods class.
 * Here are the main characteristics of a smoothing iron type goods.
 */
public class SmoothingIron extends Goods implements Serializable {

    private static final long serialVersionUID = -4194331406714804089L;

    private int maxTemperature;
    private int countMode;

    public SmoothingIron() {
    }

    public SmoothingIron(long id, String company, String name, String type, BigDecimal price) {
        super(id, company, name, type, price);
    }

    public SmoothingIron(long id, String company, String name, String type, BigDecimal price,
                         int maxTemperature, int countMode) {
        super(id, company, name, type, price);
        this.maxTemperature = maxTemperature;
        this.countMode = countMode;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(int maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public int getCountMode() {
        return countMode;
    }

    public void setCountMode(int countMode) {
        this.countMode = countMode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        SmoothingIron that = (SmoothingIron) obj;
        return maxTemperature == that.maxTemperature &&
                countMode == that.countMode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), maxTemperature, countMode);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SmoothingIronDAO{").append("id='").append(getIdGoods()).append(", company='")
                .append(getCompany()).append(", name='").append(getName()).append(", type='")
                .append(getType()).append(", price=").append(getPrice()).append(", maxTemperature=")
                .append(maxTemperature).append( ", countMode=").append(countMode).append("'}'");
        return stringBuilder.toString();
    }
}
