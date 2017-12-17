

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Add Post
        </title>
        <link rel="stylesheet" href="../CSS/style.css">
        <link rel="stylesheet" href="../CSS/homecss.css" type="text/css">

    </head>

    <body>
        <div>
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
            
            <div id="form">
                <form action="AddPost" method="post"  enctype="multipart/form-data">
               
                 <input type="number" name = "house_size" placeholder="Hoise Size meters " required>
                 <input type="number" name="house_prise"  placeholder="Hoise price L.E" required>
                 <input type="text" name="house_type" placeholder="1 For villa / 0 For Studio" required>
                 <input type="text" name="house_locattion" placeholder="House location" required>
                 <input type="number" name="house_floor" placeholder="House floor" required>
                <textarea placeholder="Description"  cols="10" rows="5" name="body" required></textarea>
                <input type="text" name="house_state" placeholder="Finished/ half finished/etc" required>
                <input type="number" name="advertisment_type" placeholder="1 For Rent / 0 For Sale" required>
                <input type="file" name="file" accept="image/gif, image/jpeg, image/png"  >
                <input type="file" name="Mfile" accept="image/gif, image/jpeg, image/png" multiple>
               
                <input type="submit" value="Post" class="submit">
            </form>
            </div>
        </div>
            </div>
    </body>
</html>
