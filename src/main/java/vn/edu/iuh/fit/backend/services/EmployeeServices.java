package vn.edu.iuh.fit.backend.services;

import java.util.List;
import java.util.Optional;
import vn.edu.iuh.fit.backend.repositories.EmployeeRepositories;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Employee;

public class EmployeeServices {

  private final EmployeeRepositories repository;

  public EmployeeServices() {
    repository = new EmployeeRepositories();
  }

  public void insertEmployee(Employee employee) {
    repository.insertEmp(employee);
  }

  public void update(Employee employee) {
    repository.update(employee);
  }

  public Optional<Employee> findById(long id) {
    return repository.findById(id);
  }

  public List<Employee> getAllEmployee(){
    return repository.getAllEmployee();
  }

  public boolean deleteEmployee(long id){
    Optional<Employee> emp = repository.findById(id);
    if (emp.isPresent()){
      Employee employee = emp.get();
      repository.setEmployeeStatus(employee, EmployeeStatus.TERMINATED);
      return true;
    }
    return false;
  }

  public boolean activeEmployee(long id){
    Optional<Employee> emp = repository.findById(id);
    if (emp.isPresent()){
      Employee employee = emp.get();
      repository.setEmployeeStatus(employee, EmployeeStatus.ACTIVE);
      return true;
    }
    return false;
  }

}
