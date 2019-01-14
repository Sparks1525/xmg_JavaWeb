<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2018/12/30
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

jsp相关:
<!----> <%-- --%> <% //service()方法内的代码 %> <%! // 类下的成员变量和方法 %>
<%=request.getAttribute("value")%>

el相关:
${pageScope.name}
${requestScope.name}
${sessionScope.name}
${applicationScope.name}
${param.name}
${initParam.name[1]}
${person.["name"]}
${p.map.key}
${p.list[1]}
${empty list}
${pageContext.request.getContextPath()}


jstl相关:
先导包 jstl.jar standard.jar
引入标签库
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="">

</c:if>
<c:if test="" var="" scope="request" />
<c:forEach var="迭代值" begin="开始值" items="迭代对象" step="递增值" end="结束值(包含)">
<c:choose>
    <c:when test=""></c:when>
    <c:when test=""></c:when>
    <c:otherwise></c:otherwise>
</c:choose>


</c:forEach>



</body>
</html>
