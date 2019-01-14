<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2018/12/29
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="_01.javabean1.Person" %>
<%@ page import="java.util.*" %>
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
    Person p1 = new Person();
    p1.setName("p1");
    p1.setAge(100);
    p1.setId(1L);
    request.setAttribute("p1", p1);


    Person p2 = new Person();
    p2.setName("p2");
    p2.setAge(200);
    p2.setId(2L);
    session.setAttribute("p2", p2);
%>


jsp_p1:<%=request.getAttribute("p1")%><br/>

el_p2_value:${p2.id}<br/> <!-- p2.id相当于 p2.getId();  遵循JavaBean,有getXxx(),也就是有属性  -->
el_p2_getId:${p2.getId()}<br/>
el_p1_getName:${p1["name"]}<br/>
el_param:${param.urlparam}<br/>  <!-- 地址栏后面跟？urlparam=xxx : ServletRequest req -> req.getParameter()     -->

el_invoke_method_ContextPath:${pageContext.getRequest().getContextPath()}<br/> <!-- 调用方法 -->

<%
    List list = new ArrayList();
    request.setAttribute("list",list);
%>

el_list_empty:${empty list}<br/> <!-- 判空 -->

<hr/>

<%
    // JSP的四大作用域
    pageContext.setAttribute("msg", "pageContextValue");
    request.setAttribute("msg", "requestValue");
    session.setAttribute("msg", "sessionValue");
    application.setAttribute("msg", "applicationValue");
%>
<h3>获取出每一个作用域中的数据</h3>
pageContext:<%=pageContext.getAttribute("msg")%><br/>
request:<%=request.getAttribute("msg")%><br/>
session:<%=session.getAttribute("msg")%><br/>
application:<%=application.getAttribute("msg")%><br/>
<hr/>
<h3>pageContext的findAttribute方法</h3>
<%=pageContext.findAttribute("msg")%><br/>
<%=pageContext.getAttribute("msg") == null ? "" : pageContext.findAttribute("msg")%><br/>


<hr/>

<!--
pageScope 对应 JSP作用域 pageContext
requestScope 对应 JSP作用域 request
sessionScope 对应 JSP作用域 session
applicationScope 对应 JSP作用域 application
-->
msg EL : ${msg} <br/> <!-- 同名取值顺序:pageScope，requestScope,sessionScope,applicationScope-->

el_pageScope_msg:${pageScope.msg}<br/>
el_requestScope_msg:${requestScope.msg}<br/>
el_session_msg:${sessionScope.msg}<br/>
el_application_msg:${applicationScope.msg}<br/>




</body>
</html>
