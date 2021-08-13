/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienvm.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import tienvm.daos.OrderDAO;
import tienvm.daos.OrderDetailDAO;
import tienvm.daos.ProductDAO;
import tienvm.dtos.OrderDetailDTO;
import tienvm.dtos.ProductDTO;

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {  

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
        try {
            HttpSession session = request.getSession();
            String userID = (String) session.getAttribute("USERID");
            if(userID == null){
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            String totalStr = request.getParameter("totalCheckOut");
            float total = Float.parseFloat(totalStr);
            OrderDAO dao = new OrderDAO();
            boolean check = dao.insertOrder(userID, total);
            if (check) {
                int orderID = dao.getIDCart(userID);
                ProductDAO productDAO = new ProductDAO();
                List<ProductDTO> list = productDAO.listProduct();
                HashMap<String, Integer> cart = (HashMap<String, Integer>) session.getAttribute("LIST_CART");
                Set<String> listKeys = cart.keySet();
                productDAO.listProduct();
                boolean insertDetail = false;
                for (String item : listKeys) {
                    ProductDTO pro = productDAO.findProductByID(item, list);
                    OrderDetailDTO orderDetail = new OrderDetailDTO(item, orderID, (pro.getPrice()), cart.get(item));
                    OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
                    insertDetail = orderDetailDAO.insertOrderDetail(orderDetail);
                }
                if(insertDetail){
                    session.removeAttribute("LIST_CART");
                    session.removeAttribute("CART");
                }
                
            }
        } catch (Exception e) {
            log("ERROR at OrderController: " + e.getMessage());
        } finally {
            response.sendRedirect("shop.jsp");
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
