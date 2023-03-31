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
public class AddAccountant extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6;
    JButton b1,b2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JPasswordField pf;
    Font f,f1,f2;
    AddAccountant(){
        super("Add Accountant");
        setLocation(100,100);
        setSize(500,400);
        
        l1 = new JLabel("Add Accountant");
        l2 = new JLabel("Name");
        l3 = new JLabel("Password");
        l4 = new JLabel("Email");
        l5 = new JLabel("Contact");
        l6 = new JLabel("Address");
        
        tf1 = new JTextField();
        pf = new JPasswordField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        
        b1 = new JButton("Add Accountant");
        b2 = new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.BLACK);
        
        f = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,15);
       
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        
        b1.setFont(f1);
        b2.setFont(f1);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,0,0));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(6,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        
        p2.add(l3);
        p2.add(pf);
        
        p2.add(l4);
        p2.add(tf2);
        
        p2.add(l5);
        p2.add(tf3);
        
        p2.add(l6);
        p2.add(tf4);
        
        p2.add(b1);
        p2.add(b2);
        
        setLayout(new BorderLayout(0,0));
        add(p1,"North");
        add(p2,"Center");
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            String name = tf1.getText();
            String pass = pf.getText();
            String email = tf2.getText();
            String mob = tf3.getText();
            String add = tf4.getText();
            
            try{
                ConnectionClass obj = new ConnectionClass();
                String q = "Insert into Accountants(name,password,email,contact,address) values('"+name+"','"+pass+"','"+email+"','"+mob+"','"+add+"')";
                int a = obj.stm.executeUpdate(q);
                if(a==1){
                   JOptionPane.showMessageDialog(null,"Data Inserted Successfully!!!");
                   this.setVisible(false);
                }
                else{
                   JOptionPane.showMessageDialog(null,"Data Inserted Unsuccessful!");
                   this.setVisible(true);
                   new AdminSection().setVisible(true);
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(e.getSource()==b2){
            new AdminSection().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddAccountant().setVisible(true);
    }
}
