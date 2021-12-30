
package Employee;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class user_Attendance implements ActionListener{
    JFrame f;
    JButton b1,b3,b2;
    JLabel l1,l2;
    String emp_id;
    String sempid,intime,indate,outtime,outdate,semmpid,inttime,inddate;
    String remaining;
   
    
    user_Attendance(String name){
             
        f=new JFrame("");
        f.setBackground(Color.red);
        f.setLayout(null);
               
     emp_id=name;
     l1=new JLabel(emp_id);
     l1.setBounds(600,50,100,30);
     f.add(l1);

        l2=new JLabel();
        l2.setBounds(150,25,100,30);
       
        f.add(l2);
        String testempid=l1.getText();
        LocalDate myDateObj = LocalDate.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    String DDate = myDateObj.format(myFormatObj);
    b1=new JButton("IN");
                    b1.setVisible(false);
        b1.setBounds(150, 20,100, 30);
        b1.addActionListener(this);
        f.add(b1);
         try{
            conn c1=new conn();
                String ntr="Select * from attendance where emp_id='"+testempid+"' AND checkin_date='"+DDate+"'";
                ResultSet crs=c1.s.executeQuery(ntr);
             
                if(crs.next()){
                    semmpid=crs.getString("emp_id");
                    inttime=crs.getString("chenkin_time");
                    inddate=crs.getString("checkin_date"); 
                   
                    if(semmpid.equals(testempid) && inddate.equals(DDate)){
                        b1.setVisible(false);
                     
                    }
                    else{
                    
                        b1.setVisible(true);
                    }          
                }
                else{
                    b1.setVisible(true);
                }
                
                
         }
        catch(Exception ee){
               JOptionPane.showMessageDialog(null,ee);
        }         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Employee/icons/backbutton.png"));
        Image i2 = i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        
         b3=new JButton(i3);
         b3.setBounds(15,10,30,30);
         b3.addActionListener(this);
         b3.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
         f.add(b3);
        
        b2=new JButton("OUT");
        b2.setBounds(300, 20,100, 30);
        b2.addActionListener(this);
        f.add(b2);
        
        
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
        f.setSize(800,500);
        f.setLocation(400,300);
//        f.setIconImage(i2);
        
    }
    public void actionPerformed(ActionEvent ae){
       
    LocalDate myDateObj = LocalDate.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
    String Date = myDateObj.format(myFormatObj);
      LocalTime myTimeObj = LocalTime.now();
      DateTimeFormatter myTimeFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
      String Time = myTimeObj.format(myTimeFormatObj);
        String empid=l1.getText();
       
        try{
            conn c1=new conn();
                String str="Select * from attendance where emp_id='"+empid+"'";
                ResultSet rs=c1.s.executeQuery(str);
                
                while(rs.next()){
                    sempid=rs.getString("emp_id");
                    intime=rs.getString("chenkin_time");
                    indate=rs.getString("checkin_date");
                    outtime=rs.getString("checkout_time");
                    outdate=rs.getString("checkout_date");
                    
                }
                   
            if(ae.getSource()==b1){
                
                conn cc = new conn();
                String q="insert into attendance values('"+empid+"','"+Time+"','"+Date+"','null','null','null')";
                cc.s.executeUpdate(q);
                b1.setVisible(false);
            }
            
            if(ae.getSource()==b2){
                if(sempid.equals(empid)&&Date.equals(indate)){
                if(sempid.equals(empid)&&outtime.equals("null")){
                    conn cc = new conn();
                String q="update attendance SET checkout_time='"+Time+"',checkout_date='"+Date+"'where emp_id='"+empid+"'AND checkout_time='null'";
                cc.s.executeUpdate(q);
                String d="select chenkin_time,checkout_time,(34.25*(checkout_time-chenkin_time)) as remainng_time from attendance where emp_id='"+empid+"'";
                ResultSet pq=cc.s.executeQuery(d);
                while(pq.next()){
                    
                    remaining=pq.getString("remainng_time");
        }
                String sp="update attendance SET salary='"+remaining+"' where emp_id='"+empid+"' AND salary='null'";
                cc.s.executeUpdate(sp);
            }
                else{
                    
                }
            }
                else{
                    JOptionPane.showMessageDialog(null,"You havent Checkedin Today");
                }
            }
            else{
                
            }
        }
        catch(Exception ee){
                System.out.println("The error is:"+ee);
        }
     
//        if(ae.getSource()==b2){
//            b2.setVisible(false);
//        }
    }
    public static void main(String[] arg){
        user_Attendance u=new user_Attendance("");
    }

}


