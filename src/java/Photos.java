
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ahmed
 */
public class Photos {
    String Advertisment_Id_FK , location_Text , photo_Id ;

    public String getAdvertisment_Id_FK() {
        return Advertisment_Id_FK;
    }

    public String getLocation_Text() {
        return location_Text;
    }

    public String getPhoto_Id() {
        return photo_Id;
    }

    public void setAdvertisment_Id_FK(String Advertisment_Id_FK) {
        this.Advertisment_Id_FK = Advertisment_Id_FK;
    }

    public void setLocation_Text(String location_Text) {
        this.location_Text = location_Text;
    }

    public void setPhoto_Id(String photo_Id) {
        this.photo_Id = photo_Id;
    }

    public Photos(String Advertisment_Id_FK, String location_Text, String photo_Id) {
        this.Advertisment_Id_FK = Advertisment_Id_FK;
        this.location_Text = location_Text;
        this.photo_Id = photo_Id;
    }

    public Photos() {
    }
    public ArrayList<Photos> ShowPhotos(String Ad_ID)
    {
        ArrayList<Photos> photos = new ArrayList<>();
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String Condition = "`Advertisment_Id_FK` = '"+ Ad_ID+"'" ;
            ResultSet res=DB.select("*", "photos", Condition) ;
            while (res.next()) {
                Photos temp = new Photos();
                temp.setAdvertisment_Id_FK(res.getString("advertisment_Id_FK"));
                temp.setLocation_Text(res.getString("location_Text"));
                temp.setPhoto_Id(res.getString("photo_Id"));
                photos.add(temp);
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Photos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Photos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return photos ;
    }
    public void AddPhoto()
    {
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String Columns = "`Advertisment_Id_FK`,`location_Text`,`photo_Id`" ;
            String Values = "'"+Advertisment_Id_FK+"' , '"+location_Text+"' , '"+photo_Id+"'" ;
            DB.insert(Columns, Values, "photos");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Photos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Photos.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void deletePhoto()
    {
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String condition = "`photo_Id` = '" + photo_Id+ "'" ;
            DB.delete(condition, "photos");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Photos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Photos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void EditPhoto(String Newlocation_Text)
    {
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String Columns = "`location_Text`" ;
            String NewValues = "'"+Newlocation_Text+"'";
            String IDValue = "`photo_Id` = '" + photo_Id+ "'" ;
            DB.update(IDValue, Columns, NewValues , "photos");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Photos.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Photos.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
