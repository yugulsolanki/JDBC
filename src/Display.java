import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Display {
    public static void main(String...arg){
        try{
            //loading driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //setting Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            
            //Queries
            PreparedStatement st = con.prepareStatement("select * from employeetab");
            
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                String empid = rs.getString(1);
                String empname = rs.getString(2);
                String post = rs.getString(3);
                String contact = rs.getString(4);
                
                System.out.println(empid+" "+empname+" "+post+" "+contact);
            }
            
            con.close();
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
}
