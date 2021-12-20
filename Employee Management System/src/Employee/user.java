/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class user implements ActionListener{
    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    user(){
        f=new JFrame("User");
        f.setBackground(Color.BLUE);
        f.setLayout(null);
        
        l1=new JLabel("Username");
        l1.setBounds(40, 20,100, 30);
        f.add(l1);
        
        l2=new JLabel("Password");
        l2.setBounds(40,70,100,30);
        f.add(l2);
        
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);
        
        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        f.add(t2);
        
        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);
        
        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);
        b2.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(800,500);
        f.setLocation(400,300);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            conn c1= new conn();
            
            String u=t1.getText();
            String v=t2.getText();
          
            String q="select * from employee where emp_id='"+u+"' and fname='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){ 
               if(ae.getSource()==b1){
                f.setVisible(false);
                f.dispose();  
               
                new user_Attendance(t1.getText()).f.setVisible(true);   
//new testing(t1.getText()).f.setVisible(true);   
//new Testing2(t1.getText()).f.setVisible(true);
               }
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.setVisible(false);
            }
        }
            catch(Exception e){
            e.printStackTrace();
            }
        
    }
    
    public static void main(String[] arg){
        
       new user();
    }
}

 