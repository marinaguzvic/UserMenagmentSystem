<%-- 
    Document   : viewButtons
    Created on : May 30, 2019, 2:34:41 PM
    Author     : MARINA
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/users/${person.id}/delete" var="deleteUrl" /> 

<button class="btn btn-primary" 
        type="submit">Update</button>
<button class="btn btn-danger" 
        type="submit"
        formaction="${deleteUrl}">Delete</button>