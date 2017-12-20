<%-- 
    Document   : Profile
    Created on : Dec 16, 2017, 10:20:15 AM
    Author     : Antr
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3304/house_buy_and_rent", "root", "");
    Statement Stmt = Con.createStatement();
    String AccountID = (String) session.getAttribute("Current user");
    ResultSet res = Stmt.executeQuery("SELECT * FROM account WHERE `AccountId` = '" + AccountID + "'");
        
    res.next();
    String EMail =res.getString("e-mail");
    String pass =res.getString("password");
    String phone = res.getString("phone");
    String pic_text = res.getString("picture_text");
    String type = res.getString("type");
    

    
%>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Profile</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="../CSS/ProfileC.css" rel="stylesheet" > 
        <link href="../CSS/homecss.css" rel="stylesheet" >    
        <script type="text/javascript" src="../JS/JSProfile.js"></script>
        <script type="text/javascript" src="../JS/jquery-3.1.0.min.js" ></script>
        
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
                <li class="dropdown"><a href="notification.jsp" class="dropdwon-link">notification</a>
                    
                     
                </li>
                <li class="hover"><a href="AddPost.jsp">Add Post</a></li>
                <li class="hover"><a href="../index.html">Log Out</a></li>
            </ul>
        </div>
        <div id="info">
            <form id="form_id"  action="../ProfileServlet" method="post"  enctype="multipart/form-data">
                <div id="photo">
                    <input type="file" name="file" accept="image/gif, image/jpeg, image/png">  
                    <h3>Photo</h3>
                </div>
                
                <input type="text" name="name" placeholder= <%= res.getString("username")  %> id="nameID" disabled/>    
                <input type="text" name="mail" placeholder= <%= EMail %> id="e-mailID" disabled/>    
                <input type="text" name="pass" placeholder= <%= pass %> id="passID" disabled/>
                <input type="text" name="phone" placeholder= <%= phone %> id="phoneID" disabled/>
                <img src="../scr/<%= pic_text%>" alt="notfound" /> <br> 
                <button type="button" id="EditID" onclick="EditFunction()">Edit</button>  
                <button type="button" id="ChangeId" onclick="ChangeFunction();" style="display:none;">change</button>


            </form> 
        </div>
                <Form action="../MakeAlert">
            
                  
                <select name="property">
                    <option   disabled selected>Choose Specific property</option>
                     <option   value="house_price">Price</option>
                     <option   value="house_size">Size</option>
                     <option  value="type">House Type</option>
                     <option  valur="Status"> State </option>
                     <option  value="advertisment_Type">ADType</option> 
                </select>
                <br/>
                <input type="text" name="searchQury"/>
                
                <input type="submit" value="MakeAlert"/>
            
            </form>
                
        </div>
                
    </body>
</html>
