<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20/05/2019
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>앒</title>
</head>
<body>
<form action="/alphalee/member/signup/process" method="post">
    <table border="1">
        <tr>
            <td>ID</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>PassWord</td>
            <td><input type="password" name="pwd"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"></td>
        </tr>
    </table>
    <input type="submit" name="signup-button" value="가입하기">
</form>
</body>
</html>
