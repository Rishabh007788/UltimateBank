<%@page import="java.util.List"%>
<%@page import="dto.BankAccountdto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<BankAccountdto> activeAccounts =(List<BankAccountdto>) request.getSession().getAttribute("activeAccounts"); 
if(activeAccounts.isEmpty())
{%>
	<h1>No active account found</h1>
<% }
else{%>
<h1>Select account type</h1>

<% for(BankAccountdto accountdto : activeAccounts)
{%>
<a href="setactiveaccount?acno=<%= accountdto.getAcc_no()%>"><button><%=accountdto.getAcc_no() %></button></a>

<%} %>
<%} %>








</body>
</html>