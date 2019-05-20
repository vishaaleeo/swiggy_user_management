<html>
<head>
<title>
</title>
<script>
if(${messageShow})
alert("${message}")
</script>
</head>
<body>
<br><br>
<form action="login" method="post" modelAttribute="user">
Username <input type="text" name="userName"/><br><br>
Password <input type="text" name="userPass"/><br><br>
<input type="submit" value="Login"/>
</form>
<form action="signup" method="get">
<input type="submit" value="Signup" />
</form>
</body
</html>