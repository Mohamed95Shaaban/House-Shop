
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
public class Comment {
    private String comment_id , commenter_FK , Advertisment_id_FK , CommentText ;

    public Comment() {
    }

    public Comment(String comment_id, String commenter_FK, String Advertisment_id_FK, String CommentText) {
        this.comment_id = comment_id;
        this.commenter_FK = commenter_FK;
        this.Advertisment_id_FK = Advertisment_id_FK;
        this.CommentText = CommentText;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id;
    }

    public void setCommenter_FK(String commenter_FK) {
        this.commenter_FK = commenter_FK;
    }

    public void setAdvertisment_id_FK(String Advertisment_id_FK) {
        this.Advertisment_id_FK = Advertisment_id_FK;
    }

    public void setCommentText(String CommentText) {
        this.CommentText = CommentText;
    }

    public String getComment_id() {
        return comment_id;
    }

    public String getCommenter_FK() {
        return commenter_FK;
    }

    public String getAdvertisment_id_FK() {
        return Advertisment_id_FK;
    }

    public String getCommentText() {
        return CommentText;
    }
    public void AddComment()
    {
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            ResultSet res = DB.select("MAX(comment_id)", "comment", "1") ;
            res.next() ; 
            int LastId = Integer.valueOf(res.getString("comment_id")) ;
            int NewId = LastId+1 ;
            comment_id = String.valueOf(NewId) ;
            String Columns = "`comment_id`,`CommentText`,`Advertisment_Id_FK`,`commenter_FK`" ;
            String Values = "'"+comment_id+"' , '"+CommentText+"' , '"+Advertisment_id_FK+"' , '"+commenter_FK+"'" ;
            DB.insert(Columns, Values, "comment");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Comment.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Comment.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void EditComment(String NewComment)
    {
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String Columns = "`CommentText`" ;
            String NewValues = "'"+CommentText+"'";
            String IDValue = "`comment_id` = '" + comment_id+ "'" ;
            DB.update(IDValue, Columns, NewValues , "comment");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Comment.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Comment.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void DeleteComment()
    {
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String condition = "`comment_id` = '" + comment_id+ "'" ;
            DB.delete(condition, "comment");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Comment.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Comment.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public ArrayList<Comment> ShowComments(String Ad_ID)
    {
        ArrayList<Comment> comments = new ArrayList<>() ;
        try
        {
            DealingWithDB DB = new DealingWithDB();
            DB.Connect();
            String Condition = "`Advertisment_Id_FK` = '"+ Ad_ID+"'" ;
            ResultSet res=DB.select("*", "comment", Condition) ;
            while (res.next()) {
                Comment temp = new Comment();
                temp.setAdvertisment_id_FK(res.getString("Advertisment_Id_FK"));
                temp.setCommentText(res.getString("CommentText"));
                temp.setComment_id(res.getString("comment_id"));
                temp.setCommenter_FK(res.getString("commenter_FK"));
                comments.add(temp);
            }
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(Comment.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (SQLException ex) {
            Logger.getLogger(Comment.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        return comments ;
    }
}
