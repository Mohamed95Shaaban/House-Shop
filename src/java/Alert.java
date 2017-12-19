
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Antr
 */
public class Alert {
    private String  propertyAlert , porpertyValue ,AccountID_Fk ;

    public Alert() {
    }

    public Alert( String propertyAlert, String porpertyValue, String AccountID_Fk) {
        
        this.propertyAlert = propertyAlert;
        this.porpertyValue = porpertyValue;
        this.AccountID_Fk = AccountID_Fk;
    }

   

   

    public String getPropertyAlert() {
        return propertyAlert;
    }

    public void setPropertyAlert(String propertyAlert) {
        this.propertyAlert = propertyAlert;
    }

    public String getPorpertyValue() {
        return porpertyValue;
    }

    public void setPorpertyValue(String porpertyValue) {
        this.porpertyValue = porpertyValue;
    }

    public String getAccountID_Fk() {
        return AccountID_Fk;
    }

    public void setAccountID_Fk(String AccountID_Fk) {
        this.AccountID_Fk = AccountID_Fk;
    }
    
   public void AddAlert() throws SQLException, ClassNotFoundException{
       try{
       DealingWithDB DB = new DealingWithDB();
       DB.Connect();
       String Columns = " `propertyAlert` , `propertyValue` , `AccountID_Fk`";
    
       String values = "'"+propertyAlert+"','"+porpertyValue+"','"+ AccountID_Fk + "'";
       String TableName = "alert" ;
       DB.insert(Columns, values, TableName);
       }
       catch (ClassNotFoundException ex) {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Advertisment.class.getName()).log(Level.SEVERE, null, ex);
        } 
   
   }
    
    
}
