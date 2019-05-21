<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 19/05/2019
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>알파리의 홈페이지에 오신걸 환영합니다.</title>
    <style>
        .signup {
            width: 60px;
            height: 30px;
            background-color: bisque;
            float:right;
        }
        .write {
            width: 60px;
            height: 30px;
            background-color: chartreuse;
            float:right;
        }
        .title {
            font-size: 40px;
            font-color: red;
            font-weight: bold;
        }
    </style>
</head>
<body>
<h2 class="title">알파리</h2>

<button type="button" onclick="location.href='./member/signup/'" class="signup">
    회원가입
</button>


<button type="button" onclick="location.href='./member/write/write.jsp'" class="write">
    글쓰기
</button>


</body>
</html>
