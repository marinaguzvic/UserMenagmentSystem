<%-- 
    Document   : templateLayout
    Created on : Jun 1, 2019, 9:43:12 AM
    Author     : MARINA
--%>
<%-- 
    Document   : new-template
    Created on : Jun 1, 2019, 8:25:55 AM
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
        <form:form method="POST" action="${action}" modelAttribute="template" enctype="multipart/form-data" style="padding:20px;">
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
                <form:label path="template.templateId" for="input-id" class="col-sm-2 col-form-label">ID</form:label>
                    <div class="col-sm-10">
                    <form:input type="number" path="template.templateId" id="input-id" placeholder="ID" class="form-control" readonly="true"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="template.templateName" for="input-name" class="col-sm-2 col-form-label">Name</form:label>
                    <div class="col-sm-10">
                    <form:input type="text" path="template.templateName" id="input-id" placeholder="Name" class="form-control ${templateNameVld}"/>
                    <form:errors path="template.templateName" class="invalid-feedback" element="div"/>
                </div>
            </div>
            <div class="custom-file">
                <form:input path="file" type="file" class="custom-file-input ${templateFileNameVld}" id="customFile"/>
                <label class="custom-file-label" for="customFile" id="file-label">${template.template.templateFileName}</label>
                <form:input type="hidden" path="template.templateFileName"/>
                <form:input type="hidden" path="template.templateFileType"/>
                <form:input type="hidden" path="template.templateFile"/>
                <form:errors path="template.templateFileName" class="invalid-feedback" element="div"/>
                <form:errors path="template.templateFileType" class="invalid-feedback" element="div"/>
                <form:errors path="template.templateFile" class="invalid-feedback" element="div"/>
            </div>
            <br><br>
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Type</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${template.template.templateFieldList}" var="field" varStatus="status"> 
                        <tr>
                            <form:input type="hidden" path="template.templateFieldList[${status.index}].templateId"/>
                            <form:input type="hidden" path="template.templateFieldList[${status.index}].templateFieldId"/>
                            <th scope="row">${field.templateFieldId}</th>

                            <td><form:input path="template.templateFieldList[${status.index}].templateFieldName" class="form-control transparent-input ${templateFieldNameVld[status.index]}"/>
                                <form:errors path="template.templateFieldList[${status.index}].templateFieldName" class="invalid-feedback" element="div"/>
                            </td>
                            <td>
                                <form:select multiple="single" class="custom-select transparent-input" path="template.templateFieldList[${status.index}].templateFieldType" items="${types}"/>
                            </td>
                            <td>
                                <c:if test="${!status.last}">
                                    <button type="submit" class="btn btn-outline-danger" formaction="${action}/delete-item/${field.templateFieldId}"><i class="fas fa-minus"></i></button>
                                    </c:if>
                                    <c:if test="${status.last}">
                                    <button type="submit" class="btn btn-outline-success" formaction="${action}/add-item"><i class="fas fa-plus"></i></button>
                                    </c:if>
                            </td>
                        </tr>    
                    </c:forEach>
                </tbody>
            </table>
            <form:errors path="template" element="div"/>
            <div class="form-group row">
                <div class="col-sm-10">
                    <tiles:insertAttribute name="buttons" />
                </div>
            </div>
        </form:form>
    </div>
</div>