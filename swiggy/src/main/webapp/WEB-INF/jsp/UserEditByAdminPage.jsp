<html>
<head>
<title>
</title>
</head>
<body>
<form modelAttribute="user">
Username : <input type ="text" name="userName"/><br><br>
Password : <input type ="text" name="userPass"/><br><br>
Email    : <input type ="text" name="email" /> <br><br>
UserType : <input type ="text" name="userType" /><br><br>
<button type="submit" formaction="createUserByAdmin" method="post">Create user</button>
<button type="submit" formaction="updateUserByAdmin" method="post">Create user</button>
<button type="submit" formaction="deleteUserByAdmin" method="post">Create user</button>
</form>
</form>
</body>
</html>