package newPaket;

import java.util.Calendar;
import java.util.Objects;

public class Product {
    private String name;
    private String punkt;
    private String seria;
    private Calendar srokGodnosti;
    private int kol;
    private int kol1;
    private int kol2;
    private int kol3;
    private double price;

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getPunkt() {
  return punkt;
 }

 public void setPunkt(String punkt) {
  this.punkt = punkt;
 }

 public String getSeria() {
  return seria;
 }

 public void setSeria(String seria) {
  this.seria = seria;
 }

 public Calendar getSrokGodnosti() {
  return srokGodnosti;
 }

 public void setSrokGodnosti(Calendar srokGodnosti) {
  this.srokGodnosti = srokGodnosti;
 }

 public int getKol() {
  return kol;
 }

 public void setKol(int kol) {
  this.kol = kol;
 }

 public int getKol1() {
  return kol1;
 }

 public void setKol1(int kol1) {
  this.kol1 = kol1;
 }

 public int getKol2() {
  return kol2;
 }

 public void setKol2(int kol2) {
  this.kol2 = kol2;
 }

 public int getKol3() {
  return kol3;
 }

 public void setKol3(int kol3) {
  this.kol3 = kol3;
 }

 public double getPrice() {
  return price;
 }

 public void setPrice(double price) {
  this.price = price;
 }

 @Override
 public boolean equals(Object o) {
  if (this == o) return true;
  if (o == null || getClass() != o.getClass()) return false;

  Product product = (Product) o;

  if (Double.compare(product.price, price) != 0) return false;
  if (!Objects.equals(name, product.name)) return false;
  if (!Objects.equals(punkt, product.punkt)) return false;
  if (!Objects.equals(seria, product.seria)) return false;
  return Objects.equals(srokGodnosti, product.srokGodnosti);
 }

 @Override
 public int hashCode() {
  int result;
  long temp;
  result = name != null ? name.hashCode() : 0;
  result = 31 * result + (punkt != null ? punkt.hashCode() : 0);
  result = 31 * result + (seria != null ? seria.hashCode() : 0);
  result = 31 * result + (srokGodnosti != null ? srokGodnosti.hashCode() : 0);
  temp = Double.doubleToLongBits(price);
  result = 31 * result + (int) (temp ^ (temp >>> 32));
  return result;
 }

 @Override
 public String toString() {
  return "Product{" +
          "Наименоввние='" + name + '\'' +
          ", пункт='" + punkt + '\'' +
          ", серия='" + seria + '\'' +
          ", срок годности=" + srokGodnosti.toString() +
          ", кол=" + kol +
          ", кол1=" + kol1 +
          ", кол2=" + kol2 +
          ", кол3=" + kol3 +
          ", price=" + price +
          '}';
 }
}
