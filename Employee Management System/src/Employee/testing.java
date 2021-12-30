/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class testing implements ActionListener {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    JLabel timelabel;
    JFrame f;
    String time;

    testing() {
        
        //ADDING FRAME 
        f = new JFrame("testing UI");
        f.setSize(1920 + 25, 1080);
        f.setLayout(new FlowLayout());
        f.setBackground(Color.white);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width / 2 - f.getSize().width / 2, dim.height / 2 - f.getSize().height / 2);
        
       timelabel=new JLabel();
       
      Timer timer =new Timer(1000,new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
              Date currenttime=new Date();
              timelabel.setText(currenttime.toString());
              Font font = timelabel.getFont();
Map attributes = font.getAttributes();
attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
timelabel.setFont(font.deriveFont(attributes));
            }
          
      });
       timer.start();
       f.add(timelabel);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        
    }

    public static void main(String[] arg) {
        testing u = new testing();
        
    }
}
