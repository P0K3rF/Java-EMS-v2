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
import java.sql.ResultSet;
import java.util.Map;
import java.awt.font.TextAttribute;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Admin_manageattendance implements ActionListener {

    JFrame f;
    JPanel p1;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, lrole, lsalpd, lsalpd1, ldeduc, ldeduc1;
    JTable table;
    JButton b1, bs, cb, clear, send, backb;
    JTextField t1, t2, tsal, tsalpd, tdeduc, trole;
    DefaultTableModel dtm;
    JDateChooser edateChooser, sdateChooser;
    SimpleDateFormat dateFormat;
    String sal, email, name;
    String s, e;
    int i = 0;
    Date date, date1;

    Admin_manageattendance() {

        f = new JFrame("Admin attendance");
        f.setBackground(Color.BLUE);
        f.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/manageattbg.jpg"));
        Image img1 = i1.getImage().getScaledInstance(1945, 1080, Image.SCALE_DEFAULT);
        ImageIcon i11 = new ImageIcon(img1);
        l1 = new JLabel(i11);
        l1.setBounds(0, 0, 1945, 1080);
        l1.setLayout(null);
        f.add(l1);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/admin_addemployee1.jpg"));
        Image img2 = i2.getImage().getScaledInstance(1945, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(img2);
        l2 = new JLabel(i3);
        l2.setBounds(100, 50, 1600, 900);
        l2.setLayout(null);
        l1.add(l2);

        l3 = new JLabel("EMPLOYEE ATTENDANCE");
        l3.setForeground(new Color(0, 255, 254));
        l3.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 35));
        l3.setBounds(60, 50, 450, 70);
        Font font1 = l3.getFont();
        Map attributes1 = font1.getAttributes();
        attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        l3.setFont(font1.deriveFont(attributes1));
        l2.add(l3);

        String columns[] = {"Emp_Id", "Checkin_Time", "Checkin_Date", "Checkout_Time", "Checkout_Date"};
        dtm = new DefaultTableModel(columns, 0);

        try {
            conn c10 = new conn();
            String query = "SELECT * FROM attendance";
            ResultSet res = c10.s.executeQuery(query);
            while (res.next()) {
                String id = res.getString("emp_id");
                String intime = res.getString("chenkin_time");
                String indate = res.getString("checkin_date");
                String outtime = res.getString("checkout_time");
                String outdate = res.getString("checkout_date");
                dtm.addRow(new Object[]{id, intime, indate, outtime, outdate});
            }
        } catch (Exception e) {

        }
        table = new JTable();
        table.setModel(dtm);
        table.setEnabled(false);
        table.setPreferredScrollableViewportSize(new Dimension(500, 50));
        table.setFillsViewportHeight(true);
        table.getTableHeader().setPreferredSize(new Dimension(100, 50));
        table.getTableHeader().setFont(new Font("solaris-2", Font.BOLD, 20));
        table.getTableHeader().setBackground(new Color(18, 140, 226));
        table.getTableHeader().setForeground(new Color(255, 255, 255));
        table.setRowHeight(50);
        table.setBackground(new Color(204, 255, 255));
        table.setFont(new Font("solrais-2", Font.ROMAN_BASELINE, 20));
        table.setForeground(new Color(0, 0, 0));
        JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(50, 150, 795, 600);
        l2.add(jsp);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/refresh.png"));
        b1 = new JButton();
        b1.setIcon(i4);
        b1.setBounds(670, 780, 160, 70);
        b1.setFocusPainted(false);
        b1.setBorder(null);
        b1.setContentAreaFilled(false);
        b1.setFocusable(false);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/refresh1.png"));
                b1.setIcon(i21);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b1.setIcon(i4);
            }

        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                f.setVisible(false);
                f.dispose();
                new Admin_manageattendance().f.setVisible(true);
            }
        });
        l2.add(b1);

        JPanel p2 = new JPanel();
        p2.setBackground(new Color(255, 255, 255));
        p2.setBounds(890, 5, 10, 890);
        l2.add(p2);

        p1 = new JPanel();
        p1.setBackground(new Color(0, 0, 50));
        p1.setBounds(900, 0, 700, 900);
        p1.setLayout(null);
        l2.add(p1);

        //calculate label
        JLabel cal = new JLabel("CALCULATE SALARY");
        cal.setForeground(new Color(0, 255, 254));
        cal.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 35));
        cal.setBounds(60, 50, 500, 80);
        Font font2 = cal.getFont();
        Map attributes2 = font2.getAttributes();
        attributes2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        cal.setFont(font2.deriveFont(attributes2));
        p1.add(cal);

        //emp_id label
        JLabel lemp = new JLabel("Emp Id :");
        lemp.setBounds(30, 150, 150, 70);
        lemp.setForeground(new Color(255, 255, 255));
        lemp.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 30));
        p1.add(lemp);

        //Emp_id Texrfiled + label
        t1 = new RoundJTextField(20);
        t1.setBounds(180, 160, 200, 50);
        t1.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 30));
        t1.setForeground(Color.BLACK);
        p1.add(t1);

        lrole = new JLabel("Role     :");
        lrole.setBounds(30, 240, 150, 79);
        lrole.setForeground(new Color(255, 255, 255));
        lrole.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 30));
        p1.add(lrole);

        trole = new RoundJTextField(20);
        trole.setBounds(180, 250, 300, 50);
        trole.setHorizontalAlignment(JTextField.CENTER);
        trole.setBorder(new LineBorder(Color.WHITE, 3, true));
        trole.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 30));
        trole.setForeground(Color.BLACK);
        trole.setEditable(false);
        p1.add(trole);

        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/search.png"));
        bs = new JButton();
        bs.setIcon(i5);
        bs.setBounds(390, 160, 70, 50);
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
                bs.setIcon(i5);
            }
        });
        bs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    conn c5 = new conn();
                    String qp = "Select * from employee where emp_id='" + t1.getText() + "'";
                    ResultSet rs1 = c5.s.executeQuery(qp);
                    if (rs1.next()) {

                        String post = rs1.getString("post");
                        name = rs1.getString("name");
                        email = rs1.getString("email");
                        trole.setText(post);
                    }

                } catch (Exception se) {

                }

                String columns[] = {"Emp_Id", "Checkin_Time", "Checkin_Date", "Checkout_Time", "Checkout_Date"};
                DefaultTableModel dtm1 = new DefaultTableModel(columns, 0);
                try {
                    conn c10 = new conn();
                    String query = "SELECT * FROM attendance where emp_id='" + t1.getText() + "'";
                    ResultSet res1 = c10.s.executeQuery(query);

                    if (t1.getText().isEmpty()) {

                        table.setModel(dtm);
                        JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
                        send.setVisible(false);
                        clear.setVisible(false);
                        sdateChooser.setCalendar(null);
                        edateChooser.setCalendar(null);
                        l4.setVisible(false);
                        l5.setVisible(false);
                        l6.setVisible(false);
                        l7.setVisible(false);
                        l8.setVisible(false);
                        clear.setVisible(false);
                        tsal.setVisible(false);
                    } else if (!res1.next()) {
                        JOptionPane.showMessageDialog(null, "No Data Found");
                        table.setModel(dtm);
                        JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
                    } else {

                        do {
                            String id = res1.getString("emp_id");
                            String intime = res1.getString("chenkin_time");
                            String indate = res1.getString("checkin_date");
                            String outtime = res1.getString("checkout_time");
                            String outdate = res1.getString("checkout_date");
                            dtm1.addRow(new Object[]{id, intime, indate, outtime, outdate});
                        } while (res1.next());
                        table.setModel(dtm1);
                        JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);

                    }

                } catch (Exception e) {

                }

            }
        });
        p1.add(bs);

        //Select Date
        JLabel lsd = new JLabel("Select Date :");
        lsd.setBounds(30, 340, 400, 70);
        lsd.setFont(new Font("solaris-s", Font.ROMAN_BASELINE, 30));
        lsd.setForeground(new Color(255, 255, 255));
        p1.add(lsd);

        //jdatechooser starting
        JLabel slabel = new JLabel("From   :");
        slabel.setBounds(100, 410, 150, 70);
        slabel.setForeground(new Color(255, 255, 255));
        slabel.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 30));
        p1.add(slabel);

        sdateChooser = new JDateChooser();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) sdateChooser.getDateEditor();
        editor.setEditable(false);
        sdateChooser.setBounds(240, 420, 250, 50);
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
        p1.add(sdateChooser);

        //edate chooser label
        JLabel elabel = new JLabel("To       :");
        elabel.setBounds(100, 500, 150, 70);
        elabel.setForeground(new Color(255, 255, 255));
        elabel.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 30));
        p1.add(elabel);
        //Jdatechooser for ending
        edateChooser = new JDateChooser();
        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) edateChooser.getDateEditor();
        editor1.setEditable(false);
        edateChooser.setBounds(240, 510, 250, 50);
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
        p1.add(edateChooser);

        lsalpd = new JLabel("Salary  :");
        lsalpd.setBounds(30, 595, 150, 70);
        lsalpd.setForeground(new Color(255, 255, 255));
        lsalpd.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 30));
        p1.add(lsalpd);

        lsalpd1 = new JLabel("(per day)");
        lsalpd1.setBounds(40, 625, 150, 70);
        lsalpd1.setForeground(new Color(255, 255, 255));
        lsalpd1.setFont(new Font("solaris-2", Font.ITALIC, 15));
        p1.add(lsalpd1);

        tsalpd = new RoundJTextField(20);
        tsalpd.setBounds(160, 610, 150, 50);
        tsalpd.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 30));
        tsalpd.setForeground(Color.BLACK);
        p1.add(tsalpd);

        ldeduc = new JLabel("Deduction :");
        ldeduc.setBounds(350, 595, 200, 70);
        ldeduc.setForeground(new Color(255, 255, 255));
        ldeduc.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 30));
        p1.add(ldeduc);

        ldeduc1 = new JLabel("(overall)");
        ldeduc1.setBounds(390, 625, 150, 70);
        ldeduc1.setForeground(new Color(255, 255, 255));
        ldeduc1.setFont(new Font("solaris-2", Font.ITALIC, 15));
        p1.add(ldeduc1);

        tdeduc = new RoundJTextField(20);
        tdeduc.setBounds(520, 610, 150, 50);
        tdeduc.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 30));
        tdeduc.setForeground(Color.BLACK);
        p1.add(tdeduc);

        l4 = new JLabel("Your salary between");
        l4.setVisible(false);
        l4.setBounds(30, 750, 360, 70);
        l4.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 25));
        l4.setForeground(new Color(255, 255, 255));
        p1.add(l4);

        l5 = new JLabel();
        l5.setVisible(false);
        l5.setBounds(275, 751, 200, 70);
        l5.setFont(new Font("solaris-s", Font.BOLD, 25));
        l5.setForeground(new Color(255, 255, 255));
        p1.add(l5);

        l6 = new JLabel("to");
        l6.setVisible(false);
        l6.setBounds(440, 750, 200, 70);
        l6.setFont(new Font("solaris-s", Font.ROMAN_BASELINE, 25));
        l6.setForeground(new Color(255, 255, 255));
        p1.add(l6);

        l7 = new JLabel();
        l7.setVisible(false);
        l7.setBounds(475, 751, 200, 70);
        l7.setFont(new Font("solaris-s", Font.BOLD, 25));
        l7.setForeground(new Color(255, 255, 255));
        p1.add(l7);

        l8 = new JLabel("is :");
        l8.setVisible(false);
        l8.setBounds(640, 750, 200, 70);
        l8.setFont(new Font("solaris-s", Font.ROMAN_BASELINE, 25));
        l8.setForeground(new Color(255, 255, 255));
        p1.add(l8);

        tsal = new RoundJTextField(20);
        tsal.setVisible(false);
        tsal.setBounds(270, 830, 200, 50);
        tsal.setHorizontalAlignment(JTextField.CENTER);
        tsal.setBorder(new LineBorder(Color.WHITE, 3, true));
        tsal.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 30));
        tsal.setForeground(Color.BLACK);
        tsal.setEditable(false);
        p1.add(tsal);

        //Clear button
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/clear.png"));
        clear = new JButton();
        clear.setVisible(false);
        clear.setIcon(i10);
        clear.setBounds(30, 820, 150, 70);
        clear.setFocusPainted(false);
        clear.setBorder(null);
        clear.setContentAreaFilled(false);
        clear.setFocusable(false);
        clear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clear.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon i211 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/clear1.png"));
                clear.setIcon(i211);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                clear.setIcon(i10);
            }

        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clear.setVisible(false);
                send.setVisible(false);
                t1.setText("");
                trole.setText("");
                tsalpd.setText("");
                tdeduc.setText("");
                sdateChooser.setCalendar(null);
                edateChooser.setCalendar(null);
                l4.setVisible(false);
                l5.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                l8.setVisible(false);
                clear.setVisible(false);
                tsal.setVisible(false);

            }
        });
        p1.add(clear);

        //Send Button
        ImageIcon i61 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/send.png"));
        send = new JButton();
        send.setVisible(false);
        send.setIcon(i61);
        send.setBounds(510, 820, 150, 70);
        send.setFocusPainted(false);
        send.setBorder(null);
        send.setContentAreaFilled(false);
        send.setFocusable(false);
        send.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        send.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon i211 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/send1.png"));
                send.setIcon(i211);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                send.setIcon(i61);
            }

        });
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (t1.getText().isEmpty() || date == null || date1 == null || tsalpd.getText().isEmpty() || tdeduc.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "fill Every Field");
                    } else {

                        conn c = new conn();
                        String send = "Insert into salary values('" + t1.getText() + "','" + s + "','" + e + "','" + tsal.getText() + "','unseen')";
                        c.s.executeUpdate(send);

                        try {

                            String host = "smtp.gmail.com";
                            String user = "employeemanagementsystem12@gmail.com";
                            String pass = "khalil95944";
                            String touser = email;
                            String subject = "Salary";
                            String message = "Hi " + name + " Your salary Fron " + s + " to " + e + " is : " + sal;
                            boolean sessionDebug = false;
                            Properties pros = System.getProperties();
                            pros.put("mail.smtp.starttls.enable", "true");
                            pros.put("mail.smtp.host", "host");
                            pros.put("mail.smtp.port", "587");
                            pros.put("mail.smtp.auth", "true");
                            pros.put("mail.smtp.ssl.trust", "smtp.gmail.com");
                            pros.put("mail.smtp.starttls.required", "true");
                            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                            Session mailSession = Session.getDefaultInstance(pros, null);
                            mailSession.setDebug(sessionDebug);
                            Message msg = new MimeMessage(mailSession);

                            msg.setFrom(new InternetAddress(user));
                            InternetAddress[] address = {new InternetAddress(touser)};
                            msg.setRecipients(Message.RecipientType.TO, address);
                            msg.setSubject(subject);
                            msg.setText(message);
                            Transport transport = mailSession.getTransport("smtp");
                            transport.connect(host, user, pass);
                            transport.sendMessage(msg, msg.getAllRecipients());
                            transport.close();
                            JOptionPane.showMessageDialog(null, "Salary receipt sent successfully");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        }

                        new Admin_manageattendance().f.setVisible(true);
                        f.setVisible(false);
                        f.dispose();
                    }
                } catch (Exception send) {

                }
            }
        });
        p1.add(send);

        //calculate button
        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/calculate.png"));
        cb = new JButton();
        cb.setIcon(i6);
        cb.setBounds(250, 685, 180, 70);
        cb.setFocusPainted(false);
        cb.setBorder(null);
        cb.setContentAreaFilled(false);
        cb.setFocusable(false);
        cb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cb.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/calculate1.png"));
                cb.setIcon(i21);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                cb.setIcon(i6);
            }

        });
        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    date = sdateChooser.getDate();
                    date1 = edateChooser.getDate();
                    if (t1.getText().isEmpty() || date == null || date1 == null || tsalpd.getText().isEmpty() || tdeduc.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "fill Every Field");
                    } else {

                        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        s = dateFormat.format(sdateChooser.getDate());
                        e = dateFormat.format(edateChooser.getDate());

                        conn c1 = new conn();
                        String p = "Select * from attendance where emp_id='" + t1.getText() + "'";
                        ResultSet res = c1.s.executeQuery(p);
                        if (res.next()) {
//                            String query = "select '" + tsalpd.getText() + "'-'" + tdeduc.getText() + "'*(count(emp_id)) as salary from attendance where emp_id='" + t1.getText() + "' and checkout_date between '" + s + "' and '" + e + "'";
                            String query = "select '" + tsalpd.getText() + "'*(count(emp_id))-'" + tdeduc.getText() + "' as salary from attendance where emp_id='" + t1.getText() + "' and checkout_date between '" + s + "' and '" + e + "'";
                            ResultSet rs = c1.s.executeQuery(query);
                            if (rs.next()) {
                                sal = rs.getString("salary");
                                l4.setVisible(true);
                                l5.setVisible(true);
                                l6.setVisible(true);
                                l7.setVisible(true);
                                l8.setVisible(true);
                                tsal.setVisible(true);
                                tsal.setText(sal);
                                l5.setText(s);
                                l7.setText(e);
                                clear.setVisible(true);
                                send.setVisible(true);

                            } else {
                                JOptionPane.showMessageDialog(null, "Data Not Found");
                                cb.setVisible(true);
                                tsal.setVisible(false);
                                l4.setVisible(false);
                                l5.setVisible(false);
                                l6.setVisible(false);
                                l7.setVisible(false);
                                l8.setVisible(false);
                                clear.setVisible(false);
                                send.setVisible(false);
                            }
                        } else {
                            cb.setVisible(true);
                            JOptionPane.showMessageDialog(null, "Data Not Found");
                            l4.setVisible(false);
                            l5.setVisible(false);
                            l6.setVisible(false);
                            l7.setVisible(false);
                            l8.setVisible(false);
                            clear.setVisible(false);
                            tsal.setVisible(false);
                            send.setVisible(false);
                        }
                    }

                } catch (Exception be) {

                }
            }
        });
        p1.add(cb);

        ImageIcon iback = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/goback.png"));
        backb = new JButton();
        backb.setIcon(iback);
        backb.setBounds(1700, 900, 155, 70);
        backb.setBackground(new Color(0, 0, 57));
        backb.setFocusPainted(false);
        backb.setBorder(null);
        backb.setContentAreaFilled(false);
        backb.setFocusable(false);
        backb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
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

        f.setSize(1920 + 25, 1080);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        Admin_manageattendance am = new Admin_manageattendance();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }
}
