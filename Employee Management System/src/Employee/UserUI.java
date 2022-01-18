/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

public class UserUI implements ActionListener {

     
    
    Calendar calendar;
    SimpleDateFormat timeFormat,dayFormat,dateFormat;
    JFrame f;
    JButton b1, b2,b3,b4,refreshb;
    JLabel l1,l2,lname,lemail,lempid,ldob,leducation,lpost,lphoneno,rsname,rsemail,rsempid,rsdob,rseducation,rspost,rsphoneno,
            timelabel,daylabel,datelabel;
    JPanel p1,p2,p3,p4;
    String emp_id,name,father,address,phone,email,education,post,age,dob,aadhar,attendancetime,attendanceday,attendancedate;
     String sempid,intime,indate,outtime,outdate;
     String remaining;
     String semmpid,inttime,inddate;
    UserUI(String e_id) {
        
        try{
            conn con = new conn();
            String str = "select * from employee where emp_id = '"+e_id+"'";
            ResultSet rs= con.s.executeQuery(str);

            while(rs.next()){
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
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //ADDING FRAME 
        f = new JFrame("testing UI");
        f.setSize(1920 + 25, 1080);
        f.setLayout(null);
        f.setBackground(Color.white);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);

        //ADDING SIDE LABEL FOR NAVIGATION
        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/sidelabel1.jpeg"));
        Image i5 = i12.getImage().getScaledInstance(275, 1100, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i4);
        l4.setBounds(0, 0, 275, 1100);
        f.add(l4);
        
        //ADDING BUTTONS IN SIDE LABEL NAVIGATION
        b1 = new JButton("PROFILE");
        b1.setBackground(Color.green);
        b1.setFont(new Font("solaris-2", Font.BOLD, 30));
        b1.setForeground(Color.BLACK);
        b1.setBounds(10, 50, 180, 60);
        l4.add(b1);
        b1.addActionListener(this);
        
        b2 = new JButton("ATTENDANCE");
        b2.setBackground(Color.green);
        b2.setFont(new Font("solaris-2", Font.BOLD, 30));
        b2.setForeground(Color.BLACK);
        b2.setBounds(1, 160, 250, 60);
        l4.add(b2);
        b2.addActionListener(this);
        
        //ADDING MAIN JPANEL IN FRAME
        p3=new JPanel();
        p3.setBackground(Color.yellow);
        p3.setBounds(290,0, 1640, 980);
        p3.setLayout(null);
        f.add(p3);
        
        //ADDING A EMP ID LABEL IN MAIN PANEL AT TOP RIGHT CORNER
        l1=new JLabel("EMP ID :");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,35));
        l1.setBounds(1300, 30,180, 50);
        
        l2=new JLabel(emp_id);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("solaris-2", Font.BOLD,35));
        l2.setBounds(1450, 30,180, 50);
          
        //ADDING AN CHANGABLE JLABEL TO CHILD JPANEL 
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/purple Main panel.png"));
        Image i7 = i13.getImage().getScaledInstance(1700,830,Image.SCALE_DEFAULT);
        ImageIcon i6 =  new ImageIcon(i7);
        JLabel l5=new JLabel(i6); 
        l5.setBounds(0, 0, 1700, 850);
        
        
        
        //CREATING A CHILD JPANEL UNDER MAIN JPANEL
        p1=new JPanel();
        p1.add(l5);
        p1.setBounds(15,130,1600,800);
        
        
        p3.add(l1);
        p3.add(l2);
        p3.add(p1);
        
        //ADDING LABELS IN CHILD JPANEL 
        lname=new JLabel("NAME : ");
        lname.setForeground(Color.black);        
        lname.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,35));
        lname.setBounds(250,130,300,50);
        
        rsname=new JLabel(name.toUpperCase());
        rsname.setForeground(Color.black);        
        rsname.setFont(new Font("solaris-2", Font.BOLD,35));
        rsname.setBounds(400,130,130,50);
        
        lempid=new JLabel("EMP ID : ");
        lempid.setForeground(Color.black);        
        lempid.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,35));
        lempid.setBounds(1000,130,160,50);
        
        rsempid=new JLabel(emp_id);
        rsempid.setForeground(Color.black);        
        rsempid.setFont(new Font("solaris-2", Font.BOLD,35));
        rsempid.setBounds(1170,130,100,50);
        
        lemail=new JLabel("EMAIL : ");
        lemail.setForeground(Color.black);        
        lemail.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,35));
        lemail.setBounds(250,280,160,50);
        
        rsemail=new JLabel(email);
        rsemail.setForeground(Color.black);        
        rsemail.setFont(new Font("solaris-2", Font.BOLD,35));
        rsemail.setBounds(400,280,500,50);
        
        ldob=new JLabel("DOB : ");
        ldob.setForeground(Color.black);        
        ldob.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,35));
        ldob.setBounds(1050,280,300,50);
        
        rsdob=new JLabel(dob);
        rsdob.setForeground(Color.black);        
        rsdob.setFont(new Font("solaris-2", Font.BOLD,35));
        rsdob.setBounds(1170,280,400,50);
        
        leducation=new JLabel("EDUCATION : ");
        leducation.setForeground(Color.black);        
        leducation.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,35));
        leducation.setBounds(155,430,240,50);
        
        rseducation=new JLabel(education.toUpperCase());
        rseducation.setForeground(Color.black);        
        rseducation.setFont(new Font("solaris-2", Font.BOLD,35));
        rseducation.setBounds(400,430,400,50);
        
        lpost=new JLabel("POST : ");
        lpost.setForeground(Color.black);        
        lpost.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,35));
        lpost.setBounds(1030,430,160,50);
        
        rspost=new JLabel(post.toUpperCase());
        rspost.setForeground(Color.black);        
        rspost.setFont(new Font("solaris-2", Font.BOLD,35));
        rspost.setBounds(1170,430,500,50);
        
        lphoneno=new JLabel("CONTACT NO. : ");
        lphoneno.setForeground(Color.black);        
        lphoneno.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,35));
        lphoneno.setBounds(120,580,280,50);
        
        rsphoneno=new JLabel(phone);
        rsphoneno.setForeground(Color.black);        
        rsphoneno.setFont(new Font("solaris-2", Font.BOLD,35));
        rsphoneno.setBounds(400,580,250,50);
        
        refreshb=new JButton("Refresh");
        refreshb.setBounds(800, 580, 100, 50);
        refreshb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                f.setVisible(false);
                
                new UserUI(l2.getText());
            }
        });
        l5.add(refreshb);
        l5.add(lname);
        l5.add(lempid);
        l5.add(lemail);
        l5.add(lempid);
        l5.add(ldob);
        l5.add(leducation);
        l5.add(lpost);
        l5.add(lphoneno);
        l5.add(rsname);
        l5.add(rsempid);
        l5.add(rsemail);
        l5.add(rsdob);
        l5.add(rseducation);
        l5.add(rspost);
        l5.add(rsphoneno);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            p2.setVisible(false);
            p3.setVisible(true);
        }
        else if(ae.getSource()==b2){
            p3.setVisible(false);
            
            
            String atemp_id=l2.getText();
            
             //ADDING NEW MAIN JPANEL IN ATTENDANCE 
            p2=new JPanel();
        p2.setBackground(Color.RED);
        p2.setBounds(290,0, 1640, 980);
        p2.setLayout(null);
        f.add(p2);
        
        //ADDING A EMP ID LABEL IN MAIN PANEL AT TOP RIGHT CORNER
        l1=new JLabel("EMP ID :");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,35));
        l1.setBounds(1300, 30,180, 50);
        p2.add(l1);
        
        JLabel emplabel=new JLabel(atemp_id);
        emplabel.setForeground(Color.BLACK);
        emplabel.setFont(new Font("solaris-2", Font.ROMAN_BASELINE,35));
        emplabel.setBounds(1450, 30,180, 50);
        p2.add(emplabel);
        
        
        
        p4=new JPanel();
        p4.setBounds(15,130,1600,800);
        
                    //ADDING AN CHANGABLE JLABEL TO CHILD JPANEL p4
        ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/Red Main panel.png"));
        Image i8 = i14.getImage().getScaledInstance(1700,830,Image.SCALE_DEFAULT);
        ImageIcon i10 =  new ImageIcon(i8);
        JLabel l6=new JLabel(i10); 
        l6.setBounds(0, 0, 1700, 850);      
        p4.add(l6);
        p2.add(p4);
        
        JLabel checkinlabel=new JLabel();
        checkinlabel.setBounds(350,300,800,70);
        checkinlabel.setFont(new Font("serif",Font.TRUETYPE_FONT,20));
        checkinlabel.setForeground(Color.black);
        l6.add(checkinlabel);
                
            LocalDate myDateObj = LocalDate.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    String DDate = myDateObj.format(myFormatObj);
    
    LocalTime myTimelabel = LocalTime.now();
      DateTimeFormatter myTimelabelFormatObj = DateTimeFormatter.ofPattern("hh:mm:ss a");
      String Timelabel = myTimelabel.format(myTimelabelFormatObj);
      
    b3=new JButton("CHECK-IN");
        b3.setBounds(350,300, 200, 70);
         b3.setFont(new Font("Sand Serif",Font.BOLD,25));
        b3.setVisible(false);
         b3.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent ae) {
                    b3.setVisible(false);
                   LocalDate myDateObj = LocalDate.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    String Date = myDateObj.format(myFormatObj);
      LocalTime myTimeObj = LocalTime.now();
      DateTimeFormatter myTimeFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
      String Time = myTimeObj.format(myTimeFormatObj);
      
      
      try{
          
          
          conn cc = new conn();
                String q="insert into attendance values('"+atemp_id+"','"+Time+"','"+Date+"','null','null','null')";
                cc.s.executeUpdate(q);
                checkinlabel.setText("You are logged in at "+Timelabel);
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, "In checkin first catch block");
      }
      
                }
            
        });
        l6.add(b3);
        
    try{
      conn c1=new conn();
                String ntr="Select * from attendance where emp_id='"+atemp_id+"' AND checkin_date='"+DDate+"'";
                ResultSet crs=c1.s.executeQuery(ntr);
                
                if(crs.next()){
                    semmpid=crs.getString("emp_id");
                    inttime=crs.getString("chenkin_time");
                    inddate=crs.getString("checkin_date"); 
                    if(semmpid.equals(atemp_id) && inddate.equals(DDate)){
                        b3.setVisible(false);
                     checkinlabel.setText("You are logged in at "+inttime);
                    }
                    else{
                    
                        b3.setVisible(true);
                    }          
                }
                else{
                    b3.setVisible(true);
                }
    }
    catch(Exception e){
        
    }
  
        b4=new JButton("CHECK-OUT");
        b4.setBounds(800,300, 200, 70);
        b4.setFont(new Font("Sand Serif",Font.BOLD,25));
        b4.addActionListener(new ActionListener(){
           
                @Override
                public void actionPerformed(ActionEvent ae) {
                    
                    LocalDate myDateObj = LocalDate.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    String Date = myDateObj.format(myFormatObj);
      LocalTime myTimeObj = LocalTime.now();
      DateTimeFormatter myTimeFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
      String Time = myTimeObj.format(myTimeFormatObj);
                    try{
                     conn c1=new conn();
                String str="Select * from attendance where emp_id='"+atemp_id+"'";
                ResultSet rs=c1.s.executeQuery(str);
                
                while(rs.next()){
                    sempid=rs.getString("emp_id");
                    intime=rs.getString("chenkin_time");
                    indate=rs.getString("checkin_date");
                    outtime=rs.getString("checkout_time");
                   outdate=rs.getString("checkout_date");
                   
                    
                }
                if(sempid.equals(atemp_id)&&Date.equals(indate)){
                if(sempid.equals(atemp_id)&&outtime.equals("null")){
                    conn cc = new conn();
                String q="update attendance SET checkout_time='"+Time+"',checkout_date='"+Date+"'where emp_id='"+atemp_id+"' AND checkout_time='null' AND checkin_date='"+Date+"'";
                cc.s.executeUpdate(q);
                String d="select chenkin_time,checkout_time,(34.25*(checkout_time-chenkin_time)) as remainng_time from attendance where emp_id='"+atemp_id+"'";
                ResultSet pq=cc.s.executeQuery(d);
                while(pq.next()){
                    
                    remaining=pq.getString("remainng_time");
        }
                String sp="update attendance SET salary='"+remaining+"' where emp_id='"+atemp_id+"' AND salary='null'";
                cc.s.executeUpdate(sp);
            }
                else{
                    JOptionPane.showMessageDialog(null, "You are already checked out today!");
                }
            }else{
                    JOptionPane.showMessageDialog(null, "You are not Checked in today");
                }
        }
                 catch(Exception e){
                     
                 }
                }
            
        });
        l6.add(b4);
        
        
         timelabel=new JLabel();
         timelabel.setFont(new Font("Sand Serif", Font.BOLD,35));
         timelabel.setForeground(Color.BLACK);
         timelabel.setBounds(140,100,300,50);
         
         daylabel=new JLabel();
         daylabel.setFont(new Font("solaris-2", Font.BOLD,40));
         daylabel.setForeground(Color.BLACK);    
         daylabel.setBounds(730,130,300,50);
         
         datelabel=new JLabel();
         datelabel.setFont(new Font("solaris-2", Font.BOLD,35));
         datelabel.setForeground(Color.BLACK);
         datelabel.setBounds(1300, 100,300,50);
       
      Timer timer =new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                timeFormat = new SimpleDateFormat("hh:mm:ss a");
              attendancetime=timeFormat.format(Calendar.getInstance().getTime());
             timelabel.setText(attendancetime);
             
             dayFormat=new SimpleDateFormat("EEEE");
             attendanceday=dayFormat.format(Calendar.getInstance().getTime());
             daylabel.setText(attendanceday);
             
             dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
             attendancedate=dateFormat.format(Calendar.getInstance().getTime());
             datelabel.setText(attendancedate);
            }
          
      });
       
         timer.start();
        l6.add(timelabel);
        l6.add(daylabel);
        l6.add(datelabel);
        }
        
    }

    public static void main(String[] arg) {
        UserUI u = new UserUI("");
        
    }
}
