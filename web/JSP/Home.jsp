<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%
    Class.forName("com.mysql.jdbc.Driver");
    Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/house_buy_and_rent", "root", "");
    String CurrentUserID = (String) session.getAttribute("Current user");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../CSS/homecss.css" type="text/css">
        <script type="text/javascript" src="../JS/JSHome.js"></script>
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
                    <%
                        Statement Stmt2 = Con.createStatement();
                        ResultSet res = Stmt2.executeQuery("SELECT * FROM account WHERE AccountId=" + CurrentUserID + "");
                        while (res.next()) {
                            String userType = res.getString("type");
                            if (userType.equals("1")) {
                                out.print("<li class='dropdown'><a class='dropdwon-link'><a href='Admin.jsp'>ADMIN</a><div class='dropdown-content'>");
                            } else {
                                out.print("<li class='dropdown'><a class='dropdwon-link'><a href='Advertisments.jsp'>Advertisments</a><div class='dropdown-content'>");
                            }
                        }


                    %>


            </div>   
        </li>
        <li class="hover"><a href="AddPost.jsp">Add Post</a></li>
        <li class="hover"><a href="../index.html">Log Out</a></li>
    </ul>
</div>
<div class="title"><p>Hello, Welcome to House Shop!</p></div>
<div class="line"></div>
<div class="line"></div>
<Form id="searchForm" action="SpaceficSearch.jsp">

    <select id ="search" name="property">
        <option   disabled selected> Choose Specific property</option>
        <option   value="house_price">Price</option>
        <option   value="house_size">Size</option>
        <option  value="type">House Type</option>
        <option  valur="Status"> State </option>
        <option  value="advertisment_Type">ADType</option> 
    </select>

    <input type="text" name="searchQury"/>

    <input type="submit" value="search"/>

</form>

<%               Statement Stmt = Con.createStatement();
    ResultSet adv = Stmt.executeQuery("SELECT * FROM advertisment ");
    while (adv.next()) {
        String id = adv.getString("HouseID");
        String Suspended = adv.getString("suspended");
        Statement stmt3 = Con.createStatement();
        ResultSet rates = stmt3.executeQuery("SELECT * FROM rate WHERE Advertisment_Id_Fk=" + id + "");
        rates.next();
        int rateCnt = 1;
        Statement stmt2 = Con.createStatement();
        ResultSet comments = stmt2.executeQuery("SELECT * FROM comment WHERE Advertisment_Id_Fk=" + id + "");
        comments.next();
        int commentCnt = 1;

        out.print("<div id=\"PID" + id + "\" class=\"post\">");
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

        out.print("<input type='text' id='HouseID' value=\"" + id + "\" hidden / >");
        out.print("<div id=\"hrefID" + id + "\" class=\"button\"><a  href=\"single.jsp?postID=" + id + "\" >Read More </a></div>");

        out.print("<div class=\"button\">"
                + "<input type=\"button\" id=\"susID" + id + "\" value=\"Suspend\" onclick=\"Suspend(" + id + ")\" hidden/>   "
                + "<input type=\"button\" id=\"unsusID" + id + "\" value=\"UnSuspend\" onclick=\"UnSuspend(" + id + ")\" hidden/>   "
                + "<input type=\"button\" id=\"remID" + id + "\" value=\"remove\" onclick=\"remove(" + id + ")\" hidden/>   "
                + "</div>");
        out.print("<p id=\"paragraphID" + id + "\" hidden>Sorry , It is Suspended </p>");

        if (Suspended.equals("1"))//it is suspended
        {
            out.print("<script type=\"text/javascript\">hideReadMore(" + id + ")</script>");
            out.print("<script type=\"text/javascript\">showParagraph(" + id + ")</script>");
        } // not Suspended
        
        if (CurrentUserID.equals("1"))//Admin
        {
            out.print("<script type=\"text/javascript\">showButtons(" + id + ")</script>");
        }

        out.print("</div>");
        out.print("</div>");

    }

    adv.close();
    Stmt.close();

    Con.close();
%>             
</div>

</body>

</html>
