
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_buy_and_rent", "root", "");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../CSS/single.css" type="text/css">
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
                    <li class="hover"><a href="">Contact</a></li>
                </ul>
            </div>
            <div class="post">
                <div class="date"><p>31 Jul</p></div>
                <div class="post-info">
                    <ul class="post-interactions">
                        <li><a>cat :</a><a class="cat">Diary , Personal</a></li>
                        <li><div class="Hline"></div></li>
                        <li><img id="star"  src="../scr/star.png"><a>139 Rates</a></li>
                        <li><div class="Hline"></div></li>
                        <li><img id="star" src="../scr/Comment2.png" alt=""><a> 21 Comment</a></li>
                    </ul>
                </div>
                <div class="post-content">
                    <h1>Lorem Ipsum Dolor Sit Amet</h1>
                    <p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit auctor aliquet.
                     Aenean sollicitudin, lorem quis bibendum auctor, nisi elit consequat ipsum, nec sagittis sem
                      nibh id elit. Duis sed odio sit amet nibh vulputate cursus a sit amet mauris.<br> <br><br> 

                    Morbi accumsan ipsum velit. Nam nec tellus a odio tincidunt auctor a ornare odio. Sed non  mauris
                     vitae erat consequat auctor eu in elit. Class aptent taciti. sociosqu ad litora torquent per conubia 
                     nostra, per inceptos himenaeos. Mauris in erat justo. Nullam ac urna eu felis dapibus condimentum sit 
                     amet a augue. Sed non neque elit. Sed ut imperdiet nisi. Proin condimentum fermentum nunc. Etiam pharetra,
                      erat sed fermentum feugiat, velit mauris egestas quam, ut aliquam massa nisl quis neque. Suspendisse in orci enim.</p>
                    <div class="post-img"><img src="../scr/post_img.PNG" alt=""></div>

                </div>
            </div>
            <div class="next-comment">
                <p>21 Comments</p>
                  
            </div>
            
            <div class="post-comment">
            <p class="head">Post A Comment</p>
                <form class="form">
                    <div class="name-email">
                    <p >Use Your Real Name</p><input type="text" placeholder="Name" name="name" id="name">
                    <input type="email" placeholder="Email" name="email" id="email"><p>Email Will not Published</p></div>
                    <p class="guid">Write a good comment</p>
                    <div class="comment">
                        <input type="text" placeholder="Comment" name="comment" id="comment">
                    </div>
                    <div class="Button-post">
                <a href="#get_in_touch">Post</a >
            </div>
                </form>
            </div>
            <div class="footer">
                <div class="footer-comments">
                    <div class="circule"></div>
                    <h3>John Doe</h3>
                    <p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit<br>
                     auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit <br>
                     consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh <br>
                     vulputate cursus a sit amet mauris</p>
                    <a href="#">Replay</a>
                </div>
                
                <div class="footer-comments">
                    <div class="circule"></div>
                    <h3>John Doe</h3>
                    <p>This is Photoshop's version  of Lorem Ipsum. Proin gravida nibh vel velit<br>
                     auctor aliquet. Aenean sollicitudin, lorem quis bibendum auctor, nisi elit <br>
                     consequat ipsum, nec sagittis sem nibh id elit. Duis sed odio sit amet nibh <br>
                     vulputate cursus a sit amet mauris</p>
                    <a href="#">Replay</a>
                </div>
            </div>
            
            <div class="Button2">
                <a href="#get_in_touch">Show More Comments</a >
            </div>
            

        
        </div>
    </body>
</html>