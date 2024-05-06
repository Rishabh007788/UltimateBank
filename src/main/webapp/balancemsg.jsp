<%@page import="dto.BankTransaction"%>
<%@page import="java.util.List"%>
<%@page import="dto.BankAccountdto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bankresponse</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%String openAccountMsg =(String)request.getSession().getAttribute("accOpenMsg"); %>
<%List <BankTransaction> transactions = (List <BankTransaction>)request.getSession().getAttribute("transactions"); %>

<!-- check balance $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$-->
<% BankAccountdto  accountdto = ( BankAccountdto)request.getSession().getAttribute("accdetails") ;
if(accountdto!=null){%>
		<h1><%=accountdto.getA3BankUserData().getUserName() %></h1>
		<h1> your  <%=accountdto.getAccount_type() %> account balance is : <%= accountdto.getAmount()%></h1>	
		<button onclick="goBack()" class="btn btn-primary btn-lg">Go Back</button>
<% }
%>





    <script>
        function goBack() {
            window.history.back();
        }
    </script>

</body>
</html>