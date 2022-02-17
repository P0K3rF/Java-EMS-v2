
package Employee;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Admin_viewemployee implements ActionListener{
    JFrame f;
    JLabel l1,l2,l3,lid,lfname,llname,laddress,lmobile,lemail,leducation,lpost,lphoto,rsid,rsfname,rslname,rsaddress,rsmobile,rsemail,rseducation,rspost,rsphoto;
    JTextField t1,tid,tfname,tlname,taddress,tmobile,temail,teducation,tpost;
    JLabel dd1,dd2,dd3,dd4,dd5,dd6,dd7;
    String emp_id,name,father,address,phone,email,education,post,age,dob,aadhar;
    Border BevelRaised=BorderFactory.createBevelBorder(BevelBorder.LOWERED);
    byte[] imagedata;
    ImageIcon leavep1;
    JButton b1,b2,backb;
    DefaultTableModel dtm;
    JTable table;
        Admin_viewemployee(){
   
        f=new JFrame("HomePage");
        f.setBackground(Color.BLUE);
        f.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/admin_viewemployee.jpg"));
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
        l2.setBounds(370, 40, 1200,910);
        l2.setLayout(null);
        l1.add(l2);
        
          l3=new JLabel("VIEW EMPLOYEE");
        l3.setBounds(200, 55, 450, 60);
        l3.setFont(new Font("solaris-2",Font.ROMAN_BASELINE,40));
        l3.setForeground(new Color(0,255,254));
        Font font1 = l3.getFont();
         Map attributes1 = font1.getAttributes();
        attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        l3.setFont(font1.deriveFont(attributes1));
        l2.add(l3);
        
        t1=new RoundJTextField(20);
        t1.setBounds(800,55,200,50);
        t1.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t1.setForeground(Color.BLACK);
        l2.add(t1);
        
      
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/search.png"));
        b1=new JButton();
        b1.setIcon(i4);
        b1.setBounds(987, 55, 80, 50);
        b1.setFocusPainted(false);
        b1.setBorder(null);
        b1.setContentAreaFilled(false);
        b1.setFocusable(false);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e){
            ImageIcon i41 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/search1.png"));
            b1.setIcon(i41);
        }
        @Override
        public void mouseExited(MouseEvent e){
            b1.setIcon(i4);
        }
                });
        b1.addActionListener(this);
        l2.add(b1);

        
        tid= new RoundJTextField(20);
        tid.setBounds(930,560, 200, 50);
        tid.setHorizontalAlignment(JTextField.CENTER);
        tid.setEditable(false);
        tid.setBackground(Color.white);
        tid.setForeground(Color.BLACK);
        tid.setFont(new Font("solaris-2", Font.BOLD, 30));
        tid.setBorder(new LineBorder(Color.WHITE, 3, true));
        tid.setVisible(false);
        l2.add(tid);
        
       
        
        lfname=new JLabel("First Name");
        lfname.setBounds(80, 200, 200, 50);
        lfname.setFont(new Font("solaris-2",Font.BOLD,30));
        lfname.setForeground(Color.WHITE);
        l2.add(lfname);
        
        dd1=new JLabel(":");
        dd1.setForeground(Color.WHITE);
        dd1.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd1.setBounds(280, 200,20, 50);
        l2.add(dd1);
        
        tfname= new RoundJTextField(20);
        tfname.setBounds(320,200, 300, 50);
        tfname.setHorizontalAlignment(JTextField.CENTER);
        tfname.setEditable(false);
        tfname.setBackground(Color.white);
        tfname.setForeground(Color.BLACK);
        tfname.setFont(new Font("solaris-2", Font.BOLD, 30));
        tfname.setBorder(new LineBorder(Color.WHITE, 3, true));
        tfname.setVisible(false);
        l2.add(tfname);
        
        llname=new JLabel("Last Name");
        llname.setBounds(80, 300, 200, 50);
        llname.setFont(new Font("solaris-2",Font.BOLD,30));
        llname.setForeground(Color.WHITE);
        l2.add(llname);
        
        dd2=new JLabel(":");
        dd2.setForeground(Color.WHITE);
        dd2.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd2.setBounds(280, 300,20, 50);
        l2.add(dd2);
        
        tlname= new RoundJTextField(20);
        tlname.setBounds(320,300, 300, 50);
        tlname.setHorizontalAlignment(JTextField.CENTER);
        tlname.setEditable(false);
        tlname.setBackground(Color.white);
        tlname.setForeground(Color.BLACK);
        tlname.setFont(new Font("solaris-2", Font.BOLD, 30));
        tlname.setBorder(new LineBorder(Color.WHITE, 3, true));
        tlname.setVisible(false);
        l2.add(tlname);
        
        laddress=new JLabel("Address");
        laddress.setBounds(80,400, 200, 50);
        laddress.setFont(new Font("solaris-2",Font.BOLD,30));
        laddress.setForeground(Color.WHITE);
        l2.add(laddress);
        
        dd3=new JLabel(":");
        dd3.setForeground(Color.WHITE);
        dd3.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd3.setBounds(280, 400,20, 50);
        l2.add(dd3);
        
        taddress= new RoundJTextField(20);
       taddress.setBounds(320,400, 300, 50);
        taddress.setHorizontalAlignment(JTextField.CENTER);
        taddress.setEditable(false);
        taddress.setBackground(Color.white);
        taddress.setForeground(Color.BLACK);
        taddress.setFont(new Font("solaris-2", Font.BOLD, 30));
        taddress.setBorder(new LineBorder(Color.WHITE, 3, true));
        taddress.setVisible(false);
        l2.add(taddress);
        
        lmobile=new JLabel("Contact No.");
        lmobile.setBounds(80,500, 200, 50);
        lmobile.setFont(new Font("solaris-2",Font.BOLD,30));
        lmobile.setForeground(Color.WHITE);
        l2.add(lmobile);
        
        dd4=new JLabel(":");
        dd4.setForeground(Color.WHITE);
        dd4.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd4.setBounds(280, 500,20, 50);
        l2.add(dd4);
        
        tmobile= new RoundJTextField(20);
        tmobile.setBounds(320,500, 300, 50);
        tmobile.setHorizontalAlignment(JTextField.CENTER);
        tmobile.setEditable(false);
        tmobile.setBackground(Color.white);
        tmobile.setForeground(Color.BLACK);
        tmobile.setFont(new Font("solaris-2", Font.BOLD, 30));
        tmobile.setBorder(new LineBorder(Color.WHITE, 3, true));
        tmobile.setVisible(false);
        l2.add(tmobile);
        
        lemail=new JLabel("Email");
        lemail.setBounds(80,600, 200, 50);
        lemail.setFont(new Font("solaris-2",Font.BOLD,30));
        lemail.setForeground(Color.WHITE);
        l2.add(lemail);
        
        dd5=new JLabel(":");
        dd5.setForeground(Color.WHITE);
        dd5.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd5.setBounds(280, 600,20, 50);
        l2.add(dd5);
        
        temail= new RoundJTextField(20);
        temail.setBounds(320,600, 380, 50);
        temail.setHorizontalAlignment(JTextField.CENTER);
        temail.setEditable(false);
        temail.setBackground(Color.white);
        temail.setForeground(Color.BLACK);
        temail.setFont(new Font("solaris-2", Font.BOLD, 25));
        temail.setBorder(new LineBorder(Color.WHITE, 3, true));
        temail.setVisible(false);
        l2.add(temail);
        
        leducation=new JLabel("Education");
        leducation.setBounds(80,700, 200, 50);
        leducation.setFont(new Font("solaris-2",Font.BOLD,30));
        leducation.setForeground(Color.WHITE);
        l2.add(leducation);
        
        dd6=new JLabel(":");
        dd6.setForeground(Color.WHITE);
        dd6.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd6.setBounds(280, 700,20, 50);
        l2.add(dd6);
        
        teducation= new RoundJTextField(20);
        teducation.setBounds(320,700, 300, 50);
        teducation.setHorizontalAlignment(JTextField.CENTER);
        teducation.setEditable(false);
        teducation.setBackground(Color.white);
        teducation.setForeground(Color.BLACK);
        teducation.setFont(new Font("solaris-2", Font.BOLD, 30));
        teducation.setBorder(new LineBorder(Color.WHITE, 3, true));
        teducation.setVisible(false);
        l2.add(teducation);
        
        lpost=new JLabel("Post");
        lpost.setBounds(80, 800, 200, 50);
        lpost.setFont(new Font("solaris-2",Font.BOLD,30));
        lpost.setForeground(Color.WHITE);
        l2.add(lpost);
        
        dd7=new JLabel(":");
        dd7.setForeground(Color.WHITE);
        dd7.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd7.setBounds(280, 800,20, 50);
        l2.add(dd7);
        
        tpost= new RoundJTextField(20);
        tpost.setBounds(320,800, 300, 50);
        tpost.setHorizontalAlignment(JTextField.CENTER);
        tpost.setEditable(false);
        tpost.setBackground(Color.white);
        tpost.setForeground(Color.BLACK);
        tpost.setFont(new Font("solaris-2", Font.BOLD, 30));
        tpost.setBorder(new LineBorder(Color.WHITE, 3, true));
        tpost.setVisible(false);
        l2.add(tpost);
        
        ImageIcon leavep = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/default_profile.png"));
        Image i6 = leavep.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
       leavep1  = new ImageIcon(i6);
        lphoto=new JLabel();
        lphoto.setBorder(BevelRaised);
        lphoto.setBounds(900, 270, 250, 250);
        lphoto.setBackground(Color.yellow);
        lphoto.setVisible(false);
        l2.add(lphoto);
        

         rsphoto=new JLabel("Profile Photo :");
         rsphoto.setBounds(900, 200, 260, 50);
         rsphoto.setFont(new Font("solaris-2",Font.BOLD,30));
         rsphoto.setForeground(Color.WHITE);        
         l2.add(rsphoto);
        

        
        ImageIcon iback = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/goback.png"));
        backb=new JButton();
        backb.setIcon(iback);
        backb.setBounds(1700, 880, 160, 60);
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
            if(ae.getSource()==b1){
                  try{
                      
            conn con = new conn();
            String str = "select * from employee where emp_id = '"+t1.getText()+"'";
            ResultSet rs= con.s.executeQuery(str);
            if(rs.next()){

                name = rs.getString("name");
                father = rs.getString("fname");
                age = rs.getString("age");
                dob = rs.getString("dob");
                address = rs.getString("address");
                phone = rs.getString("phone");
                email = rs.getString("email");
                education = rs.getString("education");
                post = rs.getString("post");
                aadhar = rs.getString("aadhar");
                emp_id = rs.getString("emp_id");
                
                if(email.length()<18){
                    temail.setBounds(320,600, 300, 50);
                }else if(email.length()>18){
                    temail.setBounds(320,600, 380, 50);
                }
                
                 tfname.setVisible(true);
                 tfname.setText(name);
                 tlname.setVisible(true);
                 tlname.setText(father);
                 taddress.setVisible(true);
                 taddress.setText(address);
                 tmobile.setVisible(true);
                 tmobile.setText(phone);
                 temail.setVisible(true);
                 temail.setText(email);
                 teducation.setVisible(true);
                 teducation.setText(education);
                 tpost.setVisible(true);
                 tpost.setText(post);
//                 lid.setVisible(true);
                 tid.setVisible(true);
                 tid.setText(emp_id);
                 
                 
            }else{
                JOptionPane.showMessageDialog(null, "ID not Found");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
                 
               
              
                  try {
                     
            conn c2 = new conn();
            String st = "Select profileimage from employee where emp_id='"+t1.getText()+"'";
            ResultSet rs = c2.s.executeQuery(st);
            if (rs.next()) {
                imagedata = rs.getBytes("profileimage");
                String imad = rs.getString("profileimage");
                if (imad.equals("null")) {
                     lphoto.setVisible(true);
                    lphoto.setIcon(leavep1);
                } else {
                    ImageIcon ime = new ImageIcon(imagedata);
                    Image mm = ime.getImage();
                    Image img2 = mm.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    ImageIcon image = new ImageIcon(img2);
                     lphoto.setVisible(true);
                    lphoto.setIcon(image);
                }
            }

        } catch (SQLException ex) {
            
        }
               
            }
        }
    
    public static void main(String[] args){
        Admin_viewemployee av=new Admin_viewemployee();
    }
}
