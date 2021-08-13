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
import tienvm.dtos.CartDTO;
import tienvm.dtos.ProductDTO;

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {
    private static final String ERROR = "shop.jsp";
    private static final String SUCCESS = "cart.jsp";

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
            String cartProductID = request.getParameter("cartProductID").trim();
            String cartQuantityStr = request.getParameter("cartProductQuantity");
            int cartQuantity = Integer.parseInt(cartQuantityStr);
            ProductDAO dao = new ProductDAO();
            List<ProductDTO> listProduct = dao.listProduct();
            HttpSession session = request.getSession();
            CartDTO cartSession = (CartDTO) session.getAttribute("CART");
            if (cartSession == null) {
                cartSession = new CartDTO();
            }
            cartSession.addToCart(cartProductID);
            session.setAttribute("CART", cartSession);
            session.setAttribute("LIST_CART", cartSession.getCart());
            session.setAttribute("LIST_PRODUCT", listProduct);
        } catch (Exception e) {
            log("ERROR at AddToCartController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("shop.jsp").forward(request, response);
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
