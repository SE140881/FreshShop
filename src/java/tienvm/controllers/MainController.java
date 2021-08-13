/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String SEARCH_USER = "SearchUserController";
    private static final String UPDATE_USER = "UpdateUserController";
    private static final String DELETE_USER = "DeleteUserController";
    private static final String CREATE_USER = "CreateUserController";
    private static final String SEARCH_PRODUCTMANAGER = "SearchProductManagerController";
    private static final String UPDATE_PRODUCT = "UpdateProductController";
    private static final String DELETE_PRODUCT = "DeleteProductController";
    private static final String CREATE_PRODUCT = "CreateProductController";
    private static final String SEARCH_PRODUCT = "SearchProductController";
    private static final String ADD_CART = "AddToCartController";
    private static final String REMOVE_ON_CART = "RemoveOnCartController";
    private static final String UPDATE_ON_CART = "UpdateOnCartController";
    private static final String ORDER = "OrderController";
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if("Login".equals(action)){
                url = LOGIN;
            }
            if(action == null) {
                url = "ProductController";
            }
            else if("Logout".equals(action)){
                url = LOGOUT;
            }
            else if("DeleteUser".equals(action)){
                url = DELETE_USER;
            }
            else if("SearchUser".equals(action)){
                url = SEARCH_USER;
            }
            else if("UpdateUser".equals(action)){
                url = UPDATE_USER;
            }
            else if("CreateUser".equals(action)){
                url = CREATE_USER;
            }
            else if("SearchAdminProduct".equals(action)){
                url = SEARCH_PRODUCTMANAGER;
            }
            else if("UpdateProduct".equals(action)){
                url = UPDATE_PRODUCT;
            }
            else if("DeleteProduct".equals(action)){
                url = DELETE_PRODUCT;
            }
            else if("CreateProduct".equals(action)){
                url = CREATE_PRODUCT;
            }
            else if("SearchProduct".equals(action)){
                url = SEARCH_PRODUCT;
            }
            else if("AddToCart".equals(action)){
                url = ADD_CART;
            }
            else if("RemoveCart".equals(action)){
                url = REMOVE_ON_CART;
            }
            else if("InDe".equals(action)){
                url = UPDATE_ON_CART;
            }
            else if("Check Out".equals(action)){
                url = ORDER;
            }
        } catch (Exception e) {
            log("Error at MainController" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
