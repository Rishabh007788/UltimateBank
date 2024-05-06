<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/AdminLogin.css">
</head>
<body>

<div id="formcnt">
	<form action="adminlogin">
		<label for="email">Email Id : </label>
		<input type="email" id="email" placeholder="enter email..." name="email" value="admin@gmail.com" class="txtinp"><br><br>
		<label for="pass">Password : </label>
		<input type="password" id="pass" name="password" placeholder="enter password" value="admin123" class="txtinp"><br><br>
		<pre><input type="submit" class="btninp">  <input type="reset" class="btninp"> </pre>
		<button onclick="goBack()" type="button">back</button>
	</form>
</div>
<script >
   function goBack(){
	   window.history.back();
   }
</script>


</body>
</html>