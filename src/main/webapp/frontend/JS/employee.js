const apiULR = "/www_lab_week02_restapi/api/employee";
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
    row += "<td><button class=\"btn btn-outline-success\" type=\"button\" id=\"btnUpdate\">Update</button></td>"
    row += "<td><button class=\"btn btn-outline-success\" type=\"button\" id=\"btnDelete\">Delete</button></td>"
    $("#tblEmployee tbody").append(row)
  })
})
.catch(error => {
  console.error("Get API fail " + error)
})

function formatDate(orginDate) {
  let newDate = new Date(orginDate[0], orginDate[1] - 1, orginDate[2]);
  return newDate.toLocaleDateString();
}
$("#btnSearch").click(function (event) {
  event.preventDefault();
  let id = $("#employeeID").val()
  console.log(id)
  fetch(apiULR)
  .then(response => {
    if (response.status === 200) {
      response.json();
    } else {
      alert("Employee with id = " + id + "isn't exist")
    }
  })
  .then(data => {
    console.log(data)
    let row = "<tr>";
    row += "<td>" + data.id + "</td>"
    row += "<td>" + data.fullName + "</td>"
    row += "<td>" + formatDate(data.dob) + "</td>"
    row += "<td>" + data.email + "</td>"
    row += "<td>" + data.phone + "</td>"
    row += "<td>" + data.address + "</td>"
    row += "<td>" + data.status + "</td>"
    row += "<td><button class=\"btn btn-outline-success\" type=\"button\" id=\"btnUpdate\">Update</button></td>"
    row += "<td><button class=\"btn btn-outline-success\" type=\"button\" id=\"btnDelete\">Delete</button></td>"
    $("#tblEmployee tbody").append(row)
  })

})

