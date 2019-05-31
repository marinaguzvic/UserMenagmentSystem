<%-- 
    Document   : saveButtons
    Created on : May 30, 2019, 2:38:31 PM
    Author     : MARINA
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/users" var="addUrl" /> 

<button class="btn btn-primary" 
        onclick="post('${addUrl}')">Save</button>
