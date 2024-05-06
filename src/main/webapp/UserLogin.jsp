<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>logintoultimatebank</title>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>
<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
<% String error = (String) request.getAttribute("error"); %>
<div id="main">
        <div id="heading"> <img src="./images/LOGO11.png" alt=""><h1>Ultimate Bank</h1></div>
        
        <div class="main2">
                <div id="loghead">
                      <b>Login</b>
                
                </div>
            <form action="loginncon">
                <div class="logintop">
                    <p id="e1">Email:</p>
                    <input type="text" placeholder="Enter your email here..." id="Email" name="email" required="required">
                    
                    <p id="pass">Password:</p>
                    <input type="password" placeholder="Enter your password here..." id="password" name="password" required="required">
                    <p class="errormsg">
                    		<% if (errorMessage != null) { %>
        <%= errorMessage %>
    <% } %>
    
    <% if (error!= null) { %>
        <%= error %>
    <% } %>
                    </p>  
                    <button id="loginbt" type="submit">Submit</button>
                </div>
            </form >

                <div class="loginbottum">
                     <hr id="hrr1"> <hr id="hrr2">
                     <div id="or">OR</div>
                    
                    <div id="reg">
                        <a href="Resgister.html"><button id="registbt">Register</button></a>
                    </div>

                    <p class="clickhere">Click here if you haven't register</p>

                    <button id="forgot"> Forgot Password</button>

                    <button id="help" onclick="goBack()">Go Back</button>
                </div>
        
        </div>
            
        
    </div>

    
    
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>