/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class testing implements ActionListener{
    JFrame f;
    JButton b1,b2;
    JLabel l1,l2;
    String emp_id;
    String sempid,intime,indate,outtime,outdate;

   
    
    testing(String name){
        
        
        
        f=new JFrame("Testing");
        f.setBackground(Color.red);
        f.setLayout(null);
        
        
        
     emp_id=name;
     l1=new JLabel(emp_id);
     l1.setBounds(600,50,100,30);
     f.add(l1);
        
        l2=new JLabel();
        l2.setBounds(150,25,100,30);
       
        f.add(l2);
        
        b1=new JButton("IN");
        b1.setBounds(150, 20,100, 30);
        b1.addActionListener(this);
        f.add(b1);
        
        b2=new JButton("OUT");
        b2.setBounds(300, 20,100, 30);
        b2.addActionListener(this);
        f.add(b2);
        
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setSize(800,500);
        f.setLocation(400,300);
        
    }
    public void actionPerformed(ActionEvent ae){
       
    LocalDate myDateObj = LocalDate.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    String Date = myDateObj.format(myFormatObj);
      LocalTime myTimeObj = LocalTime.now();
      DateTimeFormatter myTimeFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
      String Time = myTimeObj.format(myTimeFormatObj);
        String empid=l1.getText();
       
        try{
            conn c1=new conn();
                String str="Select * from attendance where emp_id='"+empid+"'";
                ResultSet rs=c1.s.executeQuery(str);
                
                while(rs.next()){
                    sempid=rs.getString("emp_id");
                    intime=rs.getString("chenkin_time");
                    indate=rs.getString("checkin_date");
                    outtime=rs.getString("checkout_time");
                    outdate=rs.getString("checkout_date");
                    
                }

//            if(sempid.equals(empid)&&Date.equals(indate)&&outtime.equals("null")){
//              b1.setVisible(false);
//              JOptionPane.showMessageDialog(null,"new script");
//            }
//              else{
//                     b1.setVisible(true); 
//                      }   
            if(ae.getSource()==b1){
               
                conn cc = new conn();
                String q="insert into attendance values('"+empid+"','"+Time+"','"+Date+"','null','null','200')";
                cc.s.executeUpdate(q);
            }
            
            if(ae.getSource()==b2){
                if(sempid.equals(empid)&&Date.equals(indate)){
                if(sempid.equals(empid)&&outtime.equals("null")){
                    JOptionPane.showMessageDialog(null,"successfully updated");
                    conn cc = new conn();
                String q="update attendance SET checkout_time='"+Time+"',checkout_date='"+Date+"'where emp_id='"+empid+"'AND checkout_time='null'";
                cc.s.executeUpdate(q);
                 
            }
                else{
                    
                }
                
                
            }
                else{
                    JOptionPane.showMessageDialog(null,"You havent Checkedin Today");
                }
            }
//            else if(ae.getSource()==b2){
//                conn cc = new conn();
//                String q="update attendance SET checkout_time='"+Time+"',checkout_date='"+Date+"'where emp_id='"+empid+"'";
//                cc.s.executeUpdate(q);
//            }

        
        }
        catch(Exception ee){
                System.out.println("The error is:"+ee);
        }
        
        
        
//        if(ae.getSource()==b1){
//            b1.setVisible(false);
//        }
//        if(ae.getSource()==b2){
//            b2.setVisible(false);
//        }
    }
    public static void main(String[] arg){
        testing u=new testing("");
    }

}

