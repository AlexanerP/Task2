package com.epam.task2.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Alexander Pishchala
 *
 * This class is the entity 'Refrigerator' and extends the 'Goods' class.
 * Here are the main characteristics of a refrigerator type goods.
 */
public class Refrigerator extends Goods implements Serializable {

    private static final long serialVersionUID = 5944837859751545777L;

    private double volumeFreezer;
    private double volumeNotFreezer;

    public Refrigerator() {
    }

    public Refrigerator(long id, String company, String name, String type, BigDecimal price) {
        super(id, company, name, type, price);
    }

    public Refrigerator(long id, String company, String name, String type, BigDecimal price,
                        double volumeFreezer, double volumeNotFreezer) {
        super(id, company, name, type, price);
        this.volumeFreezer = volumeFreezer;
        this.volumeNotFreezer = volumeNotFreezer;
    }

    public double getVolumeFreezer() {
        return volumeFreezer;
    }

    public void setVolumeFreezer(double volumeFreezer) {
        this.volumeFreezer = volumeFreezer;
    }

    public double getVolumeNotFreezer() {
        return volumeNotFreezer;
    }

    public void setVolumeNotFreezer(double volumeNotFreezer) {
        this.volumeNotFreezer = volumeNotFreezer;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Refrigerator that = (Refrigerator) obj;
        return Double.compare(that.volumeFreezer, volumeFreezer) == 0 &&
                Double.compare(that.volumeNotFreezer, volumeNotFreezer) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), volumeFreezer, volumeNotFreezer);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Refrigerator{").append("id='").append(getIdGoods()).append("', company='")
                .append(getCompany()).append(", name='").append(getName()).append(", type='")
                .append(getType()).append(", price=").append(getPrice()).append(", volumeFreezer=")
                .append(volumeFreezer).append(", volumeNotFreezer=").append(volumeNotFreezer).append("'}'");
        return stringBuilder.toString();
    }
}


