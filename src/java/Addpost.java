
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


@WebServlet(urlPatterns = {"/Addpost"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, //2 MB
        maxFileSize = 1024 * 1024 * 10, //10 MB
        maxRequestSize = 1024 * 1024 * 50)
public class Addpost extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Part part = request.getPart("houseImg");
        String houseSize = request.getParameter("house_size");
            String housePrice = request.getParameter("house_prise");
            String houseType = request.getParameter("house_type");
            String houseLocattion = request.getParameter("house_locattion");
            String houseFloor = request.getParameter("house_floor");
            String description = request.getParameter("body");
            String houseState = request.getParameter("house_state");
            String advertismentType = request.getParameter("advertisment_type");
            /**
             * ******************************************************
             */
            Advertisment advertisment = new Advertisment();
            advertisment.setHouse_size(houseSize);
            advertisment.setHouse_price(housePrice);
            advertisment.setDescription(description);
            advertisment.setType(houseType);
            advertisment.setHouse_location(houseLocattion);
            advertisment.setHouse_floor(houseFloor);
            advertisment.setStatus(houseState);
            advertisment.setPhoto_text(" ");
            advertisment.setAdvertisment_Type(advertismentType);
            advertisment.setSuspended("0");

            /**
             * **********************************************************
             */
            HttpSession session = request.getSession(true);
            session = (HttpSession) request.getServletContext().getAttribute("session");
            String userid = (String) session.getAttribute("Current user");
            advertisment.setAccountId_fk(userid);
            out.println("hhhhhh => " + advertisment.getAccountId_fk());
            advertisment.AddAdvertisment();
        String fileName = extractFileName(part);
        String savePath = "E:\\kolya\\Sna 4\\IA\\project\\House-Shop\\web\\scr\\" + File.separator;
        File fileSaveDir = new File(savePath);
        if(!fileSaveDir.exists()){
            fileSaveDir.mkdir();
        }
        try{
            part.write(savePath + File.separator+fileName);
        } catch (Exception ex){
            out.println(ex.getMessage());
        }
    }

    private String extractFileName(Part part) {
        String contentDisplay = part.getHeader("content-disposition");
        String[] items = contentDisplay.split(";");
        for (String str : items) {
            if (str.trim().startsWith("filename")) {
                return str.substring(str.indexOf("=") + 2, str.length() - 1);
            }
        }
        return "NoFile";
    }
}


