
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DealingWithDB {
    static Connection connection ;
    public static void Connect() throws SQLException, ClassNotFoundException
    {
      // This will load the MySQL driver, each DB has its own driver
      //Class.forName("com.mysql.jdbc.Driver");  ??!!
      
      // Setup the connection with the DB
      connection = DriverManager
                   .getConnection("jdbc:mysql://" + "localhost:3306" + "/house_buy_and_rent?"
                   + "user=" + "root"  );
    }
    
    public static ResultSet select(String Columns , String TableName) throws SQLException 
    {
            Statement statement = connection.createStatement() ;
            String Query = "select " + Columns + " from " + TableName ;
            ResultSet resultset = statement.executeQuery(Query) ;
            return resultset;
            
    }
    
    public static void insert(String Columns , String Values , String TableName) throws SQLException
    {
        String Query = "INSERT INTO "+TableName+" ("+Columns+") VALUES ("+Values+") " ;
        PreparedStatement preparedStatement = connection.prepareStatement(Query) ;
        preparedStatement.executeUpdate() ;
    }
    
    public static void update(String IDValue , String Column , String NewValue , String TableName) throws SQLException
    {
        String Query = "UPDATE `"+TableName+"` SET "+Column+" = "+NewValue+" WHERE "+IDValue ;
        PreparedStatement preparedStatement = connection.prepareStatement(Query) ;
        preparedStatement.executeUpdate() ;
        /*delete (IDValue , TableName) ;
        insert (Columns , NewValues , TableName) ;*/
    }
    
    public static void delete(String Condition , String TableName) throws SQLException 
    {
        PreparedStatement preparedStatement = 
                connection.prepareStatement("delete from "+TableName+" where "+Condition );
        preparedStatement.executeUpdate() ;
                
    }
    
    public static void writeResultSet(ResultSet resultSet) throws SQLException 
    {
        int numOfColumns = resultSet.getMetaData().getColumnCount() ;
        /*for  (int i = 1; i<= numOfColumns; i++)
        {
            System.out.print(resultSet.getMetaData().getColumnName(i)+ "    ");
        }
        System.out.println("");*/
        while (resultSet.next()) {
            for  (int i = 1; i<= numOfColumns; i++)
            {
                System.out.print(resultSet.getString(i)+ "        ");
            }
            System.out.println("");

        }
  }
}
