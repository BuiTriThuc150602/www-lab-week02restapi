package vn.edu.iuh.fit.backend.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.util.List;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.services.EmployeeServices;

@Path("/employee")
public class EmployeeResources {

  private final EmployeeServices employeeServices;

  public EmployeeResources() {
    employeeServices = new EmployeeServices();
  }

  @GET
  @Produces("application/json")
  public Response getAll(){
    List<Employee> em = employeeServices.getAllEmployee();
    return Response.ok(em).build();
  }

  @POST
  @Produces("application/json")
  @Consumes("application/json")
  public Response insertEmployee(Employee employee){
    employeeServices.insertEmployee(employee);
    return Response.ok(employee).build();
  }
}
