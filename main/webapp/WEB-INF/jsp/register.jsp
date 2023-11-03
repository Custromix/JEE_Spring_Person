<%--
  Created by IntelliJ IDEA.
  User: Retr0
  Date: 02/11/2023
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<div class="segment">
    <h1>Sign in</h1>
</div>
<h1>${name}</h1>
<p>PITE</p>

<form method="post" action="register">

    <input type="text" placeholder="Name" name="name"/>
    <input type="text" placeholder="Firstname" name="firstname"/>
    <input type="email" placeholder="Email" name="mail"/>
    <input type="text" placeholder="Address" name="address"/>
    <input type="date" placeholder="Birthday" name="birthday"/>
    <input type="text" placeholder="Username" name="username"/>
    <input type="password" placeholder="Password" name="password"/>
    <select name="group" id="" required>
        <option value="">Choisissez un groupe</option>
        <c:forEach items="${group}" var="groups">
            <option value="${groups.id}">${groups.name}</option>
        </c:forEach>
    </select>
    <input type="submit" class="red submit" type="button">


</form>

<div class="segment">
    <a href="/login" class="no-account" type="button">Already sign in ?</a>
</div>

</body>
</html>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>