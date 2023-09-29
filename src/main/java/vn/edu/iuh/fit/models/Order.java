package vn.edu.iuh.fit.models;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "cust_id", nullable = false)
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
    @Column(name = "orderDate")

    private LocalDateTime orderDate;

    public Order() {
    }

    public Order(long id, Employee employee, Customer customer, List<OrderDetail> orderDetails,
        LocalDateTime orderDate) {
        this.id = id;
        this.employee = employee;
        this.customer = customer;
        this.orderDetails = orderDetails;
        this.orderDate = orderDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", employee=" + employee +
            ", customer=" + customer +
            ", orderDetails=" + orderDetails +
            ", orderDate=" + orderDate +
            '}';
    }
}
