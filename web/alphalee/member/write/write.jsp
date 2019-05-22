<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/05/2019
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>알파리 글적기</title>
</head>
<body>
<form action="/alphalee/member/write/" method="post">
    <table border="1">
        <tr>
            <td>작성자</td>
            <td><input type="text" name="writer"></td>
        </tr>
        <tr>
            <td>글 제목</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea name="contents" style="width: 500px;"
                          style="height: 500px;"></textarea>
            </td>
        </tr>
    </table>
    <input type="submit" name="write-button" value="글 올리기">
</form>

</body>
</html>
