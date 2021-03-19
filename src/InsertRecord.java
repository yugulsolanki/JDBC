import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class InsertRecord {
    public static void main(String...ar){
        
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter user id : ");
            String user = sc.next();
            System.out.println("Enter password : ");
            String pass = sc.next();
            /*System.out.println("Enter employee post : ");
            String post = sc.next();
            System.out.println("Enter employee contact : ");
            String contact = sc.next();
           */
            //loading driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //implimenting database connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            
            //Query
            PreparedStatement st = con.prepareStatement("insert into adminlogintab values (?,?)");
            st.setString(1,user);
            st.setString(2,pass);
            //st.setString(3,post);
            //st.setString(4,contact);
            st.executeUpdate();
            
            //closing connnection
            con.close();
            
            System.out.println("Record inserted!!!");
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
        
    }
}
