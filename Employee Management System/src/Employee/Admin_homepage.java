
package Employee;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author ktaus
 */
public class Admin_homepage implements ActionListener{
    JFrame f;
    JButton b1,b2,b3,b4,b5,b6,logout;
    JLabel l1;
    
    Admin_homepage(){
        f=new JFrame("HomePage");
        f.setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/admin_homepage.jpg"));
        Image img1 = i1.getImage().getScaledInstance(1921,1080,Image.SCALE_DEFAULT);
        ImageIcon i11 =  new ImageIcon(img1);
        l1=new JLabel(i11);
        l1.setBounds(0, 0, 1921, 1080);
        l1.setLayout(null);
        f.add(l1);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/Add_emp.png"));
        b1=new JButton();
        b1.setIcon(i2);
        b1.setBounds(1100, 150, 300, 120);
        b1.setFocusPainted(false);
        b1.setBorder(null);
        b1.setContentAreaFilled(false);
        b1.setFocusable(false);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.addMouseListener(new MouseAdapter(){
           
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/Add_emp1.png"));
                b1.setIcon(i21);
            }

            @Override
           public void mouseExited(MouseEvent e){
               b1.setIcon(i2);
           }
 
        });
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Admin_addemployee().f.setVisible(true);
                f.setVisible(false);
                f.dispose();
            }
        });
        l1.add(b1);
        
        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/View_emp.png"));
        b2=new JButton();
        b2.setIcon(i3);
        b2.setBounds(1080, 350, 330, 120);
        b2.setFocusPainted(false);
        b2.setBorder(null);
        b2.setContentAreaFilled(false);
        b2.setFocusable(false);
        b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b2.addMouseListener(new MouseAdapter(){
           
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon i31 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/View_emp1.png"));
                b2.setIcon(i31);
            }

            @Override
           public void mouseExited(MouseEvent e){
               b2.setIcon(i3);
           }

        });
         b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                new Admin_viewemployee().f.setVisible(true);
                f.setVisible(false);
                f.dispose();
            }
        });
        l1.add(b2);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/manage_Leave.png"));
        b3=new JButton();
        b3.setIcon(i4);
        b3.setBounds(1080, 550, 330, 120);
        b3.setFocusPainted(false);
        b3.setBorder(null);
        b3.setContentAreaFilled(false);
        b3.setFocusable(false);
        b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b3.addMouseListener(new MouseAdapter(){
           
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon i41 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/manage_Leave1.png"));
                b3.setIcon(i41);
            }

            @Override
           public void mouseExited(MouseEvent e){
               b3.setIcon(i4);
           }
  
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               new Admin_manageleave().f.setVisible(true);
                f.setVisible(false);
                f.dispose();
            }
        });
        l1.add(b3);
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/update_emp.png"));
        b4=new JButton();
        b4.setIcon(i5);
        b4.setBounds(1500, 150, 360, 120);
        b4.setFocusPainted(false);
        b4.setBorder(null);
        b4.setContentAreaFilled(false);
        b4.setFocusable(false);
        b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b4.addMouseListener(new MouseAdapter(){
           
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon i51 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/update_emp1.png"));
                b4.setIcon(i51);
            }

            @Override
           public void mouseExited(MouseEvent e){
               b4.setIcon(i5);
           }

           
            
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               new Admin_updateemployee().f.setVisible(true);
                f.setVisible(false);
                f.dispose();
            }
        });
        l1.add(b4);
        
        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/Remove_emp.png"));
        b5=new JButton();
        b5.setIcon(i6);
        b5.setBounds(1500, 350, 360, 120);
        b5.setFocusPainted(false);
        b5.setBorder(null);
        b5.setContentAreaFilled(false);
        b5.setFocusable(false);
        b5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b5.addMouseListener(new MouseAdapter(){
           
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon i61 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/Remove_emp1.png"));
                b5.setIcon(i61);
            }

            @Override
           public void mouseExited(MouseEvent e){
               b5.setIcon(i6);
           }

           
            
        });
         b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               new Admin_removeemployee().f.setVisible(true);
                f.setVisible(false);
                f.dispose();
            }
        });
        l1.add(b5);
    
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/manage_att.png"));
        b6=new JButton();
        b6.setIcon(i7);
        b6.setBounds(1500, 550, 380, 120);
        b6.setFocusPainted(false);
        b6.setBorder(null);
        b6.setContentAreaFilled(false);
        b6.setFocusable(false);
        b6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b6.addMouseListener(new MouseAdapter(){
           
            @Override
            public void mouseEntered(MouseEvent e){
                ImageIcon i71 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/manage_att1.png"));
                b6.setIcon(i71);
            }

            @Override
           public void mouseExited(MouseEvent e){
               b6.setIcon(i7);
           }

           
            
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               new Admin_manageattendance().f.setVisible(true);
                f.setVisible(false);
                f.dispose();
            }
        });
        l1.add(b6);
        
        ImageIcon ilogout = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/logout.png"));
        logout=new JButton();
        logout.setIcon(ilogout);
        logout.setBounds(1700,850,160,60);
        logout.setBackground(new Color(0, 0, 57));
        logout.setFocusPainted(false);
        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.setFocusable(false);
        logout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
               int a=JOptionPane.showConfirmDialog(null,"Do you really want to Logout","select",JOptionPane.YES_NO_OPTION);
               if(a==0){
                    new login().f.setVisible(true);
               f.setVisible(false);
               f.dispose();
               }
               
              
            }
        });
        l1.add(logout);
        
        f.setSize(1920+25, 1080);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
        f.setVisible(true);
    }
      @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
public static void main(String[] arg){
    Admin_homepage ah=new Admin_homepage();
}    

  
}

