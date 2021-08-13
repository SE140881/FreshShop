<%-- 
    Document   : cart
    Created on : 22-Apr-2021, 21:14:14
    Author     : TienVM_PC
--%>
<%@include file="header.jsp" %>
<!-- Start Cart  -->
<div class="cart-box-main">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="table-main table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Images</th>
                                <th>Product Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Remove</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${empty sessionScope.CART || empty sessionScope.LIST_CART}" >
                            <h1>
                                Cart empty!
                            </h1>
                            </c:if>

                            <c:if test="${not empty sessionScope.CART || not empty sessionScope.LIST_CART}" >
                                <c:set var="listPro" value="${sessionScope.LIST_PRODUCT}"/>
                                    <form>
                                        <c:forEach var="itemCart" items="${sessionScope.LIST_CART}" varStatus="counter">
                                            <c:forEach var="proCart" items="${listPro}">
                                                <c:if test="${itemCart.key.trim() eq proCart.productID.trim()}">
                                                    <tr>
                                                       
                                                        <td class="thumbnail-img">
                                                            <img style="width: 100px !important; height: 100px !important"
                                                            src="${proCart.image}" class="img-fluid" alt="Image">
                                                        </td>
                                                        <td class="name-pr">
                                                            ${proCart.productName}
                                                        </td>
                                                        
                                                        <td class="price-pr">
                                                            ${proCart.price}$
                                                        </td>
                                                        <td class="quantity-box">
                                                            <a href="MainController?action=InDe&flag=true&id=${proCart.productID}"> 
                                                                +
                                                            </a>
                                                            <p>
                                                                ${itemCart.value}
                                                            </p>
                                                            <a href="MainController?action=InDe&flag=false&id=${proCart.productID}"> 
                                                                -
                                                            </a>
                                                        </td>
                                                        <td class="total-pr">
                                                            ${String.format("%,.0f", itemCart.value * proCart.price)}$
                                                        </td>
                                                        <c:set var="total" value="${total + (itemCart.value * proCart.price)}"/>
                                                        <td class="remove-pr">
                                                            <form action="MainController">
                                                                <a href="MainController?action=RemoveCart&removeID=${proCart.productID.trim()}">Remove</a>
                                                            </form>
                                                        </td>
                                                    </tr>
                                                </c:if>
                                            </c:forEach>
                                        </c:forEach>
                                    </form>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>


        <div class="row my-5">
            <div class="col-lg-8 col-sm-12"></div>
            <div class="col-lg-4 col-sm-12">
                <div class="order-box">
                    <h3>Order summary</h3>
                    <div class="d-flex">
                        <h4>Sub Total</h4>
                        <div class="ml-auto font-weight-bold"> 
                            ${total > 0 ? String.format("%,.0f", total) : 0}$
                        </div>
                    </div>
                    <div class="d-flex">
                        <h4>Discount</h4>
                        <div class="ml-auto font-weight-bold"> 0 </div>
                    </div>
                    <hr class="my-1">
                    <div class="d-flex">
                        <h4>Shipping Cost</h4>
                        <div class="ml-auto font-weight-bold"> Free </div>
                    </div>
                    <hr>
                    <div class="d-flex gr-total">
                        <h5>Grand Total</h5>
                        <div class="ml-auto h5"> 
                            ${total > 0 ? String.format("%,.0f", total) : 0}$
                        </div>
                    </div>
                    <hr> </div>
            </div>
            <div class="col-12 d-flex shopping-box">
                
                <form action="MainController">
                    <input class="ml-auto btn hvr-hover" type="submit" value="Check Out" name="action" />
                    <input type="hidden" name="totalCheckOut" value="${total}" />
                </form>
            </div>
        </div>

    </div>
</div>
<!-- End Cart -->
<%@include file="footer.jsp" %>