<%-- 
    Document   : Profile
    Created on : Dec 16, 2017, 10:20:15 AM
    Author     : Antr
--%>

 
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
                <li class="hover"><a href="">Home</a></li>
                <li class="hover"><a href="Profile.html">Profile</a></li>
            </ul>
            <div id="logo"><img id="iLogo" src="../scr/LOGO2.png"/></div>
            <ul id="nav-bar-list-right">
                <li class="dropdown"><a href="notification.jsp" class="dropdwon-link">notification</a>
                    
                     
                </li>
                <li class="hover"><a href="AddPost.html">Add Post</a></li>
            </ul>
        </div>
        <div id="info">
            <form id="form_id" action="../ProfileServlet" method="post" enctype="multipart/form-data">
                <div id="photo">
                    <input type="file" name="file" accept="image/gif, image/jpeg, image/png">  
                    <h3>Photo</h3>
                </div>
                
                <input type="text" name="name" placeholder="Name" id="nameID" disabled/>    
                <input type="text" name="mail" placeholder="e-mail" id="e-mailID" disabled/>    
                <input type="text" name="pass" placeholder="password" id="passID" disabled/>
                <input type="text" name="phone" placeholder="phone" id="phoneID" disabled/>
                <button type="button" id="EditID" onclick="EditFunction()">Edit</button>  
                <button type="button" id="ChangeId" onclick="ChangeFunction();" style="display:none;">change</button>


            </form> 
        </div>
        </div>
        
    </body>
</html>
