const apiULR = "../api/employee";
fetch(apiULR)
.then(response => response.json())
.then(data => {
  data.forEach(em => {
    let row = "<tr>";
    row += "<td>" + em.id + "</td>"
    row += "<td>" + em.fullName + "</td>"
    row += "<td>" + formatDate(em.dob) + "</td>"
    row += "<td>" + em.email + "</td>"
    row += "<td>" + em.phone + "</td>"
    row += "<td>" + em.address + "</td>"
    row += "<td>" + em.status + "</td>"
    row += "<td><button class='btn btn-outline-success' type='button' id='btnUpdate"
        + em.id
        + "' data-bs-toggle='modal' data-bs-target='#updateEmployeeModal'>Update</button></td>"
    row += "<td><button class=\"btn btn-outline-success\" type=\"button\" id=\"btnDelete\">Delete</button></td>"
    $("#tblEmployee tbody").append(row)

    // add event click
    const btnName = "#btnUpdate" + em.id
    $(btnName).click(function () {
      $("#employeeNameUpdate").html(em.fullName)
      $("#em_id").val(em.id)
      $("#fullName").val(em.fullName);
      $("#dob").val(formatDate(em.dob));
      $("#email").val(em.email);
      $("#phone").val(em.phone);
      $("#address").val(em.address);
      $("#status").val(em.status);
    })
  })
})
.catch(error => {
  console.error("Get API fail " + error)
})

function formatDate(originDate) {
  return originDate[0] + "-" + (originDate[1] > 9 ? originDate[1] : "0"
      + originDate[1]) + "-" + originDate[2];

}
//
// $("#saveEmployeeChanges").click(function () {
//   const updatedEmployeeFullName = $("#fullName").val();
//   const updatedEmployeeDob = $("#dob").val();
//   const updatedEmployeeEmail = $("#email").val();
//   const updatedEmployeePhone = $("#phone").val();
//   const updatedEmployeeAddress = $("#address").val();
//   const updatedEmployeeStatus = $("#status").val();
//
//   // Close the modal
//   $("#updateEmployeeModal").modal("hide");
// });


$("#saveEmployeeChanges").click(function () {
  const updatedEmployee = {
    fullName: $("#fullName").val(),
    dob: $("#dob").val(),
    email: $("#email").val(),
    phone: $("#phone").val(),
    address: $("#address").val(),
    status: $("#status").val(),
    id: $("#em_id").val()
  };

  // Make a fetch request to update the employee
  fetch("../api/employee", {
    method: "PUT",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(updatedEmployee)
  })
  .then(response => {
    if (!response.ok) {
      throw new Error(`Error updating employee: ${response.status}`);
    }
    // Handle success, e.g., show a success message or update UI
    console.log("Employee updated successfully");
    // Close the modal
    $("#updateEmployeeModal").modal("hide");
  })
  .catch(error => {
    // Handle error, e.g., show an error message or log the error
    console.error(error.message);
  });
});




$("#btnSearch").click(function (event) {
  event.preventDefault();
  let id = $("#employeeID").val()
  fetch(apiULR + "/" + id)
  .then(response => {
    if (response.status === 200) {
      response.json();
    } else {
      alert("Employee with id = " + id + " isn't exist")
    }
  })
  .then(data => {
    data.forEach(em => {
      let row = "<tr>";
      row += "<td>" + em.id + "</td>"
      row += "<td>" + em.fullName + "</td>"
      row += "<td>" + formatDate(em.dob) + "</td>"
      row += "<td>" + em.email + "</td>"
      row += "<td>" + em.phone + "</td>"
      row += "<td>" + em.address + "</td>"
      row += "<td>" + em.status + "</td>"
      row += "<td><button class='btn btn-outline-success' type='button' id='btnUpdate"
          + em.id
          + "' data-bs-toggle='modal' data-bs-target='#updateEmployeeModal'>Update</button></td>"
      row += "<td><button class=\"btn btn-outline-success\" type=\"button\" id=\"btnDelete\">Delete</button></td>"
      $("#tblEmployee tbody").append(row)

      // add event click
      const btnName = "#btnUpdate" + em.id
      console.log(btnName)
      $(btnName).click(function () {
        console.log(em.id)
        $("#fullName").val(em.fullName);
        $("#dob").val(formatDate(em.dob));
        $("#email").val(em.email);
        $("#phone").val(em.phone);
        $("#address").val(em.address);
        $("#status").val(em.status);
      })
    })
  })
})

