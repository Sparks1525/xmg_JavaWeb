<%--
  Created by IntelliJ IDEA.
  User: aa
  Date: 2018/12/22
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <form action="/regedit" method="post">
        账号:<input type="text" name="username"><br/>
        密码:<input type="password" name="password"><br/>
        性别:<input type="radio" name="sex" value="man" >男<input type="radio" name="sex" value="women">女<br/>
        爱好:<input type="checkbox" name="hobby" value="java">Java
        <input type="checkbox" name="hobby" value="C">c
        <input type="checkbox" name="hobby" value="ojbc">objc<br/>
        城市:<select name="city">
                <option value="gc">广州</option>
                <option value="fj">福建</option>
            </select><br/>
        介绍:<textarea name="tt"></textarea><br/>
        <input type="submit">
    </form>
</body>
</html>
