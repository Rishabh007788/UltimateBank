<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="dto.BankAccountdto"%>
<%@page import="dto.A3BankUserData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer home</title>
<link rel="stylesheet" href="./css/nav.css">
<link rel="stylesheet" href="./css/service.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
   
</head>
<body>
<%A3BankUserData data = (A3BankUserData)request.getSession().getAttribute("A3BankUserData"); %>
 <% BankAccountdto  accdetail = ( BankAccountdto)request.getSession().getAttribute("accdetails") ;
    BankAccountdto  errormsg = ( BankAccountdto)request.getSession().getAttribute("checkbalerrormsg") ;
    Object passbookerrormsg = request.getSession().getAttribute("passbookerrormsg");
    Object transaction_errormsg = request.getSession().getAttribute("transaction_errormsg");
    %>
<nav class="topnav" id="myTopnav">
      
        <img src="./images/LOGO11.png" alt="" class="left" h>
        <a class="left">Home</a>
        <a class="left">Services</a>
        <a class="left">Personal</a>
        <a class="left">Buseness</a>
        <a class="left">NRI</a>
        
        <div class="dropdownn right">
          <button class="dropbtnn"  style="border-radius: 50%;" popovertarget="loginft"><%=data.getUserName() %> 
            <i class="fa fa-caret-downn"></i>
          </button>
          <div class="dropdown-contentt dropdown-content-login" id="loginft">
            <form action="llogoutt"><a ><button style="background: none; color: white; border: none;">Logout</button></a></form>
          </div>
        </div>

        <div class="dropdownn right">
          <button class="dropbtnn"  style="border-radius: 50%;">Accounts 
            <i class="fa fa-caret-downn"></i>
          </button>
          <div class="dropdown-contentt" id="accountft">
            <a href="OpenAccount.jsp">Open Acc</a>
            <a href="#">Current Acc</a>
            <a href="#">Saving Acc</a>
          </div>
        </div>
        <!--for small screen-->
        <h1 class="small-head-name">ULTIMATE BANK</h1>
        <a href="OpenAccount.jsp" class="small-Login-btn">Open Account</a>
        <a href="#" class="small-Login-btn">Current Account</a>
        <a href="#" class="small-Login-btn">Saving Account</a>
        <a href="#" class="small-Login-btn">Login to different account</a>
        <a href="/llogoutt?accno=<%=data.getEmail()%>" class="small-Login-btn">Logout</a>
        <a href="javascript:void(0);" class="icon" onclick="myFunction()">🍔</a>
        
    </nav>
<!--nav ends here##############################################-->

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
        <img src="./images/offer2.png" class="d-block w-100" alt="...">
      </div>
      <div class="carousel-item">
        <img src="./images/offer.png" class="d-block w-100" alt="...">
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
  </div>

<!--#########################################-->
<div class="service">
        <div class="ser_name">Check Balance</div>
        <div class="form_cnt">          
            <form action="checkBalance" method="post">
                <select class="select_inp" name="accno" required="required">
                    <option>select account</option>
                        <%for(BankAccountdto accountdto : data.getBankAccountdtos()){%>
                                <option value="<%=accountdto.getAcc_no()%>"><%=accountdto.getAccount_type() %> account </option>
                        <%}
                        %>
                </select><br><br>
                  <label for="pin">Pin : </label>
                  <input class="text_inp" type="text" id="pin" name="pin" placeholder="Enter pin" required="required"><br><br>
                  <button type="submit" class="sub-btn">Submit</button> <button type="reset" class="sub-btn" style="background-color: rgb(219, 79, 79);">Reset</button>
                   <%if(errormsg!=null){%>
                     <p class="error" style="color: rgb(216, 51, 51);"><%=errormsg %></p>
            <% } %>                                   
                </form>      
        </div>
    </div>

<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->

<div class="service">
        <div class="ser_name">Transfer Money</div>
        <div class="form_cnt">          
                     <form action="money_trans" method="post">
      <label for="name">Name : </label>
      <input name="name" class="text_inp"  type="text" id="name" placeholder="Enter receiver,s name.."><br><br>
      <label for="acc-no">Account No : </label>
      <input name="rec_accno" class="text_inp"  type="text" id="acc-no" placeholder="Enter receiver,s Acc No.."><br><br>
      <label for="acc-no">Amount : </label>
      <input name="amount" class="text_inp"  type="text" id="" placeholder="Amount.."><br><br>
      <select class="select_inp" name="sen_accno" required="required">
    	<option>select account</option>
    		<%for(BankAccountdto accountdto : data.getBankAccountdtos()){%>
    				<option value="<%=accountdto.getAcc_no()%>"><%=accountdto.getAccount_type() %> account </option>
    		<%}
    		%>
    </select><br><br>
      <label for="pin">Pin : </label>
      <input class="text_inp" type="text" id="pin" name="pin" placeholder="Enter pin" required="required"><br><br>
       <button type="submit" class="sub-btn">Submit</button>
      <button type="reset" class="sub-btn" style="background-color: rgb(219, 79, 79);">Reset</button>
      <%if(transaction_errormsg!=null){%>
                     <p class="error" style="color: rgb(216, 51, 51);"><%=transaction_errormsg %></p>
            <% } %>
    </form>
        </div>
    </div>
<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ -->

<div class="service">
        <div class="ser_name">Passbook</div>
        <div class="form_cnt">          
            <form action="feth_passbook" method="post">
                <select class="select_inp" name="accno" required="required">
                    <option>select account</option>
                        <%for(BankAccountdto accountdto : data.getBankAccountdtos()){%>
                                <option value="<%=accountdto.getAcc_no()%>"><%=accountdto.getAccount_type() %> account </option>
                        <%}
                        %>
                </select><br><br>
                  <label for="pin">Pin : </label>
                  <input class="text_inp" type="text" id="pin" name="pin" placeholder="Enter pin" required="required"><br><br>
                  <button type="submit" class="sub-btn">Submit</button> <button type="reset" class="sub-btn" style="background-color: rgb(219, 79, 79);">Reset</button>
                   <%if(passbookerrormsg!=null){%>
                     <p class="error" style="color: rgb(216, 51, 51);"><%=passbookerrormsg %></p>
            <% } %>                                   
                </form>      
        </div>
    </div>


<!--Java Script ##########################################-->


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!--<script src="./javascript/acc_service.js"></script>-->
<script src="./javascript/nav.js"></script>
</body>
</html>