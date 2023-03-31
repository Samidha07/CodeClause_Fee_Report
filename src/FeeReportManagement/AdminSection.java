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
public class AdminSection extends JFrame implements ActionListener {
    
    JLabel l1;
    JButton b1,b2,b3;
    JPanel p1,p2;
    Font f,f1;
    
    AdminSection(){
        super("Admin Page");
        setLocation(100,100);
        setSize(500,200);
        
        l1 = new JLabel("Admin Section");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.BLACK);
        
        b1 = new JButton("Add Accountant");
        b2 = new JButton("View Accountant");
        b3 = new JButton("Logout Admin");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        f = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,15);
      
        l1.setFont(f);
        
        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(4,1,10,10));
        p1.add(l1);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        
        setLayout(new BorderLayout(0,0));
        add(p1,"Center");
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            new AddAccountant().setVisible(true);
            
        }
        if(e.getSource()==b2){
            new ViewAccoutant().setVisible(true);
        }
        if(e.getSource()==b3){
            this.setVisible(false);
            new index().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new AdminSection().setVisible(true);
    }
}
