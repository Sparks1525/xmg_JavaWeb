<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2018/12/30
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/student/edit">添加</a>
<table border="1" width="70%" cellspacing="0" cellpadding="0">
    <tr style="background-color: orange">
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.students}" var="student" varStatus="vs">
            <tr style="background-color: ${vs.count % 2 == 0?"gray" : ""}">
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>
                    <a href="/student/delete?id=${student.id}">删除</a>|
                    <a href="/student/edit?id=${student.id}">编辑</a>
                </td>
            </tr>
    </c:forEach>

</table>


</body>
</html>
