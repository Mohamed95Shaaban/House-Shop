
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
public class rate {
    String Advertisment_Id_FK , rate_id , rate_value ;

    public rate() {
    }

    public rate(String Advertisment_Id_FK, String rate_id, String rate_value) {
        this.Advertisment_Id_FK = Advertisment_Id_FK;
        this.rate_id = rate_id;
        this.rate_value = rate_value;
    }

    public void setAdvertisment_Id_FK(String Advertisment_Id_FK) {
        this.Advertisment_Id_FK = Advertisment_Id_FK;
    }

    public void setRate_id(String rate_id) {
        this.rate_id = rate_id;
    }

    public void setRate_value(String rate_value) {
        this.rate_value = rate_value;
    }

    public String getAdvertisment_Id_FK() {
        return Advertisment_Id_FK;
    }

    public String getRate_id() {
        return rate_id;
    }

    public String getRate_value() {
        return rate_value;
    }
    
    public ArrayList<rate> ShowRates(String Ad_ID)
    {
        ArrayList<rate> rates = new ArrayList<>();
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String Condition = "`Advertisment_Id_FK` = '"+ Ad_ID+"'" ;
            ResultSet res=DB.select("*", "rates", Condition) ;
            while (res.next()) {
                rate temp = new rate();
                temp.setAdvertisment_Id_FK(res.getString("advertisment_Id_FK"));
                temp.setRate_id(res.getString("rate_id"));
                temp.setRate_value(res.getString("rate_value"));
                rates.add(temp);
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(rate.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(rate.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return rates ;
    }
    public void AddRate()
    {
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String Columns = "`Advertisment_Id_FK`,`rate_value`" ;
            String Values = "'"+Advertisment_Id_FK+"' , '"+rate_value+"'" ;
            DB.insert(Columns, Values, "rate");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(rate.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(rate.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void deleteRate()
    {
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String condition = "`rate_id` = '" + rate_id+ "'" ;
            DB.delete(condition, "rate");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(rate.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(rate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void EditPhoto(String NewRate_value)
    {
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String Columns = "`rate_value`" ;
            String NewValues = "'"+NewRate_value+"'";
            String IDValue = "`rate_id` = '" + rate_id+ "'" ;
            DB.update(IDValue, Columns, NewValues , "rate");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(rate.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(rate.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
