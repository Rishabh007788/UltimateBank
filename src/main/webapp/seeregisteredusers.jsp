<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
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
<% List<A3BankUserData> userlist =(List<A3BankUserData>) request.getSession().getAttribute("userlist"); %>
<table border="1">
<tr>
<th>Userid</th>
<th>Name</th>
<th>Email</th>
<th>Mobile no</th>
<th>Saving Acc</th>
<th>Current Acc</th>
</tr>

<%for(A3BankUserData accountdto : userlist){ %>
 <%List<BankAccountdto> list = accountdto.getBankAccountdtos(); 
String sav="";
String sflag="";
String cur="";
String cflag="";
if(list!=null && !list.isEmpty()){
	for(BankAccountdto acc : list){
		if(acc.getAccount_type().equals("saving")){
			sav=acc.getAccount_type();
		}
		else{
			cur=acc.getAccount_type();
		}
	}
}
if(sav.equals("saving")) sflag="yes";
else sflag="no";
if(cur.equals("current")) cflag="yes";
else cflag="no";
 %>
<tr>
<th><%=accountdto.getUserID()%></th>
<th><%=accountdto.getUserName()%></th>
<th><%=accountdto.getEmail()%></th>
<th><%=accountdto.getMobNo()%></th>
<th><%=sflag%></th>
<th><%=cflag%></th>
</tr>

<% }%>
</table>
</body>
</body>
</html>