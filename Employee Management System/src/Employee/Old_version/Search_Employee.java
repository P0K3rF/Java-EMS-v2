/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee.Old_version;

import Employee.Old_version.details;
import Employee.conn;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Search_Employee implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l,l5;
    JButton b,b2;

    Search_Employee(){
        f=new JFrame("search");
        f.setBackground(Color.green);
        f.setLayout(null);

        l5=new JLabel();
        l5.setBounds(0,0,500,270);
        l5.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee/icons/view.jpg"));
        l5.setIcon(img);


        l=new JLabel("Employee Id");
        l.setVisible(true);
        l.setBounds(40,50,250,30);
        l.setForeground(Color.white);
        Font F1=new Font("serif",Font.BOLD,25);
        l.setFont(F1); 
        l5.add(l);
        f.add(l5);

        t=new JTextField();
        t.setBounds(240,50,220,30);
        l5.add(t);

        b=new JButton("Search");
        b.setBounds(240,150,100,30);
        b.addActionListener(this);
        l5.add(b);


        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        l5.add(b2);

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            f.setVisible(false);
            details d=new details();
        }
        if(ae.getSource()==b){
            String sid=t.getText();
            
            try{
                    
               conn sc=new conn();
               String query="select * from employee where emp_id='"+sid+"'";
               
                ResultSet cs = sc.s.executeQuery(query);
                if(cs.next()){
                   f.setVisible(false);
                   Update_Employee ue=new Update_Employee(t.getText());  
                }
                else{
                    JOptionPane.showMessageDialog(null, "Id not found");
            f.setVisible(false);
            Search_Employee se=new Search_Employee();
                }
            }
            catch(Exception e){
                
            }  
        }
    }
    
    public static void main(String[]ar){
        Search_Employee se=new Search_Employee();
    } 	
}
