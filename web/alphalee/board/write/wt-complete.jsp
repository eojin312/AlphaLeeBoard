<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/05/2019
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>글을 다 썼습니다</title>
</head>
<body>
<table border="1">
    <tr>
        <td>글번호</td>
        <td>${article.articleNo}</td>
    </tr>
    <tr>
        <td>제목</td>
        <td>${article.title}</td>
    </tr>
    <tr>
        <td>작성자</td>
        <td>${article.writer}</td>
    </tr>
    <tr>
        <td>내용</td>
        <td>${article.contents}</td>
    </tr>
    <tr>
        <td>작성일</td>
        <td>${article.createDate}</td>
    </tr>
</table>
<a href="/alphalee">홈으로 가기</a>
<a href="/alphalee/board/list">글 목록</a>
</body>
</html>
