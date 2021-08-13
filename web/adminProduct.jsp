<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="" />
        <meta name="author" content="" />

        <title>Fresh Shop</title>
        <link href="./css_table/bootstrap.min.css" rel="stylesheet" />

        <link href="./css_table/metisMenu.min.css" rel="stylesheet" />

        <link href="./css_table/dataTables/dataTables.bootstrap.css" rel="stylesheet" />

        <link href="./css_table/dataTables/dataTables.responsive.css" rel="stylesheet" />

        <link href="./css_table/startmin.css" rel="stylesheet" />

        <link href="./css_table/font-awesome.min.css" rel="stylesheet" type="text/css" />

    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"
                       ><i class="fa fa-home fa-fw"></i>Admin</a
                    >
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
                                <a href="admin.jsp"
                                   ><i class="fa fa-table fa-fw"></i> User Management</a
                                >
                            </li>
                            <li>
                                <a href="adminProduct.jsp"
                                   ><i class="fa fa-table fa-fw"></i> Product Management</a
                                >
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Product Management</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="panel panel-default">
                                <div class="panel-heading" style="height: 47px">
                                    <form action="MainController" method="POST" style="float: left">
                                        Search: <input type="text" name="txtSearchAP" />
                                        <button type="submit"
                                                name="action"
                                                value="SearchAdminProduct"><i class="fa fa-search"></i></button>
                                    </form>
                                    <h4 style="color: red">
                                        ${requestScope.SUCCESS}
                                    </h4>
                                        <h4 style="float: right">
                                            <a href="createProduct.jsp">
                                                Add Product
                                                <i class="fa fa-plus"></i>
                                            </a>
                                        </h4>
                                </div>
                                <div class="panel-body">
                                    <div class="table-responsive">
                                        <table
                                            class="table table-striped table-bordered table-hover"
                                            id="dataTables-example"
                                            >
                                            <thead>
                                                <tr>
                                                    <td>#</td>
                                                    <th>Product ID
                                                        <div style="height: 8px">                                                          
                                                        </div>
                                                    </th>
                                                    <th>Product Name
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.productNameError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <th>Quantity
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.quantityError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <th>Price
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.priceError}
                                                            </font>
                                                        </div>
                                                    </th>
                                                    <td>Image
                                                        <div style="height: 28px">
                                                            <font color="red" class="ml-1">
                                                            ${requestScope.INVALID.imageError}
                                                            </font>
                                                        </div>
                                                    </td>

                                                    <td>Category</td>
                                                    <td></td>
                                                    <td></td>
                                                </tr>
                                            </thead>
                                            <tbody>                                  
                                                <c:if test="${requestScope.INFOAP != null}" var="info">
                                                    <c:if test="${not empty requestScope.INFOAP}" var="checkList">
                                                        <c:forEach var="dto" items="${requestScope.INFOAP}" varStatus="counter">
                                                            <tr>
                                                        <form action="MainController" method="POST">
                                                            <td>${counter.count}</td>
                                                            <td>${dto.productID}
                                                                <input type="hidden" name="txtNewProductID" value="${dto.productID}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewProductName" value="${dto.productName}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewQuantity" value="${dto.quantity}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewPrice" value="${dto.price}" />

                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewImage" value="${dto.image}" />                                                              
                                                            </td>

                                                            <td>
                                                                <select name="cbxNewCategory">
                                                                    <option 
                                                                        <c:if test="${dto.categoryID.trim() eq 'P01'}"> 
                                                                            selected="true"
                                                                        </c:if> 
                                                                        value="P01"
                                                                        >Bouquet Flower</option>
                                                                    <option 
                                                                        <c:if test="${dto.categoryID.trim() eq 'P02'}">
                                                                            selected="true"
                                                                        </c:if> 
                                                                        value="P02"         
                                                                        >Flower Pot</option>
                                                                </select>
                                                            </td>
                                                            <td>
                                                                <button name="action" value="UpdateProduct" type="submit">Update</button>
                                                            </td>
                                                            <td>
                                                                <input type="hidden" name="txtSearchAP" value="${param.txtSearchAP}" />
                                                                <button name="action" value="DeleteProduct" type="submit">Delete</button>           
                                                            </td>
                                                        </form>
                                                        </tr>
                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${!checkList}">
                                                    <font color = "white" class="display-4">
                                                    Product not found
                                                    </font>
                                                </c:if>
                                            </c:if> 
                                            <c:if test="${!info}">
                                                <c:if test="${not empty sessionScope.LISTPRODUCT}" var="checkList">
                                                    <c:forEach var="dto" items="${sessionScope.LISTPRODUCT}" varStatus="counter">
                                                        <tr>
                                                        <form action="MainController" method="POST">

                                                            <td>${counter.count}</td>
                                                            <td>${dto.productID}
                                                                <input type="hidden" name="txtNewProductID" value="${dto.productID}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewProductName" value="${dto.productName}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewQuantity" value="${dto.quantity}" />
                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewPrice" value="${dto.price}" />

                                                            </td>
                                                            <td>
                                                                <input type="text" name="txtNewImage" value="${dto.image}" />                                                              
                                                            </td>
                                                            <td>
                                                                <select name="cbxNewCategory">
                                                                    <option 
                                                                        <c:if test="${dto.categoryID.trim() eq 'P01'}"> 
                                                                            selected="true"
                                                                        </c:if> 
                                                                        value="P01"
                                                                        >Bouquet Flower</option>
                                                                    <option 
                                                                        <c:if test="${dto.categoryID.trim() eq 'P02'}">
                                                                            selected="true"
                                                                        </c:if> 
                                                                        value="P02"         
                                                                        >Flower Pot</option>
                                                                </select>
                                                            </td>
                                                            <td>
                                                                <button name="action" value="UpdateProduct" type="submit">Update</button>
                                                            </td>
                                                            <td>
                                                                <button name="action" value="DeleteProduct" type="submit">Delete</button>           
                                                            </td>
                                                        </form>
                                                        </tr>     

                                                    </c:forEach>
                                                </c:if>
                                                <c:if test="${!checkList}">
                                                    <font color = "white" class="display-4">
                                                    Product not found
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
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"
        ></script>

        <script src="./js_table/metisMenu.min.js"></script>

        <script src="./js_table/dataTables/jqueryy.dataTables.min.js"></script>
        <script src="./js_table/dataTables/dataTables.bootstrap.min.js"></script>

        <script src="./js_table/startmin.js"></script>

        <script>
            $(document).ready(function () {
                $("#dataTables-example").DataTable({
                    responsive: true,
                });
            });
        </script>
    </body>
</html>
