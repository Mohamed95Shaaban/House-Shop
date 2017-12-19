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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        
        HttpSession session = request.getSession(true);
        session = (HttpSession) request.getServletContext().getAttribute("session");
        String userid = (String) session.getAttribute("Current user");
        
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
            advertisment.setAdvertisment_Type(advertismentType);
            advertisment.setSuspended("0");
            advertisment.setAccountId_fk(userid);
        
            Part part = request.getPart("houseImg");
            String UPLOAD_LOCATION = "E:\\educational books\\Fourth Year\\Internet Application\\NewpdaatedHouseShop\\House-Shop\\web\\scr";
            Part filePart = request.getPart("houseImg");
            String filename = filePart.getSubmittedFileName();
            advertisment.setPhoto_text(filename);
            
            InputStream fileContent = filePart.getInputStream();
            File fileSaveDir = new File(UPLOAD_LOCATION,filename);
            Files.copy(filePart.getInputStream(), fileSaveDir.toPath());
            
            advertisment.AddAdvertisment();
        /**
         * **********************************************************
         */
 
            ArrayList<Alert> allAlerts = new ArrayList<>();
            DealingWithDB DB = new DealingWithDB() ;
            try
            {
            DB.Connect(); 
            ResultSet res = DB.select("*", "alert", "1") ;
            while (res.next())
            {
                Alert temp = new Alert();
                temp.setAccountID_Fk(res.getString("AccountID_FK"));
                temp.setAlertID(res.getString("AlertID"));
                temp.setPorpertyValue(res.getString("propertyValue"));
                temp.setPropertyAlert(res.getString("propertyAlert"));
                allAlerts.add(temp);
            }
            
            for (int i=0 ; i<allAlerts.size() ; i++)
            {
                String Column = allAlerts.get(i).getPropertyAlert() ;
                String Value = allAlerts.get(i).getPorpertyValue() ;
                if (Column.equals("house_price"))
                {
                    if (advertisment.getHouse_price().equals(Value))
                    {
                        Notification notification = new Notification() ;
                        notification.setAdvertisment_id_fk(advertisment.getHouseID());
                        notification.setRecieverID(allAlerts.get(i).getAccountID_Fk());
                        notification.setSenderID(advertisment.getAccountId_fk());
                        notification.setDescription("Check This Advertisment");
                        notification.AddNotification();
                    }
                }
                else if (Column.equals("house_size"))
                {
                    if (advertisment.getHouse_size().equals(Value))
                    {
                        Notification notification = new Notification() ;
                        notification.setAdvertisment_id_fk(advertisment.getHouseID());
                        notification.setRecieverID(allAlerts.get(i).getAccountID_Fk());
                        notification.setSenderID(advertisment.getAccountId_fk());
                        notification.setDescription("Check This Advertisment");
                        notification.AddNotification();
                    }
                }
                else if (Column.equals("type"))
                {
                    if (advertisment.getType().equals(Value))
                    {
                        Notification notification = new Notification() ;
                        notification.setAdvertisment_id_fk(advertisment.getHouseID());
                        notification.setRecieverID(allAlerts.get(i).getAccountID_Fk());
                        notification.setSenderID(advertisment.getAccountId_fk());
                        notification.setDescription("Check This Advertisment");
                        notification.AddNotification();
                    }
                }
                else if (Column.equals("Status"))
                {
                    if (advertisment.getStatus().equals(Value))
                    {
                        Notification notification = new Notification() ;
                        notification.setAdvertisment_id_fk(advertisment.getHouseID());
                        notification.setRecieverID(allAlerts.get(i).getAccountID_Fk());
                        notification.setSenderID(advertisment.getAccountId_fk());
                        notification.setDescription("Check This Advertisment");
                        notification.AddNotification();
                    }
                }
                else if (Column.equals("advertisment_Type"))
                {
                    if (advertisment.getAdvertisment_Type().equals(Value))
                    {
                        Notification notification = new Notification() ;
                        notification.setAdvertisment_id_fk(advertisment.getHouseID());
                        notification.setRecieverID(allAlerts.get(i).getAccountID_Fk());
                        notification.setSenderID(advertisment.getAccountId_fk());
                        notification.setDescription("Check This Advertisment");
                        notification.AddNotification();
                    }
                }
            }
            
                    
            }
            catch (ClassNotFoundException ex) {
            Logger.getLogger(Addpost.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Addpost.class.getName()).log(Level.SEVERE, null, ex);
        }
            

     
        
        response.sendRedirect("JSP/Home.jsp");

        
        /**************************************************/
        /*************************************************/
        /********************************/

    }

}
