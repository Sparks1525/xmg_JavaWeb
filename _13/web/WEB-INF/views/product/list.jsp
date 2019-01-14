<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2019/1/4
  Time: 8:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function goPage(pageNo) {
            //把翻页的页码存储到高级查询表单中
            document.getElementById("currentPage").value = pageNo;
            // 获取每页显示的条数,并存储到高级查询表单中
            document.getElementById("pageSize").value = document.getElementById("pageSizeItem").value;

            //提交高级查询表单
            document.forms.namedItem("search").submit();
        }
    </script>

</head>
<body>
<form action="/product/pageQuery" method="post" name="search">
    <input type="hidden" name="currentPage" id="currentPage" value="1">
    <input type="hidden" name="pageSize" id="pageSize" value="${pageResult.pageSize}">
    商品名称<input type="search" name="productName" value="${qo.name}"/>
    零售价<input type="number" name="minSalePrice" value="${qo.minSalePrice}" style="width: 100px"/>
    <input type="number" name="maxSalePrice" value="${qo.maxSalePrice}" style="width: 120px"/>
    商品分类
    <select name="dirId" style="width: 120px">
        <option value="-1">所有分类</option>
        <c:forEach items="${dirs}" var="dir">
            <c:if test="${dir.parent_id != 0}">
                <option value="${dir.id}" ${qo.dirId==dir.id?"selected":""}>
                        ${dir.dirName}
                </option>
            </c:if>
        </c:forEach>
    </select>
    关键字<input type="search" name="keyword" value="${qo.keyword}" placeholder="商品名称/商品品牌" style="width: 200px"/>
    <input type="submit" value="搜索">
</form>

<a href="/product/list?cmd=edit">添加</a>
<table border="1" width="60%" cellpadding="0" cellspacing="0">
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

    <c:forEach items="${pageResult.listData}" var="product" varStatus="vs">
        <tr style="background-color: ${vs.count%2==0?"gray":""}">
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.brand}</td>
            <td>${product.dir.dirName}</td>
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
    <tr align="center">
        <td colspan="9">
            <a href="javascript:goPage(1);">首页</a>
            <a href="javascript:goPage(${pageResult.prevPage});">上页</a>
            <c:forEach begin="${pageResult.beginIndex}" end="${pageResult.endIndex}" var="pageNumber">
                <c:if test="${pageResult.currentPage == pageNumber}">
                    <span style="color: red;font-weight:bold;">${pageNumber}</span>
                </c:if>
                <c:if test="${pageResult.currentPage != pageNumber}">
                    <a href="javascript:goPage(${pageNumber});">${pageNumber}</a>
                </c:if>
            </c:forEach>
            <a href="javascript:goPage(${pageResult.nextPage});">下页</a>
            <a href="javascript:goPage(${pageResult.totalPage});">末页</a>
            一共${pageResult.totalCount}条数据,当前第${pageResult.currentPage} / ${pageResult.totalPage}页
            每页显示
            <select id="pageSizeItem" onchange="goPage(1);">
                <c:forEach items="${pageResult.pageSizeItems}" var="pageSizeItem">
                    <option ${pageResult.pageSize == pageSizeItem ?"selected":""}>
                            ${pageSizeItem}
                    </option>
                </c:forEach>
            </select>
            条
        </td>
    </tr>

</table>
</body>
</html>