
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import project.InsertUpdateDelete;
import sun.security.util.Password;

public class Admins {

    private static boolean notEmpty(String name, String email, String pass, String phone, String ssn) {     
        if (name.isEmpty() || email.isEmpty() || pass.isEmpty() || phone.isEmpty() || ssn.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields must be filled !");
            return false;
        }
        return true;
    }
    private static boolean validPassword(String pass) {
        boolean f1 = false, f2 = false, f3 = false;
        if (pass.length() >= 8) {
            for (int x = 0; x < pass.length(); x++) {
                if (Character.isUpperCase(pass.charAt(x))) {
                    f1 = true;
                }
                if (Character.isLowerCase(pass.charAt(x))) {
                    f2 = true;
                }
                if (Character.isDigit(pass.charAt(x))) {
                    f3 = true;
                }
            }
            if (f1 == true && f2 == true && f3 == true) {
                return true;
            } else {
                if (f1 == false) {
                    JOptionPane.showMessageDialog(null, "Password must contain a capital letter");
                    return false;
                }
                if (f2 == false) {
                    JOptionPane.showMessageDialog(null, "Password must contain an small letter");
                    return false;
                }
                if (f3 == false) {
                    JOptionPane.showMessageDialog(null, "Password must contain a number");
                    return false;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password must contain at least 8 characters");
            return false;
        }
        return true;
    }
   private static boolean validEmail(String e) {
        if (e.contains("@") && e.endsWith(".com")) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Email must contain '@' and '.com ' ");
            return false;
        }
    }
    private static boolean validName(String n) {
        String temp;
        if (n.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name must be filled");
            return false;
        }
        StringTokenizer s = new StringTokenizer(n);
        while (s.hasMoreTokens()) {
            temp = s.nextToken();
            if (!Character.isUpperCase(temp.charAt(0))) {
                JOptionPane.showMessageDialog(null, " Name Must start with capital letter");
                return false;
            }
        }
        return true;
    }
    private static boolean validPhone(String p) {
        if (p.length() == 11) {
            for (int x = 0; x < p.length(); x++) {
                if (Character.isLetter(p.charAt(x))) {
                    JOptionPane.showMessageDialog(null, "Phone number can not contain any letter");
                    return false;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Phone number must be 11 numbers");
            return false;
        }
        return true;
    }
    private static boolean validSsn(String s) {
        if (s.length() == 14) {
            for (int x = 0; x < s.length(); x++) {
                if (Character.isLetter(s.charAt(x))) {
                    JOptionPane.showMessageDialog(null, "SSN can not contains any letters");
                    return false;
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "SSN must be 14 numbers ");
            return false;
        }
        return true;
    }
    public static boolean addAdmin(String name, String email, String password, String phone, String ssn) {
        if (notEmpty(name, email, password, phone, ssn)) {
            if (Admins.validName(name) && Admins.validEmail(email) && Admins.validPassword(password) && Admins.validPhone(phone) && Admins.validSsn(ssn)) {
                String Query;
                Query = "insert into admins values('" + name + "','" + email + "','" + password + "','" + phone + "','" + ssn + "')";
                InsertUpdateDelete.setData(Query, "Refistered Successfully");
                return true;
            } else {
                return false;
            }
        } 
        else {
            return false;
        }
    }
}
