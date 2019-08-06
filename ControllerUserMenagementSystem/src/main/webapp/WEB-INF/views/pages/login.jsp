<%-- 
    Document   : login
    Created on : Aug 1, 2019, 7:21:42 PM
    Author     : MARINA
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setBundle basename="messages" />


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container">
    <div class="card card-login mx-auto mt-5">
        <div class="card-header">Login</div>
        <div class="card-body">
            <c:if test="${param.regSucc == true}">
                <div id="status">
                    <spring:message code="message.regSucc">    
                    </spring:message>
                </div>
            </c:if>
            <c:if test="${param.regError == true}">
                <div id="error">
                    <spring:message code="message.regError">   
                    </spring:message>
                </div>
            </c:if>
            <c:if test="${param.error != null}">
                <div id="error">
                    <spring:message code="message.badCredentials">   
                    </spring:message>
                </div>
            </c:if>
            <form name="f" action="perform_login" method="POST">
                <div class="form-group">
                    <div class="form-label-group">
                        <input name="username" type="text" id="inputEmail" class="form-control" placeholder="Email address" required="required" autofocus="autofocus" value="">
                        <label for="inputEmail">Username</label>
                        <fmt:message key="message.username" var="noUser" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="form-label-group">
                        <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Password" required="required">
                        <label for="inputPassword">Password</label>
                        <fmt:message key="message.password" var="noPass" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="true" name="remember-me">
                            Remember Password
                        </label>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Login</button>
            </form>
            <div class="text-center">
                <a class="d-block small mt-3" href="register.html">Register an Account</a>
                <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
            </div>
        </div>
    </div>
</div>