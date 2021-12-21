/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ktaus
 */
import Employee.conn;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;

public class testing {
    String checkout;
    String checkin;
    JFrame f;
    JLabel l1;
    JTextField t1;
    String s;
    testing(){
        f=new JFrame("Testing");
        f.setBackground(Color.red);
        f.setLayout(null);
        
         f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setSize(800,500);
        f.setLocation(400,300);
        
        LocalDate myDateObj = LocalDate.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    String DDate = myDateObj.format(myFormatObj);
        try{
            
   conn c1= new conn();
   String query="Select * from attendance where emp_id=102";
   ResultSet rs = c1.s.executeQuery(query);
   
   if(rs.next()){
       String checkindate=rs.getString("checkin_date");
       JOptionPane.showMessageDialog(null, checkindate);
   }
   
   
 

    }

        catch(Exception ee){
            
        }
       
//        t1=new JTextField();
//        t1.setText("hi");
//        t1.setBounds(400, 50, 100, 30);
//        f.add(t1);
         
    }
    
    public static void main(String[] args){
        testing test=new testing();
        
    }
    
}