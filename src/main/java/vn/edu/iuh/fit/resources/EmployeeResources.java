package vn.edu.iuh.fit.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.services.EmployeeServices;

@Path("/employee")
public class EmployeeResources {

  private final EmployeeServices employeeServices;

  public EmployeeResources() {
    employeeServices = new EmployeeServices();
  }

  @GET
  @Produces("application/json")
  public Response getAll(){
    return Response.ok(employeeServices.getAllEmployee()).build();
  }
  @POST
  @Produces("application/json")
  @Consumes("application/json")
  public Response insertEmployee(Employee employee){
    employeeServices.insertEmployee(employee);
    return Response.ok(employee).build();
  }
}
