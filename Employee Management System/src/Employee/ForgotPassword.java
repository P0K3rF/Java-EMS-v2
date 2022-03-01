package Employee;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class ForgotPassword implements ActionListener {

    JFrame f;
    JLabel l1, l2, l3, l5;
    JLabel crnp;
    JTextField t1, t2;
    JButton b1, b2, b3;
    int randomnumber;

    ForgotPassword() {

        f = new JFrame("Forgot Password");
        f.setLayout(null);

        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/forgetpassbg.jpg"));
        Image img12 = i11.getImage().getScaledInstance(1945, 1080, Image.SCALE_DEFAULT);
        ImageIcon i10 = new ImageIcon(img12);
        l5 = new JLabel(i10);
        l5.setBounds(0, 0, 1945, 1080);
        l5.setLayout(null);
        f.add(l5);

        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/createpassword.png"));
        Image i5 = i12.getImage().getScaledInstance(670, 600, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i5);
        l1 = new JLabel(i4);
        l1.setBounds(600, 200, 670, 600);
        l5.add(l1);

        crnp = new JLabel("Forget Password");
        crnp.setBounds(180, 5, 500, 60);
        crnp.setFont(new Font("sans serif", Font.BOLD, 30));
        Font font1 = crnp.getFont();
        Map attributes1 = font1.getAttributes();
        attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        crnp.setFont(font1.deriveFont(attributes1));
        crnp.setForeground(Color.BLACK);
        l1.add(crnp);

        l2 = new JLabel("Email ID");
        l2.setBounds(100, 90, 400, 40);
        l2.setFont(new Font("sans serif", Font.BOLD, 25));
        l2.setForeground(Color.BLACK);

        t1 = new JTextField();
        t1.setBounds(130, 140, 350, 50);
        t1.setFont(new Font("sans serif", Font.ROMAN_BASELINE, 30));
        t1.setForeground(Color.black);
        t1.setBorder(new LineBorder(Color.BLACK, 3, true));

        b2 = new JButton("Send Code");
        b2.setBounds(130, 220, 150, 50);
        b2.setFont(new Font("serif", Font.ROMAN_BASELINE, 20));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {

                    conn c = new conn();
                    String q = "Select * from employee where email='" + t1.getText() + "'";
                    ResultSet rs = c.s.executeQuery(q);
                    if (!rs.next()) {
                        JOptionPane.showMessageDialog(null, "Invalid Email");
                    } else {
                        try {
                            Random randno = new Random();
                            randomnumber = randno.nextInt(999999);
                            String host = "smtp.gmail.com";
                            String user = "employeemanagementsystem12@gmail.com";
                            String pass = "khalil95944";
                            String touser = t1.getText();
                            String subject = "Reset Code";
                            String message = "Your reset code is " + randomnumber;
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
                            JOptionPane.showMessageDialog(null, "Code has been sent");
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Invalid Email");
                        }
                    }

                } catch (Exception e) {

                }

            }
        });

        l3 = new JLabel("Verify Code");
        l3.setBounds(100, 307, 230, 40);
        l3.setFont(new Font("sans serif", Font.BOLD, 25));
        l3.setForeground(Color.BLACK);

        t2 = new JTextField();
        t2.setBounds(130, 360, 350, 50);
        t2.setFont(new Font("sans serif", Font.ROMAN_BASELINE, 30));
        t2.setForeground(Color.black);
        t2.setBorder(new LineBorder(Color.BLACK, 3, true));

        b1 = new JButton("Verify");
        b1.setBounds(130, 440, 200, 50);
        b1.setFont(new Font("serif", Font.ROMAN_BASELINE, 25));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                if (Integer.valueOf(t2.getText()) == randomnumber) {
                    new ResetPassword(t1.getText()).f.setVisible(true);
                    f.setVisible(false);
                    f.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Code Mismatch");
                    f.setVisible(false);
                    f.dispose();
                    new ForgotPassword().f.setVisible(true);
                }
            }
        });

        b3 = new JButton("Cancel");
        b3.setBounds(350, 440, 200, 50);
        b3.setFont(new Font("serif", Font.ROMAN_BASELINE, 25));
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new user().f.setVisible(true);
                f.setVisible(false);
                f.dispose();
            }

        });
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        l1.add(l2);
        l1.add(t1);
        l1.add(b2);
        l1.add(l3);
        l1.add(t2);
        l1.add(b1);
        l1.add(b3);

        f.setSize(1920 + 25, 1080);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        ForgotPassword fp = new ForgotPassword();
    }

}
