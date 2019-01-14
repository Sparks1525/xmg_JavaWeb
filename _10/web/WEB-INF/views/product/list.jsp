<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2019/1/3
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/product/list?cmd=edit">添加</a>
<table border="1" cellpadding="0" cellspacing="0" width="60%">
    <tr style="background-color: orange">
        <th>货品编号</th>
        <th>货品名称</th>
        <th>货品品牌</th>
        <th>货品分类</th>
        <th>供应商</th>
        <th>零售价</th>
        <th>成本价</th>
        <th>折扣</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${requestScope.products}" var="product" varStatus="vs">
        <tr style="background-color: ${vs.count%2==0?"gray":""}">
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.brand}</td>
            <td>${product.dir.id}</td>
            <td>${product.supplier}</td>
            <td>${product.salePrice}</td>
            <td>${product.costPrice}</td>
            <td>${product.cutoff}</td>
            <td>
                <a href="/product/list?cmd=delete&id=${product.id}">删除</a>|
                <a href="/product/list?cmd=edit&id=${product.id}">编辑</a>
            </td>
        </tr>
    </c:forEach>



</table>

</body>
</html>
