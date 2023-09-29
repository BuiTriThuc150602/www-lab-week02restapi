package vn.edu.iuh.fit.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.joda.time.LocalDateTime;

@Entity
@Table(name = "ProductPrice")
public class ProductPrice {

  @Id
  private LocalDateTime price_date_time;
  @ManyToOne
  private Product product;
  private double price;
  private String note;

  public ProductPrice() {
  }

  public ProductPrice(LocalDateTime price_date_time, Product product, double price, String note) {
    this.price_date_time = price_date_time;
    this.product = product;
    this.price = price;
    this.note = note;
  }

  public LocalDateTime getPrice_date_time() {
    return price_date_time;
  }

  public void setPrice_date_time(LocalDateTime price_date_time) {
    this.price_date_time = price_date_time;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  @Override
  public String toString() {
    return "ProductPrice{" +
        "price_date_time=" + price_date_time +
        ", product=" + product +
        ", price=" + price +
        ", note='" + note + '\'' +
        '}';
  }
}
