
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_buy_and_rent", "root", "");
    String ID = (String) session.getAttribute("Current user");

    String postID = request.getParameter("postID");

    out.print(ID);
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
                    <li class="dropdown"><a class="dropdwon-link"><a href="Advertisments.jsp">Advertisments</a>


                    </li>
                    <li class="hover"><a href="">Contact</a></li>
                </ul>
            </div>

            <%
                // Displaying post Content
                
                Statement Stmt = Con.createStatement();
                ResultSet adv = Stmt.executeQuery("SELECT HouseID,AccountId_fk,photo_text,description,house_floor,house_location,house_price,house_size,Status,type FROM advertisment WHERE HouseID=" + postID + "");
                int commentCnt = 0;
                while (adv.next()) {
                    String userFk = adv.getString("AccountId_fk");
                    Statement stmt3 = Con.createStatement();
                    ResultSet rates = stmt3.executeQuery("SELECT * FROM rate WHERE Advertisment_Id_Fk=" + postID + "");
                    rates.last();
                    int rateCnt = rates.getRow();
                    Statement stmt2 = Con.createStatement();
                    ResultSet comments = stmt2.executeQuery("SELECT * FROM comment WHERE Advertisment_Id_Fk=" + postID + "");
                    comments.last();
                    commentCnt = comments.getRow();
                    out.print("<div class=\"post\">");
                    out.print("<div class=\"date\"><img src=\"../scr/" + adv.getString("photo_text") + "\" alt=\"notFound\"></div>");
                    out.print(" <div class=\"post-info\">");
                    out.print("<ul class=\"post-interactions\">");
                    out.print("<li><img id=\"star\" src=\"../scr/star.png\"><a>" + rateCnt + "Rates</a></li>");
                    out.print("<li><div class=\"Hline\"></div></li>");
                    out.print("<li><img id=\"star\" src=\"../scr/Comment2.png\" alt=\"notfound\"><a>" + commentCnt + " Comment</a></li>");
                    out.print("</ul>");
                    out.print("</div>");
                    out.print("<div class=\"post-content\">");
                    out.print("<p>" + adv.getString("description") + "</p>");
                    out.print("<form action ' '>");
                    out.print("<h5>House Floor: " + adv.getString("house_floor") + "</h5>");
                    out.print("<h5>House Location: " + adv.getString("house_location") + "</h5>");
                    out.print("<h5>House Price: " + adv.getString("house_price") + "</h5>");
                    out.print("<h5>House Size: " + adv.getString("house_size") + "</h5>");
                    out.print("<h5>House Status: " + adv.getString("Status") + "</h5>");
                    out.print("<h5>House Type: " + adv.getString("type") + "</h5>");
                    out.print("<div class=\"post-img\"><img src=\"../scr/post_img.PNG\" alt=\"notFound\"></div>");
                    out.print("</div>");
                    out.print("</div>");
                    out.print("<div class=\"next-comment\">");
                    out.print("<p>" + commentCnt + "Comment</p>");
                    out.print("</div>");
                }
            %>

            <div class="post-comment">
                <p class="head">Post A Comment</p>
                <form class="form" action="../CommentServlet">
                    <div class="name-email">
                        <p >Use Your Real Name</p><input type="text" placeholder="Name" name="name" id="name">
                        <input type="email" placeholder="Email" name="email" id="email"><p>Email Will not Published</p></div>
                    <p class="guid">Write a good comment</p>
                    <div class="comment">
                        <input type="text" placeholder="Comment" name="comment" id="comment">
                    </div>
                    <input type="hidden" value="<%= postID%>" name="postid" >
                    <div class="Button-post">
                        <button>Post</button>
                    </div>
                </form>
            </div>

            <%
                //Desplaying Comments
                Statement stmt = Con.createStatement();
                ResultSet comments = stmt.executeQuery("SELECT * FROM comment WHERE Advertisment_Id_Fk=" + postID + "");
                while(comments.next())
                {
                    String UserID = comments.getString("commenter_Fk");
                    Statement stmt2 = Con.createStatement();
                    ResultSet users = stmt2.executeQuery("SELECT * FROM account WHERE AccountId=" + UserID + "");
                    users.next();
                    out.print("<div class=\"footer\">");
                    out.print("<div class=\"footer-comments\">");
                    String img= users.getString("picture_text");
                    if(img.equals("0"))
                    {
                        img="Logo.png";
                    }
                    out.print("<img  src=\"../scr/"+img+"\" class=\"circule\"/>");
                    out.print("<h3>"+users.getString("username")+"</h3>");
                    out.print("<p>"+comments.getString("CommentText")+"</p>");
                    out.print("</div>");
                    out.print("</div>");
     
                }

            %>       
            




        </div>
    </body>
</html>
