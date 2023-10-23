package vn.edu.iuh.fit.backend.wwwlabweek02restapi;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.services.EmployeeServices;

@ApplicationPath("/api")
public class RootApplication extends Application {

//  public static void main(String[] args) {
//    EmployeeServices ems = new EmployeeServices();
//    LocalDateTime d = LocalDate.parse("2002-06-22", DateTimeFormatter.ISO_DATE).atStartOfDay();
//    for (int i = 0; i < 1000 ; i++){
//      Employee em = new Employee("Name "+i,d.plusDays(1),"mail"+i+"@gmail.com","091234567"+i,i+i+i+"/abc gò vấp",
//          EmployeeStatus.ACTIVE);
//      ems.insertEmployee(em);
//
//    }
//  }

}