package vn.edu.iuh.fit.backend.resources;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import java.util.List;
import java.util.Optional;
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
  public Response getAll() {
    List<Employee> em = employeeServices.getAllEmployee();
    return Response.ok(em).build();
  }

  @GET
  @Produces("application/json")
  @Path("/{id}")
  public Response findById(@PathParam("id") Long id) {
    Optional<Employee> em = employeeServices.findById(id);
    if (em.isPresent()) {
      return Response.ok(em.get()).build();
    }
    return Response.status((Status.BAD_REQUEST)).build();
  }

  @POST
  @Produces("application/json")
  @Consumes("application/json")
  public Response insertEmployee(Employee employee) {
    employeeServices.insertEmployee(employee);
    return Response.ok(employee).build();
  }
}
