

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>
            Add Post
        </title>
        <script src="JS/jquery-3.1.0.min.js"> </script>
  
        <link rel="stylesheet" href="../CSS/style.css">
        <link rel="stylesheet" href="../CSS/homecss.css" type="text/css">
        
          <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBHGtXeRZZ2-lUD8UIHHeHP36_ruTkhyaA&callback=initMap">
    </script>
         
    <script type="text/javascript" src="../JS/map.js"> 
        </script>

    </head>

    <body>
        <div>
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
                <div class="title"><p>Hello, Welcome to House Shop!</p></div>
                <div class="line"></div>
                <div class="line"></div>
            
            <div id="form">
                <form action="../Addpost" method="post" enctype="multipart/form-data"  >
               
                 <input type="number" name = "house_size" placeholder="House Size meters " required>
                 <input type="number" name="house_price"  placeholder="House price L.E" required>
                 <input type="text" name="house_type" placeholder="villa or studio" required>
                 <div id="map"></div>
                 <input type="hidden" name="lat" id="lat"  />
                 <input type="hidden" name="lon" id="lon"   />
                 <input type="number" name="house_floor" placeholder="House floor" required>
                <textarea placeholder="Description"  cols="10" rows="5" name="body" required></textarea>
                <input type="text" name="house_state" placeholder="finished/ half finished/etc" required>
                <input type="text" name="advertisment_type" placeholder="rent or sell" required>
                <input type="file" name="houseImg" accept="image/gif, image/jpeg, image/png"  >
               <label id="error"></label>
                <input type="submit" value="Post" class="submit">
            </form>
            </div>
        </div>
            </div>
    </body>
</html>
