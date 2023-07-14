package org.example;

import java.util.Objects;

public class Product {
    private String name;
    private String point;
    private String series;
    private String expirationDate;
    private String quantity;
    private String quantity1;
    private String quantity2;
    private String quantity3;
    private String price;
    public String getQuantity2() {
        return quantity2;
    }

    public void setQuantity2(String quantity2) {
        this.quantity2 = quantity2;
    }

    public String getQuantity3() {
        return quantity3;
    }

    public void setQuantity3(String quantity3) {
        this.quantity3 = quantity3;
    }

    public String getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(String quantity1) {
        this.quantity1 = quantity1;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!name.equals(product.name)) return false;
        if (!point.equals(product.point)) return false;
        if (!series.equals(product.series)) return false;
        return expirationDate.equals(product.expirationDate);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + point.hashCode();
        result = 31 * result + series.hashCode();
        result = 31 * result + expirationDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "Наименование='" + name + '\'' +
                ", пункт='" + point + '\'' +
                ", серия='" + series + '\'' +
                ", срок годности='" + expirationDate + '\'' +
                ", количество=" + quantity +
                ", количество1=" + quantity1 +
                ", количество2=" + quantity2 +
                ", количество3=" + quantity3 +
                ", цена=" + price +
                '}';
    }
}
