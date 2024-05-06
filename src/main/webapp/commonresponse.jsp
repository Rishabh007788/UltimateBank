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

<!-- passbook $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$-->

<%if(transactions!=null){%>
<h1>Passbook</h1>
<table border="1">
	<tr>
		<th>Transac ID</th>   <th>Deposited</th>    <th>Withdrawan</th>     <th>Balance</th>     <th>Date</th>    <th>Method</th>
	</tr>

<%for(BankTransaction transaction : transactions){%>
			
			<tr>
				<td><%=transaction.getTid() %></td>
				<td><%=transaction.getDeposite() %></td>
				<td><%=transaction.getWithdraw() %></td>
				<td><%=transaction.getBalance()%></td>
				<td><%=transaction.getDateTime().withNano(0).withSecond(0)%></td>
				<td><%=transaction.getMethod()%></td>
			</tr>
		
<% }%></table> <br><br>
<button onclick="goBack()" class="btn btn-primary btn-lg">Go Back</button>
<%}%>


    <script>
        function goBack() {
            window.history.back();
        }
    </script>

</body>
</html>