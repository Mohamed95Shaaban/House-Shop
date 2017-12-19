<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%
    // hna code el connection 
    Class.forName("com.mysql.jdbc.Driver");
    Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3304/house_buy_and_rent", "root", "");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../CSS/single.css" type="text/css">
        <link rel="stylesheet" href="../CSS/notification.css" type="text/css">


        <title>Notifications</title>
    </head>
    <body>
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
                    <li class="dropdown"><a href="Advertisments.jsp" class="dropdwon-link">Advertisments</a>
                        <div class="dropdown-content">
                            
                        </div>   
                    </li>
                    <li class="hover"><a href="AddPost.jsp">Add Post</a></li>
                    <li class="hover"><a href="index.jsp">Log Out</a></li>
                </ul>
            </div>

            <%               
                Statement Stmt = Con.createStatement();
                ResultSet RS = Stmt.executeQuery("SELECT Description,adviertisment_id_fk FROM notification");
                while (RS.next()) {
                   
                    out.print(" <div id='notify'> ");
                    String d= RS.getString("Description");
                    String id= RS.getString("adviertisment_id_fk");
                    out.print("<a href=\"single.jsp?postID="+ id + "\">"+d+"</a>"); 
                    out.print("</div> ");
                }

                RS.close();
                Stmt.close();
                Con.close();

            %>
        </div>    
    </body>
</html>
