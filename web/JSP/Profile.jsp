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
                <li class="dropdown"><a class="dropdwon-link">Category</a><div class="dropdown-content">
                        <a href="#">Diary</a>
                        <a href="#">Personal</a>
                        <a href="#">Holiday</a>
                        <a href="#">Work</a>
                        <a href="#">Family</a>
                    </div>   
                </li>
                <li class="hover"><a href="AddPost.html">Add Post</a></li>
            </ul>
        </div>
        <div id="info">
            <form action="Profile" method="post" enctype="multipart/form-data">
                <div id="photo">
                    <input type="file" name="file" accept="image/gif, image/jpeg, image/png">  
                    <h3>Photo</h3>
                </div>
                
                <input type="text"  placeholder="" disabled/>    
                <input type="text" placeholder="e-mail" disabled/>    
                <input type="text" placeholder="password" disabled/>
                <input type="text" placeholder="phone" disabled/>
                <button>Edit</button>  
                <button>change</button>


            </form> 
        </div>
        </div>
    </body>
</html>
