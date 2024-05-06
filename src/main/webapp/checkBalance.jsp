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


<% BankAccountdto  accountdto = ( BankAccountdto)request.getSession().getAttribute("accdetail") ;
if(accountdto!=null){%>
		<h1><%=accountdto.getA3BankUserData().getUserName() %></h1>
		<h1> your  <%=accountdto.getAccount_type() %> account balance is : <%= accountdto.getAmount()%></h1>	
<% }


%>

<button onclick="goBack()">Go Back</button>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>

</body>
</html>