<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Deposit Balance</h1>
<form action="deposite">

<h2>
<label for="name">Customer Name</label>
<input type="text" name = "name" id="name" placeholder="enter name..."> <br>
<label for="acno">Account No: </label>
<input type="text" name = "acno" id="acno" placeholder="enter Account No..."> <br>
<label for="Bal">Balance</label>
<input type="text" name = "amount" id="Bal" placeholder="enter amount..."> <br>
<input type="submit">
 </h2>
 
 </form>
 
 <%String msg =(String) request.getSession().getAttribute("msg");  
 if(msg!=null){
 %><p style="color:red;"><%=msg %></p>
 <%} %>
 

</body>
</html>