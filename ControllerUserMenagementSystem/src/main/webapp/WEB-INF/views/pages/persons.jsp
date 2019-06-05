<%-- 
    Document   : users
    Created on : May 21, 2019, 4:58:39 AM
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
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Email</th>
                                <th>Mobile Number</th>
                                <th>Gender</th>
                                <th>Date of birth</th>
                                <th>Position</th>
                                <th>Company</th>
                                <th>View</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${persons}" var="user"> 
                            <form method="GET" action="/usermgmt/users/${user.id}">
                                <tr>
                                    <td>${user.id}</td>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.email}</td>
                                    <td>${user.mobileNumber}</td>
                                    <td>${user.gender}</td>
                                    <td>${user.dateOfBirth}</td>
                                    <td>${user.position.positionName}</td>
                                    <td>${user.position.companyIdFk.companyName}</td>
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

