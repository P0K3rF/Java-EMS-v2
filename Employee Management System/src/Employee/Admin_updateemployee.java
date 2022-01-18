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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class Admin_updateemployee implements ActionListener {

    JFrame f;
    JLabel l1, l2,l3;
    JLabel id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12;
    JLabel dd1,dd2,dd3,dd4,dd5,dd6,dd7,dd8,dd9,dd10;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, ts;
    JButton b1,bs,backb;
    int i = 0;
    DefaultTableModel dtm;
    JTable table;
    JScrollPane jsp;
    Admin_updateemployee() {

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
        l2.setBounds(250, 70, 1400, 850);
        l2.setLayout(null);
        l1.add(l2);

        l3=new JLabel("UPDATE EMPLOYEE");
        l3.setBounds(200, 40, 450, 60);
        l3.setFont(new Font("solaris-2",Font.ROMAN_BASELINE,40));
        l3.setForeground(new Color(0,255,254));
        Font font1 = l3.getFont();
        Map attributes1 = font1.getAttributes();
        attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        l3.setFont(font1.deriveFont(attributes1));
        l2.add(l3);
        
        ts = new RoundJTextField(20);
        ts.setBounds(800, 40, 200, 50);
        ts.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        ts.setForeground(Color.BLACK);
        l2.add(ts);

        ImageIcon i6 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/search.png"));
        bs = new JButton();
        bs.setIcon(i6);
        bs.setBounds(987, 40, 80, 50);
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
                bs.setIcon(i6);
            }
        });
        bs.addActionListener(this);
        l2.add(bs);
        
         String columns[] = {"Emp_Id","Phone","Email","Post"};
        dtm=new DefaultTableModel(columns,0); 
        
        try{
            conn c=new conn();
            String query="Select * from employee";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                String id=rs.getString("emp_id");
                String rsphone1=rs.getString("phone");
                String rsemail1=rs.getString("email");
                String rspost1=rs.getString("post");
                dtm.addRow(new Object[]{id,rsphone1,rsemail1,rspost1});
            }
            
        }catch(Exception e){
            
        }
        table =new JTable();
        table.setModel(dtm);
        table.setEnabled(false);
        table.setPreferredScrollableViewportSize(new Dimension(500,50));
        table.setFillsViewportHeight(true);
        table.getTableHeader().setPreferredSize(new Dimension(100,50));
        table.getTableHeader().setFont(new Font("solaris-2",Font.BOLD,20));
        table.getTableHeader().setBackground(new Color(18,140,226));
        table.getTableHeader().setForeground(new Color(255,255,255));
        table.setRowHeight(50);
        table.setBackground(new Color(204,255,255));
        table.setFont(new Font("solrais-2",Font.ROMAN_BASELINE,20));
        table.setForeground(new Color(0,0,0));
        JTableUtilities.setCellsAlignment(table, SwingConstants.CENTER);
        jsp=new JScrollPane(table);
        jsp.setBounds(150, 160, 1055, 600);
        l2.add(jsp);

        id1 = new JLabel("First Name");
        id1.setBounds(100, 160, 200, 50);
        id1.setFont(new Font("solaris-2", Font.BOLD, 30));
        id1.setForeground(Color.WHITE);
        id1.setVisible(false);
        l2.add(id1);

        dd1=new JLabel(":");
        dd1.setVisible(false);
        dd1.setForeground(Color.WHITE);
        dd1.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd1.setBounds(290, 160,20, 50);
        l2.add(dd1);
        
        t1 = new JTextField();
        t1.setBounds(330, 160, 300, 50);
        t1.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t1.setForeground(Color.BLACK);
        t1.setVisible(false);
        l2.add(t1);

        id2 = new JLabel("Last Name");
        id2.setBounds(800, 160, 200, 50);
        id2.setFont(new Font("solaris-2", Font.BOLD, 30));
        id2.setForeground(Color.WHITE);
        id2.setVisible(false);
        l2.add(id2);
        
        dd2=new JLabel(":");
        dd2.setVisible(false);
        dd2.setForeground(Color.WHITE);
        dd2.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd2.setBounds(990, 160,20, 50);
        l2.add(dd2);

        t2 = new JTextField();
        t2.setBounds(1030, 160, 300, 50);
        t2.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t2.setForeground(Color.BLACK);
        t2.setVisible(false);
        l2.add(t2);

        id3 = new JLabel("Age");
        id3.setBounds(100, 280, 150, 50);
        id3.setFont(new Font("solaris-2", Font.BOLD, 30));
        id3.setForeground(Color.WHITE);
        id3.setVisible(false);
        l2.add(id3);

        dd3=new JLabel(":");
        dd3.setVisible(false);
        dd3.setForeground(Color.WHITE);
        dd3.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd3.setBounds(290, 280,20, 50);
        l2.add(dd3);
        
        t3 = new JTextField();
        t3.setBounds(330, 280, 300, 50);
        t3.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t3.setForeground(Color.BLACK);
        t3.setVisible(false);
        l2.add(t3);

        id4 = new JLabel("Date Of Birth");
        id4.setBounds(800, 280, 300, 50);
        id4.setFont(new Font("solaris-2", Font.BOLD, 30));
        id4.setForeground(Color.WHITE);
        id4.setVisible(false);
        l2.add(id4);

        dd4=new JLabel(":");
        dd4.setVisible(false);
        dd4.setForeground(Color.WHITE);
        dd4.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd4.setBounds(990, 280,20, 50);
        l2.add(dd4);
        
        t4 = new JTextField();
        t4.setBounds(1030, 280, 300, 50);
        t4.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t4.setForeground(Color.BLACK);
        t4.setVisible(false);
        l2.add(t4);

        id5 = new JLabel("Address");
        id5.setBounds(100, 400, 200, 50);
        id5.setFont(new Font("solaris-2", Font.BOLD, 30));
        id5.setForeground(Color.WHITE);
        id5.setVisible(false);
        l2.add(id5);

        dd5=new JLabel(":");
        dd5.setVisible(false);
        dd5.setForeground(Color.WHITE);
        dd5.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd5.setBounds(290, 400,20, 50);
        l2.add(dd5);
        
        t5 = new JTextField();
        t5.setBounds(330, 400, 300, 50);
        t5.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t5.setForeground(Color.BLACK);
        t5.setVisible(false);
        l2.add(t5);

        id6 = new JLabel("Phone");
        id6.setBounds(800, 400, 100, 50);
        id6.setFont(new Font("solaris-2", Font.BOLD, 30));
        id6.setForeground(Color.WHITE);
        id6.setVisible(false);
        l2.add(id6);

        dd6=new JLabel(":");
        dd6.setVisible(false);
        dd6.setForeground(Color.WHITE);
        dd6.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd6.setBounds(990, 400,20, 50);
        l2.add(dd6);
        
        t6 = new JTextField();
        t6.setBounds(1030, 400, 300, 50);
        t6.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t6.setForeground(Color.BLACK);
        t6.setVisible(false);
        l2.add(t6);

        id7 = new JLabel("Email Id");
        id7.setBounds(100, 520, 150, 50);
        id7.setFont(new Font("solaris-2", Font.BOLD, 30));
        id7.setForeground(Color.WHITE);
        id7.setVisible(false);
        l2.add(id7);
        
        dd7=new JLabel(":");
        dd7.setVisible(false);
        dd7.setForeground(Color.WHITE);
        dd7.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd7.setBounds(290, 520,20, 50);
        l2.add(dd7);

        t7 = new JTextField();
        t7.setBounds(330, 520, 300, 50);
        t7.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t7.setForeground(Color.BLACK);
        t7.setVisible(false);
        l2.add(t7);

        id9 = new JLabel("Education");
        id9.setBounds(800, 520, 200, 50);
        id9.setFont(new Font("solaris-2", Font.BOLD, 30));
        id9.setForeground(Color.WHITE);
        id9.setVisible(false);
        l2.add(id9);

        dd8=new JLabel(":");
        dd8.setVisible(false);
        dd8.setForeground(Color.WHITE);
        dd8.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd8.setBounds(990, 520,20, 50);
        l2.add(dd8);
        
        t8 = new JTextField();
        t8.setBounds(1030, 520, 300, 50);
        t8.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t8.setForeground(Color.BLACK);
        t8.setVisible(false);
        l2.add(t8);

        id10 = new JLabel("Job Post");
        id10.setBounds(100, 640, 150, 50);
        id10.setFont(new Font("solaris-2", Font.BOLD, 30));
        id10.setForeground(Color.WHITE);
        id10.setVisible(false);
        l2.add(id10);
        
        dd9=new JLabel(":");
        dd9.setVisible(false);
        dd9.setForeground(Color.WHITE);
        dd9.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd9.setBounds(290, 640,20, 50);
        l2.add(dd9);

        t9 = new JTextField();
        t9.setBounds(330, 640, 300, 50);
        t9.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t9.setForeground(Color.BLACK);
        t9.setVisible(false);
        l2.add(t9);

        id11 = new JLabel("Aadhar No");
        id11.setBounds(800, 640, 200, 50);
        id11.setFont(new Font("solaris-2", Font.BOLD, 30));
        id11.setForeground(Color.WHITE);
        id11.setVisible(false);
        l2.add(id11);
        
        dd10=new JLabel(":");
        dd10.setVisible(false);
        dd10.setForeground(Color.WHITE);
        dd10.setFont(new Font("leelawadee UI 23 Plain", Font.BOLD, 30));
        dd10.setBounds(990, 640,20, 50);
        l2.add(dd10);

        t10 = new JTextField();
        t10.setBounds(1030, 640, 300, 50);
        t10.setFont(new Font("leelawadee UI 23 Plain", Font.ROMAN_BASELINE, 25));
        t10.setForeground(Color.BLACK);
        t10.setVisible(false);
        l2.add(t10);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/updatebutton1.png"));
        b1 = new JButton();
        b1.setVisible(false);
        b1.setIcon(i4);
        b1.setBounds(540, 750, 200, 70);
        b1.setFocusPainted(false);
        b1.setBorder(null);
        b1.setContentAreaFilled(false);
        b1.setFocusable(false);
        b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b1.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                ImageIcon i21 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/updatebutton.png"));
                b1.setIcon(i21);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b1.setIcon(i4);
            }

        });
        b1.addActionListener(this);
        l2.add(b1);

        
        ImageIcon iback = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/goback.png"));
        backb=new JButton();
        backb.setIcon(iback);
        backb.setBounds(1700, 880, 160, 60);
        backb.setBackground(new Color(0, 0, 57));
        backb.setFocusPainted(false);
        backb.setBorder(null);
        backb.setContentAreaFilled(false);
        backb.setFocusable(false);
        backb.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backb.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
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
        Admin_updateemployee au = new Admin_updateemployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bs && !ts.getText().isEmpty()) {

            try {
                conn con = new conn();
                String str = "select * from employee where emp_id = '" + ts.getText() + "'";
                ResultSet rs = con.s.executeQuery(str);

                if (rs.next()) {
                    jsp.setVisible(false);
                    id1.setVisible(true);
                    id2.setVisible(true);
                    id3.setVisible(true);
                    id4.setVisible(true);
                    id5.setVisible(true);
                    id6.setVisible(true);
                    id7.setVisible(true);
                    id9.setVisible(true);
                    id10.setVisible(true);
                    id11.setVisible(true);
                    
                    dd1.setVisible(true);
                    dd2.setVisible(true);
                    dd3.setVisible(true);
                    dd4.setVisible(true);
                    dd5.setVisible(true);
                    dd6.setVisible(true);
                    dd7.setVisible(true);
                    dd8.setVisible(true);
                    dd9.setVisible(true);
                    dd10.setVisible(true);
                    
                    t1.setVisible(true);
                    t2.setVisible(true);
                    t3.setVisible(true);
                    t4.setVisible(true);
                    t5.setVisible(true);
                    t6.setVisible(true);
                    t7.setVisible(true);
                    t8.setVisible(true);
                    t9.setVisible(true);
                    t10.setVisible(true);

                    b1.setVisible(true);
                    

                    i = 1;
                    t1.setText(rs.getString(1));
                    t2.setText(rs.getString(2));
                    t3.setText(rs.getString(3));
                    t4.setText(rs.getString(4));
                    t5.setText(rs.getString(5));
                    t6.setText(rs.getString(6));
                    t7.setText(rs.getString(7));
                    t8.setText(rs.getString(8));
                    t9.setText(rs.getString(9));
                    t10.setText(rs.getString(10));

                } else {
                    JOptionPane.showMessageDialog(null, "Id not found");
                    jsp.setVisible(true);
            
                    id1.setVisible(false);
                    id2.setVisible(false);
                    id3.setVisible(false);
                    id4.setVisible(false);
                    id5.setVisible(false);
                    id6.setVisible(false);
                    id7.setVisible(false);
                    id9.setVisible(false);
                    id10.setVisible(false);
                    id11.setVisible(false);
                    
                    dd1.setVisible(false);
                    dd2.setVisible(false);
                    dd3.setVisible(false);
                    dd4.setVisible(false);
                    dd5.setVisible(false);
                    dd6.setVisible(false);
                    dd7.setVisible(false);
                    dd8.setVisible(false);
                    dd9.setVisible(false);
                    dd10.setVisible(false);
                    
                    t1.setVisible(false);
                    t2.setVisible(false);
                    t3.setVisible(false);
                    t4.setVisible(false);
                    t5.setVisible(false);
                    t6.setVisible(false);
                    t7.setVisible(false);
                    t8.setVisible(false);
                    t9.setVisible(false);
                    t10.setVisible(false);

                    b1.setVisible(false);
                }
            } catch (Exception ex) {
            }
        } else if (ae.getSource() == b1 && i == 1) {
            try {
                conn con = new conn();
                String str = "update employee set name='" + t1.getText() + "',fname='" + t2.getText() + "',age='" + t3.getText() + "',dob='" + t4.getText() + "',address='" + t5.getText() + "',phone='" + t6.getText() + "',email='" + t7.getText() + "',education='" + t8.getText() + "',post='" + t9.getText() + "',aadhar='" + t10.getText() + "' where emp_id='" + ts.getText() + "'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "successfully updated");
                new Admin_homepage().f.setVisible(true);
                f.setVisible(false);
            } catch (Exception e) {
                System.out.println("The error is:" + e);
            }

        }else if(ae.getSource() == bs && ts.getText().isEmpty()){
            jsp.setVisible(true);
            
                    id1.setVisible(false);
                    id2.setVisible(false);
                    id3.setVisible(false);
                    id4.setVisible(false);
                    id5.setVisible(false);
                    id6.setVisible(false);
                    id7.setVisible(false);
                    id9.setVisible(false);
                    id10.setVisible(false);
                    id11.setVisible(false);
                    
                    dd1.setVisible(false);
                    dd2.setVisible(false);
                    dd3.setVisible(false);
                    dd4.setVisible(false);
                    dd5.setVisible(false);
                    dd6.setVisible(false);
                    dd7.setVisible(false);
                    dd8.setVisible(false);
                    dd9.setVisible(false);
                    dd10.setVisible(false);
                    
                    t1.setVisible(false);
                    t2.setVisible(false);
                    t3.setVisible(false);
                    t4.setVisible(false);
                    t5.setVisible(false);
                    t6.setVisible(false);
                    t7.setVisible(false);
                    t8.setVisible(false);
                    t9.setVisible(false);
                    t10.setVisible(false);

                    b1.setVisible(false);
            
        }

    }
}
