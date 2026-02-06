package db;
import java.sql.*;


public class MyConnection {
    private static final String username="root";
    private static final String password="";
    private static final String dataConn="jdbc:mysql://localhost:3306/student_management";
    private static Connection con=null;
    
    public static Connection getConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(dataConn,username,password);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return con;
    }
    
}

