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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/user_login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1921,1080,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1920,1080);
        f.add(l3);
        
        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/admin_login_template.png"));
        Image i5 = i12.getImage().getScaledInstance(400,520,Image.SCALE_DEFAULT);
        ImageIcon i4 =  new ImageIcon(i5);
        JLabel l4=new JLabel(i4);
        l4.setBounds(1400, 300, 400, 520);
        l3.add(l4);
        f.add(l3);
        
        l1=new JLabel("Username");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,20));
        l1.setBounds(20, 130,100, 30);
        l4.add(l1);
        
        l2=new JLabel("Password");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,20));
        l2.setBounds(20,260,100,30);
        l4.add(l2);
        
        t1=new JTextField();
        
        t1.requestFocus();
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,20));
         t1.setOpaque(false);
         t1.setBorder(new LineBorder(Color.BLACK, 3,true));
        t1.setBounds(40,180,280,50);
        l4.add(t1);
        
        t2=new JPasswordField();
       
        t2.setForeground(Color.WHITE);
        t2.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,20));
         t2.setOpaque(false);
         t2.setBorder(new LineBorder(Color.BLACK, 3,true));
        t2.setBounds(40,310,280,50);
        l4.add(t2);
        
        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        l3.add(b1);
        
        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        l3.add(b2);
        b2.addActionListener(this);
        
         f.getContentPane().setBackground(Color.WHITE);

        f.setSize(1920+25, 1080);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
        
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
        try{
            conn c1= new conn();
            
            String u=t1.getText();
            String v=t2.getText();
          
            String q="select * from employee where emp_id='"+u+"' and fname='"+v+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){ 
               new user_Attendance(t1.getText()).f.setVisible(true); 
                f.setVisible(false);
                f.dispose();           
//new testing(t1.getText()).f.setVisible(true);   
//new Testing2(t1.getText()).f.setVisible(true);
               }
            else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.dispose();
                user u1=new user();
            }
        }
            catch(Exception e){
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
        
       new user();
    }
}

 