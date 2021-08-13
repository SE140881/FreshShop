<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Fresh Shop</title>
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />

        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
            />
       
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="./css_table/indexxxx.css" />
    </head>
    <body>
        <div>
            <div id="logreg-forms" class="logreg-forms2">
                <form class="form-signin" action="MainController" method="POST">
                    <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
                        Create Product
                    </h1>
                    <h4 style="color: red">
                        ${requestScope.FAIL}
                    </h4>
                    <input
                        type="text"
                        name="txtNewProductID"
                        class="form-control"
                        placeholder="Product ID"
                        value="${param.txtNewProductID}"
                        />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.productIDError}
                        </font>
                    </div>
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID_ID.productIDError}
                        </font>
                    </div>
                    <input
                        type="text"
                        name="txtNewProductName"
                        class="form-control"
                        placeholder="Product Name"
                        value="${param.txtNewProductName}"
                        />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.productNameError}
                        </font>
                    </div>
                    <input
                        type="text"
                        name="txtNewQuantity"
                        class="form-control"
                        placeholder="Quantity"
                        value="${param.txtNewQuantity}"
                        />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.quantityError}
                        </font>
                    </div>
                    
                    <input
                        type="text"
                        name="txtNewPrice"
                        class="form-control"
                        placeholder="Price"
                        value="${param.txtNewPrice}"
                        />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.priceError}
                        </font>
                    </div>
                    <input
                        type="text"
                        name="txtNewImage"
                        class="form-control"
                        placeholder="Image"
                        value="${param.txtNewImage}"
                        />
                    <div style="height: 22px">
                        <font color="red" class="ml-1">
                        ${requestScope.INVALID.imageError}
                        </font>
                    </div>
                    Category:
                    <select name="cbxNewCategory">
                        <option value="P01">Bouquet Flowers</option>
                        <option value="P02">Pot Flower</option>
                        <!--<option value="Q">Trousers</option>-->
                    </select>
                    <button
                        class="btn btn-primary btn-block"
                        id="btn-signup"
                        type="submit"
                        value="CreateProduct"
                        name="action"
                        > Add Product
                    </button>
                    <a href="adminProduct.jsp" style="text-align: right">Back to Product Management page<i class="fa fa-undo ml-2"></i></a>
                </form>
            </div>
        </div>

        <script
            src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
