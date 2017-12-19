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
 * @author kawrshy
 */
@WebServlet(urlPatterns = {"/CommentServlet"})
public class CommentServlet extends HttpServlet {

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
            
             HttpSession UserSession = request.getSession(true);
             UserSession = (HttpSession)request.getServletContext().getAttribute("session");
             String UserID = (String) UserSession.getAttribute("Current user");
             String comment = request.getParameter("comment");
             String postID = request.getParameter("postid");
             
             Comment commentTable= new Comment();
             
             commentTable.setCommentText(comment);
             commentTable.setAdvertisment_id_FK(postID);
             commentTable.setCommenter_FK(UserID);
             
             commentTable.AddComment();
             
             String recieverID="" ;
           DealingWithDB DB = new DealingWithDB(); 
            try {
                DB.Connect();
                ResultSet res =DB.select("AccountId_fk", "advertisment" , "HouseID = "+postID );
                res.next() ;
                recieverID=res.getString("AccountId_fk") ;
            } catch (SQLException ex) {
                Logger.getLogger(rateServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(rateServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           Notification userNotify= new Notification();
           userNotify.setAdvertisment_id_fk(postID);
           userNotify.setDescription("Someone Commented on your post");
           userNotify.setSenderID(UserID);
           userNotify.setRecieverID(recieverID);
           userNotify.AddNotification();
             response.sendRedirect("JSP/single.jsp?postID="+postID+"");
            
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
