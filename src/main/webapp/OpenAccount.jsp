<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>openaccount</title>
</head>
<h1>Account Opening</h1>
<body>
<form action="open_acc">
<h2>Choose account type</h2>

	<input type="radio" name="accounttype" id="saving"  value="saving"><label for="saving"> : Saving  </label><br>
	
	<input type="radio" name="accounttype" id="current" value="current" ><label for="current"> : Current  </label><br><br>
	<label for="current">Pin : </label>
	<input type="text" name="pin" id="pin" placeholder="create a pin " ><br><br>
	<input type="submit"><br><br>
</form>

<button onclick="goBack()" class="btn btn-primary btn-lg">Go Back</button>
<script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>