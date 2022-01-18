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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Admin_manageleave implements ActionListener {

    JFrame f;
    JLabel l1, l2, l3;
    JLabel lid, lcat, lsubj, ldesc;
    JTextField t1, t2;
    JButton backb,appb,denyb;
    DefaultTableModel dtm;
    JTable table;
    JScrollPane jsp, jsp1,jsp2;
    JTextArea tsubj, tdesc;
    String Data2, Data3;
    String subj,desc,email;

    Admin_manageleave() {
        f = new JFrame("HomePage");
        f.setBackground(Color.BLUE);
        f.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/admin_addemployeebg.jpg"));
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
        l2.setBounds(100, 50, 1600, 870);
        l2.setLayout(null);
        l1.add(l2);

        l3 = new JLabel("MANAGE LEAVE");
        l3.setBounds(700, 30, 400, 60);
        l3.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 40));
        l3.setForeground(new Color(0, 255, 254));
        Font font1 = l3.getFont();
        Map attributes1 = font1.getAttributes();
        attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        l3.setFont(font1.deriveFont(attributes1));
        l2.add(l3);

        lid = new JLabel("Emp Id     :");
        lid.setBounds(900, 150, 200, 60);
        lid.setFont(new Font("solaris-2", Font.BOLD, 30));
        lid.setForeground(Color.WHITE);
        l2.add(lid);

        t1 = new RoundJTextField(20);
        t1.setBounds(1100, 155, 200, 50);
        t1.setHorizontalAlignment(JTextField.CENTER);
        t1.setBorder(new LineBorder(Color.WHITE, 3, true));
        t1.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 30));
        t1.setForeground(Color.BLACK);
        t1.setEditable(false);
        l2.add(t1);

        lcat = new JLabel("Category :");
        lcat.setBounds(900, 250, 200, 60);
        lcat.setFont(new Font("solaris-2", Font.BOLD, 30));
        lcat.setForeground(Color.WHITE);
        l2.add(lcat);

        //For Category
        t2 = new RoundJTextField(20);
        t2.setBounds(1100, 155, 200, 50);
        t2.setHorizontalAlignment(JTextField.CENTER);
        t2.setBorder(new LineBorder(Color.WHITE, 3, true));
        t2.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 30));
        t2.setForeground(Color.BLACK);
        t2.setEditable(false);
        l2.add(t2);

        //for subject
        lsubj = new JLabel("Subject  :");
        lsubj.setBounds(900, 380, 200, 60);
        lsubj.setFont(new Font("solaris-2", Font.BOLD, 30));
        lsubj.setForeground(Color.WHITE);
        l2.add(lsubj);

        tsubj = new JTextArea();
        tsubj.setBounds(1100, 355, 400, 100);
        tsubj.setEditable(false);
        tsubj.setCaretColor(Color.BLACK);
        tsubj.setLineWrap(true);
        tsubj.setWrapStyleWord(true);
        tsubj.setBackground(new Color(255, 255, 255));
        tsubj.setForeground(Color.BLACK);
        tsubj.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
        tsubj.setBorder(new LineBorder(Color.WHITE, 3, true));

        jsp1 = new JScrollPane(tsubj, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp1.setBounds(1100, 355, 450, 100);
        l2.add(jsp1);

        //For description
        ldesc = new JLabel("Description :");
        ldesc.setBounds(860, 580, 200, 60);
        ldesc.setFont(new Font("solaris-2", Font.BOLD, 30));
        ldesc.setForeground(Color.WHITE);
        l2.add(ldesc);

        tdesc = new JTextArea();
        tdesc.setBounds(1100, 510, 400, 100);
        tdesc.setEditable(false);
        tdesc.setCaretColor(Color.BLACK);
        tdesc.setLineWrap(true);
        tdesc.setWrapStyleWord(true);
        tdesc.setBackground(new Color(255, 255, 255));
        tdesc.setForeground(Color.BLACK);
        tdesc.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
        tdesc.setBorder(new LineBorder(Color.WHITE, 3, true));
       
        jsp2 = new JScrollPane(tdesc, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp2.setBounds(1100, 510, 450, 200);
      
        l2.add(jsp2);
        
        
        ImageIcon iappr = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/approve.png"));
        appb = new JButton();
        appb.setIcon(iappr);
        appb.setVisible(false);
        appb.setBounds(1150, 772, 155, 50);
        appb.setBackground(new Color(0, 0, 57));    
        appb.setFocusPainted(false);
        appb.setBorder(null);
        appb.setContentAreaFilled(false);
        appb.setFocusable(false);
        appb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        appb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon iappr1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/approve1.png"));
                appb.setIcon(iappr1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                appb.setIcon(iappr);
            }
        });
        appb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    conn c4=new conn();
                    String q="Select * from eleave where emp_id='"+t1.getText()+"' and sdate='"+Data2+"' and edate='"+Data3+"' and status='pending'";
                    ResultSet rs2=c4.s.executeQuery(q);
                    if(rs2.next()){
                        String q1="Update eleave set status='approved',status1='unseen' where emp_id='"+t1.getText()+"' and sdate='"+Data2+"' and edate='"+Data3+"' and status='pending'";
                        c4.s.executeUpdate(q1);
                        
                         
                         try{
                    
             String host="smtp.gmail.com";
             String user="employeemanagementsystem12@gmail.com";
             String pass="khalil95944";
             String touser=email;
             String subject="Leave Application";
             String message="Emp ID= "+t1.getText()+" Your Leave Application from  "+Data2+ "  To " + Data3+ "  Has been Approved";
             boolean sessionDebug=false;
             Properties pros=System.getProperties();
             pros.put("mail.smtp.starttls.enable","true");
             pros.put("mail.smtp.host","host"); 
             pros.put("mail.smtp.port", "587");
             pros.put("mail.smtp.auth","true");
             pros.put("mail.smtp.ssl.trust", "smtp.gmail.com");
             pros.put("mail.smtp.starttls.required","true");
             java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
             Session mailSession=Session.getDefaultInstance(pros,null);
             mailSession.setDebug(sessionDebug);
             Message msg=new MimeMessage(mailSession);
               
                    msg.setFrom(new InternetAddress(user));
                    InternetAddress[] address ={new InternetAddress(touser)};
                    msg.setRecipients(Message.RecipientType.TO, address);
                    msg.setSubject(subject);
                    msg.setText(message);
                    Transport transport=mailSession.getTransport("smtp");
                    transport.connect(host,user,pass);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();
                     JOptionPane.showMessageDialog(null, "Approved");
                     new Admin_manageleave().f.setVisible(true);
                     f.setVisible(false);
                     f.dispose();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
                         
     
                    }else{
                        JOptionPane.showMessageDialog(null, "Already Approved or Denied");
                    }
                    
                    
                }catch(Exception e){
                    
                }
            }
        });
        l2.add(appb);
        
        
        ImageIcon ideny = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/deny.png"));
        denyb = new JButton();
        denyb.setIcon(ideny);
        denyb.setVisible(false);
        denyb.setBounds(1340, 770, 144, 55);
        denyb.setBackground(new Color(0, 0, 57));
        denyb.setFocusPainted(false);
        denyb.setBorder(null);
        denyb.setContentAreaFilled(false);
        denyb.setFocusable(false);
        denyb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        denyb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon ideny1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/deny1.png"));
                denyb.setIcon(ideny1);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                denyb.setIcon(ideny);
            }
        });
        denyb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    conn c4=new conn();
                    String q="Select * from eleave where emp_id='"+t1.getText()+"' and sdate='"+Data2+"' and edate='"+Data3+"' and status='pending'";
                    ResultSet rs2=c4.s.executeQuery(q);
                    if(rs2.next()){
                        String q1="Update eleave set status='denied' , status1='unseen' where emp_id='"+t1.getText()+"' and sdate='"+Data2+"' and edate='"+Data3+"' and status='pending'";
                        c4.s.executeUpdate(q1);
                        
                         
                         try{
                    
             String host="smtp.gmail.com";
             String user="employeemanagementsystem12@gmail.com";
             String pass="khalil95944";
             String touser=email;
             String subject="Leave Application";
             String message="Emp ID= "+t1.getText()+" Your Leave Application from  "+Data2+ "  To  " + Data3+ "  Has been Denied";
             boolean sessionDebug=false;
             Properties pros=System.getProperties();
             pros.put("mail.smtp.starttls.enable","true");
             pros.put("mail.smtp.host","host"); 
             pros.put("mail.smtp.port", "587");
             pros.put("mail.smtp.auth","true");
             pros.put("mail.smtp.ssl.trust", "smtp.gmail.com");
             pros.put("mail.smtp.starttls.required","true");
             java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
             Session mailSession=Session.getDefaultInstance(pros,null);
             mailSession.setDebug(sessionDebug);
             Message msg=new MimeMessage(mailSession);
               
                    msg.setFrom(new InternetAddress(user));
                    InternetAddress[] address ={new InternetAddress(touser)};
                    msg.setRecipients(Message.RecipientType.TO, address);
                    msg.setSubject(subject);
                    msg.setText(message);
                    Transport transport=mailSession.getTransport("smtp");
                    transport.connect(host,user,pass);
                    transport.sendMessage(msg, msg.getAllRecipients());
                    transport.close();
                     JOptionPane.showMessageDialog(null, "Denied");
                     new Admin_manageleave().f.setVisible(true);
                     f.setVisible(false);
                     f.dispose();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
                         
     
                    }else{
                        JOptionPane.showMessageDialog(null, "Already Approved or Denied");
                    }
                    
                    
                }catch(Exception e){
                    
                }
            }
        });
        l2.add(denyb);

        String columns[] = {"Emp_Id", "From", "To", "Category", "Status"};
        dtm = new DefaultTableModel(columns, 0);
        try {
            conn c = new conn();
            String query = "SELECT * FROM eleave";
            ResultSet res = c.s.executeQuery(query);
            while (res.next()) {
                String id = res.getString("emp_id");
                String sdate = res.getString("sdate");
                String edate = res.getString("edate");
                String cat = res.getString("category");

                String status = res.getString("status");

                dtm.addRow(new Object[]{id, sdate, edate, cat, status});
            }
        } catch (Exception e) {

        }

        table = new JTable();
        table.setModel(dtm);
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
        jsp = new JScrollPane(table);
        jsp.setBounds(50, 150, 795, 600);
        l2.add(jsp);

        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 1) {
                    final JTable target = (JTable) e.getSource();
                    final int row = target.getSelectedRow();
                    int column = 0;
                    final String Data = (String) target.getValueAt(row, column);

                    t1.setText(Data);

                    int column1 = 3;
                    final String Data1 = (String) target.getValueAt(row, column1);
                    if (Data1.length() > 18) {
                        t2.setBounds(1100, 250, 400, 70);
                        t2.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
                        t2.setText(Data1);

                    } else if (Data1.length() > 16 && Data1.length() < 30) {
                        t2.setBounds(1100, 250, 400, 70);
                        t2.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 25));
                        t2.setText(Data1);

                    } else {
                        t2.setBounds(1100, 250, 250, 70);
                        t2.setText(Data1);
                        t2.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 25));

                    }
                    int column2 = 1;
                    Data2 = (String) target.getValueAt(row, column2);
                    int column3 = 2;
                    Data3 = (String) target.getValueAt(row, column3);
                    try {
                        conn c2 = new conn();
                        String q = "Select * from eleave where emp_id='" + t1.getText() + "' And sdate='" + Data2 + "' And edate='" + Data3 + "'";
                        ResultSet rs1 = c2.s.executeQuery(q);
                        while (rs1.next()) {
                            subj = rs1.getString("subject");
                            desc = rs1.getString("description");
                            email=rs1.getString("email");

                        }
                    } catch (Exception ae) {

                    }
                   
                    appb.setVisible(true);
                    denyb.setVisible(true);
                    tsubj.setText(subj);
                    tdesc.setText(desc);
                }

            }
        });

        ImageIcon iback = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/goback.png"));
        backb = new JButton();
        backb.setIcon(iback);

        backb.setBounds(1730, 870, 155, 70);
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

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        Admin_manageleave am = new Admin_manageleave();
    }

}
