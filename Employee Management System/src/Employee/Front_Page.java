/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;

class Front_Page implements ActionListener{
    JFrame f; 
    JLabel id,l1;
    JButton b,b1,b2;

    Front_Page(){

         
        f=new JFrame("Employee Management System");
        f.setBackground(Color.red);
        f.setLayout(null);
        f.setVisible(true);
       
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/frontpage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1920,1080,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        
        l1.setBounds(0,0,1920,1080);
        f.add(l1);


        b = new JButton("ADMIN");
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setForeground(Color.WHITE);
        b.setBounds(1500,500,150,50);
        b.setFont(new Font("solaris-2",Font.BOLD,20));
         b.setFocusable(false);
        b.addActionListener(this);
        f.add(b);
//        
        b1 = new JButton("USER");
        b1.setOpaque(false);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(true);
        b1.setForeground(Color.WHITE);
        b1.setBounds(1500,400,150,50);
        b1.setFont(new Font("solaris-2",Font.BOLD,20));
        b1.setFocusable(false);
        b1.addActionListener(this);
        f.add(b1);
//       
        id=new JLabel();
        id.setBounds(35,20,1360,750);
        
        JLabel lid=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        lid.setBounds(1280,250,800,50);
        
        lid.setFont(new Font("solaris-2", Font.BOLD,35));
        lid.setForeground(Color.WHITE);
        l1.add(lid);
//
        l1.add(b);
        l1.add(b1);
        f.add(l1);

               
        f.getContentPane().setBackground(Color.WHITE);
      
//        f.setExtendedState(f.MAXIMIZED_BOTH);
        f.setSize(1920+25, 1080);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
        
           
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            
            f.setVisible(false);
           new login().f.setVisible(true);    
        }
        else if (ae.getSource()==b1){
        f.setVisible(false);
        new user().f.setVisible(true);}
    }

    public static void main(String[] arg){
        Front_Page f = new Front_Page();
    }
}