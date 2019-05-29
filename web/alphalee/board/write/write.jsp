<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 21/05/2019
  Time: 10:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>알파리 글적기</title>
</head>
<body>
<form action="/alphalee/board/write" id="member_write" method="post">
    <table border="1">
        <tr>
            <td>작성자</td>
            <td><input type="text" name="writer" id="writer"></td>
        </tr>
        <tr>
            <td>글 제목</td>
            <td><input type="text" name="title" id="title"></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea name="contents" style="width: 500px; height: 320px;" id="contents"></textarea></td>
        </tr>
    </table>
    <input type="button" onclick="write()" name="write-button" value="글 올리기">
</form>


<script>
    function write() {
        var writer = document.getElementById("writer").value;
        if (writer == '') {
            alert('작성자를 입력해주세요');
            document.getElementById("writer").focus();
            return;
        }
        var title = document.getElementById("title");
        if (title == '') {
            alert('제목을 입력해주세요');
            document.getElementById("title").focus();
            return;
        }
        var contents = document.getElementById("contents");
        if (contents == '') {
            alert('글을 작성해주세요');
            document.getElementById("contents").focus();
            return;
        }
        document.getElementById("member_write").submit();
    }
</script>

<input type="button" onclick="history.back()" value="취소">
<a href="/alphalee">홈으로 가기</a>


</body>

</html>
