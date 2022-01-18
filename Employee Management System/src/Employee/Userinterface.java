package Employee;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Userinterface implements ActionListener {
    
    JFrame f;
    JLabel l1;
    SimpleDateFormat timeFormat, dayFormat, dateFormat;
    JLabel lname, lfname, lemail, lempid, ldob, leducation, lpost, lphoneno, rsname, rsfname, rsemail, rsempid, rsdob, rseducation, rspost, rsphoneno, lphoto,
            lupdate, lok, ltime, lswingtime, lday, lswingday, ldate, lswingdate, lopcheckin, lmarkatt, lprofile, leaveemp, leaveemail, leavesdate, leaveedate, leavesubject, leavedesc, leavecatg,othercatg,leaveprofile;
    JPanel mainpanel, p1, p2, p3, p4, p5, attendancelabel, upperpanel, attchildlabel, leavepanel, leavechildpanel,notpanel,notchildpanel;
    String emp_id, name, father, address, phone, email, education, post, age, dob, aadhar;
    JButton b1, b2, b3,b4, updateb, saveb, cancelb, checkinb, checkoutb, addprofileb, saveprofileb,applyleave,not,logout;
    JTextField tname, tfname, temail, tdob, tphoneno, tcatg;
    String Stname, Stfname, Stemail, Stdob, Stphoneno;
    String attendancetime, attendanceday, attendancedate;
    String semmpid, inttime, inddate;
    String remaining;
    String sempid, intime, indate, outtime, outdate;
    JTextArea tsubj, tdesc;
    JScrollPane jsp;
    
    File f1 = null;
    String path;
    String fname = null;
    int s = 0;
    byte[] pimage = null;
    byte[] imagedata;
    String[] salarr=null;
    String[] sarr=null;
    String[] earr=null;
    JLabel[] labels;
    int v=50;
    String sal;
    int b=1;
    String[] arrcatg = null;
    String[] sdatearr = null;
    String[] edatearr = null;
    String[] arrstatus = null;
    int x=370;
    Userinterface() {
        
        try {
            conn con = new conn();
            String str = "select * from employee where emp_id = '101'";
            ResultSet rs = con.s.executeQuery(str);
            
            while (rs.next()) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        

     
        

        
        f = new JFrame("User");
        f.setBackground(Color.BLUE);
        f.setLayout(null);

        //Side Panel
        p1 = new JPanel();
        p1.setBounds(0, 0, 230, 990);
        p1.setBackground(new Color(23, 35, 51));
        p1.setLayout(null);
        f.add(p1);
        
        
        ImageIcon i123 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/notification.png"));
        not=new JButton();
        not.setIcon(i123);
        not.setVisible(false);
        not.setBounds(200,570,30,30);
        not.setBackground(new Color(0, 0, 57));
        not.setFocusPainted(false);
        not.setBorder(null);
        not.setContentAreaFilled(false);
        not.setFocusable(false);
        p1.add(not);
        
          
        //Center Panel for Profile
        mainpanel = new JPanel();
        mainpanel.setBounds(230, 0, 1700, 990);
        mainpanel.setBackground(new Color(86, 88, 188));
        mainpanel.setLayout(null);
        f.add(mainpanel);
        
        upperpanel = new JPanel();
        upperpanel.setBounds(0, 90, 1700, 820);
        upperpanel.setBackground(new Color(0, 0, 57));
        upperpanel.setLayout(null);
        mainpanel.add(upperpanel);
        
        p4 = new JPanel();
        p4.setBackground(Color.white);
        p4.setBounds(0, 323, 230, 5);
        p1.add(p4);
        
        b1 = new JButton("Profile");
        b1.setBorder(null);
        b1.setBackground(new Color(23, 35, 51));
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b1.setBackground(new Color(86, 88, 188));
            }
            
            public void mouseClicked(java.awt.event.MouseEvent e) {
                b1.setBackground(new Color(86, 88, 188));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b1.setBackground(new Color(23, 35, 51));
            }
            
        });
        b1.setBounds(0, 330, 230, 70);
        b1.setForeground(Color.white);
        b1.setFont(new Font("serif", Font.ROMAN_BASELINE, 30));
        b1.setFocusable(false);
        b1.setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                attendancelabel.setVisible(false);
                 notpanel.setVisible(false);
                leavepanel.setVisible(false);
                mainpanel.setVisible(true);
            }
        });
        p1.add(b1);
        
        p2 = new JPanel();
        p2.setBackground(Color.white);
        p2.setBounds(0, 403, 230, 5);
        p1.add(p2);
        
        attendancelabel = new JPanel();
        attendancelabel.setVisible(false);
        attendancelabel.setBounds(230, 0, 1700, 990);
        attendancelabel.setBackground(new Color(86, 88, 188));
        attendancelabel.setLayout(null);
        f.add(attendancelabel);
        
        attchildlabel = new JPanel();
        attchildlabel.setBounds(0, 90, 1700, 820);
        attchildlabel.setBackground(new Color(0, 0, 57));
        attchildlabel.setLayout(null);
        attendancelabel.add(attchildlabel);
        
        b2 = new JButton("Attendance");
        b2.setBorder(null);
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b2.setBackground(new Color(33, 109, 150));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b2.setBackground(new Color(23, 35, 51));
            }
            
        });
        b2.setBounds(0, 410, 230, 70);
        
        b2.setForeground(Color.white);
        b2.setFont(new Font("serif", Font.ROMAN_BASELINE, 30));
        b2.setFocusable(false);
        b2.setBackground(new Color(23, 35, 51));
        b2.setVisible(true);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                b2.setBackground(new Color(86, 88, 188));
                 notpanel.setVisible(false);
                mainpanel.setVisible(false);
                leavepanel.setVisible(false);                
                attendancelabel.setVisible(true);
//                attendancelabel = new JPanel();
//                attendancelabel.setVisible(true);
//                attendancelabel.setBounds(230, 0, 1700, 990);
//                attendancelabel.setBackground(new Color(86, 88, 188));
//                attendancelabel.setLayout(null);
//                f.add(attendancelabel);
//
//                attchildlabel = new JPanel();
//                attchildlabel.setBounds(0, 90, 1700, 820);
//                attchildlabel.setBackground(new Color(0, 0, 57));
//                attchildlabel.setLayout(null);
//                attendancelabel.add(attchildlabel);

                lmarkatt = new JLabel();
                lmarkatt.setText("Mark Your Attendance :");
                lmarkatt.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
                lmarkatt.setForeground(Color.WHITE);
                lmarkatt.setBounds(80, 300, 600, 60);
                attchildlabel.add(lmarkatt);
                
                ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/default_profile.png"));
                Image i1 = i10.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
                ImageIcon i11 = new ImageIcon(i1);
                JLabel lattprofile = new JLabel(i11);
                lattprofile.setBounds(1300, 200, 300, 300);
                lattprofile.setBackground(Color.yellow);
                attchildlabel.add(lattprofile);
                    
                try {
                    conn c2 = new conn();
                    String st = "Select profileimage from employee where emp_id='101'";
                    ResultSet rs = c2.s.executeQuery(st);
                    if (rs.next()) {
                        imagedata = rs.getBytes("profileimage");
                        String imad = rs.getString("profileimage");
                        if (imad.equals("null")) {
                            lattprofile.setIcon(i11);
                        } else {
                            ImageIcon ime = new ImageIcon(imagedata);
                            Image mm = ime.getImage();
                            Image img2 = mm.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                            ImageIcon image = new ImageIcon(img2);
                            lattprofile.setIcon(image);
                        }
                    }
                    
                } catch (SQLException ex) {
                    
                }
                
                JPanel ptime = new JPanel();
                ptime.setBounds(200, 100, 250, 50);
                ptime.setBackground(new Color(0, 0, 0));
                attchildlabel.add(ptime);
                
                JPanel pday = new JPanel();
                pday.setBounds(650, 100, 250, 50);
                pday.setBackground(new Color(0, 0, 0));
                attchildlabel.add(pday);
                
                JPanel pdate = new JPanel();
                pdate.setBounds(1090, 100, 250, 50);
                pdate.setBackground(new Color(0, 0, 0));
                attchildlabel.add(pdate);
                
                LocalDate myDateObj = LocalDate.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
                String DDate = myDateObj.format(myFormatObj);
                
                LocalTime myTimelabel = LocalTime.now();
                DateTimeFormatter myTimelabelFormatObj = DateTimeFormatter.ofPattern("hh:mm:ss a");
                String Timelabel = myTimelabel.format(myTimelabelFormatObj);
                
                lopcheckin = new JLabel();
                lopcheckin.setBounds(200, 400, 600, 50);
                lopcheckin.setForeground(Color.WHITE);
                attchildlabel.add(lopcheckin);
                
                ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/checkin.png"));
                checkinb = new JButton(i12);
                checkinb.setBounds(200, 400, 230, 100);
                checkinb.setBackground(new Color(0, 0, 57));
                checkinb.setFocusPainted(false);
                checkinb.setBorder(null);
                checkinb.setContentAreaFilled(false);
                checkinb.setFocusable(false);
                checkinb.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/checkin1.png"));
                        checkinb.setIcon(i13);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent e) {
                        
                        checkinb.setIcon(i12);
                    }
                    
                });
                checkinb.setVisible(false);
                checkinb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        checkinb.setVisible(false);
                        LocalDate myDateObj = LocalDate.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
                        String Date = myDateObj.format(myFormatObj);
                        LocalTime myTimeObj = LocalTime.now();
                        DateTimeFormatter myTimeFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
                        String Time = myTimeObj.format(myTimeFormatObj);
                        
                        try {
                            
                            conn cc = new conn();
                            String q = "insert into attendance values('101','" + Time + "','" + Date + "','null','null','null')";
                            cc.s.executeUpdate(q);
                            lopcheckin.setText("You are logged in at " + Timelabel);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "In checkin first catch block");
                        }
                    }
                });
                attchildlabel.add(checkinb);
                try {
                    conn c1 = new conn();
                    String ntr = "Select * from attendance where emp_id='101' AND checkin_date='" + DDate + "'";
                    ResultSet crs = c1.s.executeQuery(ntr);
                    
                    if (crs.next()) {
                        semmpid = crs.getString("emp_id");
                        inttime = crs.getString("chenkin_time");
                        inddate = crs.getString("checkin_date");
                        if (semmpid.equals("101") && inddate.equals(DDate)) {
                            checkinb.setVisible(false);
                            lopcheckin.setText("You are logged in at " + inttime);
                        } else {
                            
                            checkinb.setVisible(true);
                        }
                    } else {
                        checkinb.setVisible(true);
                    }
                } catch (Exception e) {
                    
                }
                
                ImageIcon i114 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/checkout.png"));
                checkoutb = new JButton(i114);
                checkoutb.setBounds(500, 400, 230, 100);
                checkoutb.setBackground(new Color(0, 0, 57));
                checkoutb.setFocusPainted(false);
                checkoutb.setBorder(null);
                checkoutb.setContentAreaFilled(false);
                checkoutb.setFocusable(false);
                checkoutb.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/checkout1.png"));
                        checkoutb.setIcon(i13);
                    }
                    
                    @Override
                    public void mouseExited(MouseEvent e) {
                        
                        checkoutb.setIcon(i114);
                    }
                    
                });
                
                checkoutb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        LocalDate myDateObj = LocalDate.now();
                        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
                        String Date = myDateObj.format(myFormatObj);
                        LocalTime myTimeObj = LocalTime.now();
                        DateTimeFormatter myTimeFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
                        String Time = myTimeObj.format(myTimeFormatObj);
                        try {
                            conn c1 = new conn();
                            String str = "Select * from attendance where emp_id='101'";
                            ResultSet rs = c1.s.executeQuery(str);
                            
                            while (rs.next()) {
                                sempid = rs.getString("emp_id");
                                intime = rs.getString("chenkin_time");
                                indate = rs.getString("checkin_date");
                                outtime = rs.getString("checkout_time");
                                outdate = rs.getString("checkout_date");
                                
                            }
                            if (sempid.equals("101") && Date.equals(indate)) {
                                if (sempid.equals("101") && outtime.equals("null")) {
                                    conn cc = new conn();
                                    String q = "update attendance SET checkout_time='" + Time + "',checkout_date='" + Date + "'where emp_id='101' AND checkout_time='null' AND checkin_date='" + Date + "'";
                                    cc.s.executeUpdate(q);
                                    String d = "select chenkin_time,checkout_time,(34.25*(checkout_time-chenkin_time)) as remainng_time from attendance where emp_id='101'";
                                    ResultSet pq = cc.s.executeQuery(d);
                                    while (pq.next()) {
                                        
                                        remaining = pq.getString("remainng_time");
                                    }
                                    String sp = "update attendance SET salary='" + remaining + "' where emp_id='101' AND salary='null'";
                                    cc.s.executeUpdate(sp);
                                } else {
                                    JOptionPane.showMessageDialog(null, "You are already checked out today!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "You are not Checked in today");
                            }
                        } catch (Exception e) {
                            
                        }
                    }
                });
                attchildlabel.add(checkoutb);
                
                ltime = new JLabel("Time :");
                ltime.setForeground(Color.white);
                ltime.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
                ltime.setBounds(80, 100, 300, 50);
                
                lswingtime = new JLabel();
                lswingtime.setForeground(Color.WHITE);
                lswingtime.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
                lswingtime.setBounds(200, 100, 200, 50);
                attchildlabel.add(ltime);
                ptime.add(lswingtime);
//        attchildlabel.add(lswingtime);

                lday = new JLabel("Day :");
                lday.setForeground(Color.white);
                lday.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
                lday.setBounds(550, 100, 300, 50);
                
                lswingday = new JLabel();
                lswingday.setForeground(Color.WHITE);
                lswingday.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
                lswingday.setBounds(650, 100, 300, 50);
                attchildlabel.add(lday);
                pday.add(lswingday);
//        attchildlabel.add(lswingday);

                ldate = new JLabel("Date :");
                ldate.setForeground(Color.white);
                ldate.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
                ldate.setBounds(970, 100, 300, 50);
                
                lswingdate = new JLabel();
                lswingdate.setForeground(Color.WHITE);
                lswingdate.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
                lswingdate.setBounds(1090, 100, 300, 50);
                attchildlabel.add(ldate);
                pdate.add(lswingdate);
//        attchildlabel.add(lswingdate);

                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        timeFormat = new SimpleDateFormat("hh:mm:ss a");
                        attendancetime = timeFormat.format(Calendar.getInstance().getTime());
                        lswingtime.setText(attendancetime);
                        
                        dayFormat = new SimpleDateFormat("EEEE");
                        attendanceday = dayFormat.format(Calendar.getInstance().getTime());
                        lswingday.setText(attendanceday);
                        
                        dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        attendancedate = dateFormat.format(Calendar.getInstance().getTime());
                        lswingdate.setText(attendancedate);
                    }
                    
                });
                timer.start();
            }
            
        });
        p1.add(b2);
        
        p3 = new JPanel();
        p3.setBackground(Color.white);
        p3.setBounds(0, 483, 230, 5);
        p1.add(p3);
        
        leavepanel = new JPanel();
        leavepanel.setVisible(false);
        leavepanel.setBounds(230, 0, 1700, 990);
        leavepanel.setBackground(new Color(86, 88, 188));
        leavepanel.setLayout(null);
        f.add(leavepanel);
        
        leavechildpanel = new JPanel();
        leavechildpanel.setBounds(0, 90, 1700, 820);
        leavechildpanel.setBackground(new Color(0, 0, 57));
        leavechildpanel.setLayout(null);
        leavepanel.add(leavechildpanel);
        
        b3 = new JButton("Apply Leave");
        b3.setBorder(null);
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b3.setBackground(new Color(33, 109, 150));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b3.setBackground(new Color(23, 35, 51));
            }
        });
        b3.setBounds(0, 490, 230, 70);
        b3.setForeground(Color.white);
        b3.setFont(new Font("serif", Font.ROMAN_BASELINE, 30));
        b3.setFocusable(false);
        b3.setBackground(new Color(23, 35, 51));
        b3.setVisible(true);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                notpanel.setVisible(false);
                mainpanel.setVisible(false);
                attendancelabel.setVisible(false);
                leavepanel.setVisible(true);
                
                leaveemp = new JLabel("EMP ID :- ");
                leaveemp.setForeground(Color.WHITE);
                leaveemp.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
                leaveemp.setBounds(120, 100, 150, 70);
                leavechildpanel.add(leaveemp);
                
                JTextField t1emp = new RoundJTextField(20);
                t1emp.setText(emp_id);
                t1emp.setHorizontalAlignment(JTextField.CENTER);
                t1emp.setBounds(300, 110, 250, 50);
                t1emp.setEditable(false);
                t1emp.setBackground(Color.white);
                t1emp.setForeground(Color.BLACK);
                t1emp.setFont(new Font("solaris-2", Font.BOLD, 30));
                t1emp.setBorder(new LineBorder(Color.WHITE, 3, true));
                t1emp.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        t1emp.setBorder(new LineBorder(Color.cyan, 3, true));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                       t1emp.setBorder(new LineBorder(Color.WHITE, 3, true));
                    }
                });
                leavechildpanel.add(t1emp);
                
                
                
                leaveemail = new JLabel("EMAIL :- ");
                leaveemail.setForeground(Color.WHITE);
                leaveemail.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
                leaveemail.setBounds(720, 100, 150, 70);
                leavechildpanel.add(leaveemail);
                
                JTextField t1email = new RoundJTextField(20);
                t1email.setText(email);
                t1email.setHorizontalAlignment(JTextField.CENTER);
                t1email.setBounds(900, 110, 350, 50);
                t1email.setEditable(false);
                t1email.setBackground(Color.WHITE);
                t1email.setForeground(Color.BLACK);
                t1email.setFont(new Font("solaris-2", Font.BOLD, 30));
                t1email.setBorder(new LineBorder(Color.WHITE, 3, true));
                t1email.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        t1email.setBorder(new LineBorder(Color.cyan, 3, true));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                       t1email.setBorder(new LineBorder(Color.WHITE, 3, true));
                    }
                });
                leavechildpanel.add(t1email);
                
                ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/default_profile.png"));
                Image i1 = i10.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
                ImageIcon i11 = new ImageIcon(i1);
                leaveprofile = new JLabel(i11);
                leaveprofile.setBounds(1300, 200, 300, 300);
                leaveprofile.setBackground(Color.yellow);
                leavechildpanel.add(leaveprofile);
                
                try {
                    conn c2 = new conn();
                    String st = "Select profileimage from employee where emp_id='101'";
                    ResultSet rs = c2.s.executeQuery(st);
                    if (rs.next()) {
                        imagedata = rs.getBytes("profileimage");
                        String imad = rs.getString("profileimage");
                        if (imad.equals("null")) {
                            leaveprofile.setIcon(i11);
                        } else {
                            ImageIcon ime = new ImageIcon(imagedata);
                            Image mm = ime.getImage();
                            Image img2 = mm.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                            ImageIcon image = new ImageIcon(img2);
                           leaveprofile.setIcon(image);
                        }
                    }
                    
                } catch (SQLException ex) {
                    
                }
                
                
                
                leavesdate = new JLabel("From :- ");
                leavesdate.setForeground(Color.WHITE);
                leavesdate.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
                leavesdate.setBounds(120, 220, 150, 70);
                leavechildpanel.add(leavesdate);

//                ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/default_profile.png"));
//        Image i1 = i10.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
//        ImageIcon i11 = new ImageIcon(i1);
                JDateChooser sdateChooser = new JDateChooser();
                JTextFieldDateEditor editor = (JTextFieldDateEditor) sdateChooser.getDateEditor();
                editor.setEditable(false);
                sdateChooser.setBounds(300, 230, 250, 50); 
                sdateChooser.setBackground(new Color(0, 0, 57));
                sdateChooser.setForeground(Color.WHITE);
                sdateChooser.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
                sdateChooser.setBorder(new LineBorder(Color.WHITE, 3, true));
                sdateChooser.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        sdateChooser.setBorder(new LineBorder(Color.cyan, 3, true));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                       sdateChooser.setBorder(new LineBorder(Color.WHITE, 3, true));
                    }
                });
//                sdateChooser.setIcon(i11);
                leavechildpanel.add(sdateChooser);
                
                leaveedate = new JLabel("To :- ");
                leaveedate.setForeground(Color.WHITE);
                leaveedate.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
                leaveedate.setBounds(720, 220, 150, 70);
                leavechildpanel.add(leaveedate);
                
                JDateChooser edateChooser = new JDateChooser();
                JTextFieldDateEditor editor1 = (JTextFieldDateEditor) edateChooser.getDateEditor();
                editor1.setEditable(false);
                edateChooser.setBounds(900, 230, 250, 50);
                edateChooser.setBackground(new Color(0, 0, 57));
                edateChooser.setForeground(Color.WHITE);
                edateChooser.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
                edateChooser.setBorder(new LineBorder(Color.WHITE, 3, true));
                edateChooser.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        edateChooser.setBorder(new LineBorder(Color.cyan, 3, true));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                       edateChooser.setBorder(new LineBorder(Color.WHITE, 3, true));
                    }
                });
                leavechildpanel.add(edateChooser);
                
                leavecatg = new JLabel("Select Category :-");
                leavecatg.setForeground(Color.WHITE);
                leavecatg.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
                leavecatg.setBounds(120, 350, 300, 70);
                leavechildpanel.add(leavecatg);
                
                othercatg=new JLabel("Other :");
                othercatg.setBounds(730, 350, 300, 50);
                othercatg.setVisible(false);
                othercatg.setForeground(Color.WHITE);
                othercatg.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
                leavechildpanel.add(othercatg);
                
                
                tcatg = new JTextField();
                tcatg.setBounds(880, 355, 300, 50);
                tcatg.setVisible(false);
                tcatg.setCaretColor(Color.white);
                tcatg.setBackground(new Color(0, 0, 57));
                tcatg.setForeground(Color.WHITE);
                tcatg.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
                tcatg.setBorder(new LineBorder(Color.WHITE, 3, true));
                tcatg.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        tcatg.setBorder(new LineBorder(Color.cyan, 3, true));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        tcatg.setBorder(new LineBorder(Color.WHITE, 3, true));
                    }
                });
                leavechildpanel.add(tcatg);
                
                String category[] = {"Medical Leave", "Casual Leave", "Maternity Leave", "other"};
                JComboBox cbcategory = new JComboBox(category);
                cbcategory.setBounds(400, 370, 200, 40);
                cbcategory.setBackground(new Color(0, 0, 57));
                cbcategory.setForeground(Color.WHITE);
                cbcategory.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
                cbcategory.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (cbcategory.getSelectedIndex() == 3) {
                            othercatg.setVisible(true);
                            tcatg.setVisible(true);
                        } else {
                            othercatg.setVisible(false);
                            tcatg.setVisible(false);
                        }
                    }
                });
                leavechildpanel.add(cbcategory);
                
                leavesubject = new JLabel("Subject :");
                leavesubject.setForeground(Color.WHITE);
                leavesubject.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
                leavesubject.setBounds(120, 460, 300, 70);
                leavechildpanel.add(leavesubject);
                
                tsubj = new JTextArea();
                tsubj.setBounds(300, 465, 800, 70);
                tsubj.setCaretColor(Color.white);
                tsubj.setLineWrap(true);
                tsubj.setWrapStyleWord(true);
                tsubj.setBackground(new Color(0, 0, 57));
                tsubj.setForeground(Color.WHITE);
                tsubj.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
                tsubj.setBorder(new LineBorder(Color.WHITE, 3, true));
                tsubj.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        tsubj.setBorder(new LineBorder(Color.cyan, 3, true));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        tsubj.setBorder(new LineBorder(Color.WHITE, 3, true));
                    }
                });
                leavechildpanel.add(tsubj);
                
                leavedesc = new JLabel("Description :");                
                leavedesc.setForeground(Color.WHITE);
                leavedesc.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
                leavedesc.setBounds(120, 650, 300, 50);
                leavechildpanel.add(leavedesc);
                
                tdesc = new JTextArea();
                tdesc.setBounds(340, 580, 550, 200);
                tdesc.setLineWrap(true);
                tdesc.setCaretColor(Color.WHITE);
                tdesc.setBackground(new Color(0, 0, 57));
                tdesc.setForeground(Color.WHITE);
                tdesc.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
                tdesc.setBorder(new LineBorder(Color.WHITE, 3, true));
                tdesc.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        tdesc.setBorder(new LineBorder(Color.cyan, 3, true));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        tdesc.setBorder(new LineBorder(Color.WHITE, 3, true));
                    }
                });
//                leavechildpanel.add(tdesc);
                
                jsp=new JScrollPane(tdesc,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                jsp.setBounds(340, 580, 550, 200);
                leavechildpanel.add(jsp);
                ImageIcon appl = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/leaveapply.png"));
                applyleave=new JButton(appl);
                applyleave.setBounds(1250,700 , 200, 80);
                applyleave.setBackground(new Color(0, 0, 57));
                applyleave.setFocusPainted(false);
                applyleave.setBorder(null);
                applyleave.setContentAreaFilled(false);
                applyleave.setFocusable(false);
               applyleave.addMouseListener(new MouseAdapter() {
                    
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/leaveapply1.png"));
                        applyleave.setIcon(i13);
                    }
                    
                    @Override
                    public void mouseClicked(MouseEvent e){
                        ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/leaveapply2.png"));
                        applyleave.setIcon(i14);
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                        
                        applyleave.setIcon(appl);
                    }
                    
                });
               applyleave.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            if(sdateChooser.getDate()==null|| edateChooser.getDate()==null||tsubj.getText()==null||tdesc.getText()==null){
                                JOptionPane.showMessageDialog(null, "Required");
                            }
                            else{
                            conn c2=new conn();
                            dateFormat=new SimpleDateFormat("dd-MMM-yyyy");
                            String s=dateFormat.format(sdateChooser.getDate());
                            String e=dateFormat.format(edateChooser.getDate());
                            String q="Insert into eleave values('"+emp_id+"','"+email+"','"+s+"','"+e+"','"+tdesc.getText()+"','"+tsubj.getText()+"','"+cbcategory.getSelectedItem()+"','Pending')";
                            c2.s.executeUpdate(q);
                            JOptionPane.showMessageDialog(null, "Request Send Successfully");
                            new Userinterface().f.setVisible(true);
                     f.setVisible(false);
                     f.dispose();
                            }
                        }
                        catch(Exception e){
                            
                        }
                    }
                });
                leavechildpanel.add(applyleave);
                
            }
        });
        
        p1.add(b3);
        
        p5 = new JPanel();
        p5.setBackground(Color.white);
        p5.setBounds(0, 563, 230, 5);
        p1.add(p5);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/default_profile.png"));
        Image i1 = i10.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i11 = new ImageIcon(i1);
        lprofile = new JLabel(i11);
        lprofile.setBounds(1300, 100, 300, 300);
        lprofile.setBackground(Color.yellow);
        upperpanel.add(lprofile);
        
        try {
            conn c2 = new conn();
            String st = "Select profileimage from employee where emp_id='101'";
            ResultSet rs = c2.s.executeQuery(st);
            if (rs.next()) {
                imagedata = rs.getBytes("profileimage");
                String imad = rs.getString("profileimage");
                if (imad.equals("null")) {
                    lprofile.setIcon(i11);
                } else {
                    ImageIcon ime = new ImageIcon(imagedata);
                    Image mm = ime.getImage();
                    Image img2 = mm.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    ImageIcon image = new ImageIcon(img2);
                    lprofile.setIcon(image);
                }
            }
            
        } catch (SQLException ex) {
            
        }
        
        ImageIcon ip = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/addprofile1.png"));
        addprofileb = new JButton(ip);
        addprofileb.setBounds(1250, 430, 200, 40);
        addprofileb.setVisible(false);
        addprofileb.setBackground(new Color(0, 0, 57));
        addprofileb.setFocusPainted(false);
        addprofileb.setBorder(null);
        addprofileb.setContentAreaFilled(false);
        addprofileb.setFocusable(false);
        addprofileb.addMouseListener(new MouseAdapter() {
            
            public void mouseEntered(MouseEvent e) {
                ImageIcon ip1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/addprofile.png"));
                addprofileb.setIcon(ip1);
            }
            
            public void mouseExited(MouseEvent e) {
                addprofileb.setIcon(ip);
            }
        });
        addprofileb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser chooser = new JFileChooser();
                chooser.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter fnw = new FileNameExtensionFilter("png jpg jpeg", "png", "jpg", "jpeg");
                chooser.addChoosableFileFilter(fnw);
                chooser.showOpenDialog(null);
                
                f1 = chooser.getSelectedFile();
                path = f1.getAbsolutePath();
                Image getAbsolutepath = null;
                ImageIcon icon = new ImageIcon(path);
                Image image = icon.getImage().getScaledInstance(lprofile.getWidth(), lprofile.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon1 = new ImageIcon(image);
                lprofile.setIcon(icon1);
                
                ImageIcon is = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/saveinfo.png"));
                saveprofileb = new JButton(is);
                saveprofileb.setBounds(1470, 430, 180, 50);
                saveprofileb.setVisible(true);
                saveprofileb.setBackground(new Color(0, 0, 57));
                saveprofileb.setFocusPainted(false);
                saveprofileb.setBorder(null);
                saveprofileb.setContentAreaFilled(false);
                saveprofileb.setFocusable(false);
                saveprofileb.addMouseListener(new MouseAdapter() {
                    
                    public void mouseEntered(MouseEvent e) {
                        ImageIcon is1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/saveinfo1.png"));
                        saveprofileb.setIcon(is1);
                    }
                    
                    public void mouseExited(MouseEvent e) {
                        saveprofileb.setIcon(is);
                    }
                });
                saveprofileb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            
                            File f = new File(path);
                            InputStream is = new FileInputStream(f);
                            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                            String mysqlUrl = "jdbc:mysql://localhost/emp";
                            Connection con = DriverManager.getConnection(mysqlUrl, "root", "khalil95944");
                            PreparedStatement psmt = con.prepareStatement("update employee set profileimage=? where emp_id='101'");
                            psmt.setBinaryStream(1, is, (int) (f.length()));
                            int n = psmt.executeUpdate();
                            if (n > 0) {
                                JOptionPane.showMessageDialog(null, "successfull");
                            }
                            saveprofileb.setVisible(false);
//                    
                        } catch (Exception ex) {
                            
                            
                        }
                    }
                });
                upperpanel.add(saveprofileb);
            }
        });
        upperpanel.add(addprofileb);
        
        lname = new JLabel("First Name :");
        lname.setForeground(Color.white);
        lname.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        lname.setBounds(80, 100, 300, 50);
        
        rsname = new JLabel(name.toUpperCase());
        rsname.setForeground(Color.WHITE);
        rsname.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rsname.setBounds(280, 100, 150, 50);
        upperpanel.add(lname);
        upperpanel.add(rsname);
        
        lfname = new JLabel("Last Name :");
        lfname.setForeground(Color.white);
        lfname.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        lfname.setBounds(500, 100, 300, 50);
        
        rsfname = new JLabel(father.toUpperCase());
        rsfname.setForeground(Color.WHITE);
        rsfname.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rsfname.setBounds(700, 100, 150, 50);
        upperpanel.add(lfname);
        upperpanel.add(rsfname);

//        lempid=new JLabel("EMP ID : ");
//        lempid.setForeground(Color.black);        
//        lempid.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE,30));
//        lempid.setBounds(1000,130,160,50);
//        
//        rsempid=new JLabel(emp_id);
//        rsempid.setForeground(Color.black);        
//        rsempid.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD,35));
//        rsempid.setBounds(1170,130,100,50);
        lemail = new JLabel("EMAIL : ");
        lemail.setForeground(Color.WHITE);
        lemail.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        lemail.setBounds(80, 200, 160, 50);
        
        rsemail = new JLabel(email);
        rsemail.setForeground(Color.WHITE);
        rsemail.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rsemail.setBounds(230, 200, 800, 50);
        upperpanel.add(lemail);
        upperpanel.add(rsemail);
        
        ldob = new JLabel("DOB : ");
        ldob.setForeground(Color.WHITE);
        ldob.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        ldob.setBounds(80, 300, 300, 50);
        
        rsdob = new JLabel(dob);
        rsdob.setForeground(Color.WHITE);
        rsdob.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rsdob.setBounds(230, 300, 400, 50);
        upperpanel.add(ldob);
        upperpanel.add(rsdob);
        
        leducation = new JLabel("EDUCATION : ");
        leducation.setForeground(Color.WHITE);
        leducation.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        leducation.setBounds(80, 400, 240, 50);
        
        rseducation = new JLabel(education.toUpperCase());
        rseducation.setForeground(Color.WHITE);
        rseducation.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rseducation.setBounds(290, 400, 400, 50);
        upperpanel.add(leducation);
        upperpanel.add(rseducation);
        
        lpost = new JLabel("POST : ");
        lpost.setForeground(Color.WHITE);
        lpost.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        lpost.setBounds(80, 500, 160, 50);
        
        rspost = new JLabel(post.toUpperCase());
        rspost.setForeground(Color.WHITE);
        rspost.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rspost.setBounds(230, 500, 500, 50);
        upperpanel.add(lpost);
        upperpanel.add(rspost);
        
        lphoneno = new JLabel("CONTACT NO. : ");
        lphoneno.setForeground(Color.WHITE);
        lphoneno.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        lphoneno.setBounds(80, 600, 280, 50);
        
        rsphoneno = new JLabel(phone);
        rsphoneno.setForeground(Color.WHITE);
        rsphoneno.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rsphoneno.setBounds(320, 600, 250, 50);
        upperpanel.add(lphoneno);
        upperpanel.add(rsphoneno);
        
        ImageIcon i15 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/updatebutton.png"));
        updateb = new JButton(i15);
        updateb.setVisible(true);
        updateb.setBounds(200, 750, 200, 50);
        updateb.setBackground(new Color(0, 0, 57));
        updateb.setFocusPainted(false);
        updateb.setBorder(null);
        updateb.setContentAreaFilled(false);
        updateb.setFocusable(false);
        updateb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon i16 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/updatebutton1.png"));
                updateb.setIcon(i16);
            }
            
            public void mouseExited(MouseEvent e) {
                updateb.setIcon(i15);
            }
        });
        updateb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                leavepanel.setVisible(false);
                addprofileb.setVisible(true);
                
                updateb.setVisible(false);
                rsname.setVisible(false);
                rsfname.setVisible(false);
                rsemail.setVisible(false);
                rsdob.setVisible(false);
                rsphoneno.setVisible(false);
                
                tname = new JTextField(name);
                tname.setBounds(280, 110, 180, 40);
                tname.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
                upperpanel.add(tname);
                
                tfname = new JTextField(father);
                tfname.setBounds(700, 110, 180, 40);
                tfname.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
                upperpanel.add(tfname);
                
                temail = new JTextField(email);
                temail.setBounds(230, 210, 300, 40);
                temail.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
                upperpanel.add(temail);
                
                tdob = new JTextField(dob);
                tdob.setBounds(230, 310, 180, 40);
                tdob.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
                upperpanel.add(tdob);
                
                tphoneno = new JTextField(phone);
                tphoneno.setBounds(320, 610, 250, 40);
                tphoneno.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
                upperpanel.add(tphoneno);
                
                ImageIcon i18 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/saveinfo.png"));
                saveb = new JButton(i18);
                saveb.setVisible(true);
                saveb.setBounds(250, 750, 180, 50);
                saveb.setBackground(new Color(0, 0, 57));
                saveb.setFocusPainted(false);
                saveb.setBorder(null);
                saveb.setContentAreaFilled(false);
                saveb.setFocusable(false);
                saveb.addMouseListener((new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        ImageIcon i19 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/saveinfo1.png"));
                        saveb.setIcon(i19);
                    }
                    
                    public void mouseExited(MouseEvent e) {
                        saveb.setIcon(i18);
                    }
                }));
                saveb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Stname = tname.getText();
                        Stfname = tfname.getText();
                        Stemail = temail.getText();
                        Stdob = tdob.getText();
                        Stphoneno = tphoneno.getText();
                        
                        try {
                            conn savecon = new conn();
                            String save = "Update employee set name='" + Stname + "',fname='" + Stfname + "',email='" + Stemail + "',dob='" + Stdob + "',phone='" + Stphoneno + "' where emp_id='101'";
                            savecon.s.executeUpdate(save);
                            JOptionPane.showMessageDialog(null, "Updated Succesfully");
                            cancelb.setVisible(false);
                            saveb.setVisible(false);
                            tname.setVisible(false);
                            tfname.setVisible(false);
                            tdob.setVisible(false);
                            temail.setVisible(false);
                            tphoneno.setVisible(false);
                            
                            rsname.setVisible(true);
                            rsfname.setVisible(true);
                            rsemail.setVisible(true);
                            rsdob.setVisible(true);
                            rsphoneno.setVisible(true);
                            updateb.setVisible(true);
                            f.setVisible(false);
                            new Userinterface();
                            
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "mehnat barbad");
                        }
                    }
                });
                upperpanel.add(saveb);
                
                ImageIcon i110 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/Cancelinfo.png"));
                cancelb = new JButton(i110);
                cancelb.setVisible(true);
                cancelb.setBounds(400, 750, 180, 50);
                cancelb.setBackground(new Color(0, 0, 57));
                cancelb.setFocusPainted(false);
                cancelb.setBorder(null);
                cancelb.setContentAreaFilled(false);
                cancelb.setFocusable(false);
                cancelb.addMouseListener((new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        ImageIcon i111 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/Cancelinfo1.png"));
                        cancelb.setIcon(i111);
                    }
                    
                    public void mouseExited(MouseEvent e) {
                        cancelb.setIcon(i110);
                    }
                }));
                cancelb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        addprofileb.setVisible(false);
                        
                        cancelb.setVisible(false);
                        saveb.setVisible(false);
                        tname.setVisible(false);
                        tfname.setVisible(false);
                        tdob.setVisible(false);
                        temail.setVisible(false);
                        tphoneno.setVisible(false);
                        
                        rsname.setVisible(true);
                        rsfname.setVisible(true);
                        rsemail.setVisible(true);
                        rsdob.setVisible(true);
                        rsphoneno.setVisible(true);
                        updateb.setVisible(true);
                        
                    }
                });
                upperpanel.add(cancelb);
                
            }
        });
        upperpanel.add(updateb);
        
        //Center Panel for Profile
        notpanel = new JPanel();
        notpanel.setVisible(false);
        notpanel.setBounds(230, 0, 1700, 990);
        notpanel.setBackground(new Color(86, 88, 188));
        notpanel.setLayout(null);
        f.add(notpanel);
        
        notchildpanel = new JPanel();
        notchildpanel.setVisible(true);
        notchildpanel.setBounds(0, 90, 1700, 820);
        notchildpanel.setBackground(new Color(0, 0, 57));
        notchildpanel.setLayout(null);
        notpanel.add(notchildpanel);
        
        JLabel lmsg=new JLabel();
        lmsg.setVisible(false);
        lmsg.setBounds(30, 50, 1500, 70);
        lmsg.setFont(new Font("solaris-2",Font.BOLD,30));
        lmsg.setForeground(Color.WHITE);
        notchildpanel.add(lmsg);
        

        JButton b6=new JButton("Seen");
        b6.setBounds(100,600, 50,50);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               try{
                   conn c=new conn();
                   String s="Update salary set status='seen' where emp_id='101'";
                   c.s.executeUpdate(s);
                   JOptionPane.showMessageDialog(null, "Done");
               }catch(Exception e){
                   
               }
            }
        });
        notchildpanel.add(b6);
        
          try{
                 conn c=new conn();
                 String q="Select * from salary where emp_id='101'";
                 String q1 = "Select * from eleave where emp_id='107' and  status1='unseen' and status='approved' or 'denied'";
                 ResultSet rss=c.s.executeQuery(q1);
                 ResultSet rs=c.s.executeQuery(q);
                 if(rs.next() || rss.next()){

                 String query="Select * from salary where emp_id='101' and status='unseen' limit 3";
                 ResultSet rs1=c.s.executeQuery(query);
                 while(rs1.next()){
                      sal=rs1.getString("salary");
                      salarr=sal.split("\n");
                      String sdate=rs1.getString("checkin_date");
                     String edate=rs1.getString("checkout_date");
                     sarr=sdate.split("\n");
                      earr=edate.split("\n");
                     
                      
            JLabel[] labels = new JLabel[salarr.length];
            for (int i = 0; i < salarr.length; i++){
                labels[i] = new JLabel();
                labels[i].setBounds(50,v,1500,70);
                labels[i].setText(b+". "+"  Your Salary from  "+ sarr[i]+"  to  "+earr[i]+ "  is  "+salarr[i]);
                labels[i].setFont(new Font("solaris-2",Font.ROMAN_BASELINE,30));
                labels[i].setForeground(new Color(255,255,255));
                notchildpanel.add(labels[i]);
                v=v+100;
                b++;
            }
                 
                 }
                 
                 String query1 = "Select * from eleave where emp_id='107' and  status1='unseen' and status='approved' or 'denied' limit 1 ";
                        ResultSet rs2 = c.s.executeQuery(query1);
                  while (rs2.next()) {
                            String catg = rs2.getString("category");
                            arrcatg = catg.split("\n");
                            String sdate = rs2.getString("sdate");
                            sdatearr = sdate.split("\n");
                            String edate = rs2.getString("edate");
                            edatearr = edate.split("\n");
                            String status = rs2.getString("status");
                            arrstatus = status.split("\n");

                            
                            JLabel[] labels1 = new JLabel[arrcatg.length];
                            for (int i = 0; i < arrcatg.length; i++) {
                                labels1[i] = new JLabel();
                                labels1[i].setBounds(50, x, 1500, 70);
                                labels1[i].setText(" -- " + "  Your Leave Application of " + arrcatg[i] + " from " + sdatearr[i] + " to " + edatearr[i] + " is " + arrstatus[i]);
                                labels1[i].setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 30));
                                labels1[i].setForeground(new Color(255, 255, 255));
                                notchildpanel.add(labels1[i]);
                                x = x + 100;
                               
                            }

                        }
                 
                 
                 }else{
                    
                 }
             }
                 
             catch(Exception e){
                 
             }
        
        b4 = new JButton("Notifications");
        b4.setBorder(null);
        b4.setBackground(new Color(23, 35, 51));
        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b4.setBackground(new Color(86, 88, 188));
              
            }
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                b4.setBackground(new Color(86, 88, 188));
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b4.setBackground(new Color(23, 35, 51));
            }
            
        });
        b4.setBounds(0, 570, 230, 70);
        b4.setForeground(Color.white);
        b4.setFont(new Font("serif", Font.ROMAN_BASELINE, 30));
        b4.setFocusable(false);
        b4.setVisible(true);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                mainpanel.setVisible(false);
                leavepanel.setVisible(false);
                attendancelabel.setVisible(false);
             notpanel.setVisible(true);
             
           
            
            }
        });
        p1.add(b4);
        
                 try{
            conn p=new conn();
           String query="Select * from salary where emp_id='101' and status='unseen'";
           ResultSet st=p.s.executeQuery(query);
           if(!st.next()){ 
              not.setVisible(false);
              b4.setBounds(0, 570, 230, 70);
           }else{
               b4.setBounds(0, 570, 200, 70);
               not.setVisible(true);
           }
            
        }catch(Exception e){
            
        }
                 try{
            conn p = new conn();
             String q1="Select * from eleave where emp_id='107' and status1='unseen'";
            ResultSet st1=p.s.executeQuery(q1);
            if(!st1.next()){
                not.setVisible(false);
                b4.setBounds(0, 570, 230, 70);
            } else {
                b4.setBounds(0, 570, 200, 70);
                not.setVisible(true);
            }
        }catch(Exception e){
            
        }
        
        JPanel p6 = new JPanel();
        p6.setBackground(Color.white);
        p6.setBounds(0, 643, 230, 5);
        p1.add(p6);
        
        ImageIcon ilogout = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/logout.png"));
        logout=new JButton();
        logout.setIcon(ilogout);
        logout.setBounds(10,850,200,100);
        logout.setBackground(new Color(0, 0, 57));
        logout.setFocusPainted(false);
        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.setFocusable(false);
        logout.addMouseListener(new MouseAdapter(){
            
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon ilogout1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/logout1.png"));
                logout.setIcon(ilogout1);
            }
             @Override
            public void mouseExited(MouseEvent e) {
                logout.setIcon(ilogout);
            }
        });
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               new user().f.setVisible(true);
               f.setVisible(false);
               f.dispose();
            }
        });
        p1.add(logout);
        
        
        f.setSize(1920 + 25, 1080);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);
        
        f.setVisible(true);
        
    }
    
    public static void main(String[] args) {
        Userinterface ui = new Userinterface();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
}
