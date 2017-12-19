
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3304/house_buy_and_rent", "root", "");
    String ID = (String) session.getAttribute("Current user");

    String postID = request.getParameter("postID");

    out.print(ID);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../CSS/single.css" type="text/css">
        <script type="text/javascript" src="../JS/JSSingle.js"></script>
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
                    <li class="dropdown"><a class="dropdwon-link"><a href="Advertisments.jsp">Advertisments</a>


                    </li>
                    <li class="hover"><a href="AddPost.jsp">Add Post</a></li>
                </ul>
            </div>

            <%
                // Displaying post Content
                
                Statement Stmt = Con.createStatement();
                ResultSet adv = Stmt.executeQuery("SELECT * FROM advertisment WHERE HouseID=" + postID + "");
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
                    out.print("<form id=\"form_id\" class=\"form\" action=\"../EditAdvertisment\">");
                    out.print("<h5>House Floor: " +"<input type='number' name='house_floor' id='floorID' placeholder=\""+adv.getString("house_floor")+"\" disabled / >"+ "</h5>");
                    out.print("<h5>House Location: "+"<input type='text' name='house_location' id='locationID' placeholder=\""+ adv.getString("house_location")+"\" disabled / >"  + "</h5>");
                    out.print("<h5>House Price: " +"<input type='number' name='house_price' id='priceID' placeholder=\""+ adv.getString("house_price") +"\" disabled / >"+ "</h5>");
                    out.print("<h5>House Size: " +"<input type='number' name='house_size' id='sizeID' placeholder=\""+ adv.getString("house_size") +"\" disabled / >" + "</h5>");
                    out.print("<h5>House Status: " +"<input type='text' name='Status' id='statusID' placeholder=\""+ adv.getString("Status")+"\" disabled / >"  + "</h5>");
                    out.print("<h5>House Type: " +"<input type='text' name='type' id='typeID' placeholder=\""+ adv.getString("type")+"\" disabled / >"  + "</h5>");
                    out.print("<h5>Advertisment Type: " +"<input type='text' name='adtype' id='adtypeID' placeholder=\""+ adv.getString("advertisment_Type")+"\" disabled / >"  + "</h5>");
                    out.print("<input type='text' name='AdID' value=\""+ postID+"\" hidden / >");
                    out.print("<a href='AdvertiserData.jsp?postID=\""+postID+"\"'>AdvertiserData</a>");
                    
                    out.print("<div class=\"post-img\"><img src=\"../scr/post_img.PNG\" alt=\"notFound\"></div>");
                    if(userFk.equals(ID))
                    {
                        out.print("<button type=\"button\" id=\"EditID\" onclick=\"EditFunction()\">  Edit  </button>");
                        out.print("<button type=\"button\" id=\"ChangeId\" onclick=\"ChangeFunction()\" style=\"display:none;\">   change   </button>");
                    }
//                    if(ID.equals("1"))
//                    {
//                        
//                    }
                        
                    out.print("</form>");
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
