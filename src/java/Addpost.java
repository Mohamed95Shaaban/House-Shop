/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
@MultipartConfig(maxFileSize = 16177215)
public class Addpost extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String houseSize = request.getParameter("house_size");
        String housePrice = request.getParameter("house_price");
        String houseType = request.getParameter("house_type");
        String lat = request.getParameter("lat");
        String lon = request.getParameter("lon");
        String houseFloor = request.getParameter("house_floor");
        String description = request.getParameter("body");
        String houseState = request.getParameter("house_state");
        String advertismentType = request.getParameter("advertisment_type");
        /**
         * ******************************************************
         */
//            Advertisment advertisment = new Advertisment();
//            advertisment.setHouse_size(houseSize);
//            advertisment.setHouse_price(housePrice);
//            advertisment.setDescription(description);
//            advertisment.setType(houseType);
//            advertisment.setLat(lat);
//            advertisment.setLon(lon);
//            advertisment.setHouse_floor(houseFloor);
//            advertisment.setStatus(houseState);
//            advertisment.setPhoto_text("k");
//            advertisment.setAdvertisment_Type(advertismentType);
//            advertisment.setSuspended("0");

        /**
         * **********************************************************
         */
        HttpSession session = request.getSession(true);
        session = (HttpSession) request.getServletContext().getAttribute("session");
        String userid = (String) session.getAttribute("Current user");
        //advertisment.setAccountId_fk(userid);
        //   out.println("hhhhhh => " + advertisment.getAccountId_fk());
        // advertisment.AddAdvertisment();
        Part part = request.getPart("houseImg");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_buy_and_rent", "root", "");
            String houseID = "6";
            Statement Stmt = Con.createStatement();

            String UPLOAD_LOCATION = "E:/kolya/Sna 4/IA/project/House-Shop/web/scr";
            Part filePart = request.getPart("houseImg");
            String name = filePart.getSubmittedFileName();
            Stmt.executeUpdate("INSERT INTO  advertisment VALUES('" + houseSize + "','" + housePrice + "','" + houseType + "','" + houseType + "','" + description + "','" + houseState + "','" + houseID + "','" + 0 + "','" + userid + "','" + advertismentType + "','" + lat + "','" + lon + "','" + name + "')");
            Stmt.close();
            Con.close();
            InputStream fileContent = filePart.getInputStream();
            File fileSaveDir = new File(UPLOAD_LOCATION,name);

            Files.copy(filePart.getInputStream(), fileSaveDir.toPath());
            response.sendRedirect("JSP/Home.jsp");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Addpost.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Addpost.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
