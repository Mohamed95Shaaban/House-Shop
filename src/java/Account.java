
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
 * @author Ahmed
 */
public class Account {
    private String E_Mail, Pass, Phone, Picture_text="", Type="0", User_Name , AccountID ;

    public Account() {
    }

    public Account(String E_Mail, String Pass, String Phone, String Picture_text, String Type, String User_Name, String AccountID) {
        this.E_Mail = E_Mail;
        this.Pass = Pass;
        this.Phone = Phone;
        this.Picture_text = Picture_text;
        this.Type = Type;
        this.User_Name = User_Name;
        this.AccountID = AccountID;
    }

    public void setE_Mail(String E_Mail) {
        this.E_Mail = E_Mail;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setPicture_text(String Picture_text) {
        this.Picture_text = Picture_text;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setUser_Name(String User_Name) {
        this.User_Name = User_Name;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public String getE_Mail() {
        return E_Mail;
    }

    public String getPass() {
        return Pass;
    }

    public String getPhone() {
        return Phone;
    }

    public String getPicture_text() {
        return Picture_text;
    }

    public String getType() {
        return Type;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public String getAccountID() {
        return AccountID;
    }
    
    public void SignUP()
    {
        try
        {
        DealingWithDB DB = new DealingWithDB() ;
        DB.Connect();
        ResultSet res = DB.select("MAX(HouseID)", "Account", "1") ;
        res.next() ; 
        int LastId = Integer.valueOf(res.getString(1)) ;
        int NewId = LastId+1 ;
        AccountID = String.valueOf(NewId) ;
        
        String Columns = "`user_name` , `password` , `e-mail` , `phone` , `type` , `picture_text` , `AccountId`" ;
        String Values = "'"+User_Name+"' , '"+Pass+"' , '"+E_Mail
                + "' , '"+Phone+"', '"+"0"+"' , '"+""+"' , '" +AccountID+"'" ;
        String TableName = "account" ;
        DB.insert(Columns, Values, TableName);
        DB.writeResultSet(DB.select("*", TableName, ""));
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registiration.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Registiration.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public boolean LogIn()
    {
        boolean Existed = false ;
        try {
            
            DealingWithDB DB = new DealingWithDB() ;
            DB.Connect();
            String Condition = "`e-mail`='"+E_Mail+"' and `password`='"+Pass+"'" ;
            ResultSet resultSet = DB.select("*", "account", Condition) ;
            
            if (resultSet.next()) 
            {
                User_Name=resultSet.getString(1);
                Pass=resultSet.getString(2);
                E_Mail=resultSet.getString(3);
                Phone=resultSet.getString(4);
                Type=resultSet.getString(5);
                Picture_text=resultSet.getString(6);
                
                Existed = true ;
            }
            
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Registiration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Registiration.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return Existed ; // initially false
    }
    
    public void Update(String Column , String NewValue , String TableName)
    {
        try
        {
        String Idcondition = "`AccountId` = " + "'"+AccountID+"'" ;
        DealingWithDB DB = new DealingWithDB() ;
        DB.Connect();
        DB.update(Idcondition , Column, NewValue, "Account");
        }
        catch(ClassNotFoundException ex) {
            Logger.getLogger(Registiration.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch(SQLException ex)
        {
            Logger.getLogger(Registiration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
