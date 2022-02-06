
package Employee;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Admin_addemployee implements ActionListener {
    JFrame f;
    JLabel l1,l2,l3;
    JLabel id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12;
    JLabel dd1,dd2,dd3,dd4,dd5,dd6,dd7,dd8,dd9,dd10,dd11;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    JButton b1,b2,backb;
    
    Admin_addemployee(){
        f=new JFrame("HomePage");
        f.setBackground(Color.BLUE);
        f.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/admin_addemployeebg.jpg"));
        Image img1 = i1.getImage().getScaledInstance(1945,1080,Image.SCALE_DEFAULT);
        ImageIcon i11 =  new ImageIcon(img1);
        l1=new JLabel(i11);
        l1.setBounds(0, 0, 1945, 1080);
        l1.setLayout(null);
        f.add(l1);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/admin_addemployee1.jpg"));
        Image img2 = i2.getImage().getScaledInstance(1945,1080,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(img2);
        l2=new JLabel(i3);
        l2.setBounds(250, 50, 1430,900);
        l2.setLayout(null);
        l1.add(l2);
        
        l3=new JLabel("ADD EMPLOYEE");
        l3.setBounds(550, 55, 400, 60);
        l3.setFont(new Font("solaris-2",Font.ROMAN_BASELINE,40));
        l3.setForeground(new Color(0,255,254));
        Font font1 = l3.getFont();
         Map attributes1 = font1.getAttributes();
        attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        l3.setFont(font1.deriveFont(attributes1));
        l2.add(l3);
        
        id1 = new JLabel("First Name");
        id1.setBounds(100,190,200,50);
        id1.setFont(new Font("solaris-2",Font.BOLD,30));
        id1.setForeground(Color.WHITE);
        l2.add(id1);
        
        dd1=new JLabel(":");
        dd1.setForeground(Color.WHITE);
        dd1.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd1.setBounds(310, 190,20, 50);
        l2.add(dd1);
        
        t1=new JTextField();
        t1.setBounds(350,190,300,50);
        t1.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t1.setForeground(Color.BLACK);
        l2.add(t1);
        
        
        id2 = new JLabel("Last Name");
        id2.setBounds(800,190,200,50);
        id2.setFont(new Font("solaris-2",Font.BOLD,30));
        id2.setForeground(Color.WHITE);
        l2.add(id2);
        
        dd2=new JLabel(":");
        dd2.setForeground(Color.WHITE);
        dd2.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd2.setBounds(1010, 190,20, 50);
        l2.add(dd2);
        
        t2=new JTextField();
        t2.setBounds(1050,190,300,50);
        t2.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t2.setForeground(Color.BLACK);
        l2.add(t2);
        
        id3= new JLabel("Age");
        id3.setBounds(100,290,150,50);
        id3.setFont(new Font("solaris-2",Font.BOLD,30));
        id3.setForeground(Color.WHITE);
        l2.add(id3);
        
        dd3=new JLabel(":");
        dd3.setForeground(Color.WHITE);
        dd3.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd3.setBounds(310, 290,20, 50);
        l2.add(dd3);
        
        t3=new JTextField();
        t3.setBounds(350,290,300,50);
        t3.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t3.setForeground(Color.BLACK);
        l2.add(t3);
        
        id4= new JLabel("Date Of Birth");  
        id4.setBounds(800,290,300,50);
        id4.setFont(new Font("solaris-2",Font.BOLD,30));
        id4.setForeground(Color.WHITE);
        l2.add(id4);
        
        dd4=new JLabel(":");
        dd4.setForeground(Color.WHITE);
        dd4.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd4.setBounds(1010, 290,20, 50);
        l2.add(dd4);
        
        t4=new JTextField();
        t4.setBounds(1050,290,300,50);
        t4.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t4.setForeground(Color.BLACK);
        l2.add(t4);

        id5= new JLabel("Address");
        id5.setBounds(100,390,200,50);
        id5.setFont(new Font("solaris-2",Font.BOLD,30));
        id5.setForeground(Color.WHITE);
        l2.add(id5);
        
        dd5=new JLabel(":");
        dd5.setForeground(Color.WHITE);
        dd5.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd5.setBounds(310, 390,20, 50);
        l2.add(dd5);
        
        t5=new JTextField();
        t5.setBounds(350,390,300,50);
        t5.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t5.setForeground(Color.BLACK);
        l2.add(t5);
        
        id6= new JLabel("Phone");
        id6.setBounds(800,390,100,50);
        id6.setFont(new Font("solaris-2",Font.BOLD,30));
        id6.setForeground(Color.WHITE);
        l2.add(id6);
        
        dd6=new JLabel(":");
        dd6.setForeground(Color.WHITE);
        dd6.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd6.setBounds(1010, 390,20, 50);
        l2.add(dd6);
        
        t6=new JTextField();
        t6.setBounds(1050,390,300,50);
        t6.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t6.setForeground(Color.BLACK);
        l2.add(t6);

        id7= new JLabel("Email Id");
        id7.setBounds(100,490,150,50);
        id7.setFont(new Font("solaris-2",Font.BOLD,30));
        id7.setForeground(Color.WHITE);
        l2.add(id7);
        
        dd7=new JLabel(":");
        dd7.setForeground(Color.WHITE);
        dd7.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd7.setBounds(310, 490,20, 50);
        l2.add(dd7);
        
        t7=new JTextField();
        t7.setBounds(350,490,300,50);
        t7.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t7.setForeground(Color.BLACK);
        l2.add(t7);
        
        id9= new JLabel("Education");
        id9.setBounds(800,490,200,50);
        id9.setFont(new Font("solaris-2",Font.BOLD,30));
        id9.setForeground(Color.WHITE);   
        l2.add(id9);
        
        dd8=new JLabel(":");
        dd8.setForeground(Color.WHITE);
        dd8.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd8.setBounds(1010, 490,20, 50);
        l2.add(dd8);

        t8=new JTextField();
        t8.setBounds(1050,490,300,50);
        t8.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t8.setForeground(Color.BLACK);
        l2.add(t8);
        
        id10= new JLabel("Job Post");
        id10.setBounds(100,590,150,50);
        id10.setFont(new Font("solaris-2",Font.BOLD,30));
        id10.setForeground(Color.WHITE);
        l2.add(id10);
        
        dd9=new JLabel(":");
        dd9.setForeground(Color.WHITE);
        dd9.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd9.setBounds(310, 590,20, 50);
        l2.add(dd9);
        
        t9=new JTextField();
        t9.setBounds(350,590,300,50);
        t9.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t9.setForeground(Color.BLACK);
        l2.add(t9);
        
        id11= new JLabel("Aadhar No");
        id11.setBounds(800,590,200,50);
        id11.setFont(new Font("solaris-2",Font.BOLD,30));
        id11.setForeground(Color.WHITE);
        l2.add(id11);
        
        dd10=new JLabel(":");
        dd10.setForeground(Color.WHITE);
        dd10.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd10.setBounds(1010, 590,20, 50);
        l2.add(dd10);
        
        
        t10=new JTextField();
        t10.setBounds(1050,590,300,50);
        t10.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t10.setForeground(Color.BLACK);
        l2.add(t10);
        
        id12= new JLabel("Employee Id");
        id12.setBounds(100,690,250,50);
        id12.setFont(new Font("solaris-2",Font.BOLD,30));
        id12.setForeground(Color.WHITE);
        l2.add(id12);
        
        dd11=new JLabel(":");
        dd11.setForeground(Color.WHITE);
        dd11.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd11.setBounds(310, 690,20, 50);
        l2.add(dd11);
        
        t11=new JTextField();
        t11.setBounds(350,690,300,50);
        t11.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t11.setForeground(Color.BLACK);
        l2.add(t11);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/Add_emp_submit.png"));
        b1=new JButton();
        b1.setIcon(i4);
        b1.setBounds(450, 800, 160, 70);
        b1.setFocusPainted(false);
        b1.setBorder(null);
        b1.setContentAreaFilled(false);
        b1.setFocusable(false);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.addMouseListener(new MouseAdapter(){
           
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/Add_emp_submit1.png"));
                b1.setIcon(i21);
            }

            @Override
           public void mouseExited(MouseEvent e){
               b1.setIcon(i4);
           }

        });
        b1.addActionListener(this);
        l2.add(b1);
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/Add_emp_cancel.png"));
        b2=new JButton();
        b2.setIcon(i5);
        b2.setBounds(650, 800, 150, 70);
        b2.setFocusPainted(false);
        b2.setBorder(null);
        b2.setContentAreaFilled(false);
        b2.setFocusable(false);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.addMouseListener(new MouseAdapter(){
           
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon i31 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/Add_emp_cancel1.png"));
                b2.setIcon(i31);
            }

            @Override
           public void mouseExited(MouseEvent e){
               b2.setIcon(i5);
           }

        });
        b2.addActionListener(this);
        l2.add(b2);
        
        ImageIcon iback = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/goback.png"));
        backb=new JButton();
        backb.setIcon(iback);
        backb.setBounds(1700, 900, 155, 70);
        backb.setBackground(new Color(0, 0, 57));
        backb.setFocusPainted(false);
        backb.setBorder(null);
        backb.setContentAreaFilled(false);
        backb.setFocusable(false);
        backb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backb.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon iback1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/goback1.png"));
                backb.setIcon(iback1);
            }
             @Override
            public void mouseExited(MouseEvent e) {
                backb.setIcon(iback);
            }
        });
        backb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               new Admin_homepage().f.setVisible(true);
               f.setVisible(false);
               f.dispose();
            }
        });
        l1.add(backb);
        
        f.setSize(1920+25, 1080);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String a = t1.getText();
        String bb = t2.getText();
        String c = t3.getText();
        String d = t4.getText();
        String e = t5.getText();
        String ff = t6.getText();
        String g = t7.getText();
        String h = t8.getText();
        String i = t9.getText();
        String j = t10.getText();
        String k = t11.getText();
        if(ae.getSource() == b1){
            if(a.isEmpty()||bb.isEmpty()||c.isEmpty()||d.isEmpty()||e.isEmpty()||ff.isEmpty()||g.isEmpty()||h.isEmpty()||i.isEmpty()||j.isEmpty()||k.isEmpty()){
               JOptionPane.showMessageDialog(null, "Fill Every Details"); 

            }
            else{
                try{
                conn cc = new conn();
                String q = "insert into employee values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+ff+"','"+g+"','"+h+"','"+i+"','"+j+"','"+k+"','null','null')";
               cc.s.executeUpdate(q); 
               
                 JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                new Admin_homepage().f.setVisible(true);
                f.setVisible(false);
            }catch(HeadlessException | SQLException ee){
                System.out.println("The error is:"+ee);
            }
            }
            
        }else if(ae.getSource() == b2){
             new Admin_homepage().f.setVisible(true);
            f.setVisible(false);
           
        }
        
    }
    public static void main(String[] args){
    Admin_addemployee aa=new Admin_addemployee();    
    }
}
