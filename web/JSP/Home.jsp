<%-- 
    Document   : Home
    Created on : Dec 16, 2017, 10:19:55 AM
    Author     : Antr
--%>

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
            <div class="title"><p>Hello, Welcome to House Shop!</p></div>
            <div class="line"></div>
            <div class="line"></div>
            <div class="post">
                <div class="date"><p>31 Jul</p></div>
                <div class="post-info">
                    <ul class="post-interactions">

                        <li><img id="star" src="../scr/star.png"><a>139 Rates</a></li>
                        <li><div class="Hline"></div></li>
                        <li><img id="star" src="../scr/Comment2.png" alt=""><a> 21 Comment</a></li>
                    </ul>
                </div>
                <div class="post-content">
                    <h1>Lorem Ipsum Dolor Sit Amet</h1>
                    <p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet. Aenean sollicitu-<br>din, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit <br>amet nibh vulputate cursus a sit amet mauris. Morbi accumsan ipsum velit. Nam nec tellus a odio tincid-<br>unt auctor a ornare odio. Sed non  mauris vitae erat consequat auctor eu in elit. Class aptent taciti.</p>
                    <div class="button"><a href="">Read More</a></div>
                </div>
            </div>
            
            <div class="Button1">
                <a href="#get_in_touch">Load More</a >
            </div>      
              
        </div>
        
    </body>
    
</html>
