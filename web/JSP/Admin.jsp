<%-- 
    Document   : AdminJSp
    Created on : Dec 19, 2017, 10:26:49 AM
    Author     : Antr
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_buy_and_rent", "root", "");
    String AccountID = (String) session.getAttribute("Current user");   
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
                    <li class="hover"><a href="">Home</a></li>
                    <li class="hover"><a href="Profile.jsp">Profile</a></li>
                </ul>
                <div id="logo"><img id="iLogo" src="../scr/LOGO2.png"/></div>
                <ul id="nav-bar-list-right">
                    <li class="dropdown"><a class="dropdwon-link"><a href="Admin.jsp">ADMIN</a><div class="dropdown-content">
                                </div>   
                    </li>
                    <li class="hover"><a href="AddPost.jsp">Add Post</a></li>
                </ul>
            </div>
            <%
                Statement Stmt = Con.createStatement();
                ResultSet adv = Stmt.executeQuery("SELECT  AccountId,username, password FROM account ");
                while(adv.next())
                {
                    String accid= adv.getString("AccountId");
                    Statement stmt3= Con.createStatement();
                    out.print("<div class=\"post\">");
                    out.print(" <div class=\"post-info\">");
                    out.print("<ul class=\"post-interactions\">");
                    out.print("<li><div class=\"Hline\"></div></li>");
                    out.print("</ul>");
                    out.print("</div>");
                    out.print("<div class=\"post-content\">");
                    out.print("<p>"+adv.getString("username")+"</p>");
                    out.print("<p>"+adv.getString("password")+"</p>");
                    out.print("</div>"); 
                    out.print("</div>");
                  
                      
                    
                }
                 
                    
                    adv.close();
                    Stmt.close();
                    
                    Con.close();
            %>             
        </div>
    </body>
</html>
                           
