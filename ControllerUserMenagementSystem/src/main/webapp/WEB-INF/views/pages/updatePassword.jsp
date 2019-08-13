<%-- 
    Document   : updatePassword
    Created on : Aug 12, 2019, 2:22:47 PM
    Author     : MARINA
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">Reset Password</div>
        <div class="card-body">
            <div class="text-center mb-4">
                <h4>Reset your password</h4>
                <p>Please enter your new password.</p>
            </div>
            <form:form modelAttribute="password" action="/usermgmt/resetPassword" method="POST">
                <div class="form-group">
                    <div class="col-md-6">
                        <div class="form-label-group">
                            <form:input type="password" path="password" class="form-control" required="required" autofocus="autofocus"/>
                            <label for="inputEmail">Enter email address</label>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-label-group">
                            <form:input type="password" path="confirmPassword" class="form-control" required="required" autofocus="autofocus"/>
                            <label for="inputEmail">Enter email address</label>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Reset Password</button>
            </form:form>
            <div class="text-center">
                <a class="d-block small mt-3" href="register.html">Register an Account</a>
                <a class="d-block small" href="login.html">Login Page</a>
            </div>
        </div>
    </div>
</div>