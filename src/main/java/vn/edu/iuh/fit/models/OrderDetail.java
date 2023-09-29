package vn.edu.iuh.fit.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @ManyToOne
    private Order order;
    @Id
    @ManyToOne
    private Product product;
    private double quantity;
    private double price;
    private String note;


    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product, double quantity, double price, String note) {

        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
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
        return "OrderDetail{" +
            "order=" + order +
            ", product=" + product +
            ", quantity=" + quantity +
            ", price=" + price +
            ", note='" + note + '\'' +
            '}';
    }
}