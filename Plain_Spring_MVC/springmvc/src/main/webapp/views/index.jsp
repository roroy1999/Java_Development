<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
welcome to Robin

<form action="addAlien" method="post">
Enter your id : <input type="text" name="aid"></br>
Enter your name : <input type="text" name="aname"></br>
<input type="submit">
</form>
<hr>
To Find ID
<form action="getAlien" method="get">
	Enter your id : <input type="text" name="aid"></br>
	<input type="submit">
</form>
</body>
</html>