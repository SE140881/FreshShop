package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <!-- Basic -->\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("\n");
      out.write("        <!-- Mobile Metas -->\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <!-- Site Metas -->\n");
      out.write("        <title>Freshshop - Ecommerce Bootstrap 4 HTML Template</title>\n");
      out.write("        <meta name=\"keywords\" content=\"\">\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"author\" content=\"\">\n");
      out.write("\n");
      out.write("\n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/favicon.ico\" type=\"image/x-icon\">\n");
      out.write("        <link rel=\"apple-touch-icon\" href=\"images/apple-touch-icon.png\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <!--<link rel=\"stylesheet\" href=\"css/style_login.css\">-->\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/responsive.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/custom.css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <header class=\"main-header\">\n");
      out.write("\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light navbar-default bootsnav\" style=\"background-image: url('images/bg-header.jpg');\">\n");
      out.write("                <div class=\"container\" >\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                        <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbar-menu\" aria-controls=\"navbars-rs-food\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                            <i class=\"fa fa-bars\"></i>\n");
      out.write("                        </button>\n");
      out.write("                        <a href=\"home.jsp\"><img src=\"images/logo.png\" class=\"img-logo\" alt=\"\"></a>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"collapse navbar-collapse\" id=\"navbar-menu\">\n");
      out.write("                                <ul class=\"nav navbar-nav ml-auto\" data-in=\"fadeInDown\" data-out=\"fadeOutUp\">\n");
      out.write("                                    <li class=\"nav-item active\"><a class=\"nav-link\" href=\"home.jsp\">Home</a></li>\n");
      out.write("                                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"shop.jsp\">Flower</a></li>\n");
      out.write("                                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"cart.jsp\">Cart</a></li>\n");
      out.write("                                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"login.jsp\">Login</a></li>\n");
      out.write("                                    \n");
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("  \n");
      out.write("                            <div class=\"attr-nav\">\n");
      out.write("                                <ul>\n");
      out.write("                                    <li class=\"dropdown\">\n");
      out.write("                                        \n");
      out.write("                                        <a class=\"nav-link\" style=\"font-size: 20px\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("                                            <i class=\"fa fa-user fa-fw\"></i> Welcome, ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.USERNAME}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" <b class=\"caret\"></b>\n");
      out.write("                                        </a>\n");
      out.write("                                        <form action=\"MainController\" method=\"POST\">\n");
      out.write("                                            <ul class=\"dropdown-menu dropdown-user\">\n");
      out.write("                                                <li>\n");
      out.write("                                                    <button class=\"nav-link\" type=\"submit\" name=\"action\" value=\"Logout\"><i class=\"fa fa-sign-out fa-fw\"></i> Logout</button>\n");
      out.write("                                                </li>\n");
      out.write("                                            </ul>\n");
      out.write("                                        </form>\n");
      out.write("                                    </li>\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("        <!-- End Main Top -->\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style_login.css\">\n");
      out.write("<!-- Login part -->\n");
      out.write("    <div class=\"img js-fullheight\" style=\"background-image: url(images/bg.jpg);\">\n");
      out.write("        <section class=\"ftco-section\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row justify-content-center\">\n");
      out.write("                    <div class=\"col-md-6 col-lg-4\">\n");
      out.write("                        <div class=\"login-wrap p-0\">\n");
      out.write("                            <h1 class=\"mb-4 text-center\">Fresh Shop</h1>\n");
      out.write("                            <h4>\n");
      out.write("                                <font colo=\"red\">\n");
      out.write("                                    ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.SUCCESS_USER}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("                                </font>\n");
      out.write("                            </h4>\n");
      out.write("                            <form action=\"MainController\" method=\"POST\" class=\"signin-form\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <input type=\"text\" name=\"txtUserID\" class=\"form-control\" placeholder=\"Username\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <input id=\"password-field\" type=\"password\" name=\"txtPassword\" class=\"form-control\" placeholder=\"Password\" required>\n");
      out.write("                                    <span toggle=\"#password-field\" class=\"fa fa-fw fa-eye field-icon toggle-password\"></span>\n");
      out.write("                                </div>\n");
      out.write("                                <h3>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <button type=\"submit\" value=\"Login\" name=\"action\" class=\"form-control btn btn-primary submit px-3\">\n");
      out.write("                                        Sign In\n");
      out.write("                                    </button>\n");
      out.write("                                </div>\n");
      out.write("                                <a class=\"btn btn-primary btn-block text-white\" type=\"button\" id=\"btn-signup\"\n");
      out.write("                                    href=\"createUser.jsp\">\n");
      out.write("                                    Sign up New Account\n");
      out.write("                                </a></h3>\n");
      out.write("                                <h6>\n");
      out.write("                                <a href=\"home.jsp\" style=\"text-align: right;\">Back to Home page <i\n");
      out.write("                                        class=\"fa fa-undo ml-2\"></i></a></h6>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("\n");
      out.write("        <script src=\"js/js_login/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/js_login/popper.js\"></script>\n");
      out.write("        <script src=\"js/js_login/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/js_login/main.js\"></script>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- End login -->\n");
      out.write("    ");
      out.write("\n");
      out.write("    <footer>\n");
      out.write("        <div class=\"footer-main\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-lg-4 col-md-12 col-sm-12\">\n");
      out.write("                        <div class=\"footer-widget\">\n");
      out.write("                            <h4>Business Time</h4>\n");
      out.write("                            <!--<ul class=\"list-time\">-->\n");
      out.write("                            <p>Monday - Friday: 08.00am to 19.00pm</p> \n");
      out.write("                            <p>Saturday - Sunday: 08.00am to 22.00pm</p> \n");
      out.write("                            <!--</ul>-->\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-lg-4 col-md-12 col-sm-12\">\n");
      out.write("                        <div class=\"footer-link-contact\">\n");
      out.write("                            <h4>Contact Us</h4>\n");
      out.write("                            <ul>\n");
      out.write("                                <li>\n");
      out.write("                                    <p><i class=\"fas fa-map-marker-alt\"></i>999 Vo Van Hat <br>Phuong Long Truong<br> Q9, tp.Ho Chi Minh</p>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <p><i class=\"fas fa-phone-square\"></i>Phone: <a>+84 346754958</a></p>\n");
      out.write("                                </li>\n");
      out.write("                                <li>\n");
      out.write("                                    <p><i class=\"fas fa-envelope\"></i>Email: <a href=\"mailto:tienvmt02@gmail.com\">tienvmt02@gmail.com</a></p>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"col-lg-4 col-md-12 col-sm-12\">\n");
      out.write("                        <div class=\"footer-widget\">\n");
      out.write("                            <h4>About Fresh Shop</h4>\n");
      out.write("                            <p>Owner: Tien VM </p> \n");
      out.write("                            <p>A store about flower, where you can choice a special gift for your lover, your life! </p> \t\t\t\t\t\t\t\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </footer>\n");
      out.write("    <!-- End Footer  -->\n");
      out.write("\n");
      out.write("    <!-- Start copyright  -->\n");
      out.write("    <div class=\"footer-copyright\">\n");
      out.write("        <p class=\"footer-company\">All Rights Reserved. &copy; 2021 <a href=\"#\">Fresh Shop</a> Design By : Tien VM</p>\n");
      out.write("    </div>\n");
      out.write("    <!-- End copyright  -->\n");
      out.write("\n");
      out.write("    <a href=\"#\" id=\"back-to-top\" title=\"Back to top\" style=\"display: none;\">&uarr;</a>\n");
      out.write("\n");
      out.write("    <!-- ALL JS FILES -->\n");
      out.write("    <script src=\"js/js_main/jquery-3.2.1.min.js\"></script>\n");
      out.write("    <script src=\"js/js_main/popper.min.js\"></script>\n");
      out.write("    <script src=\"js/js_main/bootstrap.min.js\"></script>\n");
      out.write("    <!-- ALL PLUGINS -->\n");
      out.write("    <script src=\"js/js_main/jquery.superslides.min.js\"></script>\n");
      out.write("    <script src=\"js/js_main/bootstrap-select.js\"></script>\n");
      out.write("    <script src=\"js/js_main/inewsticker.js\"></script>\n");
      out.write("    <script src=\"js/js_main/bootsnav.js.\"></script>\n");
      out.write("    <script src=\"js/js_main/images-loded.min.js\"></script>\n");
      out.write("    <script src=\"js/js_main/isotope.min.js\"></script>\n");
      out.write("    <script src=\"js/js_main/owl.carousel.min.js\"></script>\n");
      out.write("    <script src=\"js/js_main/baguetteBox.min.js\"></script>\n");
      out.write("    <script src=\"js/js_main/form-validator.min.js\"></script>\n");
      out.write("    <script src=\"js/js_main/contact-form-script.js\"></script>\n");
      out.write("    <script src=\"js/js_main/custom.js\"></script>\n");
      out.write("    \n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
