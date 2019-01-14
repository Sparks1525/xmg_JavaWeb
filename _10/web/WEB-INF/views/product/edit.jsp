<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form action="/product/list?cmd=save" method="post">
    <input type="hidden" name="id" value="${product.id}">
    货品名称:<input type="text" name="productName" value="${product.productName}"><br/>
    货品品牌:<input type="text" name="brand" value="${product.brand}"><br/>
    货品分类:
    <select name="productDir">
        <c:forEach items="${productDirs}" var="productDir">
            <option value="${productDir.id}" ${productDir.id==product.dir.id?"selected":""}>
                    ${productDir.dirName}
            </option>
        </c:forEach>
    </select><br/>
    供应商:<input type="text" name="supplier" value="${product.supplier}"><br/>
    零售价:<input type="number" name="salePrice" value="${product.salePrice}"><br/>
    成本价:<input type="number" name="costPrice" value="${product.costPrice}"><br/>
    折扣:<input type="number" name="cutoff" value="${product.cutoff}" max="1.00" min="0.01" step="0.01"><br/>
    <input type="submit" value="${product == null?"保存":"修改"}">
</form>

</body>
</html>
