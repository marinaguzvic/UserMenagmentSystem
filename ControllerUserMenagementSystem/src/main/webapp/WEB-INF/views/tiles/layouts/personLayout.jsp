<%-- 
    Document   : personLayout
    Created on : May 30, 2019, 2:41:00 PM
    Author     : MARINA
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="container-fluid">

    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="index.html">Dashboard</a>
        </li>
        <li class="breadcrumb-item active"><tiles:getAsString name="title" /></li>
    </ol>


    <h1><tiles:getAsString name="title" /></h1>
    <div class="card mb-3">
        <form:form method="POST" action="${action}" modelAttribute="person" style="padding:20px;">
            <!--<form style="padding:20px;">-->
            <c:if test="${not empty msg}">
                <div class="alert alert-${css} alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" 
                            aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                    <strong>${msg}</strong>
                </div>
            </c:if>
            <div class="form-group row">
                <form:label path="id" for="input-id" class="col-sm-2 col-form-label">ID</form:label>
                    <!--<label for="input-id" class="col-sm-2 col-form-label">ID</label>-->
                    <div class="col-sm-10">
                    <form:input type="number" path="id" id="input-id" placeholder="ID" class="form-control" readonly="true"/>
                    <!--<input type="number" name="id" value="${person.id}" class="form-control" id="input-id" placeholder="ID" readonly="readonly">-->
                </div>
            </div>
            <div class="form-group row">
                <form:label path="email" for="input-email" class="col-sm-2 col-form-label">Email</form:label>
                    <div class="col-sm-10">
                        
                    <form:input type="email" path="email" class="form-control ${emailVld}" id="input-email" placeholder="Email" required="true"/>
                    <form:errors path="email" class="invalid-feedback" element="div"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="firstName" for="input-first-name" class="col-sm-2 col-form-label">First Name</form:label>
                    <div class="col-sm-10">
                    <form:input path="firstName" type="text" class="form-control ${firstNameVld}" id="input-first-name" placeholder="First Name" required="true"/>
                    <form:errors path="firstName" class="invalid-feedback"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="lastName" for="input-last-name" class="col-sm-2 col-form-label">Last Name</form:label>
                    <div class="col-sm-10">
                    <form:input path="lastName" type="text" class="form-control ${lastNameVld}" id="input-last-name" placeholder="Last Name" required="true"/>
                    <form:errors path="lastName" class="invalid-feedback"  element="div"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="mobileNumber" for="input-mobile" class="col-sm-2 col-form-label">Mobile Number</form:label>
                    <div class="col-sm-10">
                    <form:input type="tel" path="mobileNumber" class="form-control ${mobileNumberVld}" id="input-mobile" placeholder="Mobile Number" pattern="\+[0-9]{3,5}/[0-9]{3,4}-[0-9]{3,4}"/>
                    <form:errors path="mobileNumber" class="invalid-feedback" element="div"/>
                </div>
            </div>
            <fieldset class="form-group">
                <div class="row">
                    <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
                    <div class="col-sm-10">
                        <div class="custom-control custom-radio">
                            <form:radiobutton path="gender" class="custom-control-input ${genderVld}" value="Female" id="genderF"/> 
                            <form:label path="gender" class="custom-control-label" for="genderF">
                                Female
                            </form:label>
                        </div>
                        <div class="custom-control custom-radio">
                            <form:radiobutton path="gender" class="custom-control-input ${genderVld}" value="Male" id="genderM"/>
                            <form:label path="gender" class="custom-control-label" for="genderM">
                                Male
                            </form:label>
                        </div>
                        <form:errors path="gender" class="invalid-feedback" element="div"/>    
                    </div>
                </div>
            </fieldset>
            <div class="form-group row">
                <form:label path="dateOfBirth" for="input-date" class="col-sm-2 col-form-label">Date Of Birth</form:label>
                    <div class="col-sm-10">
                        <div class="input-group date">
                        <form:input path="dateOfBirth" type="text" class="form-control ${dateOfBirthVld}" id="input-date" aria-describedby="basic-addon2"/>
                        <div class="input-group-append">
                            <span class="input-group-text" id="basic-addon2"><i class="fas fa-calendar-week"></i></span>
                        </div>
                        <form:errors path="dateOfBirth" class="invalid-feedback" element="div"/>  
                    </div>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="position" for="input-position" class="col-sm-2 col-form-label">Position</form:label>
                    <div class="col-sm-10">
                    <form:select multiple="single" path="position.positionId" class="custom-select ${positionVld}">
                        <c:forEach var="company" items="${companies}">
                            <optgroup label="${company.companyName}">
                                <c:forEach var="pos" items="${company.positions}">
                                    <form:option value="${pos.positionId}" label="${pos}"/>    
                                </c:forEach>
                            </optgroup>
                        </c:forEach>        
                    </form:select>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-10">

                    <tiles:insertAttribute name="buttons" />
                </div>
            </div>
        </form:form>
    </div>
</div>