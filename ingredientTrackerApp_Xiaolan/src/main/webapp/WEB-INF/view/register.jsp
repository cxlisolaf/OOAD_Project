<%--
  Created by IntelliJ IDEA.
  User: ellie
  Date: 12/5/17
  Time: 12:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="common/header.jspf"%>


<div class="container">
    <h1>Ingredient Tracker Account Register</h1>

    <form:form name="myForm" method="post" commandName="user">
        <form:hidden path="id" />

        <fieldset class="form-group">
            <form:label path="username" class="col-md-2 control-label">User Name: </form:label>
            <div class="col-md-5">
                <form:input path="username" class="form-control" type="text"
                            name="username" placeholder="Enter your Usename" id="username"></form:input>
            </div>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="password" class="col-md-2 control-label">Password: </form:label>
            <div class="col-md-5">
                <form:input path="password" class="form-control" type="password"
                            name="password" placeholder="Enter password" id="password"></form:input>
                <form:errors path="password" cssClass="text-warning" />
            </div>
        </fieldset>




        <input class="btn btn-success" type="submit" value="Register" />
    </form:form>

</div>

<%@ include file="common/footer.jspf"%>