<%@ include file="/WEB-INF/jsp/header.jsp"%>


<div class="row justify-content-center">
    <div class="col-10">
        <div class="card" style="margin-top: 5%">
            <div class="card-header">
                Edit Person
            </div>
            <div class="card-body">
                <form method="post" action="edit">
                    <div class="row">
                        <div class="col-6">
                            <label class="form-label">Name</label>
                            <input type="text" name="name" class="form-control" value="${person.name}">
                        </div>
                        <div class="col-6">
                            <label class="form-label">Firstname</label>
                            <input type="text" name="firstname" class="form-control" value="${person.firstname}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <label class="form-label">Email</label>
                            <input type="email" name="mail" class="form-control" value="${person.mail}">
                        </div>
                        <div class="col-6">
                            <label class="form-label">Birthday</label>
                            <input type="date" name="birthday" class="form-control" value="${person.birthday}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <label class="form-label">Address</label>
                            <input type="text" name="address" class="form-control" value="${person.adress}">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <label class="form-label">Username</label>
                            <input type="text" name="username" class="form-control" value="${person.user.userName}">
                        </div>
                        <div class="col-6">
                            <label class="form-label">Pasword</label>
                            <input type="password" name="password" class="form-control" >
                        </div>
                    </div>
                    <div class="row" style="margin-top: 2%">
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </div>

                </form>
            </div>
        </div>
    </div>

</div>




<%@ include file="/WEB-INF/jsp/footer.jsp"%>