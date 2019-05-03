<%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 20.04.2019
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--First JSP
<p>Today <%= new java.util.Date() %></p>
My First JSP!!! My name is ${name} and password is ${password}--%>

<%--<form action="login" method="POST">
    Name : <input type="text" name="name"/> <input type="submit" />
</form>--%>

<p><font color="red">${errorMessage}</font></p>
<form action="login" method="POST">
    <p>  Name     : <input  name="name" type="text" />
    </p>
    <p>   Password : <input name="password" type="password" />
    </p>
    <input type="submit" />
</form>
<div>
    <form action="RegisterServlet" method="GET">
        <input class ="button-main-page" type="submit" value="Регистрация"/>
    </form>
</div>
</body>
</html>
