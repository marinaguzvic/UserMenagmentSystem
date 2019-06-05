<%-- 
    Document   : documents
    Created on : Jun 4, 2019, 3:56:31 PM
    Author     : MARINA
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid">

    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="index.html">Dashboard</a>
        </li>
        <li class="breadcrumb-item active">Blank Page</li>
    </ol>

    <div class="panel panel-default">
        <div class="card mb-3">
            <div class="card-header">
                <i class="fas fa-table"></i>
                Data Table Example</div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Template</th>
                                <th>View</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${documents}" var="document"> 
                            <form method="GET" action="/usermgmt/templates/${document.documentFieldList[0].templateField.templateId}/documents/${document.documentId}">
                                <tr>
                                    <td>${document.documentId}</td>
                                    <td>${document.documentName}</td>
                                    <td>${document.documentFieldList[0].templateField.template.templateName}</td>
                                    <td><button type="submit" class="btn btn-outline-primary"><i class="far fa-eye"></i></button></td>
                                </tr>
                            </form>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
