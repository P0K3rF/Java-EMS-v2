
package Employee;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

public class ResetPassword implements ActionListener {
    JFrame f;
    JLabel l1,l2,l3;
    JButton b1,b2,b3,b4,b5,b6;
    JPasswordField t1,t2;
    String empemail,dbemail,dbpass;
    ResetPassword(String email_id){
        
        empemail=email_id;
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
        
        l2 = new JLabel("New Password");
        l2.setBounds(100, 90, 200, 40);
        l2.setFont(new Font("sans serif", Font.BOLD, 25));
        l2.setForeground(Color.BLACK);
        
        t1 = new JPasswordField();
        t1.setBounds(130, 150, 350, 50);
        t1.setFont(new Font("sans serif", Font.ROMAN_BASELINE, 30));
        t1.setForeground(Color.black);
        t1.setBorder(new LineBorder(Color.BLACK, 3, true));
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/showpassword.png"));
        Image i1 = i13.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon il4 = new ImageIcon(i1);
        b3 = new JButton(il4);
        b3.setBounds(490, 160, 30, 30);
        b3.setOpaque(false);
        b3.setContentAreaFilled(false);
        b3.setBorderPainted(false);
        b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b3.setVisible(true);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                b3.setVisible(false);
                t1.setEchoChar((char) 0);
                ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/hidepassword.png"));
                Image i2 = i14.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
                ImageIcon il5 = new ImageIcon(i2);
                b4 = new JButton(il5);
                b4.setBounds(490, 160, 30, 30);
                b4.setOpaque(false);
                b4.setContentAreaFilled(false);
                b4.setBorderPainted(false);
                b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                b4.setVisible(true);
                b4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        b4.setVisible(false);
                        b3.setVisible(true);
                        t1.setEchoChar('*');
                    }
                });

                l1.add(b4);
            }

        });
        
        l3 = new JLabel("Confirm password");
        l3.setBounds(100, 230, 230, 40);
        l3.setFont(new Font("sans serif", Font.BOLD, 25));
        l3.setForeground(Color.BLACK);
        
        t2 = new JPasswordField();
        t2.setBounds(130, 290, 350, 50);
        t2.setFont(new Font("sans serif", Font.ROMAN_BASELINE, 30));
        t2.setForeground(Color.black);
        t2.setBorder(new LineBorder(Color.BLACK, 3, true));
        
        ImageIcon i15 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/showpassword.png"));
        Image i3 = i15.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon il6 = new ImageIcon(i3);
        b5 = new JButton(il6);
        b5.setBounds(490, 300, 30, 30);
        b5.setOpaque(false);
        b5.setContentAreaFilled(false);
        b5.setBorderPainted(false);
        b5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b5.setVisible(true);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               b5.setVisible(false);
                t2.setEchoChar((char) 0);

                ImageIcon i17 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/hidepassword.png"));
                Image i4 = i17.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
                ImageIcon il8 = new ImageIcon(i4);
                b6 = new JButton(il8);
                b6.setFocusable(true);
                b6.setBounds(490, 300, 30, 30);
                b6.setOpaque(false);
                b6.setContentAreaFilled(false);
                b6.setBorderPainted(false);
                b6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                b6.setVisible(true);
                b6.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        b6.setVisible(false);
                        b5.setVisible(true);
                        t2.setEchoChar('*');
                    }
                });

                l1.add(b6);
            }
        });
        
        b1 = new JButton("Set Password");
        b1.setBounds(100, 390, 250, 50);
        b1.setFont(new Font("serif", Font.ROMAN_BASELINE, 25));
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!t1.getText().isEmpty() && !t2.getText().isEmpty()){
                    if (t1.getText().equals(t2.getText())){
                        try{
                            conn c1=new conn();
                            String newpass=t1.getText();
                            String query="select * from employee where email='"+empemail+"'";
                            ResultSet rs=c1.s.executeQuery(query);
                            while(rs.next()){
                                dbemail=rs.getString("email");
                                dbpass=rs.getString("password");
                            }
                            if(dbemail.equals(empemail) && dbpass.equals("null")){
                                JOptionPane.showMessageDialog(null, "You haven't Create Your Password Yet");
                               
                                new user().f.setVisible(true);
                                f.setVisible(false);
                               f.dispose();
                               
                            }else{
                                String updatepassquery="update employee set password='"+newpass+"' where email='"+empemail+"'";
                            c1.s.executeUpdate(updatepassquery);
                            JOptionPane.showMessageDialog(null, "Password Updated Successfully");
                            new user().f.setVisible(true);
                            f.setVisible(false);
                            f.dispose();
                            }
//                            
                            
                        }catch(Exception e){
                            
                        }
                    }
                else{
                        JOptionPane.showMessageDialog(null, "Password Mismatch");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Password field cannot be empty");
                }
            }
        });
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        b2 = new JButton("Cancel");
        b2.setBounds(390, 390, 150, 50);
        b2.setFont(new Font("serif", Font.ROMAN_BASELINE, 25));
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        l1.add(l2);
        l1.add(t1);
        l1.add(b3);
        l1.add(l3);
        l1.add(t2);
        l1.add(b5);
        l1.add(b1);
        l1.add(b2);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==b1){
        
    }
    else if (ae.getSource()==b2){
        new user().f.setVisible(true);
        f.setVisible(false);
        f.dispose();
    }
    }
    
    public static void main(String[] args){
        ResetPassword rp=new ResetPassword("");
    }

    
}
