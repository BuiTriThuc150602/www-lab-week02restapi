package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Employee;

public class EmployeeRepositories {

  private final EntityManager entityManager;
  private final EntityTransaction transaction;

  public EmployeeRepositories() {
    entityManager = Connection.getInstance().getEntityManager();
    transaction = Connection.getInstance().getTransaction();
  }

  public void insertEmp(Employee employee) {
    try {
      transaction.begin();
      entityManager.persist(employee);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }
  }

  public void setEmployeeStatus(Employee employee, EmployeeStatus status) {
    employee.setStatus(status);
  }

  public void update(Employee employee) {
    try {
      transaction.begin();
      entityManager.merge(employee);
      transaction.commit();
    } catch (Exception e) {
      transaction.rollback();
      e.printStackTrace();
    }
  }

  public List<Employee> getAllEmployee() {
    return entityManager.createNamedQuery("Employee.findAll", Employee.class).setParameter("status",EmployeeStatus.ACTIVE).getResultList();
  }

  public Optional<Employee> findById(long id) {
    Employee em = entityManager.find(Employee.class, id);
    return em == null ? Optional.empty() : Optional.of(em);
  }


}
