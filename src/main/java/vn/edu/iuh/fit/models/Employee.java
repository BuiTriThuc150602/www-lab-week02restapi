package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import org.joda.time.DateTime;
import vn.edu.iuh.fit.enums.EmployeeStatus;

import java.util.List;

@Entity
@Table(name = "Employee")
@NamedQueries(
    @NamedQuery(name = "Employee.findAll",query = "select e from Employee e where e.status = :status")
)
public class Employee {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "emp_id")
  private Long id;
  @Column(name = "full_name", length = 150, nullable = false)
  private String fullName;
  @Column(name = "dob", nullable = false)
  private DateTime dob;
  @Column(name = "email", length = 150, unique = true)
  private String email;
  @Column(name = "phone", length = 15, nullable = false)
  private String phone;
  @Column(name = "address", length = 150, nullable = false)
  private String address;
  @Column(name = "status", nullable = false)
  private EmployeeStatus status;
  @OneToMany(mappedBy = "employee")
  private List<Order> lstOrders;

  public Employee(Long id, String fullName, DateTime dob, String email, String phone,
      String address,
      EmployeeStatus status) {
    this.id = id;
    this.fullName = fullName;
    this.dob = dob;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.status = status;
  }

  public Employee() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public DateTime getDob() {
    return dob;
  }

  public void setDob(DateTime dob) {
    this.dob = dob;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public EmployeeStatus getStatus() {
    return status;
  }

  public void setStatus(EmployeeStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", fullName='" + fullName + '\'' +
        ", dob=" + dob +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", address='" + address + '\'' +
        ", status=" + status +
        '}';
  }
}
