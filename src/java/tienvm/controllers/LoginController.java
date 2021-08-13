/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tienvm.daos.ProductDAO;
import tienvm.daos.UserDAO;
import tienvm.dtos.FreshShopErrorDTO;
import tienvm.dtos.ProductDTO;
import tienvm.dtos.UserDTO;

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String INVALID = "login.jsp";
    private static final String ADMIN = "admin.jsp";
    private static final String USER = "ProductController";

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
        String url = INVALID;
        try {
            String userID = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");
            FreshShopErrorDTO errorObj = new FreshShopErrorDTO();
            boolean valid = true;
            if(userID.length() == 0) {
                errorObj.setUserIDError("UserID can't be blank!");
                valid = false;
            }
            if(password.length() == 0) {
                errorObj.setPasswordError("Password can't be blank!");
                valid = false;
            }
            if(valid){
                UserDAO dao = new UserDAO();
                ProductDAO daoPro = new ProductDAO();
                UserDTO user = dao.checkLogin(userID, password);
                List<UserDTO> listUser = dao.listUser();
                List<ProductDTO> listPro = daoPro.listProduct();
                if(user == null){
                    request.setAttribute("ERROR", "Invalid UserID and Password");
                }
                else {
                    HttpSession session = request.getSession();
                    session.setAttribute("USERID", user.getUserID());
                    session.setAttribute("USERNAME", user.getUserName());
                    session.setAttribute("LISTUSER", listUser);
                    session.setAttribute("LISTPRODUCT", listPro);
                    String roleID = user.getRoleID();
                    if(roleID.trim().equals("AD")){
                        url = ADMIN;
                    }
                    else if(roleID.trim().equals("US")){
                        url = USER;
                    }
                    else {
                        request.setAttribute("ERROR", "Invalid role!");
                    }
                }
            }
            else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("Error at LoginController" + e.toString());
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
