<%-- 
    Document   : documentLayout
    Created on : Jun 4, 2019, 3:56:53 PM
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
        <li class="breadcrumb-item active">Blank Page</li>
    </ol>


    <h1>Blank Page</h1>${blah}
    <div class="card mb-3">
        <form:form method="POST" action="${action}" modelAttribute="document" style="padding:20px;">
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
                <form:label path="documentId" for="input-id" class="col-sm-2 col-form-label">ID</form:label>
                    <div class="col-sm-10">
                    <form:input type="number" path="documentId" id="input-id" placeholder="ID" class="form-control" readonly="true"/>
                </div>
            </div>
            <div class="form-group row">
                <form:label path="documentName" for="input-name" class="col-sm-2 col-form-label">Name</form:label>
                    <div class="col-sm-10">
                    <form:input type="text" path="documentName" id="input-id" placeholder="Name" class="form-control ${documentNameVld}"/>
                    <form:errors path="documentName" class="invalid-feedback" element="div"/>
                </div>
            </div>
            <br><br>
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Type</th>
                        <th scope="col">Value</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${document.documentFieldList}" var="field" varStatus="status"> 
                        <tr>
                            <form:input type="hidden" path="documentFieldList[${status.index}].documentId" />
                            <form:input type="hidden" path="documentFieldList[${status.index}].documentFieldId"/>
                            <form:input type="hidden" path="documentFieldList[${status.index}].templateField.templateFieldId"/>  
                            <form:input type="hidden" path="documentFieldList[${status.index}].templateField.templateId"/>  
                            <form:input type="hidden" path="documentFieldList[${status.index}].templateField.templateFieldType"/> 
                            <th scope="row">${field.documentFieldId}</th>

                            <td>
                                ${field.templateField.templateFieldName}
                            </td>
                            <td>
                                ${field.templateField.templateFieldType}
                            </td>
                            <td>
                                <form:input path="documentFieldList[${status.index}].fieldValue" class="form-control transparent-input ${documentFieldVld[status.index]}"/>
                                <form:errors path="documentFieldList[${status.index}].fieldValue" class="invalid-feedback" element="div"/>
                            </td>
                        </tr>    
                    </c:forEach>
                </tbody>
            </table>
            <div class="form-group row">
                <div class="col-sm-10">
                    <tiles:insertAttribute name="buttons" />
                </div>
            </div>
        </form:form>
    </div>
</div>