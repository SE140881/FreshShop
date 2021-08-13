<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Contact V3</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="images/icons/favicon.ico" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap_input/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate_input/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers_input/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2_input/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util_input.css">
        <link rel="stylesheet" type="text/css" href="css/main_input.css">
        <!--===============================================================================================-->
    </head>

    <body>

        <div class="bg-contact3" style="background-image: url('images/bg-01.jpg');">
            <div class="container-contact3">
                <div class="wrap-contact3">
                    <form class="contact3-form validate-form" action="MainController" method="POST">
                        <span class="contact3-form-title">
                            User Information
                        </span>

                        <div class="wrap-input3 validate-input">
                            <input class="input3" 
                                   type="text" 
                                   name="txtNewUserID" 
                                   placeholder="User ID"
                                   value="${param.txtNewUserID}"/>
                            <span class="focus-input3">
                                <font color="red">
                                ${requestScope.INVALID.newUserIDError}
                                </font>
                            </span>
                        </div>

                        <div class="wrap-input3 validate-input">
                            <input class="input3" 
                                   type="text" 
                                   name="txtNewUserName" 
                                   placeholder="User Name"
                                   value="${param.txtNewUserName}"/>
                            <span class="focus-input3">
                                <font color="red">
                                ${requestScope.INVALID.newUserNameError}
                                </font>
                            </span>
                        </div>

                        <div class="wrap-input3 validate-input">
                            <input class="input3" 
                                   type="password" 
                                   name="txtNewPassword" 
                                   placeholder="Password" />
                            <span class="focus-input3">
                                <font color="red">
                                ${requestScope.INVALID.newPasswordError}
                                </font>
                            </span>
                        </div>

                        <div class="wrap-input3 validate-input">
                            <input class="input3" 
                                   type="password" 
                                   name="txtNewConfirm" 
                                   placeholder="Confirm Password" />
                            <span class="focus-input3">
                                <font color="red">
                                ${requestScope.INVALID.newConfirmError}
                                </font>
                            </span>
                        </div>

                        <div class="wrap-input3 validate-input">
                            <input class="input3" 
                                   type="text" 
                                   name="txtNewPhone" 
                                   placeholder="Phone"
                                   value="${param.txtNewPhone}"/>
                            <span class="focus-input3">
                                <font color="red">
                                ${requestScope.INVALID.newPhoneError}
                                </font>
                            </span>
                        </div>

                        <div class="wrap-input3 validate-input">
                            <input class="input3" 
                                   type="text" 
                                   name="txtNewEmail" 
                                   placeholder="Email"
                                   value="${param.txtNewEmail}"/>
                            <span class="focus-input3">
                                <font color="red">
                                ${requestScope.INVALID.newEmailError}
                                </font>
                            </span>
                        </div>

                        <div class="wrap-input3 validate-input">
                            <input class="input3" 
                                   type="text" 
                                   name="txtNewAddress" 
                                   placeholder="Address"
                                   value="${param.txtNewAddress}"/>
                            <span class="focus-input3">
                                <font color="red">
                                ${requestScope.INVALID.newAddressError}
                                </font>
                            </span>
                        </div>

                        <div class="container-contact3-form-btn">
                            <button class="contact3-form-btn"
                                    type="submit"
                                    value="CreateUser"
                                    name="action">
                                    Sing Up
                            </button>
                            <a class="link-back-login" href="login.jsp">Back to Login</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <!--===============================================================================================-->
        <script src="vendor/jquery_input/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/bootstrap/js/popper.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="vendor/select2_input/select2.min.js"></script>
        <script>
            $(".selection-2").select2({
                minimumResultsForSearch: 20,
                dropdownParent: $('#dropDownSelect1')
            });
        </script>
        <!--===============================================================================================-->
        <script src="js/main_input.js"></script>

        <!-- Global site tag (gtag.js) - Google Analytics -->
        <script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
        <script>
            window.dataLayer = window.dataLayer || [];
            function gtag() {
                dataLayer.push(arguments);
            }
            gtag('js', new Date());

            gtag('config', 'UA-23581568-13');
        </script>

    </body>

</html>