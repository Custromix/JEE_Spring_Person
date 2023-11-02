<%--
  Created by IntelliJ IDEA.
  User: Retr0
  Date: 02/11/2023
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add group</title>
</head>
<body>

<form method="post" action="/group/add">

    <input type="text" placeholder="Name" name="name"/>
    <select name="person" id="" onselect="addNewSelect()">
        <option value="">Choisissez une personne</option>
        <c:forEach items="${persons}" var="person">

            <c:if test = "${person.group != null}">
                <option value="${person.id}">${person.name}</option>
            </c:if>

        </c:forEach>
    </select>

    <input type="submit" class="red submit" type="button">


</form>

</body>
</html>
