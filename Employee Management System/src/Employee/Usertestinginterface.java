package Employee;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
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
import java.util.Date;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Usertestinginterface {

    JFrame f;
    JLabel l1;
    JLabel dd1, dd2, dd3, dd4, dd5, dd6, dd7;
    SimpleDateFormat timeFormat, dayFormat, dateFormat;
    JLabel lname, lfname, lemail, lempid, ldob, leducation, lpost, lphoneno, rsname, rsfname, rsemail, rsempid, rsdob, rseducation, rspost, rsphoneno, lphoto,
            lupdate, lok, ltime, lswingtime, lday, lswingday, ldate, lswingdate, lopcheckin, lmarkatt, lprofile, lattprofile, leaveemp, leaveemail, leavesdate, leaveedate, leavesubject, leavedesc, leavecatg, othercatg, leaveprofile, lmsg, lmsg1, lmsg2;
    JPanel mainpanel, p1, p2, p3, p4, p5, p6, attendancelabel, upperpanel, attchildlabel, leavepanel, leavechildpanel, notpanel, notchildpanel;
    String emp_id, name, father, address, phone, email, education, post, age, dob, aadhar;
    JButton b1, b2, b3, b4, updateb, saveb, cancelb, checkinb, checkoutb, addprofileb, saveprofileb, applyleave, seenb, not, not1, not2, notrefb, notrefb1, logout;
    JTextField tname, tfname, temail, tdob, tphoneno, tcatg;
    JTextField t1emp, t1email;
    String Stname, Stfname, Stemail, Stdob, Stphoneno;
    String attendancetime, attendanceday, attendancedate;
    String DDate, Timelabel;
    String semmpid, inttime, inddate;
    String remaining;
    String sempid, intime, indate, outtime, outdate;
    JTextArea tsubj, tdesc;
    JScrollPane jsp;
    Border BevelRaised = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

    File f1 = null;
    String path;
    String fname = null;
    int s = 0;
    byte[] pimage = null;
    byte[] imagedata;

    String[] salarr = null;
    String[] sarr = null;
    String[] earr = null;
    JLabel[] labels, labels1;
    int v = 50;
    int x = 370;
    String sal;
    int b = 1;
    String[] arrcatg = null;
    String[] sdatearr = null;
    String[] edatearr = null;
    String[] arrstatus = null;
    String status, status1;

    Usertestinginterface(String e_id) {

        try {
            conn con = new conn();
            String str = "select * from employee where emp_id = '" + e_id + "'";
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
        } catch (SQLException e) {
        }

        f = new JFrame("User");
        f.setBackground(Color.BLUE);
        f.setLayout(null);

        //Side Master Panel
        p1 = new JPanel();
        p1.setBounds(0, 0, 230, 990);
        p1.setBackground(new Color(23, 35, 51));
        p1.setLayout(null);
        f.add(p1);

        //Adding lines betweens side panel button
        p4 = new JPanel();
        p4.setBackground(Color.white);
        p4.setBounds(0, 323, 230, 5);
        p1.add(p4);

        //Creating Profile button in sidepanel 
        b1 = new JButton("Profile");
        b1.setBorder(null);
        b1.setBackground(new Color(23, 35, 51));
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                mainpanel.setVisible(true);
                attendancelabel.setVisible(false);
                leavepanel.setVisible(false);
                notpanel.setVisible(false);
            }
        });
        p1.add(b1);

        //Creating Main Panel for Profile 
        mainpanel = new JPanel();
        mainpanel.setBounds(230, 0, 1700, 990);
        mainpanel.setBackground(new Color(86, 88, 188));
        mainpanel.setLayout(null);
        f.add(mainpanel);

        //Creating Child Panel for profile
        upperpanel = new JPanel();
        upperpanel.setBounds(0, 90, 1700, 820);
        upperpanel.setBackground(new Color(0, 0, 57));
        upperpanel.setLayout(null);
        mainpanel.add(upperpanel);

        //Adding components in Profile child Panel
        lname = new JLabel("First Name ");
        lname.setForeground(Color.white);
        lname.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        lname.setBounds(80, 100, 300, 50);

        dd1 = new JLabel(":");
        dd1.setForeground(Color.WHITE);
        dd1.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd1.setBounds(270, 100, 20, 50);

        rsname = new JLabel(name.toUpperCase());
        rsname.setForeground(Color.WHITE);
        rsname.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rsname.setBounds(310, 100, 150, 50);
        upperpanel.add(lname);
        upperpanel.add(rsname);
        upperpanel.add(dd1);

        lfname = new JLabel("Last Name :");
        lfname.setForeground(Color.white);
        lfname.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        lfname.setBounds(700, 100, 300, 50);

        rsfname = new JLabel(father.toUpperCase());
        rsfname.setForeground(Color.WHITE);
        rsfname.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rsfname.setBounds(890, 100, 150, 50);
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
        lemail = new JLabel("Email");
        lemail.setForeground(Color.WHITE);
        lemail.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        lemail.setBounds(80, 200, 160, 50);

        dd2 = new JLabel(":");
        dd2.setForeground(Color.WHITE);
        dd2.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd2.setBounds(270, 200, 20, 50);

        rsemail = new JLabel(email);
        rsemail.setForeground(Color.WHITE);
        rsemail.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rsemail.setBounds(310, 200, 800, 50);
        upperpanel.add(lemail);
        upperpanel.add(dd2);
        upperpanel.add(rsemail);

        ldob = new JLabel("Dob");
        ldob.setForeground(Color.WHITE);
        ldob.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        ldob.setBounds(80, 300, 300, 50);

        dd3 = new JLabel(":");
        dd3.setForeground(Color.WHITE);
        dd3.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd3.setBounds(270, 300, 20, 50);

        rsdob = new JLabel(dob);
        rsdob.setForeground(Color.WHITE);
        rsdob.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rsdob.setBounds(310, 300, 400, 50);
        upperpanel.add(ldob);
        upperpanel.add(dd3);
        upperpanel.add(rsdob);

        leducation = new JLabel("Education");
        leducation.setForeground(Color.WHITE);
        leducation.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        leducation.setBounds(80, 400, 240, 50);

        dd4 = new JLabel(":");
        dd4.setForeground(Color.WHITE);
        dd4.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd4.setBounds(270, 400, 20, 50);

        rseducation = new JLabel(education.toUpperCase());
        rseducation.setForeground(Color.WHITE);
        rseducation.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rseducation.setBounds(310, 400, 400, 50);
        upperpanel.add(leducation);
        upperpanel.add(dd4);
        upperpanel.add(rseducation);

        lpost = new JLabel("Post");
        lpost.setForeground(Color.WHITE);
        lpost.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        lpost.setBounds(80, 500, 160, 50);

        dd5 = new JLabel(":");
        dd5.setForeground(Color.WHITE);
        dd5.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd5.setBounds(270, 500, 20, 50);

        rspost = new JLabel(post.toUpperCase());
        rspost.setForeground(Color.WHITE);
        rspost.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rspost.setBounds(310, 500, 500, 50);
        upperpanel.add(lpost);
        upperpanel.add(dd5);
        upperpanel.add(rspost);

        lphoneno = new JLabel("Contact No.");
        lphoneno.setForeground(Color.WHITE);
        lphoneno.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        lphoneno.setBounds(80, 600, 280, 50);

        dd6 = new JLabel(":");
        dd6.setForeground(Color.WHITE);
        dd6.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd6.setBounds(270, 600, 20, 50);

        rsphoneno = new JLabel(phone);
        rsphoneno.setForeground(Color.WHITE);
        rsphoneno.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        rsphoneno.setBounds(310, 600, 250, 50);
        upperpanel.add(lphoneno);
        upperpanel.add(dd6);
        upperpanel.add(rsphoneno);

        //Adding Profile image label on left side 
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/default_profile.png"));
        Image i1 = i10.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i11 = new ImageIcon(i1);
        lprofile = new JLabel(i11);
        lprofile.setBorder(BevelRaised);
        lprofile.setBounds(1400, 50, 250, 250);
        lprofile.setBackground(Color.yellow);
        upperpanel.add(lprofile);

        try {
            conn c2 = new conn();
            String st = "Select profileimage from employee where emp_id='" + emp_id + "'";
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

        //Adding buttons under profile label to upload photo which will get trigger after clicking on update button
        ImageIcon is = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/saveinfo.png"));
        saveprofileb = new JButton(is);
        saveprofileb.setBounds(1510, 335, 180, 50);
        saveprofileb.setVisible(false);
        saveprofileb.setBackground(new Color(0, 0, 57));
        saveprofileb.setFocusPainted(false);
        saveprofileb.setBorder(null);
        saveprofileb.setContentAreaFilled(false);
        saveprofileb.setFocusable(false);
        saveprofileb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                    PreparedStatement psmt = con.prepareStatement("update employee set profileimage=? where emp_id='" + emp_id + "'");
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

        ImageIcon ip = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/addprofile1.png"));
        addprofileb = new JButton(ip);
        addprofileb.setBounds(1320, 340, 200, 40);
        addprofileb.setVisible(false);
        addprofileb.setBackground(new Color(0, 0, 57));
        addprofileb.setFocusPainted(false);
        addprofileb.setBorder(null);
        addprofileb.setContentAreaFilled(false);
        addprofileb.setFocusable(false);
        addprofileb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                saveprofileb.setVisible(true);

            }
        });
        upperpanel.add(addprofileb);

        //Adding Update Button in Profile Panel
        ImageIcon i15 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/updatebutton.png"));
        updateb = new JButton(i15);
        updateb.setVisible(true);
        updateb.setBounds(200, 750, 200, 50);
        updateb.setBackground(new Color(0, 0, 57));
        updateb.setFocusPainted(false);
        updateb.setBorder(null);
        updateb.setContentAreaFilled(false);
        updateb.setFocusable(false);
        updateb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                addprofileb.setVisible(true);

                updateb.setVisible(false);
                rsname.setVisible(false);
                rsfname.setVisible(false);
                rsemail.setVisible(false);
                rsdob.setVisible(false);
                rsphoneno.setVisible(false);

                tname = new JTextField(name);
                tname.setBounds(310, 110, 180, 40);
                tname.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
                upperpanel.add(tname);

                tfname = new JTextField(father);
                tfname.setBounds(890, 110, 180, 40);
                tfname.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
                upperpanel.add(tfname);

                temail = new JTextField(email);
                temail.setBounds(310, 210, 300, 40);
                temail.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
                upperpanel.add(temail);

                tdob = new JTextField(dob);
                tdob.setBounds(310, 310, 180, 40);
                tdob.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
                upperpanel.add(tdob);

                tphoneno = new JTextField(phone);
                tphoneno.setBounds(310, 610, 250, 40);
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
                saveb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                            String save = "Update employee set name='" + Stname + "',fname='" + Stfname + "',email='" + Stemail + "',dob='" + Stdob + "',phone='" + Stphoneno + "' where emp_id='" + emp_id + "'";
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
                            new Usertestinginterface(emp_id).f.setVisible(true);

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
                cancelb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                        saveprofileb.setVisible(false);

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

        //Creating attendance button in side panel
        b2 = new JButton("Attendance");
        b2.setBorder(null);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b2.setBackground(new Color(86, 88, 188));
            }

            public void mouseClicked(MouseEvent e) {
                b2.setBackground(new Color(86, 88, 188));
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
                leavepanel.setVisible(false);
                mainpanel.setVisible(false);
                notpanel.setVisible(false);
                attendancelabel.setVisible(true);

                //Declaring date and time to insert in database 
                LocalDate myDateObj = LocalDate.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                DDate = myDateObj.format(myFormatObj);

                LocalTime myTimelabel = LocalTime.now();
                DateTimeFormatter myTimelabelFormatObj = DateTimeFormatter.ofPattern("hh:mm:ss a");
                Timelabel = myTimelabel.format(myTimelabelFormatObj);

                //Creating a method which checks wheter user is logged in or not
                try {
                    conn c1 = new conn();
                    String ntr = "Select * from attendance where emp_id='" + emp_id + "' AND checkin_date='" + DDate + "'";
                    ResultSet crs = c1.s.executeQuery(ntr);

                    if (crs.next()) {
                        semmpid = crs.getString("emp_id");
                        inttime = crs.getString("chenkin_time");
                        inddate = crs.getString("checkin_date");
                        if (semmpid.equals(emp_id) && inddate.equals(DDate)) {
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

                //Created a thread for time
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

        //Adding divider between buttons in side panel
        p2 = new JPanel();
        p2.setBackground(Color.white);
        p2.setBounds(0, 403, 230, 5);
        p1.add(p2);

        //Creating Main Panel for Attendance
        attendancelabel = new JPanel();
        attendancelabel.setVisible(false);
        attendancelabel.setBounds(230, 0, 1700, 990);
        attendancelabel.setBackground(new Color(86, 88, 188));
        attendancelabel.setLayout(null);
        f.add(attendancelabel);

        //Creating Child Panel in Attendance to hold components
        attchildlabel = new JPanel();
        attchildlabel.setBounds(0, 90, 1700, 820);
        attchildlabel.setBackground(new Color(0, 0, 57));
        attchildlabel.setLayout(null);
        attendancelabel.add(attchildlabel);

        //Adding Time components
        ltime = new JLabel("Time :");
        ltime.setForeground(Color.white);
        ltime.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        ltime.setBounds(80, 100, 300, 50);

        JPanel ptime = new JPanel();
        ptime.setBounds(200, 100, 250, 50);
        ptime.setBackground(new Color(0, 0, 0));
        attchildlabel.add(ptime);

        lswingtime = new JLabel();
        lswingtime.setForeground(Color.WHITE);
        lswingtime.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        lswingtime.setBounds(200, 100, 200, 50);
        attchildlabel.add(ltime);
        ptime.add(lswingtime);

        //Adding Day components
        lday = new JLabel("Day :");
        lday.setForeground(Color.white);
        lday.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        lday.setBounds(550, 100, 300, 50);

        JPanel pday = new JPanel();
        pday.setBounds(650, 100, 250, 50);
        pday.setBackground(new Color(0, 0, 0));
        attchildlabel.add(pday);

        lswingday = new JLabel();
        lswingday.setForeground(Color.WHITE);
        lswingday.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        lswingday.setBounds(650, 100, 300, 50);
        attchildlabel.add(lday);
        pday.add(lswingday);

        //Adding Date components
        ldate = new JLabel("Date :");
        ldate.setForeground(Color.white);
        ldate.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        ldate.setBounds(970, 100, 300, 50);

        JPanel pdate = new JPanel();
        pdate.setBounds(1090, 100, 250, 50);
        pdate.setBackground(new Color(0, 0, 0));
        attchildlabel.add(pdate);

        lswingdate = new JLabel();
        lswingdate.setForeground(Color.WHITE);
        lswingdate.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        lswingdate.setBounds(1090, 100, 300, 50);
        attchildlabel.add(ldate);
        pdate.add(lswingdate);

        //Adding "Mark Attendance " Label in Attendance Panel
        lmarkatt = new JLabel();
        lmarkatt.setText("Mark Your Attendance :");
        lmarkatt.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 35));
        lmarkatt.setForeground(Color.WHITE);
        lmarkatt.setBounds(80, 300, 600, 60);
        attchildlabel.add(lmarkatt);

        BevelRaised = BorderFactory.createBevelBorder(BevelBorder.LOWERED);
        //Adding Profile Photo in Attendance panel
        ImageIcon attp = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/default_profile.png"));
        Image i2 = attp.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon attp1 = new ImageIcon(i2);
        lattprofile = new JLabel(attp1);
        lattprofile.setBounds(1400, 50, 250, 250);
        lattprofile.setBorder(BevelRaised);
        lattprofile.setBackground(Color.yellow);
        attchildlabel.add(lattprofile);

        try {
            conn c2 = new conn();
            String st = "Select profileimage from employee where emp_id='" + emp_id + "'";
            ResultSet rs = c2.s.executeQuery(st);
            if (rs.next()) {
                imagedata = rs.getBytes("profileimage");
                String imad = rs.getString("profileimage");
                if (imad.equals("null")) {
                    lattprofile.setIcon(attp);
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

        //Creating Label to display when user has already checked in 
        lopcheckin = new JLabel();
        lopcheckin.setBounds(200, 400, 600, 50);
        lopcheckin.setForeground(Color.WHITE);
        attchildlabel.add(lopcheckin);

        //Creating a checkinbutton
        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/checkin.png"));
        checkinb = new JButton(i12);
        checkinb.setBounds(200, 400, 230, 100);
        checkinb.setBackground(new Color(0, 0, 57));
        checkinb.setFocusPainted(false);
        checkinb.setBorder(null);
        checkinb.setContentAreaFilled(false);
        checkinb.setFocusable(false);
        checkinb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                    String q = "insert into attendance values('" + emp_id + "','" + Time + "',STR_TO_DATE('" + Date + "','%d-%b-%Y'),'null',NULL,'null')";
                    cc.s.executeUpdate(q);
                    lopcheckin.setText("You are logged in at " + Timelabel);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        });
        checkinb.setVisible(false);
        attchildlabel.add(checkinb);

        //Creating a checkout Button
        ImageIcon i114 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/checkout.png"));
        checkoutb = new JButton(i114);
        checkoutb.setBounds(500, 400, 230, 100);
        checkoutb.setBackground(new Color(0, 0, 57));
        checkoutb.setFocusPainted(false);
        checkoutb.setBorder(null);
        checkoutb.setContentAreaFilled(false);
        checkoutb.setFocusable(false);
        checkoutb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                LocalDate myDateObj1 = LocalDate.now();
                DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String Date1 = myDateObj1.format(myFormatObj1);
                LocalTime myTimeObj = LocalTime.now();
                DateTimeFormatter myTimeFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
                String Time = myTimeObj.format(myTimeFormatObj);
                try {
                    conn c1 = new conn();
                    String str = "Select * from attendance where emp_id='" + emp_id + "'";
                    ResultSet rs = c1.s.executeQuery(str);

                    while (rs.next()) {
                        sempid = rs.getString("emp_id");
                        intime = rs.getString("chenkin_time");
                        indate = rs.getString("checkin_date");
                        outtime = rs.getString("checkout_time");
                        outdate = rs.getString("checkout_date");

                    }
                    if (sempid.equals(emp_id) && Date1.equals(indate)) {
                        if (sempid.equals(emp_id) && outtime.equals("null")) {
                            conn cc = new conn();
                            String q = "update attendance SET checkout_time='" + Time + "',checkout_date=STR_TO_DATE('" + Date + "','%d-%b-%Y') where emp_id='" + emp_id + "' AND checkout_time='null' AND checkin_date=STR_TO_DATE('" + Date + "','%d-%b-%Y')";
                            cc.s.executeUpdate(q);
                            JOptionPane.showMessageDialog(null, "Checkout Succesfull");
                            String d = "select chenkin_time,checkout_time,(34.25*(checkout_time-chenkin_time)) as remainng_time from attendance where emp_id='" + emp_id + "'";
                            ResultSet pq = cc.s.executeQuery(d);
                            while (pq.next()) {

                                remaining = pq.getString("remainng_time");
                            }
                            String sp = "update attendance SET salary='" + remaining + "' where emp_id='" + emp_id + "' AND salary='null'";
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

        //Adding divider in buttons
        p3 = new JPanel();
        p3.setBackground(Color.white);
        p3.setBounds(0, 483, 230, 5);
        p1.add(p3);

        //Adding Leave Button in side panel
        b3 = new JButton("Apply Leave");
        b3.setBorder(null);
        b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b3.setBackground(new Color(86, 88, 188));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                b3.setBackground(new Color(86, 88, 188));
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
                mainpanel.setVisible(false);
                attendancelabel.setVisible(false);
                notpanel.setVisible(false);
                leavepanel.setVisible(true);

                try {

                } catch (Exception e) {

                }
            }
        });
        p1.add(b3);

        //Adding Main Panel for Leave 
        leavepanel = new JPanel();
        leavepanel.setVisible(false);
        leavepanel.setBounds(230, 0, 1700, 990);
        leavepanel.setBackground(new Color(86, 88, 188));
        leavepanel.setLayout(null);
        f.add(leavepanel);

        //Adding child Panel in Leave
        leavechildpanel = new JPanel();
        leavechildpanel.setBounds(0, 90, 1700, 820);
        leavechildpanel.setBackground(new Color(0, 0, 57));
        leavechildpanel.setLayout(null);
        leavepanel.add(leavechildpanel);

        //Adding Emp and Email Non editable Textfield with respective labels
        leaveemp = new JLabel("EMP ID :- ");
        leaveemp.setForeground(Color.WHITE);
        leaveemp.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        leaveemp.setBounds(120, 100, 150, 70);
        leavechildpanel.add(leaveemp);

        t1emp = new RoundJTextField(20);
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

        t1email = new RoundJTextField(20);
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

        //Adding Profile image in Leave
        ImageIcon leavep = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/default_profile.png"));
        Image i3 = leavep.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon leavep1 = new ImageIcon(i3);
        leaveprofile = new JLabel(leavep1);
        leaveprofile.setBorder(BevelRaised);
        leaveprofile.setBounds(1400, 50, 250, 250);
        leaveprofile.setBackground(Color.yellow);
        leavechildpanel.add(leaveprofile);

        try {
            conn c2 = new conn();
            String st = "Select profileimage from employee where emp_id='" + emp_id + "'";
            ResultSet rs = c2.s.executeQuery(st);
            if (rs.next()) {
                imagedata = rs.getBytes("profileimage");
                String imad = rs.getString("profileimage");
                if (imad.equals("null")) {
                    leaveprofile.setIcon(leavep1);
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

        //Adding From and To Date with respective labels
        leavesdate = new JLabel("From :- ");
        leavesdate.setForeground(Color.WHITE);
        leavesdate.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        leavesdate.setBounds(120, 220, 150, 70);
        leavechildpanel.add(leavesdate);

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

        //Adding category component in Label
        leavecatg = new JLabel("Select Category :-");
        leavecatg.setForeground(Color.WHITE);
        leavecatg.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        leavecatg.setBounds(120, 350, 300, 70);
        leavechildpanel.add(leavecatg);

        othercatg = new JLabel("Other :");
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

        //Adding a ComboBox
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
                    tcatg.setText("");
                    tcatg.setVisible(false);
                }
            }
        });
        leavechildpanel.add(cbcategory);

        //Adding a TextArea for subject and description with respective labels
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

        //Adding a Scrollable pane for Descriptopn
        jsp = new JScrollPane(tdesc, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBounds(340, 580, 550, 200);
        leavechildpanel.add(jsp);

        //Adding "APPLY" button in Leave Panel
        ImageIcon appl = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/leaveapply.png"));
        applyleave = new JButton(appl);
        applyleave.setBounds(1250, 700, 200, 80);
        applyleave.setBackground(new Color(0, 0, 57));
        applyleave.setFocusPainted(false);
        applyleave.setBorder(null);
        applyleave.setContentAreaFilled(false);
        applyleave.setFocusable(false);
        applyleave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        applyleave.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/leaveapply1.png"));
                applyleave.setIcon(i13);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/leaveapply2.png"));
                applyleave.setIcon(i14);
            }

            @Override
            public void mousePressed(MouseEvent e) {
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
                    Date d = sdateChooser.getDate();
                    Date d1 = edateChooser.getDate();
                    if (d == null || d1 == null || tsubj.getText().isEmpty() || tdesc.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Required");
                    } else {
                        conn c2 = new conn();
                        dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                        String s = dateFormat.format(sdateChooser.getDate());
                        String e = dateFormat.format(edateChooser.getDate());
                        String q = "Insert into eleave values('" + t1emp.getText() + "','" + email + "','" + s + "','" + e + "','" + tdesc.getText() + "','" + tsubj.getText() + "','" + cbcategory.getSelectedItem() + ' ' + tcatg.getText() + "','Pending','unseen')";
                        c2.s.executeUpdate(q);
                        JOptionPane.showMessageDialog(null, "Request Send Successfully");
                        new Usertestinginterface(emp_id).f.setVisible(true);
                        f.setVisible(false);
                        f.dispose();
                    }
                } catch (Exception e) {

                }
            }
        });
        leavechildpanel.add(applyleave);

        //Adding divider after leave buttons
        p5 = new JPanel();
        p5.setBackground(Color.white);
        p5.setBounds(0, 563, 230, 5);
        p1.add(p5);

        //Adding a back panel and main panel for notification
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

        //Adding a label in notification panel
        lmsg = new JLabel("NOTHING TO SEE HERE");
        lmsg.setVisible(false);
        lmsg.setBounds(500, 400, 700, 90);
        lmsg.setFont(new Font("solaris-2", Font.ITALIC, 40));
        lmsg.setForeground(Color.WHITE);
        notchildpanel.add(lmsg);

        ImageIcon iref = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/refresh.png"));
        notrefb = new JButton();
        notrefb.setVisible(false);
        notrefb.setIcon(iref);
        notrefb.setBounds(1000, 410, 160, 70);
        notrefb.setFocusPainted(false);
        notrefb.setBorder(null);
        notrefb.setContentAreaFilled(false);
        notrefb.setFocusable(false);
        notrefb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        notrefb.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/refresh1.png"));
                notrefb.setIcon(i21);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                notrefb.setIcon(iref);
            }

        });
        notrefb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Usertestinginterface(emp_id).f.setVisible(true);
                f.setVisible(false);
                f.dispose();

            }
        });
        notchildpanel.add(notrefb);

        lmsg2 = new JLabel();
        lmsg2.setVisible(false);
        lmsg2.setBounds(30, 200, 1500, 70);
        lmsg2.setFont(new Font("solaris-2", Font.BOLD, 30));
        lmsg2.setForeground(Color.WHITE);
        notchildpanel.add(lmsg2);

        //Adding a mark see button
        ImageIcon mar = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/markread.png"));
        seenb = new JButton();
        seenb.setIcon(mar);
        seenb.setVisible(false);
        seenb.setBounds(1300, 700, 188, 60);
        seenb.setBackground(new Color(0, 0, 57));
        seenb.setFocusPainted(false);
        seenb.setBorder(null);
        seenb.setContentAreaFilled(false);
        seenb.setFocusable(false);
        seenb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        seenb.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                ImageIcon mar1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/markread1.png"));
                seenb.setIcon(mar1);
            }

            public void mouseExited(MouseEvent e) {
                seenb.setIcon(mar);
            }
        });
        seenb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    conn c = new conn();
                    String s = "Update salary set status='seen' where emp_id='" + emp_id + "'";
                    String s1 = "Update eleave set status1='seen' where emp_id='" + emp_id + "'";
                    c.s.executeUpdate(s);
                    c.s.executeUpdate(s1);
                    new Usertestinginterface(emp_id).f.setVisible(true);
                    f.setVisible(false);
                    f.dispose();
                } catch (Exception e) {

                }
            }
        });
        notchildpanel.add(seenb);

        //Adding a notification button
        b4 = new JButton("Notifications");
        b4.setBorder(null);
        b4.setBackground(new Color(23, 35, 51));
        b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                attendancelabel.setVisible(false);
                leavepanel.setVisible(false);
                notpanel.setVisible(true);

            }
        });
        p1.add(b4);

        ImageIcon i124 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/notification1.png"));
        not1 = new JButton();
        not1.setIcon(i124);
        not1.setVisible(false);
        not1.setBounds(200, 570, 30, 30);
        not1.setBackground(new Color(0, 0, 57));
        not1.setFocusPainted(false);
        not1.setBorder(null);
        not1.setContentAreaFilled(false);
        not1.setFocusable(false);
        p1.add(not1);

        //Adding notification alert button
        ImageIcon i123 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/notification.png"));
        not = new JButton();
        not.setIcon(i123);
        not.setVisible(false);
        not.setBounds(200, 570, 30, 30);
        not.setBackground(new Color(0, 0, 57));
        not.setFocusPainted(false);
        not.setBorder(null);
        not.setContentAreaFilled(false);
        not.setFocusable(false);
        p1.add(not);

        try {
            conn p10 = new conn();
            String q10 = "Select * from salary where emp_id='" + emp_id + "' and status='unseen'";
            ResultSet st = p10.s.executeQuery(q10);
            if (st.next()) {
                not.setVisible(true);
                b4.setBounds(0, 570, 200, 70);

            } else {
                not.setVisible(false);
                b4.setBounds(0, 570, 230, 70);
                try {
                    conn p = new conn();
                    String q1 = "Select * from eleave where emp_id='" + emp_id + "' and status1='unseen' and status!='Pending'";
                    ResultSet st1 = p.s.executeQuery(q1);
                    if (st1.next()) {
                        b4.setBounds(0, 570, 200, 70);
                        not1.setVisible(true);

                    } else {
                        not1.setVisible(false);
                        b4.setBounds(0, 570, 230, 70);

                    }
                } catch (Exception e) {

                }
            }

        } catch (Exception e) {

        }

        //Adding a referest notification button
        try {
            conn c9 = new conn();
            String q = "Select * from salary where emp_id='" + emp_id + "' and status='unseen'";
            ResultSet qs = c9.s.executeQuery(q);
            if (qs.next()) {

                notrefb.setVisible(false);
                lmsg.setVisible(false);
            } else {

                try {
                    conn c91 = new conn();
                    String q9 = "Select * from eleave where emp_id='" + emp_id + "' and status1='unseen'";
                    ResultSet qs1 = c91.s.executeQuery(q9);
                    if (qs1.next()) {

                        notrefb.setVisible(false);
                        lmsg.setVisible(false);
                    } else {

                        notrefb.setVisible(true);
                        lmsg.setVisible(true);
                    }
                } catch (Exception e) {

                }
            }

        } catch (Exception e) {

        }

        try {
            conn c = new conn();
            String q = "Select * from salary where emp_id='" + emp_id + "' and status='unseen'";
            ResultSet rs = c.s.executeQuery(q);
            if (rs.next()) {
                String query = "Select * from salary where emp_id='" + emp_id + "' and status='unseen' limit 3";
                ResultSet rs1 = c.s.executeQuery(query);
                while (rs1.next()) {
                    sal = rs1.getString("salary");
                    salarr = sal.split("\n");
                    String sdate = rs1.getString("s_date");
                    String edate = rs1.getString("e_date");
                    sarr = sdate.split("\n");
                    earr = edate.split("\n");
                    seenb.setVisible(true);

                    JLabel[] labels = new JLabel[salarr.length];
                    for (int i = 0; i < salarr.length; i++) {
                        labels[i] = new JLabel();
                        labels[i].setBounds(50, v, 1500, 70);
                        labels[i].setText(b + ". " + "  Your Salary from  " + sarr[i] + "  to  " + earr[i] + "  is  " + salarr[i]);
                        labels[i].setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 30));
                        labels[i].setForeground(new Color(255, 255, 255));
                        notchildpanel.add(labels[i]);
                        v = v + 100;
                        b++;
                    }

                }
            } else {

            }

        } catch (Exception e) {

        }

        try {
            conn c1 = new conn();
            String q1 = "Select * from eleave where emp_id='" + emp_id + "' and  status1='unseen' and status!='Pending'";
            ResultSet rss = c1.s.executeQuery(q1);
            if (rss.next()) {
                String query1 = "Select * from eleave where emp_id='" + emp_id + "' and  status1='unseen' and status!='Pending' limit 3 ";
                ResultSet rs2 = c1.s.executeQuery(query1);
                while (rs2.next()) {
                    String catg = rs2.getString("category");
                    arrcatg = catg.split("\n");
                    String sdate = rs2.getString("sdate");
                    sdatearr = sdate.split("\n");
                    String edate = rs2.getString("edate");
                    edatearr = edate.split("\n");
                    String status = rs2.getString("status");
                    arrstatus = status.split("\n");
                    seenb.setVisible(true);

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
            } else {

            }

        } catch (Exception e) {

        }

        //Adding a last divider
        p6 = new JPanel();
        p6.setBackground(Color.white);
        p6.setBounds(0, 643, 230, 5);
        p1.add(p6);

        ImageIcon ilogout = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/logout.png"));
        logout = new JButton();
        logout.setIcon(ilogout);
        logout.setBounds(10, 850, 160, 60);
        logout.setBackground(new Color(0, 0, 57));
        logout.setFocusPainted(false);
        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.setFocusable(false);
        logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logout.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
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
                int a = JOptionPane.showConfirmDialog(null, "Do you really want to Logout", "select", JOptionPane.YES_NO_OPTION);
                if (a == 0) {
                    new user().f.setVisible(true);
                    f.setVisible(false);
                    f.dispose();
                }
            }
        });
        p1.add(logout);

        f.setSize(1920 + 25, 1080);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);

        f.setVisible(true);
    }

    public static void main(String[] args) {
        Usertestinginterface uti = new Usertestinginterface("");
    }
}
