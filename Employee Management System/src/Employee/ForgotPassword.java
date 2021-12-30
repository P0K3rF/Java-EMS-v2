
package Employee;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
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
    JLabel l1,l2,l3;
    JTextField t1,t2;
    JButton b1,b2;
    int randomnumber;
    
    ForgotPassword(){
        
        f = new JFrame("Forgot Password");
        f.setLayout(null);
        f.setBounds(0, 0, 630, 580);
        f.setResizable(false);
        
        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/createpassword.png"));
        Image i5 = i12.getImage().getScaledInstance(630, 550, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i5);
        l1 = new JLabel(i4);
        l1.setBounds(0, 0, 630, 550);
        f.add(l1);
        
        l2 = new JLabel("Email ID");
        l2.setBounds(100, 80, 400, 40);
        l2.setFont(new Font("sans serif", Font.BOLD, 25));
        l2.setForeground(Color.BLACK);
        
        t1 = new JTextField();
        t1.setBounds(130, 140, 350, 50);
        t1.setFont(new Font("sans serif", Font.ROMAN_BASELINE, 30));
        t1.setForeground(Color.black);
        t1.setBorder(new LineBorder(Color.BLACK, 3, true));
        
        b2 = new JButton("Send Code");
        b2.setBounds(130, 200, 150, 50);
        b2.setFont(new Font("serif", Font.ROMAN_BASELINE, 20));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
             
                
                try{Random randno=new Random();
             randomnumber=randno.nextInt(999999);
             String host="smtp.gmail.com";
             String user="employeemanagementsystem12@gmail.com";
             String pass="khalil95944";
             String touser=t1.getText();
             String subject="Reset Code";
             String message="Your reset code is "+randomnumber;
             boolean sessionDebug=false;
             Properties pros=System.getProperties();
             pros.put("mail.smtp.starttls.enable","true");
             pros.put("mail.smtp.host","host"); 
             pros.put("mail.smtp.port", "587");
             pros.put("mail.smtp.auth","true");
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
                    JOptionPane.showMessageDialog(null,"Code has been sent");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }
                
            }
        });
        
        l3 = new JLabel("Verify Code");
        l3.setBounds(100, 280, 230, 40);
        l3.setFont(new Font("sans serif", Font.BOLD, 25));
        l3.setForeground(Color.BLACK);
        
        t2 = new JTextField();
        t2.setBounds(130, 330, 350, 50);
        t2.setFont(new Font("sans serif", Font.ROMAN_BASELINE, 30));
        t2.setForeground(Color.black);
        t2.setBorder(new LineBorder(Color.BLACK, 3, true));
        
        b1 = new JButton("Verify");
        b1.setBounds(200, 410, 200, 50);
        b1.setFont(new Font("serif", Font.ROMAN_BASELINE, 25));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              if(Integer.valueOf(t2.getText())==randomnumber){
                  new ResetPassword(t1.getText()).f.setVisible(true);
                  f.setVisible(false);
                  f.dispose();
              }
                else{
                  JOptionPane.showMessageDialog(null, "Code Mismatch");
                  f.setVisible(false);
                  f.dispose();
                  new ForgotPassword().f.setVisible(true);
              }
            }
        });
       
        
        l1.add(l2);
        l1.add(t1);
        l1.add(b2);
        l1.add(l3);
        l1.add(t2);
        l1.add(b1);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        
    }
     @Override
    public void actionPerformed(ActionEvent ae) {
         
    }
    
    
    public static void main(String[] args){
        ForgotPassword fp=new ForgotPassword();
    }

   
}
