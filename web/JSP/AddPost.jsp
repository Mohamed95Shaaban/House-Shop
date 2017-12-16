
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Add Post </title>
    </head>
    <body>
        <form action="Home.html" method="get">
            <%  
                
              DealingWithDB db = new DealingWithDB();
              db.Connect();
              int houseSize = Integer.parseInt(request.getParameter("house_size"));
              int housePrice = Integer.parseInt(request.getParameter("house_prise"));
              String houseType = request.getParameter("house_type");
              String houseState = request.getParameter("house_type");
              String houseLocation = request.getParameter("house_locattion");
              int houseFloor = Integer.parseInt(request.getParameter("house_floor"));
              String house_state =request.getParameter("house_state");
              db.insert("`house_size`,`house_price`,`house_location`,`type`,`house_floor`,`Statuese`", " , " + houseSize + " , "+ housePrice + " , " +houseLocation+" , "+houseType+" , "+houseFloor+" , "+house_state, "advertisment");
              
                %>
            <input type="submit" value="Home">
        </form>
    </body>
</html>
