<%@ include file="/WEB-INF/jsp/header.jsp"%>
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

<form method="post" action="/Group/add">

    <input type="text" placeholder="Name" name="name"/>
    <select name="person" id="">
        <option value="">Choisissez une personne</option>
        <c:forEach items="${persons}" var="person">
            <option value="${person.id}">${person.name}</option>
            <c:if test = "${person.groupe == null}">

            </c:if>

        </c:forEach>
    </select>
    <button class="btn btn-primary" type="button">+</button>

    <input type="submit" class="red submit" type="button">


</form>

<script>
    addNewSelect
</script>

</body>
</html>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>