/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FeeReportManagement;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class ViewAccoutant extends JFrame {
    String x[] = {"Name","Password","Email","Contanct","Address"};
    String y[][] = new String[20][5];
    int i=0,j=0;
    JTable t;
    Font f;
    
    ViewAccoutant(){
       
        super("Accountant Information");
        setLocation(100,100);
        setSize(800,400);
        
        f = new Font("MS UI Gothic",Font.BOLD,15);
        
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "Select * from Accountants;";
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("password");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("contact");
                y[i][j++] = rest.getString("address");
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
        new ViewAccoutant().setVisible(true);
    }
}
