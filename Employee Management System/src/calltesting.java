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
import java.time.Duration;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class calltesting {
    JFrame f;
    DefaultTableModel dtm;
    JTable table;
    JButton b1;
    calltesting(){
        f=new JFrame("Testing");
        f.setBackground(Color.red);
        f.setLayout(null);
        f.setSize(600,600);
        f.setLocationRelativeTo(null);
        
        
      String columns[] = {"eMP_ID", "checkin_time", "checkin_date","checkout_time","checkout_date"};
      Object[][] data;
      DefaultTableModel dtm=new DefaultTableModel(columns,0);
      try{
          conn c10=new conn();
     String query = "SELECT * FROM attendance";
    ResultSet res =c10.s.executeQuery(query);
    while(res.next()){
        String id=res.getString("emp_id");
         String intime=res.getString("chenkin_time");
         String indate=res.getString("checkin_date");
         String outtime=res.getString("checkout_time");
         String outdate=res.getString("checkout_date");
         dtm.addRow(new Object[]{id,intime,indate,outtime,outdate});
    }
      }catch(Exception e){
              
      }
        table =new JTable(dtm);
        
        table.setPreferredScrollableViewportSize(new Dimension(500,50));
        table.setFillsViewportHeight(true);
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0, 0, 400, 100);
        f.add(jsp);
        
        b1=new JButton("click");
//        b1.setBounds(60, 400, 90, 50);
        
        f.add(b1);
        f.setVisible(true);
    }
    public static void main(String[] args){
  calltesting ct=new calltesting();
    }
}
