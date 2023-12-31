package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import vn.edu.iuh.fit.backend.enums.ProductStatus;

@Entity
@Table(name = "Product")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id")

  private long product_id;
  @Column(name = "product_name")

  private String name;
  @Column(name = "unit")

  private String unit;
  @Column(name = "status")

  private ProductStatus status;
  @Column(name = "manufacturer")

  private String manufacturer;
  @Column(name = "description")

  private String description;

  @OneToMany(mappedBy = "product")
  private List<OrderDetail> orderDetails;
  @OneToMany(mappedBy = "product")
  private List<ProductImage> productImageList;
  @OneToMany(mappedBy = "product")
  private List<ProductPrice> productPrices;

  public Product() {
  }

  public Product(long product_id, String name, String unit, ProductStatus status,
      String manufacturer,
      String description, List<OrderDetail> orderDetails, List<ProductImage> productImageList,
      List<ProductPrice> productPrices) {
    this.product_id = product_id;
    this.name = name;
    this.unit = unit;
    this.status = status;
    this.manufacturer = manufacturer;
    this.description = description;
    this.orderDetails = orderDetails;
    this.productImageList = productImageList;
    this.productPrices = productPrices;
  }

  public long getProduct_id() {
    return product_id;
  }

  public void setProduct_id(long product_id) {
    this.product_id = product_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public ProductStatus getStatus() {
    return status;
  }

  public void setStatus(ProductStatus status) {
    this.status = status;
  }

  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<OrderDetail> getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(List<OrderDetail> orderDetails) {
    this.orderDetails = orderDetails;
  }

  public List<ProductImage> getProductImageList() {
    return productImageList;
  }

  public void setProductImageList(List<ProductImage> productImageList) {
    this.productImageList = productImageList;
  }

  public List<ProductPrice> getProductPrices() {
    return productPrices;
  }

  public void setProductPrices(List<ProductPrice> productPrices) {
    this.productPrices = productPrices;
  }

  @Override
  public String toString() {
    return "Product{" +
        "product_id=" + product_id +
        ", name='" + name + '\'' +
        ", unit='" + unit + '\'' +
        ", status=" + status +
        ", manufacturer='" + manufacturer + '\'' +
        ", description='" + description + '\'' +
        ", orderDetails=" + orderDetails +
        ", productImageList=" + productImageList +
        ", productPrices=" + productPrices +
        '}';
  }
}
