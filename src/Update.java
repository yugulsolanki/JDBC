import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Update{
    public static void main(String...arg){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter employee id whose record you want to update : ");
            String eId = sc.next();
            
            //loading driver
            Class.forName("com.mysql.jdbc.Driver");
            
            //setting Connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            
            //Queries
            PreparedStatement st = con.prepareStatement("select * from employeetab where empid=?");
            st.setString(1, eId);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String empid = rs.getString(1);
                String empname = rs.getString(2);
                String post = rs.getString(3);
                String contact = rs.getString(4);
                
                System.out.println(empid+" "+empname+" "+post+" "+contact);
                //code to update
                System.out.println("Select the choice : ");
                System.out.println("1.Update Employee Name");
                System.out.println("2.Update Employee Post");
                System.out.println("3.Update Employee Contact no.");
                Byte ch = sc.nextByte();
                switch(ch){
                    case 1:
                        System.out.println("Enter updated name :");
                        String uName = sc.next();
                        PreparedStatement st1 = con.prepareStatement("update employeetab set empname=? where empid=?");
                        st1.setString(1, uName);
                        st1.setString(2, eId);
                        st1.executeUpdate();
                        System.out.println("Record updated");
                        break;
                        
                    case 2:
                        System.out.println("Enter updated post :");
                        String uPost = sc.next();
                        PreparedStatement st2 = con.prepareStatement("update employeetab set post=? where empid=?");
                        st2.setString(1, uPost);
                        st2.setString(2, eId);
                        st2.executeUpdate();
                        System.out.println("Record updated");
                        break;
                        
                    case 3:
                        System.out.println("Enter updated contact :");
                        String uContact = sc.next();
                        PreparedStatement st3 = con.prepareStatement("update employeetab set contact=? where empid=?");
                        st3.setString(1, uContact);
                        st3.setString(2, eId);
                        st3.executeUpdate();
                        System.out.println("Record updated");
                        break;
                }
            }
            else{
                System.out.println("No Record Found!!");
            }
            con.close();
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
}
