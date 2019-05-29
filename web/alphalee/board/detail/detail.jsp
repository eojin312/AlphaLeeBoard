<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23/05/2019
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <td>작성자</td>
        <td>${article.writer}</td>
    </tr>
    <tr>
        <td>글 제목</td>
        <td>${article.title}</td>
    </tr>
    <tr>
        <td>내용</td>
        <td>${article.contents}</td>
    </tr>
    <tr>
        <td>생성일자</td>
        <td>${article.createDate}</td>
    </tr>
    <tr>
        <td>변경일자</td>
        <td>${article.updateDate}</td>
    </tr>
    <tr>
        <td>조회수</td>
        <td>${article.readCount}</td>
    </tr>
    <tr>
        <td>추천 수</td>
        <td>${article.recommendCount}</td>
    </tr>
</table><input type="button" onclick="history.back()" value="뒤로가기">

<a href="/alphalee/board/list">글 목록</a>

<form action="/alphalee/board/recommendcount/update" name="recommend_count_form" id="recommend_count_form" method="post">
    <input type="hidden" id="article_no" name="article_no" value="${article.articleNo}">
    <input type="submit" name="update_recommend_count" value="추천하기">
</form>
<a href="/alphalee/board/update?article_no=${article.articleNo}">글 수정하기</a>
<a href="/alphalee">홈으로 가기</a>

</body>
</html>
