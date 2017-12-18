/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Antr
 */
@WebServlet(urlPatterns = {"/EditAdvertisment"})
public class EditAdvertisment extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String HFloor = request.getParameter("house_floor");
            String HLocation = request.getParameter("house_location");
            String HPrice = request.getParameter("house_price");
            String HSize = request.getParameter("house_size");
            String HStatus = request.getParameter("Status");
            String HType = request.getParameter("type");
            String adtype = request.getParameter("adtype");
            String adID = request.getParameter("AdID");
             
            Advertisment adv = new Advertisment();
            adv.setHouseID(adID);
            
            if (HFloor.length()>0)
            {
                adv.updateAdvertisment("house_floor", HFloor);
            }
            if (HLocation.length()>0)
            {
                adv.updateAdvertisment("house_location", HLocation);
            }
            if (HPrice.length()>0)
            {
                adv.updateAdvertisment("house_price", HPrice);
            }
            if (HSize.length()>0)
            {
                adv.updateAdvertisment("house_size", HSize);
            }
            if (HStatus.length()>0)
            {
                adv.updateAdvertisment("Status", HStatus);
            }
            if (HType.length()>0)
            {
                adv.updateAdvertisment("type", HType);
            }
            if (adtype.length()>0)
            {
                adv.updateAdvertisment("advertisment_Type", adtype);
            }
            response.sendRedirect("JSP/single.jsp?postID="+adID);
            //out.println(HLocation);
            //out.println(adID);
//            out.println(NewPass);
//            out.println(NewPhone);

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
