<%@page import="dto.A3BankUserData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% A3BankUserData userdata =(A3BankUserData) request.getSession().getAttribute("A3BankUserData");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/openaccount.css">
</head>
<body>
 <div id="heading"> <h1>Ultimate</h1> <img src="LOGO11.png" alt=""> <h1>Bank</h1></div>
    
    <form action="oppenaccpunt" method="post" enctype="multipart/form-data">
        
        <div class="column col1" >
            <label for="name">Name :</label>
            <input id="name" class="txt" type="text" name="name"  value="<%=userdata.getUserName()%>"  readonly="readonly">

            <label for="fname">Father's Name :</label>
            <input id="fname" class="txt" type="text" name="fname" placeholder="Enter father's name...">

            <label for="mname">Mother's Name :</label>
            <input id="mname" class="txt" type="text" name="mname" placeholder="Enter mother's name...">

            <label for="aadhar">Aadhar No. :</label>
            <input id="aadhar" class="txt" type="text" name="aadhar" placeholder="Enter adhar number...">

            <label for="mob">Mobile No. :</label>
            <input id="mob" class="txt" type="text" name="mob"value="<%=userdata.getMobNo()%>"  readonly="readonly">

            <label for="email">Email :</label>
            <input id="email" class="txt" type="text" name="email"value="<%=userdata.getEmail()%>"  readonly="readonly">

            <label for="dob">Date Of Birth :</label>
            <input id="dob" type="date" name="dob">

            
            <label for="address">Address :</label>
            <input id="address" class="txt" type="text" name="address" placeholder="Enter full address...">


            
        </div>

        <div class="column">

            <label for="">Gender </label>
            <label for="male" class="rdo">Male : </label>
            <input id="male" class="rdo" type="radio" name="gender" value="male"><br>
            <label for="female" class="rdo">Female :</label>
            <input id="female" class="rdo" type="radio" name="gender" value="female">

            <label for="">Account type :</label>
            <label for="saving" class="rdo">Saving :</label>
            <input id="saving" class="rdo" type="radio" name="acctype" value="saving"><br>
            <label for="current" class="rdo">Current :</label>
            <input id="current" class="rdo" type="radio" name="acctype" value="current">

            <label for="">Upload photo :</label>
            <input type="file" id="photo" class="rdo" name="photo" accept="image/*">

            <label for="">Upload Signature :</label>
            <input type="file" id="sign" class="rdo" name="signature" accept="image/*">

            
            <label for="pin">Pin :</label>
            <input id="pin" class="txt" type="txt" name="pin" placeholder="create one pin...">


            <button type="submit">Submit</button>
            <button type="reset" class="btn2">Reset</button>
        </div>

        
    
    </form>
</body>
</html>
