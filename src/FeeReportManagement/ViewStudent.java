
package FeeReportManagement;

import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewStudent extends JFrame{
    
    String x[]= {"rollno","name","email","course","fee","paid","due","address","country","contact"};
    String y[][] = new String[25][10];
    int i=0,j=0;
    JTable t;
    Font f;
    
    ViewStudent(){
      super("Student Information");
        setLocation(100,100);
        setSize(800,400);
        
        f = new Font("MS UI Gothic",Font.BOLD,15);
        
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "Select * from Students;";
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++] = rest.getString("rollno");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("course");
                y[i][j++] = rest.getString("fee");
                y[i][j++] = rest.getString("paid");
                y[i][j++] = rest.getString("due");
                y[i][j++] = rest.getString("address");
                y[i][j++] = rest.getString("country");
                y[i][j++] = rest.getString("contact");
                
                i++;
                j = 0;
            }
            t = new JTable(y,x);
            t.setFont(f);
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        JScrollPane sp = new JScrollPane(t);
        add(sp);
    }
    public static void main(String[] args) {
        new ViewStudent().setVisible(true);
    }
}
