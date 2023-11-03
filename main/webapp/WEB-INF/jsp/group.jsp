<%@ include file="/WEB-INF/jsp/header.jsp"%>


<%--<form method="post" action="/group/add">

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


</form>--%>
<div class="accordion" id="accordionExample">
    <c:forEach items="${groups}" var="group">
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingOne">
                <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    <c:out value="${group.name}" />
                </button>
            </h2>
            <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    <ul class="list-group">
                        <c:forEach items="${group.persons}" var="person">
                            <a href="/person/edit">
                                <li class="list-group-item active" aria-current="true"><c:out value="${person.name}" /></li>
                            </a>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
    </c:forEach>
    <%--<div class="accordion-item">
        <h2 class="accordion-header" id="headingTwo">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                Accordion Item #2
            </button>
        </h2>
        <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
            <div class="accordion-body">
                <strong>This is the second item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
            </div>
        </div>
    </div>
    <div class="accordion-item">
        <h2 class="accordion-header" id="headingThree">
            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                Accordion Item #3
            </button>
        </h2>
        <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
            <div class="accordion-body">
                <strong>This is the third item's accordion body.</strong> It is hidden by default, until the collapse plugin adds the appropriate classes that we use to style each element. These classes control the overall appearance, as well as the showing and hiding via CSS transitions. You can modify any of this with custom CSS or overriding our default variables. It's also worth noting that just about any HTML can go within the <code>.accordion-body</code>, though the transition does limit overflow.
            </div>
        </div>
    </div>--%>
</div>






<%@ include file="/WEB-INF/jsp/footer.jsp"%>