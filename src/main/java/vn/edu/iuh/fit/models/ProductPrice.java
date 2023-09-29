package vn.edu.iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Blob;
import java.sql.Timestamp;
import org.joda.time.LocalDateTime;
import org.mariadb.jdbc.client.column.BlobColumn;

@Entity
@Table(name = "ProductPrice")
public class ProductPrice {

  @Id
  @Column(name = "price_date_time",columnDefinition = "Timestamp")
  private LocalDateTime price_date_time;
  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)

  private Product product;
  @Column(name = "price")
  private double price;
  @Column(name = "note")

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
