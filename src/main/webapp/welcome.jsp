<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome_to_ULTIMATE_BANK</title>
<link rel="stylesheet" href="./css/nav.css">
   
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>
	<nav class="topnav" id="myTopnav">
      
        <img src="./images/LOGO11.png" alt="" class="left" h>
        <a class="left">Home</a>
        <a class="left">Services</a>
        <a class="left">Personal</a>
        <a class="left">Buseness</a>
        <a class="left">NRI</a>
        <a class="right" href="register.jsp">Register</a>
        
        <div class="dropdownn right">
          <button class="dropbtnn">Logins 
            <i class="fa fa-caret-downn"></i>
          </button>
          <div class="dropdown-contentt">
            <a href="UserLogin.jsp">Customer</a>
            <a href="AdminLogin.jsp">Admin</a>
          </div>
        </div>
        <!--for small screen-->
        <h1 class="small-head-name">ULTIMATE BANK</h1>
        <a href="UserLogin.jsp" class="small-Login-btn">Login as Customer</a>
        <a href="AdminLogin.jsp" class="small-Login-btn">Login as Admin</a>
        <a href="javascript:void(0);" class="icon" onclick="myFunction()">
          ≣
        </a>
        
    </nav>
<!--nav ends here-->


  <!-- Carousal-->

  <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="true">
    <div class="carousel-indicators">
      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
      <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
    </div>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="./images/Screenshot (23).png" class="d-block w-100" alt="...">
      </div>
      <div class="carousel-item">
        <img src="./images/offer.png" class="d-block w-100" alt="...">
      </div>
      <div class="carousel-item">
        <img src="./images/creditoffer.png" class="d-block w-100" alt="...">
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true" ></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
  </div>


<script>
  function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
function login() {
  
}
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>