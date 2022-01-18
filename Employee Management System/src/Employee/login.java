/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.sql.*;
import java.util.Map;
import javax.swing.border.LineBorder;

class login  implements ActionListener{

    JFrame f;
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    login(){

        f=new JFrame("Login");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel("Username");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("solaris-2", Font.BOLD,15));
        l1.setBounds(700,420,100,30);
        f.add(l1);
        
        l2 = new JLabel("Password");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("solaris-2", Font.BOLD,15));
        l2.setBounds(700,520,100,30);
        f.add(l2);
        
        l3=new JLabel("ADMIN LOGIN");
        l3.setForeground(Color.BLACK);
        l3.setFont(new Font("solaris-2", Font.BOLD,20));
        l3.setBounds(790,270,150,150);
        Font font = l3.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        l3.setFont(font.deriveFont(attributes));
        f.add(l3);
        
        l4=new JLabel("Please Enter Your Login Details.");
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("solaris-2", Font.ITALIC,15));
        l4.setBounds(730,320,350,150);
        f.add(l4);
 
        t1=new JTextField();
        t1.setBounds(700,460,280,50);
         t1.setOpaque(false);
         t1.setBorder(new LineBorder(Color.BLACK, 2));
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("solaris-2", Font.BOLD,20));
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(700,560,280,50);
         t2.setOpaque(false);
         t2.setBorder(new LineBorder(Color.BLACK, 2));
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("solaris-2", Font.BOLD,20));
        f.add(t2);
        
        b1 = new JButton("Login");
        b1.setBounds(770,640,140,50);
        b1.setFont(new Font("solaris-2",Font.ROMAN_BASELINE,20));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        f.add(b1);

        b2=new JButton("Go to Home Menu");
        b2.setBounds(830,710,163,20);
         b2.setOpaque(false);
        b2.setContentAreaFilled(false);
        b2.setBorderPainted(false);
        b2.setFont(new Font("solaris-2",Font.BOLD,15));
        Font font1 = b2.getFont();
         Map attributes1 = font1.getAttributes();
        attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        b2.setFont(font.deriveFont(attributes1));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        b2.addActionListener(this);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        f.add(b2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/admin_login.png"));
        Image i2 = i1.getImage().getScaledInstance(1921,1080,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1920,1080);
        f.add(l3);
        
        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/admin_login_template.png"));
        Image i5 = i12.getImage().getScaledInstance(400,480,Image.SCALE_DEFAULT);
        ImageIcon i4 =  new ImageIcon(i5);
        JLabel l4=new JLabel(i4);
        l4.setBounds(650, 300, 400, 480);
        l3.add(l4);
        f.add(l3);
           
        f.getContentPane().setBackground(Color.WHITE);

        f.setSize(1920+25, 1080);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
        
        f.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){

        try{
            conn c1 = new conn();
            String u = t1.getText();
            String v = t2.getText();
            
            String q = "select * from login where username='"+u+"' and password='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){
                new Admin_homepage().f.setVisible(true);
                f.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.dispose();
                login d=new login();
                
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        }
        else if(ae.getSource()==b2){
            
            new Front_Page().f.setVisible(true);
            f.setVisible(false);
            f.dispose();
        }
    }
    public static void main(String[] arg){
        login l=new login();
    }
}