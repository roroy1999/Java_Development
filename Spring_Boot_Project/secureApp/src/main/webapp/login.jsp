<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <p style="color:red;">
	    ${SPRING_SECURITY_LAST_EXCEPTION.message}
	</p>
    <form action="login" method="post">  
	    <table>
	    	<tr>
	    		<td>User:</td>
	    		<td><input type='text' name='username' value=''></td>
	    	</tr>
	    	<tr>
	    		<td>Password:</td>
	    		<td><input type='text' name='password' value=''></td>
	    	</tr>
	    	<tr>
	    		<td><input name ='submit' type='submit'></td>
	    	</tr>
	    </table>
    </form>
</body>
</html>