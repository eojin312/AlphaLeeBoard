<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 20/05/2019
  Time: 7:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>AlphaLee Complete Sign Up</title>
    <style>
        .message {
            font-color : gray;
            font-size: 40px;
        }
        .message_email {
            font-color : red;
            font-size: 40px;
        }
    </style>
</head>
<body>alphaLeeBoardUser
<p class="message">축하합니다 고객님 회원님의 고객번호는 ${alphaLeeBoardUser.alno} 입니다.</p>
<p class="message">축하합니다 고객님 회원님의 아이디는 ${alphaLeeBoardUser.id} 입니다.</p>
<p class="message_email">이메일은 ${alphaLeeBoardUser.email} 입니다.</p>
<button type="button" onclick="location.href='http://localhost:8080/alphalee/'">홈으로가기</button>
</body>
</html>
