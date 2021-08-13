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
import tienvm.daos.UserDAO;
import tienvm.dtos.FreshShopErrorDTO;
import tienvm.dtos.UserDTO;

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "UpdateUserController", urlPatterns = {"/UpdateUserController"})
public class UpdateUserController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "LoadUserController";
    private static final String INVALID = "LoadUserController";
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
            String newUserID = request.getParameter("txtNewUserID");
            String newUserName = request.getParameter("txtNewUserName");
            String newPhone = request.getParameter("txtNewPhone");
            String newEmail = request.getParameter("txtNewEmail");
            String newPassword = request.getParameter("txtNewPassword");
            String newAddress = request.getParameter("txtNewAddress");
            String newRole = request.getParameter("cbxNewRole");
            FreshShopErrorDTO errorObj = new FreshShopErrorDTO();
            boolean valid = true;
            if (newUserName.trim().length() == 0) {
                valid = false;
                errorObj.setNewUserNameError("Full Name can't be blank");
            }
            if (!newEmail.trim().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)$")) {
                valid = false;
                errorObj.setNewEmailError("Email is not in the correct format");
            }
            if (newPhone.trim().length() == 0 || !newPhone.trim().matches("^[0-9]{10}$")) {
                valid = false;
                errorObj.setPhoneError("Password can't be blank");
            }
            if (newPassword.trim().length() == 0) {
                valid = false;
                errorObj.setNewPasswordError("Password can't be blank");
            }
            if (newAddress.trim().length() == 0) {
                valid = false;
                errorObj.setNewAddressError("Address can't be blank");
            }
            UserDTO user = new UserDTO(newUserID, newPassword, newUserName, newPhone, newAddress, newRole, newEmail);
            if(valid){
                UserDAO dao = new UserDAO();
                if(dao.updateUser(user)){
                    url = SUCCESS;
                    request.setAttribute("CONTROL_USER", "User information has been changed!");
                }
                else {
                    request.setAttribute("ERROR", "Update failed!");
                }
            }
            else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
        } catch (Exception e) {
            log("Error at UpdateUserController: " +e.toString());
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
