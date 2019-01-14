<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2018/12/30
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/student/save?id=${param.id}" method="post">
    <input type="hidden" name="id" value="${student.id}">
    姓名:<input type="text" name="name" required value="${student.name}"><br/>
    年龄:<input type="number" name="age" required value="${student.age}"><br/>
    <input type="submit" value='${studnet == null ?"保存":"更新"}'>
</form>

</body>
</html>
