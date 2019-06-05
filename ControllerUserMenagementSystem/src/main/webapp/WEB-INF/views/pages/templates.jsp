<%-- 
    Document   : templates
    Created on : Jun 3, 2019, 4:08:20 PM
    Author     : MARINA
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<div class="container-fluid">

    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
        <li class="breadcrumb-item">
            <a href="index.html">Dashboard</a>
        </li>
        <li class="breadcrumb-item active"><tiles:getAsString name="title" /></li>
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
                                <th>File type</th>
                                <th>View</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${templates}" var="template"> 
                            <form method="GET" action="/usermgmt/templates/${template.templateId}">
                                <tr>
                                    <td>${template.templateId}</td>
                                    <td>${template.templateName}</td>
                                    <td>${template.templateFileType}</td>
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
</div>