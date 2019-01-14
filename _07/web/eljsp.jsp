<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2018/12/29
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!--
 EL从作用域中查询指定属性名的共享数据,是有查找顺序的
 按照顺序依次从page,request,session,application寻找共享数据
-->
    <%
        // JSP的四大作用域
        pageContext.setAttribute("msg","pageContextValue");
        request.setAttribute("msg","requestValue");
        session.setAttribute("msg","sessionValue");
        application.setAttribute("msg","applicationValue");
    %>
<h3>获取出每一个作用域中的数据</h3>
pageContext:<%=pageContext.getAttribute("msg")%><br/>
request:<%=request.getAttribute("msg")%><br/>
session:<%=session.getAttribute("msg")%><br/>
application:<%=application.getAttribute("msg")%><br/>
<hr/>
<h3>pageContext的findAttribute方法</h3>
<%=pageContext.findAttribute("msg")%><br/>
<%=pageContext.getAttribute("msg") == null?"":pageContext.findAttribute("msg")%><br/>
msg EL :  ${msg} <br/>
</body>
</html>
