package employee.management.system;
import java.sql.*;

public class Conn {
    
    Connection c;
    Statement stm;
    
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c= DriverManager.getConnection("jdbc:mysql:///Employee","root","Gagan");
            stm=c.createStatement();
            
            
        }catch(Exception e){
            
            e.printStackTrace();
            
            
        }
    }
    
}
