<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <!-- Basic -->

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <!-- Mobile Metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Site Metas -->
        <title>Freshshop - Ecommerce Bootstrap 4 HTML Template</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">


        <link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
        <link rel="apple-touch-icon" href="images/apple-touch-icon.png">

        <link rel="stylesheet" href="css/bootstrap.min.css">

        <link rel="stylesheet" href="css/style.css">
        <!--<link rel="stylesheet" href="css/style_login.css">-->

        <link rel="stylesheet" href="css/responsive.css">

        <link rel="stylesheet" href="css/custom.css">


    </head>

    <body>

        <header class="main-header">

            <nav class="navbar navbar-expand-lg navbar-light navbar-default bootsnav" style="background-image: url('images/bg-header.jpg');">
                <div class="container" >
                    <div class="navbar-header">
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                            <i class="fa fa-bars"></i>
                        </button>
                        <a href="home.jsp"><img src="images/logo.png" class="img-logo" alt=""></a>
                            </div>

                            <div class="collapse navbar-collapse" id="navbar-menu">
                                <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                                    <li class="nav-item active"><a class="nav-link" href="home.jsp">Home</a></li>
                                    <li class="nav-item"><a class="nav-link" href="shop.jsp">Flower</a></li>
                                    <li class="nav-item"><a class="nav-link" href="cart.jsp">Cart</a></li>
                                    <li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
                                    

                                </ul>
                            </div>
  
                            <div class="attr-nav">
                                <ul>
                                    <li class="dropdown">
                                        
                                        <a class="nav-link" style="font-size: 20px" data-toggle="dropdown" href="#">
                                            <i class="fa fa-user fa-fw"></i> Welcome, ${sessionScope.USERNAME} <b class="caret"></b>
                                        </a>
                                        <form action="MainController" method="POST">
                                            <ul class="dropdown-menu dropdown-user">
                                                <li>
                                                    <button class="nav-link" type="submit" name="action" value="Logout"><i class="fa fa-sign-out fa-fw"></i> Logout</button>
                                                </li>
                                            </ul>
                                        </form>
                                    </li>
                                </ul>
                            </div>

                    </div>
            </nav>

        </header>
        <!-- End Main Top -->
