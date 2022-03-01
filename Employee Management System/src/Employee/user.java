/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.sql.*;
import java.util.Map;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

class user implements ActionListener {

    JFrame f;
    JLabel l1, l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2, b3, b4;

    user() {
        f = new JFrame("User");
        f.setBackground(Color.BLUE);
        f.setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/user_login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1921, 1080, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1920, 1080);
        f.add(l3);

        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/admin_login_template.png"));
        Image i5 = i12.getImage().getScaledInstance(400, 520, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i5);
        JLabel l4 = new JLabel(i4);
        l4.setBounds(1400, 300, 400, 520);
        l3.add(l4);
        f.add(l3);

        JLabel l5 = new JLabel("USER LOGIN");
        l5.setForeground(Color.BLACK);
        l5.setFont(new Font("solaris-2", Font.BOLD, 20));
        l5.setBounds(130, 20, 150, 50);
        Font font1 = l5.getFont();
        Map attributes1 = font1.getAttributes();
        attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        l5.setFont(font1.deriveFont(attributes1));
        l4.add(l5);

        JLabel l6 = new JLabel("Please Enter Your Login Details.");
        l6.setForeground(Color.BLACK);
        l6.setFont(new Font("solaris-2", Font.ITALIC, 15));
        l6.setBounds(100, 30, 350, 150);
        l4.add(l6);

        l1 = new JLabel("Employee ID");
        l1.setForeground(Color.BLACK);
        l1.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
        l1.setBounds(20, 130, 140, 30);
        l4.add(l1);

        l2 = new JLabel("Password");
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
        l2.setBounds(20, 240, 100, 30);
        l4.add(l2);

        t1 = new JTextField();

        t1.requestFocus();
        t1.setCaretColor(Color.WHITE);
        t1.setForeground(Color.BLACK);
        t1.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
        t1.setOpaque(false);
        t1.setBorder(new LineBorder(Color.BLACK, 3, true));
        t1.setBounds(40, 170, 280, 50);
        l4.add(t1);

        t2 = new JPasswordField();
        t2.setForeground(Color.BLACK);
        t2.setCaretColor(Color.WHITE);
        t2.setFont(new Font("solaris-2", Font.ROMAN_BASELINE, 20));
        t2.setOpaque(false);
        t2.setBorder(new LineBorder(Color.BLACK, 3, true));
        t2.setBounds(40, 280, 280, 50);
        l4.add(t2);

        b1 = new JButton("Login");
        b1.setBounds(120, 360, 140, 50);
        b1.setFont(new Font("serif", Font.ROMAN_BASELINE, 25));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l4.add(b1);

        b2 = new JButton("Go to Home Menu");
        b2.setBounds(1580, 800, 400, 80);
        b2.setOpaque(false);
        b2.setContentAreaFilled(false);
        b2.setBorderPainted(false);
        b2.setFont(new Font("serif", Font.ROMAN_BASELINE, 30));

        Font font = b2.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        b2.setFont(font.deriveFont(attributes));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l3.add(b2);

        b3 = new JButton("Create Password");
        b3.setBounds(0, 420, 200, 50);
        b3.setOpaque(false);
        b3.setContentAreaFilled(false);
        b3.setBorderPainted(false);
        b3.setFont(new Font("sans serif", Font.ROMAN_BASELINE, 20));

        Font font2 = b3.getFont();
        Map attributes2 = font2.getAttributes();
        attributes2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        b3.setFont(font2.deriveFont(attributes2));
        b3.setForeground(Color.BLACK);
        b3.addActionListener(this);
        b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l4.add(b3);

        b4 = new JButton("Forgot Password?");
        b4.setBounds(190, 420, 200, 50);
        b4.setOpaque(false);
        b4.setContentAreaFilled(false);
        b4.setBorderPainted(false);
        b4.setFont(new Font("sans serif", Font.ROMAN_BASELINE, 20));

        Font font3 = b4.getFont();
        Map attributes3 = font3.getAttributes();
        attributes3.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        b4.setFont(font3.deriveFont(attributes3));
        b4.setForeground(Color.BLACK);
        b4.addActionListener(this);
        b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        l4.add(b4);

        f.getContentPane().setBackground(Color.WHITE);

        f.setSize(1920 + 25, 1080);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);

        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                conn c1 = new conn();

                String u = t1.getText();
                String v = t2.getText();

                String q = "select * from employee where emp_id='" + u + "' and password='" + v + "'";

                ResultSet rs = c1.s.executeQuery(q);
                if (rs.next()) {
                    new Usertestinginterface(t1.getText()).f.setVisible(true);
                    f.setVisible(false);
                    f.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    user u1 = new user();
                    f.dispose();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            new Front_Page().f.setVisible(true);
            f.setVisible(false);
            f.dispose();
        } else if (ae.getSource() == b3) {
            new CreatePassword().f.setVisible(true);
            f.setVisible(false);
        } else if (ae.getSource() == b4) {
            new ForgotPassword().f.setVisible(true);
            f.setVisible(false);
        }

    }

    public static void main(String[] arg) {

        new user();
    }
}
