<%@page import="dto.A3BankUserData"%>
<%@page import="dto.BankAccountdto"%>
<%@page import="dao.BankAccountdao"%>
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
<% List<A3BankUserData> userlist =(List<A3BankUserData>) request.getSession().getAttribute("userlist"); %>
<% List<BankAccountdto> savingaccounts =(List<BankAccountdto>) request.getSession().getAttribute("savingaccounts"); %>
<% List<BankAccountdto> currentaccounts =(List<BankAccountdto>) request.getSession().getAttribute("currentaccounts"); %>

<a href="seeallaccounts.jsp"><button><h3>view all accounts</h3></button></a>
<h1>Registered users : <%=userlist.size() %>  <a href="seeregisteredusers.jsp"><button><h3>View</h3></button></a></h1><br> 
<h1>Saving Accounts : <%=savingaccounts.size()%>  <a href="seesavingaccounts.jsp"><button><h3>View</h3></button></a></h1><br>
<h1>Current Accounts : <%=currentaccounts.size() %>  <a href="seecurrentaccounts.jsp"><button><h3>View</h3></button></a></h1><br> 
<h1><a href="Withdraw.jsp">Withdraw balance</a> </h1><br>
<h1><a href="Deposite.jsp">Deposit balance</a></h1>
</body>
</html>