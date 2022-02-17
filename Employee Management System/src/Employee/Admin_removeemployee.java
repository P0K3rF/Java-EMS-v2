
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
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


public class Admin_removeemployee implements ActionListener{
    
    JFrame f;
    JLabel l1,l2,l3,lname,lemail,lmobile,lprofile,lphoto;
    JLabel dd1,dd2,dd3;
    JTextField ts,t1,t2,t3;
    JButton bs,b1,backb;
    Border BevelRaised=BorderFactory.createBevelBorder(BevelBorder.LOWERED);
    byte[] imagedata;
    ImageIcon leavep1;
    DefaultTableModel dtm;
    JTable table;
    JScrollPane jsp;
    Admin_removeemployee(){
        
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
        l2.setBounds(370, 50, 1200,900);
        l2.setLayout(null);
        l1.add(l2);
        
        l3=new JLabel("REMOVE EMPLOYEE");
        l3.setBounds(200, 55, 450, 60);
        l3.setFont(new Font("solaris-2",Font.ROMAN_BASELINE,40));
        l3.setForeground(new Color(0,255,254));
        Font font1 = l3.getFont();
         Map attributes1 = font1.getAttributes();
        attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        l3.setFont(font1.deriveFont(attributes1));
        l2.add(l3);
        
        ts = new RoundJTextField(20);
        ts.setBounds(800,60, 200, 50);
        ts.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        ts.setForeground(Color.BLACK);
        l2.add(ts);
        
         ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/search.png"));
        bs = new JButton();
        bs.setIcon(i6);
        bs.setBounds(987,60, 80, 50);
        bs.setFocusPainted(false);
        bs.setBorder(null);
        bs.setContentAreaFilled(false);
        bs.setFocusable(false);
        bs.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon i41 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/search1.png"));
                bs.setIcon(i41);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bs.setIcon(i6);
            }
        });
        bs.addActionListener(this);
        l2.add(bs);
        
         String columns[] = {"Emp_Id", "First_Name", "Last_Name","Phone","Email","Post"};
        dtm=new DefaultTableModel(columns,0); 
        
        try{
            conn c=new conn();
            String query="Select * from employee";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                String id=rs.getString("emp_id");
                String fname=rs.getString("fname");
                String rslname=rs.getString("name");
                String rsphone1=rs.getString("phone");
                String rsemail1=rs.getString("email");
                String rspost1=rs.getString("post");
                dtm.addRow(new Object[]{id,fname,rslname,rsphone1,rsemail1,rspost1});
            }
            
        }catch(Exception e){
            
        }
        table =new JTable();
          table.setModel(dtm);
         table.setEnabled(false);
         table.setPreferredScrollableViewportSize(new Dimension(500,50));
        table.setFillsViewportHeight(true);
        table.getTableHeader().setPreferredSize(new Dimension(100,50));
        table.getTableHeader().setFont(new Font("solaris-2",Font.BOLD,20));
        table.getTableHeader().setBackground(new Color(18,140,226));
        table.getTableHeader().setForeground(new Color(255,255,255));
        table.setRowHeight(50);
        table.setBackground(new Color(204,255,255));
        table.setFont(new Font("solrais-2",Font.ROMAN_BASELINE,20));
        table.setForeground(new Color(0,0,0));
        JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
        jsp=new JScrollPane(table);
        jsp.setBounds(50, 190, 1055, 600);
        l2.add(jsp);
        
        lname=new JLabel("Name");
        lname.setVisible(false);
        lname.setBounds(80, 280, 200, 50);
        lname.setFont(new Font("solaris-2",Font.BOLD,30));
        lname.setForeground(Color.WHITE);
        l2.add(lname);
        
        dd1=new JLabel(":");
        dd1.setVisible(false);
        dd1.setForeground(Color.WHITE);
        dd1.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd1.setBounds(280, 280,20, 50);
        l2.add(dd1);
        
        t1= new RoundJTextField(20);
        t1.setBounds(350,280, 300, 50);
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setEditable(false);
        t1.setBackground(Color.white);
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("solaris-2", Font.BOLD, 30));
        t1.setBorder(new LineBorder(Color.WHITE, 3, true));
        t1.setVisible(false);
        l2.add(t1);
        
        lemail=new JLabel("Email");
        lemail.setVisible(false);
        lemail.setBounds(80, 420, 200, 50);
        lemail.setFont(new Font("solaris-2",Font.BOLD,30));
        lemail.setForeground(Color.WHITE);
        l2.add(lemail);
        
        dd2=new JLabel(":");
        dd2.setVisible(false);
        dd2.setForeground(Color.WHITE);
        dd2.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd2.setBounds(280, 420,20, 50);
        l2.add(dd2);
        
        t2= new RoundJTextField(20);
        t2.setBounds(350,420, 370, 50);
        t2.setHorizontalAlignment(JTextField.CENTER);
        t2.setEditable(false);
        t2.setBackground(Color.white);
        t2.setForeground(Color.BLACK);
        t2.setFont(new Font("solaris-2", Font.BOLD, 25));
        t2.setBorder(new LineBorder(Color.WHITE, 3, true));
        t2.setVisible(false);
        l2.add(t2);
        
        lmobile=new JLabel("Contact No.");
        lmobile.setVisible(false);
        lmobile.setBounds(80, 550, 200, 50);
        lmobile.setFont(new Font("solaris-2",Font.BOLD,30));
        lmobile.setForeground(Color.WHITE);
        l2.add(lmobile);
        
        dd3=new JLabel(":");
        dd3.setVisible(false);
        dd3.setForeground(Color.WHITE);
        dd3.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd3.setBounds(280, 550,20, 50);
        l2.add(dd3);
        
        t3= new RoundJTextField(20);
        t3.setBounds(350,550, 300, 50);
        t3.setHorizontalAlignment(JTextField.CENTER);
        t3.setEditable(false);
        t3.setBackground(Color.white);
        t3.setForeground(Color.BLACK);
        t3.setFont(new Font("solaris-2", Font.BOLD, 30));
        t3.setBorder(new LineBorder(Color.WHITE, 3, true));
        t3.setVisible(false);
        l2.add(t3);
        
        lprofile=new JLabel("Profile Photo ");
        lprofile.setVisible(false);
        lprofile.setBounds(900, 230, 300, 50);
        lprofile.setFont(new Font("solaris-2",Font.BOLD,30));
        lprofile.setForeground(Color.WHITE);
        l2.add(lprofile);
        
        ImageIcon leavep = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/default_profile.png"));
        Image i10 = leavep.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        leavep1  = new ImageIcon(i10);
        lphoto=new JLabel();
        lphoto.setBorder(BevelRaised);
        lphoto.setBounds(880, 300, 250, 250);
        lphoto.setBackground(Color.yellow);
        lphoto.setVisible(false);
        l2.add(lphoto);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/remove_employee.png"));
        b1 = new JButton();
        b1.setVisible(false);
        b1.setIcon(i4);
        b1.setBounds(390, 800, 180, 70);
        b1.setFocusPainted(false);
        b1.setBorder(null);
        b1.setContentAreaFilled(false);
        b1.setFocusable(false);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/remove_employee1.png"));
                b1.setIcon(i21);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b1.setIcon(i4);
            }

        });
        b1.addActionListener(this);
        l2.add(b1);
        
        
        ImageIcon iback = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/goback.png"));
        backb=new JButton();
        backb.setIcon(iback);
        backb.setBounds(1700, 880, 160, 70);
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
    
    public static void main(String[] args){
        Admin_removeemployee ar=new Admin_removeemployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==bs && !ts.getText().isEmpty()){
           try{
                conn con = new conn();
                String str = "select name,phone,email,profileimage from employee where emp_id ='"+ts.getText()+"' ";
                ResultSet rs = con.s.executeQuery(str);

          
                if(rs.next()){
                    
                    String name = rs.getString(1);
                    String mob = rs.getString(2);
                    String email=rs.getString(3);
                    imagedata = rs.getBytes("profileimage");
                    String imad = rs.getString("profileimage");
         
                    jsp.setVisible(false);
                    lname.setVisible(true);
                    dd1.setVisible(true);
                    t1.setVisible(true);
                    t1.setText(name);
                    lemail.setVisible(true);
                    dd2.setVisible(true);
                    t2.setVisible(true);
                    t2.setText(email);
                    lmobile.setVisible(true);
                    dd3.setVisible(true);
                    t3.setVisible(true);
                    t3.setText(mob);
                    lprofile.setVisible(true);
                    lphoto.setVisible(true);
                   b1.setVisible(true);
                  
                   if (imad.equals("null")) {
                    lphoto.setIcon(leavep1);
                } else {
                    ImageIcon ime = new ImageIcon(imagedata);
                    Image mm = ime.getImage();
                    Image img2 = mm.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    ImageIcon image = new ImageIcon(img2);
                    lphoto.setIcon(image);
                }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Id not Found");
                    jsp.setVisible(true);
                    lname.setVisible(false);
                    dd1.setVisible(false);
                    t1.setVisible(false);
                    
                    lemail.setVisible(false);
                    dd2.setVisible(false);
                    t2.setVisible(false);
                   
                    lmobile.setVisible(false);
                    dd3.setVisible(false);
                    t3.setVisible(false);
                 
                    lprofile.setVisible(false);
                    lphoto.setVisible(false);
                   b1.setVisible(false);
                }
               
            }catch(Exception ex){}

       }else if(ae.getSource()==b1){
           try{
                conn con = new conn();
                String str = "delete from employee where emp_id = '"+ts.getText()+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"deleted successfully");   
                new Admin_homepage().f.setVisible(true);
                f.setVisible(false);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Exception occured while deleting record "+ex);
            }
       }else if(ae.getSource()==bs && ts.getText().isEmpty()){
                    
                    jsp.setVisible(true);
                    lname.setVisible(false);
                    dd1.setVisible(false);
                    t1.setVisible(false);
                    
                    lemail.setVisible(false);
                    dd2.setVisible(false);
                    t2.setVisible(false);
                   
                    lmobile.setVisible(false);
                    dd3.setVisible(false);
                    t3.setVisible(false);
                 
                    lprofile.setVisible(false);
                    lphoto.setVisible(false);
                   b1.setVisible(false);
                }
       }
   }
