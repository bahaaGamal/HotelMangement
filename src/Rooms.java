
import java.util.ArrayList;
import javax.swing.JOptionPane;
import project.InsertUpdateDelete;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ELWANY
 */
public class Rooms {
   
   static ArrayList<String>nums=new ArrayList<>();
    public static void addRoom(String roomNo,String roomType,String bed,double price){
        if(price<0){
            JOptionPane.showMessageDialog(null,"Price cannot be negative ","Error",1);
            return;
        }
    if(nums.contains(roomNo)){
        JOptionPane.showMessageDialog(null,"This room is already exist !");
    }
        
    
    else {
        String Query="INSERT INTO rooms(roomNO,roomType,bed,price,status)VALUES('"+roomNo+"','"+roomType+"','"+bed+"','"+price+"','Not Booked')";
        nums.add(roomNo);
       InsertUpdateDelete.setData(Query, "successfully Updated");
       
    }
    }  
    }
    
    

