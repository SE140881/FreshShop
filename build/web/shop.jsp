<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="header.jsp" %>  
<!-- Start Shop Page  -->
    <div class="shop-box-inner">
        <div class="container">
            <div class="row">
                <div class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
                    <!--Right-->
                    <div class="right-product-box">
                        <div>
                            <h1>
                                Welcome To Flower Shop
                            </h1>
                        </div>
                        <div class="product-categorie-box">
                            <div class="tab-content">
                                <c:if test="${sessionScope.LISTPRODUCT != null}" var="checklist">
                                <div role="tabpanel" class="tab-pane fade show active" id="grid-view">
                                    <div class="row">
                                        <c:forEach var="dto" items="${sessionScope.LISTPRODUCT}">
                                            <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                                <div class="products-single fix">
                                                    <div>
                                                        <img style="width: 500px !important; height: 300px !important"
                                                            src="${dto.image}" class="img-fluid" alt="Image">
                                                        
                                                    </div>
                                                    <div class="why-text">
                                                        <h4>${dto.productName}</h4>
                                                        <h5> ${dto.price}$</h5>
                                                        <form action="MainController">
                                                            <input type="submit" value="AddToCart" name="action" />
                                                            <input type="hidden" name="cartProductID" value="${dto.productID}" />
                                                            <input type="hidden" name="cartProductName" value="${dto.productName}" />
                                                            <input type="hidden" name="cartProductPrice" value="${dto.price}" />
                                                            <input type="hidden" name="cartProductQuantity" value="${dto.quantity}" />
                                                            <input type="hidden" name="cartProductImage" value="${dto.image}" />
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
                

                <!--Left-->
                <div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left">
                    <div class="product-categori">
                        <div class="search-product">
                            <form action="MainController">
                                <input class="form-control" placeholder="Search here..." type="text" name="searchName">
                                <button type="submit" name="action" value="SearchProduct"> <i class="fa fa-search"></i> </button>
                            </form>
                        </div>
                        <div class="filter-sidebar-left">
                            <div class="title-left">
                                <h3>Categories</h3>
                            </div>
                                <div class="list-group list-group-collapse list-group-sm list-group-tree"
                                    id="list-group-men" data-children=".sub-men">
                                    <div class="list-group-collapse sub-men">
                                        <a class="list-group-item list-group-item-action" href="#sub-men1"
                                            data-toggle="collapse" aria-expanded="true" aria-controls="sub-men1">
                                            <h2>Bouquet of Flower</h2>
                                        </a>
                                        <a class="list-group-item list-group-item-action" href="#sub-men1"
                                            data-toggle="collapse" aria-expanded="true" aria-controls="sub-men1">
                                            <h2>Flower Pot</h2>
                                        </a>
                                    </div>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <!-- End Shop Page -->
<%@include file="footer.jsp" %>