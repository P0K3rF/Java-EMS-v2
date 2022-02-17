
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ktaus
 */

public class testing {
    
    JFrame f;
    JTextField t1,t2;
    JLabel l1,l2;
    JButton b1;
     calltesting cl;
    
    testing(){
        f=new JFrame();
        f.setBounds(500, 500, 500,500);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        
        
        t1=new JTextField();
        t1.setBounds(50, 50, 300, 50);
        f.add(t1);
        
        t2=new JTextField();
        t2.setBounds(50, 150, 300, 50);
        f.add(t2);
        
        l1=new JLabel();
        l1.setBounds(80, 250, 300, 50);
        l1.setFont(new Font("sans-serif",Font.BOLD,30));
        f.add(l1);
        
        l2=new JLabel();
        l2.setBounds(250, 250, 300, 50);
        l2.setFont(new Font("sans-serif",Font.BOLD,30));
        f.add(l2);
        
        b1=new JButton("click");
        b1.setBounds(80,350, 100, 50);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              cl=new calltesting(t1.getText(),t2.getText());
              String s=cl.getName();
              String d=cl.getPass();
              l1.setText(s);
              l2.setText(d);
            }
        });
        f.add(b1);        
        f.setVisible(true);
    }
    
    public static void main(String[] args){
        testing t=new testing();
//        
//        String name="khalil";
//        String pass="khalil95944";
//        
//        calltesting cl=new calltesting(name,pass);
//        String s=cl.getName();
//        String d=cl.getPass();
//        System.out.println("your name is "+ s + " Your password is "+ d);
        
                
        
    }
    
}