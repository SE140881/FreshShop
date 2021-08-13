<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>FreshShop</title>
        <link href="./css_table/bootstrap.min.css" rel="stylesheet">
        <link href="./css_table/metisMenu.min.css" rel="stylesheet">

        <link href="./css_table/dataTables/dataTables.bootstrap.css" rel="stylesheet">

        <link href="./css_table/dataTables/dataTables.responsive.css" rel="stylesheet">

        <link href="./css_table/startmin.css" rel="stylesheet">

        <link href="./css_table/font-awesome.min.css" rel="stylesheet" type="text/css">

    </head>
    <body>

        <div id="wrapper">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"><i class="fa fa-home fa-fw"></i>Admin</a>
                </div>
                <ul class="nav navbar-right navbar-top-links">
                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> Welcome, ${sessionScope.USERNAME} ! <b class="caret"></b>
                        </a>
                        <form action="MainController" method="POST">
                            <ul class="dropdown-menu dropdown-user">
                                <li>
                                    <button type="submit" name="action" value="Logout"><i class="fa fa-sign-out fa-fw"></i> Logout</button>
                                </li>
                            </ul>
                        </form>
                    </li>
                </ul>

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <li>
                                <a href="admin.jsp"><i class="fa fa-table fa-fw"></i> User Management</a>
                            </li>
                            <li>
                                <a href="adminProduct.jsp"><i class="fa fa-table fa-fw"></i> Product Management</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">User Management</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <form action="MainController" method="POST">
                                        Search: <input type="text" name="txtSearch" />
                                        <button type="submit"
                                                name="action"
                                                value="SearchUser"><i class="fa fa-search"></i></button>
                                    </form>
                                    
                                    <h4 style="color: red">
                                        ${requestScope.CONTROL_USER}
                                    </h4>
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>User ID
                                                        <div style="height: 26px">                                                          
                                                        </div>
                                                    </th>
                                                    <th>Full Name
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.newUserNameError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <th>Email
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.newEmailError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <th>Phone
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.phoneError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <th>Password
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.newPasswordError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <th>Address
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.newAddressError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <th>Role
                                                        <div style="height: 28px">
                                                        </div>
                                                    </th>
                                                    <th></th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:if test="${requestScope.INFO != null}" var="info">
                                                    <c:if test="${not empty requestScope.INFO}" var="checkList">
                                                        <c:forEach var="dto" items="${requestScope.INFO}" varStatus="counter">
                                                            <tr>
                                                        <form action="MainController" method="POST">
                                                            <td>${counter.count}</td>
                                                            <td>${dto.userID}
                                                                <input type="hidden" name="txtNewUserID" value="${dto.userID}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewUserName" value="${dto.userName}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewEmail" value="${dto.email}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewPhone" value="${dto.phone}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewPassword" value="${dto.password}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewAddress" value="${dto.address}" />
                                                            </td>
                                                            <td>
                                                                <select name="cbxNewRole">
                                                                    <option 
                                                                        <c:if test="${dto.roleID.trim() eq 'AD'}"> 
                                                                            selected="true"
                                                                        </c:if> 
                                                                        value="AD"
                                                                        >Admin</option>
                                                                    <option 
                                                                        <c:if test="${dto.roleID.trim() eq 'US'}">
                                                                            selected="true"
                                                                        </c:if> 
                                                                        value="US"         
                                                                        >User</option>
                                                                </select>
                                                            </td>
                                                            <td>
                                                                <button name="action" value="UpdateUser" type="submit">Update</button>
                                                            </td>
                                                            <td>
                                                                <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                                                <Button name="action" value="DeleteUser" type="submit">Delete</Button>
                                                            </td>
                                                        </form>
                                                        </tr>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${!checkList}">
                                                    <font color = "white" class="display-4">
                                                    User not found
                                                    </font>
                                                </c:if>
                                            </c:if> 
                                            <c:if test="${!info}">
                                                <c:if test="${not empty sessionScope.LISTUSER}" var="checkList">
                                                    <c:forEach var="dto" items="${sessionScope.LISTUSER}" varStatus="counter">
                                                        <tr>
                                                        <form action="MainController" method="POST">
                                                            <td>${counter.count}</td>
                                                            <td>${dto.userID}
                                                                <input type="hidden" name="txtNewUserID" value="${dto.userID}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewUserName" value="${dto.userName}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewEmail" value="${dto.email}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewPhone" value="${dto.phone}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewPassword" value="${dto.password}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewAddress" value="${dto.address}" />
                                                            </td>
                                                            <td>
                                                                <select name="cbxNewRole">
                                                                    <option 
                                                                        <c:if test="${dto.roleID.trim() eq 'US'}">
                                                                            selected="true"
                                                                        </c:if> 
                                                                        value="US"         
                                                                        >User</option>
                                                                    <option 
                                                                        <c:if test="${dto.roleID.trim() eq 'AD'}"> 
                                                                            selected="true"
                                                                        </c:if> 
                                                                        value="AD"
                                                                        >Admin</option>
                                                                </select>
                                                            </td>
                                                            <td>
                                                                <button name="action" value="UpdateUser" type="submit">Update</button>
                                                            </td>
                                                            <td>
                                                                <Button name="action" value="DeleteUser" type="submit">Delete</Button>
                                                            </td>
                                                        </form>
                                                        </tr>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${!checkList}">
                                                    <font color = "white" class="display-4">
                                                    User not found
                                                    </font>
                                                </c:if>
                                            </c:if> 
                                            </tbody>                                            
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>            
        </div>
        <script src="./js_table/jquery.min.js"></script>
        <script src="./js_table/bootstrap.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="./js_table/metisMenu.min.js"></script>

        <script src="./js_table/dataTables/jqueryy.dataTables.min.js"></script>
        <script src="./js_table/dataTables/dataTables.bootstrap.min.js"></script>

        <script src="./js_table/startmin.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').DataTable({
                    responsive: true
                });
            });
        </script>

    </body>
</html>
