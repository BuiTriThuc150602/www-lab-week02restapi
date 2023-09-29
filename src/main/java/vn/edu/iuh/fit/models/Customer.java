package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Customer")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "cust_id")
  private long cust_id;
  @Column(name = "cust_name")
  private String cust_name;
  @Column(name = "email")

  private String email;
  @Column(name = "phone")

  private String Phone;
  @Column(name = "address")

  private String address;
  @OneToMany(mappedBy = "customer")
  private List<Order> order;


  public Customer() {
  }

  public Customer(long cust_id, String cust_name, String email, String phone, String address,
      List<Order> order) {
    this.cust_id = cust_id;
    this.cust_name = cust_name;
    this.email = email;
    Phone = phone;
    this.address = address;
    this.order = order;
  }

  public long getCust_id() {
    return cust_id;
  }

  public void setCust_id(long cust_id) {
    this.cust_id = cust_id;
  }

  public String getCust_name() {
    return cust_name;
  }

  public void setCust_name(String cust_name) {
    this.cust_name = cust_name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return Phone;
  }

  public void setPhone(String phone) {
    Phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<Order> getOrder() {
    return order;
  }

  public void setOrder(List<Order> order) {
    this.order = order;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "cust_id=" + cust_id +
        ", cust_name='" + cust_name + '\'' +
        ", email='" + email + '\'' +
        ", Phone='" + Phone + '\'' +
        ", address='" + address + '\'' +
        ", order=" + order +
        '}';
  }
}
