<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2019/1/8
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script type="text/javascript">
    function goPage(pageNo) {
        //把翻页的页码存储到高级查询表单中
        document.getElementById("currentPage").value = pageNo;
        // 获取每页显示的条数,并存储到高级查询表单中
        document.getElementById("pageSize").value = document.getElementById("pageSizeItem").value;

        //提交高级查询表单
        document.forms[0].submit();
    }
</script>

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
