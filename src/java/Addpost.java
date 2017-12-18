/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


/**
 *
 * @author Antr
 */
@WebServlet(urlPatterns = {"/Addpost"})
  @MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)
public class Addpost extends HttpServlet {

    private static final String SAVE_DIR = "images";

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
            String houseSize = request.getParameter("house_size");
            String housePrice = request.getParameter("house_price");
            String houseType = request.getParameter("house_type");
            String lat = request.getParameter("lat");
            String lon= request.getParameter("lon");
            String houseFloor = request.getParameter("house_floor");
            String description = request.getParameter("body");
            String houseState = request.getParameter("house_state");
            String advertismentType = request.getParameter("advertisment_type");
            /**
             * ******************************************************
             */
            Advertisment advertisment = new Advertisment();
            advertisment.setHouse_size(houseSize);
            advertisment.setHouse_price(housePrice);
            advertisment.setDescription(description);
            advertisment.setType(houseType);
            advertisment.setLat(lat);
            advertisment.setLon(lon);
            advertisment.setHouse_floor(houseFloor);
            advertisment.setStatus(houseState);
            advertisment.setPhoto_text("k");
            advertisment.setAdvertisment_Type(advertismentType);
            advertisment.setSuspended("0");

            /**
             * **********************************************************
             */
            HttpSession session = request.getSession(true);
            session = (HttpSession) request.getServletContext().getAttribute("session");
            String userid = (String) session.getAttribute("Current user");
            advertisment.setAccountId_fk(userid);
            out.println("hhhhhh => " + advertisment.getAccountId_fk());
            advertisment.AddAdvertisment();
            Part part = request.getPart("houseImg");
            InputStream is = part.getInputStream();
            String savePath = "C:" + File.separator + SAVE_DIR;
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {

                fileSaveDir.mkdir();

            }
            String photoName= extractFileName(part);
            out.print(photoName);
            out.print("lat: "+request.getParameter("lat"));
             out.print("price: "+ housePrice);
            part.write(savePath + File.separator + photoName);
             
//              response.sendRedirect("JSP/Home.jsp");
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
private String extractFileName(Part part) {
    String contentDisp = part.getHeader("content-disposition");
    String[] items = contentDisp.split(";");
    for (String s : items) {
        if (s.trim().startsWith("filename")) {
            return s.substring(s.indexOf("=") + 2, s.length()-1);
        }
    }
    return "";
}
}
