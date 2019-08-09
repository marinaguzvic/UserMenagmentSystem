<%-- 
    Document   : registration
    Created on : Aug 8, 2019, 5:53:53 PM
    Author     : MARINA
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container">
    <div class="card card-register mx-auto mt-5">
        <div class="card-header">Register an Account</div>
        <div class="card-body">
            <form:form method="POST" action="/usermgmt/registration" modelAttribute="account">
                <div class="form-group">
                    <div class="form-row">
                        <div class="col-md-6">
                            <div class="form-label-group">
                                <form:input type="text" path="firstName" id="firstName" placeholder="First name" class="form-control" required="required" autofocus="autofocus" />
                                <form:label path="firstName">First name</form:label>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-label-group">
                                <form:input type="text" path="lastName" id="lastName" placeholder="Last name" class="form-control" required="required" autofocus="autofocus" />
                                <form:label path="lastName">Last name</form:label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-label-group">
                        <form:input type="email" path="email" id="email" placeholder="Email" class="form-control" required="required" autofocus="autofocus" />
                        <form:label path="email">Email address</form:label>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col-md-6">
                                <div class="form-label-group">
                                <form:input type="password" path="password" id="password" placeholder="" class="form-control" required="required" autofocus="autofocus" />
                                <form:label path="password">Password</form:label>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-label-group">
                                <form:input type="password" path="confirmPassword" id="confirmPassword" placeholder="" class="form-control" required="required" autofocus="autofocus" />
                                <form:label path="confirmPassword">Confirm Password</form:label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary btn-block">Register</button>
            </form:form>
            <div class="text-center">
                <a class="d-block small mt-3" href="/login">Login Page</a>
                <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
            </div>
        </div>
    </div>
</div>