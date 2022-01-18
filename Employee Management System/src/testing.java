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
    JButton b2;
    String s;
    String[] arr=null;
    String[] sarr=null;
    String[] earr=null;
    int v=30;
    testing(){
        f=new JFrame("Testing");
        f.setBackground(Color.red);
        f.setLayout(null);
        
        JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBounds(0, 0, 800, 500);
            try{
                conn c1=new conn();
               String query="Select * from salary where emp_id='101' and status='unseen'";
                 ResultSet rs1=c1.s.executeQuery(query);
                 while(rs1.next()){
                     String sal=rs1.getString("salary");
                      arr=sal.split("\n");
                      String sdate=rs1.getString("checkin_date");
                     String edate=rs1.getString("checkout_date");
                     sarr=sdate.split("\n");
                      earr=edate.split("\n");
                     
            JLabel[] labels = new JLabel[arr.length];
            for (int i = 0; i < arr.length; i++){
                labels[i] = new JLabel();
                labels[i].setBounds(50,v,80,20);
                labels[i].setText("Your Salary from "+ sarr[i]+" to "+earr[i]+ " is "+arr[i]);
                panel.add(labels[i]);
                v=v+40;
            }
                 }
                
            }catch(Exception e){
                
            }
            
            f.add(panel);
       
        
         f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setSize(800,500);
        f.setLocation(400,300);
        
         
    }
    
    public static void main(String[] args){
        testing test=new testing();
        
    }
    
}