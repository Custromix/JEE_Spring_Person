<%@ include file="/WEB-INF/jsp/header.jsp"%>

<c:url var="list" value="/course/list" />

<div class="container">

    <c:forEach items="${person}" var="pers">
        <h1>
        ${pers}
        </h1>
    </c:forEach>

    <c:forEach items="${persons}" var="course">
        <tr>
            <td>${course.id}--</td>
            <td>
                <c:out value="${course.name}" />
            </td>
            <td>
                <c:out value="${course.mail}" />
            </td>
        </tr>
    </c:forEach>
</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
