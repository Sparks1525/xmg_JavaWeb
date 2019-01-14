<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2018/12/30
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<% request.setAttribute("data", new java.util.Date());%>

北京时间:${data}<br/>
jstl_fmt:<fmt:formatDate value="${data}" pattern="yyyy-mm-dd"/><br/>


<% request.setAttribute("num", 10); %>

<c:if test="${num > 5}">
    jstl_if:num > 5 <br>
</c:if>

<c:if test="${num > 10}" var="numresult" scope="request"/>

jstl_if_var:${numresult}<br/>


<% request.setAttribute("numc", 30); %>

<c:choose>
    <c:when test="${numc < 10}"> numc < 10</c:when>
    <c:when test="${numc > 5}"> numc > 5</c:when>
    <c:when test="${numc > 10}"> numc > 10</c:when>
    <c:when test="${numc > 20}"> numc > 20</c:when>
    <c:otherwise> numc otherwise </c:otherwise>
</c:choose><br/>

<hr/>
<%--
    需求1:从1输出到10
    1 2 3 4 5 6 7 8 9 10
--%>
<c:forEach var="numf" begin="1" end="10" step="2">
    jstl_numf:${numf}<br/> <!-- numf的作用范围只在forEach内 -->
</c:forEach>

<%--
    需求2:迭代一个集合中所有的数据
--%>
<hr/>
<%
    pageContext.setAttribute("listf", java.util.Arrays.asList("A", "B", "C", "D"));
%>

<c:forEach items="${listf}" var="ele" begin="2">
    jstl_listf:${ele}<br/>
</c:forEach>

<hr/>

<c:forEach items="${listf}" var="ele">
    jstl_listf:${ele}<br/>
</c:forEach>

<hr/>


<%
    // error 错误的写法
//<c:choose>
//    jstl_choose:<c:when test="${numc < 10}"> numc < 10</c:when><br/>
//    jstl_choose:<c:when test="${numc > 5}"> numc < 10</c:when><br/>
//    jstl_choose:<c:when test="${numc > 10}"> numc < 10</c:when><br/>
//    jstl_choose:<c:when test="${numc > 20}"> numc < 10</c:when><br/>
//    jstl_choose:<c:otherwise> numc otherwise </c:otherwise><br/>
//</c:choose>
%>


</body>
</html>
