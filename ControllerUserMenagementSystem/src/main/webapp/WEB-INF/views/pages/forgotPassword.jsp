<%-- 
    Document   : forgotPassword
    Created on : Aug 12, 2019, 7:48:09 AM
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
                <h4>Forgot your password?</h4>
                <p>Enter your email address and we will send you instructions on how to reset your password.</p>
            </div>
            <form action="/usermgmt/resetPassword/request" method="POST">
                <div class="form-group">
                    <div class="form-label-group">
                        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Enter email address" required="required" autofocus="autofocus">
                        <label for="inputEmail">Enter email address</label>
                    </div>
                </div>
                <button class="btn btn-primary btn-block" type = "submit">Reset Password</button>
            </form>
            <div class="text-center">
                <a class="d-block small mt-3" href="register.html">Register an Account</a>
                <a class="d-block small" href="login.html">Login Page</a>
            </div>
        </div>
    </div>
</div>