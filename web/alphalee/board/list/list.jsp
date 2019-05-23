<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23/05/2019
  Time: 9:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>알파리 게시판</title>
</head>
<body>
<table border="1">
    <tr>
        <th>번호</th>
        <th>글 제목</th>
        <th>작성자</th>
    </tr>
<c:forEach var="article" items="${articleList}">
    <tr>
        <td>${article.articleNo}</td>
        <td><a href="/alphalee/board/detail?article_no=${article.articleNo}">${article.title}</a></td>
        <td>${article.writer}</td>
    </tr>
</c:forEach>
</table>
<a href="/alphalee/board/write/write.jsp">글쓰기</a>
</body>
</html>
