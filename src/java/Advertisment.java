
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Advertisment {
    private String Description , HouseID , House_floor , lat, lon ,photo_text , removed="0",
                   House_price , House_size , Status , Suspended , Type , AccountId_fk , advertisment_Type;

    public Advertisment() {
    }

    public Advertisment(String Description, String HouseID, String House_floor, String lat,String lon, String House_price, String House_size, String Status, String Suspended, String Type, String AccountId ,String advertisment_Type , String photo_text , String removed) {
        this.Description = Description;
        this.HouseID = HouseID;
        this.House_floor = House_floor;
        this.lat = lat;
        this.lon = lon;
        this.House_price = House_price;
        this.House_size = House_size;
        this.Status = Status;
        this.Suspended = Suspended;
        this.Type = Type;
        this.AccountId_fk = AccountId;
        this.advertisment_Type = advertisment_Type;
        this.photo_text = photo_text ;
        this.removed = removed ;
    }

    public void setRemoved(String removed) {
        this.removed = removed;
    }

    public String getRemoved() {
        return removed;
    }

    public String getAdvertisment_Type() {
        return advertisment_Type;
    }

    public String getPhoto_text() {
        return photo_text;
    }

    public void setPhoto_text(String photo_text) {
        this.photo_text = photo_text;
    }

    public void setAdvertisment_Type(String advertisment_Type) {
        this.advertisment_Type = advertisment_Type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getHouseID() {
        return HouseID;
    }

    public void setHouseID(String HouseID) {
        this.HouseID = HouseID;
    }

    public String getHouse_floor() {
        return House_floor;
    }

    public void setHouse_floor(String House_floor) {
        this.House_floor = House_floor;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

   

    public String getHouse_price() {
        return House_price;
    }

    public void setHouse_price(String House_price) {
        this.House_price = House_price;
    }

    public String getHouse_size() {
        return House_size;
    }

    public void setHouse_size(String House_size) {
        this.House_size = House_size;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getSuspended() {
        return Suspended;
    }

    public void setSuspended(String Suspended) {
        this.Suspended = Suspended;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getAccountId_fk() {
        return AccountId_fk;
    }

    public void setAccountId_fk(String AccountId) {
        this.AccountId_fk = AccountId;
    }
    /**************************************************************************/
    /**************************************************************************/
    public void AddAdvertisment()
    {
        try{
        DealingWithDB DB =new DealingWithDB() ;
        DB.Connect();
        String Columns = "`HouseID` , `description` , `house_floor` , `lat, lon` , `house_price` ,"
                       + " `house_size` , `removed` , `status` , `suspended` , `type` , `AccountId_fk` , `advertisment_Type` , `photo_text`" ;
        ResultSet res = DB.select(" MAX(HouseID) ", "advertisment", "1") ;
        res.next() ; 
        int LastId = Integer.valueOf(res.getString(1)) ;
        int NewId = LastId+1 ;
        HouseID= String.valueOf(NewId) ;
        String Values = "'"+HouseID+"' , '"+Description+"' , '"+House_floor+"' , '"
                +lat+"' , '"+lon+"' , '"+House_price+"' , '"+House_size+"' , '"+removed+"' , '"
                +Status+"' , '"+Suspended+"' , '"+Type+"' , '"+AccountId_fk+"' , '" + advertisment_Type+"' , '"+photo_text+"'" ;  
        String TableName = "advertisment" ;
        DB.insert(Columns, Values, TableName);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void SuspendAdvertisment()
    {
        try
        {
        DealingWithDB DB = new DealingWithDB() ;
        DB.Connect();
        String IdCondition = HouseID ;
        String Column = "`suspended`" ;
        String NewValue = "1" ;
        String TableName = "advertisment" ;
        DB.update(IdCondition , Column, NewValue, TableName);
        }
        catch(ClassNotFoundException ex) {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void UnSuspendAdvertisment()
    {
        try
        {
        DealingWithDB DB = new DealingWithDB() ;
        DB.Connect();
        String IdCondition = HouseID ;
        String Column = "`suspended`" ;
        String NewValue = "0" ;
        String TableName = "advertisment" ;
        DB.update(IdCondition , Column, NewValue, TableName);
        }
        catch(ClassNotFoundException ex) {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateAdvertisment(String Columns , String NewValues)
    {
        try
        {
        DealingWithDB DB = new DealingWithDB() ;
        DB.Connect();
        String Idcondition = "`HouseID` = '" + HouseID+"'" ;
        DB.update(Idcondition , Columns, NewValues, "advertisment");
        }
        catch(ClassNotFoundException ex) {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void DeleteAdvertisment()
    {
        try
        {
        DealingWithDB DB = new DealingWithDB();
        DB.Connect();
        String condition = "`HouseID` = '"+ HouseID+ "'" ;
        DB.delete(condition,"advertisment" );
        }
        catch(ClassNotFoundException ex) {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<Advertisment> Search(String Condition)
    {
        ArrayList<Advertisment> Ads = new ArrayList<>();
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            Condition += " and `suspended`='0'" ;
            ResultSet res=DB.select("*", "advertisment", Condition) ; 
            while (res.next()) {
                Advertisment temp = new Advertisment();
                temp.setHouseID(res.getString("HouseID"));
                temp.setHouse_floor(res.getString("house_floor"));
                temp.setLat(res.getString("lat"));
                temp.setLon(res.getString("lon"));
                temp.setHouse_price(res.getString("house_price"));
                temp.setHouse_size(res.getString("house_size"));
                temp.setDescription(res.getString("description"));
                temp.setAccountId_fk(res.getString("AccountId_fk"));
                temp.setPhoto_text(res.getString("photo_text"));
                temp.setAdvertisment_Type(res.getString("advertisment_Type"));
                temp.setStatus(res.getString("status"));
                temp.setType(res.getString("type"));
                temp.setSuspended(res.getString("suspended"));
                Ads.add(temp);
            }
            
        }
        catch(ClassNotFoundException ex) {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ads ;
    }
    
}
