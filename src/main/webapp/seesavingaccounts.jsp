<%@page import="dto.BankAccountdto"%>
<%@page import="dto.A3BankUserData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Admin home page</h1>
<% List<BankAccountdto> savingaccounts =(List<BankAccountdto>) request.getSession().getAttribute("savingaccounts"); %>
<table border="1">
<tr>
<th>Account No.</th>
<th>Account Holder Name</th>
<th>User ID</th>
<th>Account type</th>
<th>status</th>
</tr>

<%for(BankAccountdto accountdto : savingaccounts){ %>
<tr>
<th><%=accountdto.getAcc_no()%></th>
<th><%=accountdto.getA3BankUserData().getUserName()%></th>
<th><%=accountdto.getA3BankUserData().getUserID()%></th>
<th><%=accountdto.getAccount_type()%></th>
<th><%=accountdto.isStatus()%></th>
</tr>

<% }%>
</table>
</body>
</html>