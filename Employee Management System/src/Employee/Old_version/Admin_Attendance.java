
package Employee.Old_version;
import Employee.conn;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.border.LineBorder;

public class Admin_Attendance {
    JFrame f;
  JDateChooser edateChooser, sdateChooser;
  JButton b;
  java.util.Date date, date1;
  SimpleDateFormat dateFormat;
    Admin_Attendance(){
        
        f=new JFrame("testing");
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        
        sdateChooser = new JDateChooser();
        JTextFieldDateEditor editor = (JTextFieldDateEditor) sdateChooser.getDateEditor();
        editor.setEditable(false);
        sdateChooser.setBounds(60, 100, 250, 50);
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
        f.add(sdateChooser);
        
        edateChooser = new JDateChooser();
        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) edateChooser.getDateEditor();
        editor1.setEditable(false);
        edateChooser.setBounds(60, 200, 250, 50);
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
        f.add(edateChooser);
        
        b=new JButton("Click");
        b.setBounds(70,300,100,30);
        f.add(b);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    conn c=new conn();
                    String q="select salary.status,eleave.status1 from salary,eleave where salary.emp_id='101' and salary.status='unseen' and eleave.emp_id='101' and eleave.status1='unseen'";
                   ResultSet rs=c.s.executeQuery(q);
                   if(rs.next()){
                      JOptionPane.showMessageDialog(null, "hi");
                   }else{
                       JOptionPane.showMessageDialog(null, "bye");
                   }
                   
                }catch(Exception e){
                    
                }
                       
            }
        });
        
        
         f.setBounds(40,60,500,500);
        f.setVisible(true);
} 
    public static void main(String[] args){
       Admin_Attendance a=new Admin_Attendance();
    }
    
}
