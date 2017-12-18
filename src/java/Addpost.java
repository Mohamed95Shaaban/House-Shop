/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Antr
 */
@WebServlet(urlPatterns = {"/Addpost"})
@MultipartConfig(maxFileSize = 16177216)
public class Addpost extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
              String HouseSize = request.getParameter("house_size");
              String HousePrice = request.getParameter("house_price");
              String HouseType = request.getParameter("house_type");
              String HouseLocation = request.getParameter("house_locattion");
              String HouseFloor= request.getParameter("house_floor");
              String Describtion = request.getParameter("body");
              String HouseStates = request.getParameter("house_state");
              String AdvertismentType = request.getParameter("advertisment_type");
              
              /*************************************************************/
              Advertisment advertisment = new Advertisment();
              advertisment.setHouse_size(HouseSize);
              advertisment.setHouse_price(HousePrice);
              advertisment.setType(HouseType);
              advertisment.setHouse_location(HouseLocation);
              advertisment.setHouse_floor(HouseFloor);
              advertisment.setDescription(Describtion);
              advertisment.setStatus(HouseStates);
              advertisment.setAdvertisment_Type(AdvertismentType);
              advertisment.setSuspended(HouseType);
              advertisment.setSuspended("0");
              advertisment.setPhoto_text("");
             
              HttpSession  session = request.getSession(true);
              session = (HttpSession) request.getServletContext().getAttribute("session") ;
              String userid = (String) session.getAttribute("Current user");
              advertisment.setAccountId_fk(userid);  
              advertisment.AddAdvertisment();
              
              response.sendRedirect("JSP/Home.jsp");
              
              //Profile
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Addpost.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Addpost.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Addpost.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Addpost.class.getName()).log(Level.SEVERE, null, ex);
        }
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
