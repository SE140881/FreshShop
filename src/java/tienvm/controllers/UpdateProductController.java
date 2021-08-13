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
import tienvm.daos.ProductDAO;
import tienvm.dtos.FreshShopErrorDTO;
import tienvm.dtos.ProductDTO;

/**
 *
 * @author TienVM_PC
 */
@WebServlet(name = "UpdateProductController", urlPatterns = {"/UpdateProductController"})
public class UpdateProductController extends HttpServlet {
    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "LoadProductController";
    private static final String INVALID = "LoadProductController";

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
            String newProductID = request.getParameter("txtNewProductID");
            String newProductName = request.getParameter("txtNewProductName");
            String newQuantityStr = request.getParameter("txtNewQuantity");
            int newQuantity = 0;
            String newPriceStr = request.getParameter("txtNewPrice");
            double newPrice = 0;
            String newImage = request.getParameter("txtNewImage");
            String newCategory = request.getParameter("cbxNewCategory");
            
            FreshShopErrorDTO errorObj = new FreshShopErrorDTO();
            boolean valid = true;
            if (newProductName.length() == 0) {
                valid = false;
                errorObj.setProductNameError("Product Name can't be blank");
            }
            if (newQuantityStr.length() == 0 || !newQuantityStr.matches("[0-9]{1,}")) {
                valid = false;
                errorObj.setQuantityError("Quantity can't be blank and > 0");
            } else {
                newQuantity = Integer.parseInt(newQuantityStr);
            }
            if (newPriceStr.length() == 0 || !newPriceStr.matches("^\\d*\\.?\\d*$")) {
                valid = false;
                errorObj.setPriceError("Price can't be blank and > 0");
            } else {
                newPrice = Double.parseDouble(newPriceStr);
            }
            if (newImage.length() == 0) {
                valid = false;
                errorObj.setImageError("Image can't be blank");
            }
            
            ProductDTO pro = new ProductDTO(newProductID, newProductName, newPrice, newImage, newCategory, newQuantity);
            if(valid) {
                ProductDAO dao = new ProductDAO();
                if(dao.updateProduct(pro)){
                    url = SUCCESS;
                    request.setAttribute("SUCCESS", "Product information has been changed!");
                }
                else {
                    request.setAttribute("ERROR", "Update Failed!");
                }
            }
            else {
                url = INVALID;
                request.setAttribute("INVALID", errorObj);
            }
            
        } catch (Exception e) {
            log("ERROR at UpdateProductController: " + e.getMessage());
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
