<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23/05/2019
  Time: 10:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

보여줄 게시글 번호는 ${articleNo}
<input type="button" onclick="history.back()" value="뒤로가기">

<a href="/alphalee/board/list">글 목록</a>

<a href="/alphalee/board/update?artice_no=${articleNo}">글 수정하기</a>

</body>
</html>
