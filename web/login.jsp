<%@include file="header.jsp" %>
<link rel="stylesheet" href="css/style_login.css">
<!-- Login part -->
    <div class="img js-fullheight" style="background-image: url(images/bg.jpg);">
        <section class="ftco-section">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-md-6 col-lg-4">
                        <div class="login-wrap p-0">
                            <h1 class="mb-4 text-center">Fresh Shop</h1>
                            <h4>
                                <font colo="red">
                                    ${requestScope.SUCCESS_USER}
                                </font>
                            </h4>
                            <form action="MainController" method="POST" class="signin-form">
                                <div class="form-group">
                                    <input type="text" name="txtUserID" class="form-control" placeholder="Username" required>
                                </div>
                                <div class="form-group">
                                    <input id="password-field" type="password" name="txtPassword" class="form-control" placeholder="Password" required>
                                    <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password"></span>
                                </div>
                                <h3>
                                <div class="form-group">
                                    <button type="submit" value="Login" name="action" class="form-control btn btn-primary submit px-3">
                                        Sign In
                                    </button>
                                </div>
                                <a class="btn btn-primary btn-block text-white" type="button" id="btn-signup"
                                    href="createUser.jsp">
                                    Sign up New Account
                                </a></h3>
                                <h6>
                                <a href="home.jsp" style="text-align: right;">Back to Home page <i
                                        class="fa fa-undo ml-2"></i></a></h6>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script src="js/js_login/jquery.min.js"></script>
        <script src="js/js_login/popper.js"></script>
        <script src="js/js_login/bootstrap.min.js"></script>
        <script src="js/js_login/main.js"></script>
    </div>

    <!-- End login -->
    <%@include file="footer.jsp" %>