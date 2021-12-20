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
public class Testing2 {
    String checkintime,remaining,checkouttime;
    JFrame f;
    JLabel l;
   
    
    Testing2(){
        f=new JFrame("Testing 2");
        f.setLayout(null);
        f.setBackground(Color.red);
        
        try{
        conn c1=new conn();
        String d="select chenkin_time,checkout_time,(34.25*(checkout_time-chenkin_time)) as remainng_time from attendance where emp_id='101';";
        ResultSet rs=c1.s.executeQuery(d);
        while(rs.next()){
            checkintime=rs.getString("chenkin_time");
            checkouttime=rs.getString("checkout_time");
            remaining=rs.getString(3);
        }
//       int i=Integer.parseInt(remaining)*10;
//       String p=String.valueOf(i);
        l=new JLabel(remaining);
        l.setBounds(40, 20,100, 30);
        f.add(l);
        
        }
        catch(Exception ee){
            
        }
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setSize(800,500);
        f.setLocation(400,300);
    }
    public static void main(String[] arg){
        Testing2 u=new Testing2();
    }

}


