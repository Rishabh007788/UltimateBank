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


<%if(openAccountMsg!=null){%>
	<h1><%=openAccountMsg %></h1>
	<%}
%>



    <script>
        function goBack() {
            window.history.back();
        }
    </script>

</body>
</html>