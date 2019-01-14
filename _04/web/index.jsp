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

<form method="post" action="/demo4/reg">
    账号:<input type="text" name="username"/><br/>

    密码:<input type="password" name="password"/><br/>

    性别:
    <input type="radio" name="gender" value="boy">男
    <input type="radio" name="gender" value="girl">女<br/>

    爱好:
    <input type="checkbox" name="hobby" value="java">Java
    <input type="checkbox" name="hobby" value="c">C
    <input type="checkbox" name="hobby" value="objc">objc<br/>

    城市:<select>
            <option name="gz">广州</option>
            <option name="fs">佛山</option>
            <option name="dg">东莞</option>
        </select><br/>


    介绍:<textarea rows="5" cols="15" name="intro"></textarea><br/>

    <input type="submit" name="sub" value="朕要注册">
</form>
</body>
</html>
