package vn.edu.iuh.fit.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductImage")
public class ProductImage {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long image_id;
  @ManyToOne
  private Product product;
  private String path;
  private String alternative;

  public ProductImage() {
  }

  public ProductImage(long image_id, Product product, String path, String alternative) {
    this.image_id = image_id;
    this.product = product;
    this.path = path;
    this.alternative = alternative;
  }

  public long getImage_id() {
    return image_id;
  }

  public void setImage_id(long image_id) {
    this.image_id = image_id;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getAlternative() {
    return alternative;
  }

  public void setAlternative(String alternative) {
    this.alternative = alternative;
  }

  @Override
  public String toString() {
    return "ProductImage{" +
        "image_id=" + image_id +
        ", product=" + product +
        ", path='" + path + '\'' +
        ", alternative='" + alternative + '\'' +
        '}';
  }
}
