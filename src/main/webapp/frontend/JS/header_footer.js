fetch("header.html")
.then(response => response.text())
.then(data => {
  document.getElementById("header_container").innerHTML = data;
})