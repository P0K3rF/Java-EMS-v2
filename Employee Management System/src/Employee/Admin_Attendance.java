
package Employee;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class Admin_Attendance {
    JFrame f;
    
    Admin_Attendance(){
         try{
         conn c10=new conn();
     String query = "SELECT * FROM attendance";
    ResultSet res =c10.s.executeQuery(query);
    String columns[] = { "emp_id", "checkin_time", "checkin_date","checkout_time","checkout_date"};
     String data[][] = new String[20][20];
     int i=0;
     while(res.next()){
         String id=res.getString("emp_id");
         String intime=res.getString("chenkin_time");
         String indate=res.getString("checkin_date");
         String outtime=res.getString("checkout_time");
         String outdate=res.getString("checkout_date");
         
         data[i][0]=id+"";
         data[i][1]=intime;
         data[i][2]=indate;
         data[i][3]=outtime;
         data[i][4]=outdate;
         i++;
              
     }
     DefaultTableModel model = new DefaultTableModel(data, columns);
      JTable table = new JTable(model);
      table.setShowGrid(true);
      table.setShowVerticalLines(true);
      JScrollPane pane = new JScrollPane(table);
      JFrame f = new JFrame("Attendance of Employees");
      JPanel panel = new JPanel();
      panel.add(pane);
      f.add(panel);
      f.setSize(800, 500);
      f.setLocation(400,300);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
     }
     catch(Exception ex){
         
     }
      
} 
    public static void main(String[] args){
        new Admin_Attendance();
    }
}
