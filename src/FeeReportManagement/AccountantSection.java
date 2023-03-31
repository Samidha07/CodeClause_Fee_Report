
package FeeReportManagement;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AccountantSection extends JFrame implements ActionListener{
    JButton b1,b2,b3,b4,b5,b6;
    JLabel l1;
    JPanel p1,p2;
    
    AccountantSection(){
        super("Accountant Login Page");
        setLocation(100,100);
        setSize(500,200);
        
        l1 = new JLabel("Accountant Section");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.BLACK);
        
        b1 = new JButton("Add Student");
        b2 = new JButton("View Student");
        b3 = new JButton("Edit Student");
        b4 = new JButton("Due Fee");
        b5 = new JButton("Logout");
        b6 = new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(3,2,10,10));
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        
        setLayout(new BorderLayout(0,0));
        add(p1,"North");
        add(p2,"Center");
    
    }
    
    
    public void actionPerformed(ActionEvent e){
    if(e.getSource()==b1){
            new AddStudent().setVisible(true);
            
        }
        if(e.getSource()==b2){
            new ViewStudent().setVisible(true);
        }
        if(e.getSource()==b3){
            new EditStudent().setVisible(true);
        }
        if(e.getSource()==b4){
            new DueFee().setVisible(true);
            
        }
        if(e.getSource()==b5){
            new index().setVisible(true);
            this.setVisible(false);
        }
        if(e.getSource()==b6){
            this.setVisible(false);
            new Accountant().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new AccountantSection().setVisible(true);
    }
}
