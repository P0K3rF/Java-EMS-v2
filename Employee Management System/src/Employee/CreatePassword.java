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
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class CreatePassword implements ActionListener {

    JFrame f;
    JLabel l1, l2, l3, l4;
    JButton b1, b2;
    JTextField t1;
    JPasswordField t2, t3;
    JButton b4,b6;
    String dbempid, password;

    CreatePassword() {
        f = new JFrame("Create Password");
        f.setLayout(null);
        f.setBounds(0, 0, 670, 630);
        f.setResizable(false);

        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/createpassword.png"));
        Image i5 = i12.getImage().getScaledInstance(670, 600, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i5);
        l1 = new JLabel(i4);
        l1.setBounds(0, 0, 670, 600);
        f.add(l1);

        l2 = new JLabel("EMP ID");
        l2.setBounds(100, 70, 120, 40);
        l2.setFont(new Font("sans serif", Font.BOLD, 25));
        l2.setForeground(Color.BLACK);

        t1 = new JTextField();
        t1.setBounds(130, 120, 350, 50);
        t1.setFont(new Font("sans serif", Font.ROMAN_BASELINE, 30));
        t1.setForeground(Color.black);
        t1.setBorder(new LineBorder(Color.BLACK, 3, true));

        l3 = new JLabel("Create Password");
        l3.setBounds(100, 190, 230, 40);
        l3.setFont(new Font("sans serif", Font.BOLD, 25));
        l3.setForeground(Color.BLACK);

        t2 = new JPasswordField();
        t2.setBounds(130, 240, 350, 50);
        t2.setFont(new Font("sans serif", Font.ROMAN_BASELINE, 30));
        t2.setForeground(Color.black);
        t2.setBorder(new LineBorder(Color.BLACK, 3, true));

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/showpassword.png"));
        Image i1 = i13.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon il4 = new ImageIcon(i1);
        JButton b3 = new JButton(il4);
        b3.setBounds(490, 250, 30, 30);
        b3.setOpaque(false);
        b3.setContentAreaFilled(false);
        b3.setBorderPainted(false);
        b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b3.setVisible(true);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                b3.setVisible(false);
                t2.setEchoChar((char) 0);

                ImageIcon i14 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/hidepassword.png"));
                Image i2 = i14.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
                ImageIcon il5 = new ImageIcon(i2);
                b4 = new JButton(il5);
                b4.setBounds(490, 250, 30, 30);
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
                        t2.setEchoChar('*');
                    }
                });

                l1.add(b4);
            }

        });

        l4 = new JLabel("Confirm password");
        l4.setBounds(100, 300, 230, 40);
        l4.setFont(new Font("sans serif", Font.BOLD, 25));
        l4.setForeground(Color.BLACK);

        t3 = new JPasswordField();
        t3.setBounds(130, 350, 350, 50);
        t3.setFont(new Font("sans serif", Font.ROMAN_BASELINE, 30));
        t3.setForeground(Color.black);
        t3.setBorder(new LineBorder(Color.BLACK, 3, true));
        
        
         ImageIcon i15 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/showpassword.png"));
        Image i3 = i15.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
        ImageIcon il6 = new ImageIcon(i3);
        JButton b5 = new JButton(il6);
        b5.setBounds(490, 360, 30, 30);
        b5.setOpaque(false);
        b5.setContentAreaFilled(false);
        b5.setBorderPainted(false);
        b5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b5.setVisible(true);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               b5.setVisible(false);
                t3.setEchoChar((char) 0);

                ImageIcon i17 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/hidepassword.png"));
                Image i4 = i17.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT);
                ImageIcon il8 = new ImageIcon(i4);
                b6 = new JButton(il8);
                b6.setBounds(490, 360, 30, 30);
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
                        t3.setEchoChar('*');
                    }
                });

                l1.add(b6);
            }
        });
        
        

        b1 = new JButton("Set Password");
        b1.setBounds(110, 430, 200, 50);
        b1.setFont(new Font("serif", Font.ROMAN_BASELINE, 25));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        b2 = new JButton("Cancel");
        b2.setBounds(350, 430, 200, 50);
        b2.setFont(new Font("serif", Font.ROMAN_BASELINE, 25));
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        l1.add(l2);
        l1.add(t1);
        l1.add(l3);
        l1.add(t2);
        l1.add(l4);
        l1.add(t3);
        l1.add(b1);
        l1.add(b2);
        l1.add(b3);
        l1.add(b5);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            if (t1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Emp id Texfield cannot be empty!");
            }
            if (!t2.getText().isEmpty() && !t3.getText().isEmpty()) {
                if (t2.getText().equals(t3.getText())) {

                    try {
                        conn c9 = new conn();
                        String empid = t1.getText();
                        String emppass = t2.getText();
                        String q = "select * from employee where emp_id='" + empid + "'";
                        ResultSet rs = c9.s.executeQuery(q);
                        while (rs.next()) {
                            dbempid = rs.getString("emp_id");
                            password = rs.getString("password");

                        }
                        if (dbempid.equals(empid) && password.equals("null")) {
                            String updatequery = "update employee set password='" + emppass + "' where emp_id='" + empid + "'";
                            c9.s.executeUpdate(updatequery);
                            JOptionPane.showMessageDialog(null, "Created Password Successfully!!");
                            new user().f.setVisible(true);
                            f.setVisible(false);
                            f.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Incorrect Empid or your password is already set");
                        }
                    } catch (Exception e) {

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Password mismatch");

                    new CreatePassword();
                    f.setVisible(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Enter password");
            }

        } else if (ae.getSource() == b2) {
            new user().f.setVisible(true);
            f.setVisible(false);
            f.dispose();
        }

    }

    public static void main(String[] args) {
        CreatePassword cp = new CreatePassword();
    }

}
