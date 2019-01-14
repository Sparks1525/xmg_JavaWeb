<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2018/12/28
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<html>
<head>
    <title>Insert title here</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
</head>
<body>

<jsp:include page="index.jsp"/>
<%@include file="index.jsp"%>


<!-- HTLM 注释代码 也会被翻译到 myjsp_jsp.java中 -->

<%--
注释Java脚本代码
************ JSP notate : JSP注释不会被编码 ************
--%>

<%
    String name = "Will";
    // this is java code : Java注释会被编码
    // 其中的语句会原封不动的被服务器翻译到对应的Servlet的_jspService方法中
    System.out.println("java in jsp");// show in console
%>

<%-- <%=表达式%>(实际上就是调用输出流打印到页面上)  --%>
<%=name%>


<%

    request.getAttribute("");
    session.getAttribute("");
    application.getAttribute("");
    response.getWriter();

%>


<%!
    //其中的语句会原封不动的被服务器翻译到对应Servlet类中,作为成员变量和方法
    private String file;

    private int getIdx() {
        return 0;
    }

%>


北京时间:<%=new java.util.Date().toLocaleString()%>
</body>
</html>
