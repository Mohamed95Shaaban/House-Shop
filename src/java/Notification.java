
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
public class Notification {
    private String advertisment_id_fk , comment_id_FK , Description , notification_ID , recieverID , senderID ;

    public void setAdvertisment_id_fk(String advertisment_id_fk) {
        this.advertisment_id_fk = advertisment_id_fk;
    }

    public void setComment_id_FK(String comment_id_FK) {
        this.comment_id_FK = comment_id_FK;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setNotification_ID(String notification_ID) {
        this.notification_ID = notification_ID;
    }

    public void setRecieverID(String recieverID) {
        this.recieverID = recieverID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public String getAdvertisment_id_fk() {
        return advertisment_id_fk;
    }

    public String getComment_id_FK() {
        return comment_id_FK;
    }

    public String getDescription() {
        return Description;
    }

    public String getNotification_ID() {
        return notification_ID;
    }

    public String getRecieverID() {
        return recieverID;
    }

    public String getSenderID() {
        return senderID;
    }

    public Notification(String advertisment_id_fk, String comment_id_FK, String Description, String notification_ID, String recieverID, String senderID) {
        this.advertisment_id_fk = advertisment_id_fk;
        this.comment_id_FK = comment_id_FK;
        this.Description = Description;
        this.notification_ID = notification_ID;
        this.recieverID = recieverID;
        this.senderID = senderID;
    }

    public Notification() {
    }
    public void AddNotification ()
    {
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String Columns = "`adviertisment_id_fk`,`comment_Id_FK`,`Description`,`recieverID`,`senderID`" ;
            String Values = "'"+advertisment_id_fk+"' , '"+comment_id_FK+"' , '"+Description+"' ,'"+recieverID+"' , '"+senderID+"'" ;
            DB.insert(Columns, Values, "notification");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void DeleteNotification()
    {
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String condition = "`notification_ID` = '" + notification_ID+ "'" ;
            DB.delete(condition, "notification");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public ArrayList<Notification> ShowNotification(String reciever_ID)
    {
        ArrayList<Notification> notifications = new ArrayList<>();
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String Condition = "`recieverID` = '"+ reciever_ID+"'" ;
            ResultSet res=DB.select("*", "notification", Condition) ;
            while (res.next()) {
                Notification temp = new Notification();
                temp.setAdvertisment_id_fk(res.getString("adviertisment_id_fk"));
                temp.setComment_id_FK(res.getString("comment_Id_FK"));
                temp.setDescription(res.getString("Description"));
                temp.setNotification_ID(res.getString("notification_ID"));
                temp.setRecieverID(res.getString("recieverID"));
                temp.setSenderID(res.getString("senderID"));
                notifications.add(temp);
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return notifications ;
    }
    
}
