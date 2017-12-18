/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ahmed
 */
@WebServlet(urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends HttpServlet {

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
            String NewName = request.getParameter("name");
            String NewEmail = request.getParameter("mail");
            String NewPass = request.getParameter("pass");
            String NewPhone = request.getParameter("phone");
           
            Account account = new Account() ;
            HttpSession session = request.getSession(true);
            session = (HttpSession)request.getServletContext().getAttribute("session");
            account.setAccountID((String) session.getAttribute("Current user"));
            String Column ="" , NewValue="" , tableName="account"; 
            if (NewName.length()>0)
            {
                account.Update("username", NewName , tableName);
            }
            if (NewEmail.length()>0)
            {
                account.Update("e-mail", NewEmail , tableName);
            }
            if (NewPass.length()>0)
            {
                account.Update("password", NewPass , tableName);
            }
            if (NewPhone.length()>0)
            {
                account.Update("phone", NewPhone , tableName);
            }
            response.sendRedirect("JSP/Profile.jsp");
            
            
//            out.println(account.getAccountID());
//            out.println(NewName);
//            out.println(NewEmail);
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
