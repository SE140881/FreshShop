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
@WebServlet(name = "CreateProductController", urlPatterns = {"/CreateProductController"})
public class CreateProductController extends HttpServlet {
    private static final String SUCCESS = "LoadProductController";
    private static final String INVALID = "createProduct.jsp";

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
            
            if (newProductID.trim().length() == 0 || !newProductID.trim().matches("^[A-Z]+[0-9]{3}$")) {
                valid = false;
                errorObj.setProductIDError("Wrong format AAXXX. A from A-Z, X is digit from ‘0’ to ‘9’");
            }
            if (newProductName.trim().length() == 0) {
                valid = false;
                errorObj.setProductNameError("Product Name can't be blank");
            }
            if (newQuantityStr.trim().length() == 0 || !newQuantityStr.trim().matches("[0-9]{1,}")) {
                valid = false;
                errorObj.setQuantityError("Quantity must be number and greater 0");
            } else {
                newQuantity = Integer.parseInt(newQuantityStr);
            }
            if (newPriceStr.trim().length() == 0 || !newPriceStr.trim().matches("^\\d*\\.?\\d*$")) {
                valid = false;
                errorObj.setPriceError("Price must be number and greater 0");
            } else {
                newPrice = Double.parseDouble(newPriceStr);
            }
            if (newImage.trim().length() == 0) {
                valid = false;
                errorObj.setImageError("Image can't be blank");
            }
            ProductDTO pro = new ProductDTO(newProductID, newProductName, newPrice, newImage, newCategory, newQuantity);
            if(valid){
                ProductDAO dao = new ProductDAO();
                if(dao.insertProduct(pro)){
                    url = SUCCESS;
                    request.setAttribute("SUCCESS", "Create product susscessully!");
                }
            }else {
                    url = INVALID;
                    request.setAttribute("INVALID", errorObj);
                    request.setAttribute("FAIL", "Create product fail!");
            }
            
        } catch (Exception e) {
            log("ERROR at CreateProductController: " + e.getMessage());
            System.out.println(e.getMessage());
            if(e.getMessage().contains("duplicate")){
                FreshShopErrorDTO errorObj = new FreshShopErrorDTO();
                errorObj.setProductIDError("Product ID existed!");
                request.setAttribute("INVALID", errorObj);
            }
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
