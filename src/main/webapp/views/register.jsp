<%--
  Created by IntelliJ IDEA.
  User: Виктория
  Date: 01.05.2019
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><font color="red">${errorRegister}</font></p>
<form action="${pageContext.servletContext.contextPath}/controller?command=register_new_user" method="POST">
    <p> Регистрация нового пользователя </p>
    <p> Введите имя : <input name="newLoginName" type="text" />
    </p>
    <p> Введите пароль : <input name="newPassword" type="password" />
    </p>
    <input class ="button-main-page" type="submit" value="Зарегистрировать"/>
</form>
</body>
</html>