<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20/05/2019
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>알파리</title>
</head>
<body>
<form action="/alphalee/member/signup/process" id="member_join" method="post">
    <table border="1">
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" id="id"></td>
        </tr>
        <tr>
            <td>PassWord</td>
            <td><input type="password" name="pwd" id="pwd"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" id="email"></td>
        </tr>
    </table>
    <input type="button" onclick="join()" name="signup-button" value="가입하기">

</form>

<script>
    function join() {
        var id = document.getElementById("id").value;
        if (id == '') {
            alert('아이디를 입력해주세요');
            document.getElementById("id").focus();
            return;
        }
        var pwd = document.getElementById("pwd").value;
        if (pwd == '') {
            alert('비밀번호를 입력해주세요');
            document.getElementById("pwd").focus();
            return;
        }
        var email = document.getElementById("email").value;
        if (email == '') {
            alert('이메일을 입력해주세요');
            document.getElementById("email").focus();
            return;
        }

        document.getElementById("member_join").submit();
    }
</script>
</body>
</html>
