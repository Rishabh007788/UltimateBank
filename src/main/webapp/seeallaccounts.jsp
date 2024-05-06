<%@page import="dto.BankAccountdto"%>
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
<% List<BankAccountdto> list =(List<BankAccountdto>) request.getSession().getAttribute("list"); %>
<table border="1">
<tr>
<th>Account No.</th>
<th>Name</th>
<th>ID</th>
<th>Account type</th>
<th>status</th>
<th>Change Status</th>
</tr>

<%for(BankAccountdto accountdto : list){ %>
<tr>
<th><%=accountdto.getAcc_no()%></th>
<th><%=accountdto.getA3BankUserData().getUserName()%></th>
<th><%=accountdto.getA3BankUserData().getUserID()%></th>
<th><%=accountdto.getAccount_type()%></th>
<th><%=accountdto.isStatus()%></th>
<th><a href="changestatus?accno=<%=accountdto.getAcc_no()%>"><button>Change Status</button></a></th>
</tr>

<% }%>
</table>
</body>
</html>