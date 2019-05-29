<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 28/05/2019
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>글 수정</title>
</head>
<body>
<form action="/alphalee/board/update" method="post">
    <input type="hidden" name="article_no" value="${article.articleNo}">
    <table border="1">
        <tr>
            <td>작성자</td>
            <td><input type="text" name="writer" value="${article.writer}"></td>
        </tr>
        <tr>
            <td>글 제목</td>
            <td><input type="text" name="title" value="${article.title}"></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea name="contents" style="height: 320px; width: 500px ">${article.contentsWithReturn}</textarea>
            </td>
        </tr>
    </table>
    <input type="submit" name="write-button" value="글 올리기">
</form>

<input type="button" onclick="history.back()" value="취소">
<a href="/alphalee">홈으로 가기</a>
</body>
</html>
