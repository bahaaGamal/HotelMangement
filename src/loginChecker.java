
import java.sql.ResultSet;
import project.Select;
import java.sql.*;
import javax.swing.JOptionPane;

public class loginChecker {

    public static boolean verify(String email, String pass) {
        String s;
        boolean f1=false;
          System.out.println(email+" "+pass);
        try {
            ResultSet rs = Select.getData("select email , password from admins");
            while (rs.next()) {
                System.out.println(rs.getString("email")+" "+rs.getString("password"));
                 
                if(rs.getString("email")==email&&rs.getString("password")==pass) f1=true;
                
                }
            if(f1) return true;
            else {
                JOptionPane.showMessageDialog(null, "Wrong");
            }
            }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Email is wrong");
        }
        return false;
    }
    }

