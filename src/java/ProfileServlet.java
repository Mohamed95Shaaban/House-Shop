/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.ResultSet;
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
 * @author Ahmed
 */
@WebServlet(urlPatterns = {"/ProfileServlet"})
@MultipartConfig(maxFileSize = 16177215)
public class ProfileServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

         String NewName = request.getParameter("name");
            String NewEmail = request.getParameter("mail");
            String NewPass = request.getParameter("pass");
            String NewPhone = request.getParameter("phone");
           
            String UPLOAD_LOCATION = "E:/kolya/Sna 4/IA/project/House-Shop/web/scr";
            Part filePart = request.getPart("file");
            String name = filePart.getSubmittedFileName();
            Account account = new Account();
            HttpSession session = request.getSession(true);
            session = (HttpSession) request.getServletContext().getAttribute("session");
            account.setAccountID((String) session.getAttribute("Current user"));
            String Column = "", NewValue = "", tableName = "account";
            if (NewName.length() > 0) {
                account.Update("username", NewName, tableName);
            }
            if (NewEmail.length() > 0) {
                account.Update("e-mail", NewEmail, tableName);
            }
            if (NewPass.length() > 0) {
                account.Update("password", NewPass, tableName);
            }
            if (NewPhone.length() > 0) {
                account.Update("phone", NewPhone, tableName);
            }
            
                account.Update("picture_text", name, tableName);
                
                File fileSaveDir = new File(UPLOAD_LOCATION, name);
                Files.copy(filePart.getInputStream(), fileSaveDir.toPath());
                 System.out.println("photo Name: "+name);
                response.sendRedirect("JSP/Profile.jsp");
    }

   

}
