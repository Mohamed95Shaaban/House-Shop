<%-- 
    Document   : AdvertiserData
    Created on : Dec 18, 2017, 2:21:10 PM
    Author     : Antr
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3304/house_buy_and_rent", "root", "");
    String ID = (String) session.getAttribute("Current user");

    String postID = request.getParameter("postID");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../CSS/homecss.css" type="text/css">
    </head>
    <body>
       
       <div class="header">  
           <img id="himg" src="../scr/header.jpg"/>
        </div>
        <div id="Container">
            <div id="nav-bar">
                <ul id="nav-bar-list-left">
                    <li class="hover"><a href="Home.jsp">Home</a></li>
                    <li class="hover"><a href="Profile.jsp">Profile</a></li>
                </ul>
                <div id="logo"><img id="iLogo" src="../scr/LOGO2.png"/></div>
                <ul id="nav-bar-list-right">
                    <li class="dropdown"><a class="dropdwon-link"><a href="Advertisments.jsp">Advertisments</a><div class="dropdown-content">
                        
                         </div>   
                    </li>
                    <li class="hover"><a href="AddPost.jsp">Add Post</a></li>
                    <li class="hover"><a href="index.jsp">Log Out</a></li>
                </ul>
            </div>
            <% 
       Statement Stmt = Con.createStatement();
        ResultSet adv = Stmt.executeQuery("SELECT AccountId_fk FROM advertisment WHERE HouseID=" + postID + "");
        adv.next();
        String userID = adv.getString("AccountId_fk");
        Statement  stmt2 = Con.createStatement();
        ResultSet data = stmt2.executeQuery("SELECT * FROM account WHERE AccountId=" +userID+"");
         while (data.next()){
          out.print("<h5>"+data.getString("username")+ "</h5>");
          out.print("<h5>"+data.getString("e-mail")+ "</h5>");
           out.print("<h5>"+data.getString("phone")+ "</h5>");
         }
       %>
        </div>
       
    </body>
</html>