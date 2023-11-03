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


<div class="row justify-content-center">
    <div class="col-10">
        <div class="card" style="margin-top: 5%">
            <div class="card-header">
                REGISTER
            </div>
            <div class="card-body">
                <form method="post" action="register">
                    <div class="row">
                        <div class="col-6">
                            <label class="form-label">Name</label>
                            <input type="text" class="form-control" placeholder="Name" name="name"/>
                        </div>
                        <div class="col-6">
                            <label class="form-label">Firstname</label>
                            <input type="text" class="form-control" placeholder="Firstname" name="firstname"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <label class="form-label">Email</label>
                            <input type="email" class="form-control" placeholder="Email" name="mail"/>
                        </div>
                        <div class="col-6">
                            <label class="form-label">Birthday</label>
                            <input type="date" class="form-control" placeholder="Birthday" name="birthday"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label class="form-label">Address</label>
                            <input type="text" class="form-control" placeholder="Address" name="address"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <label class="form-label">Username</label>
                            <input type="text" class="form-control" placeholder="Username" name="username"/>
                        </div>
                        <div class="col-6">
                            <label class="form-label">Pasword</label>
                            <input type="password" class="form-control" placeholder="Password" name="password"/>
                        </div>
                        <div class="col-6">
                            <select name="group" id="" required>
                            <option value="">Choisissez un groupe</option>
                            <c:forEach items="${group}" var="groups">
                                <option value="${groups.id}">${groups.name}</option>
                            </c:forEach>
                        </select></div>
                    </div>
                    <div class="row" style="margin-top: 2%">
                        <input type="submit" class="red submit" type="button">
                    </div>

                </form>
            </div>
        </div>
    </div>
    <div class="segment">
        <a href="/login" class="no-account" type="button">Already sign in ?</a>
    </div>
</div>
</body>
</html>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>