package FeeReportManagement;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class EditStudent extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
    JButton b1,b2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
    JPasswordField pf;
    Font f,f1,f2;
    Choice ch;
    EditStudent(){
        
        super("Edit Student");
        setLocation(100,100);
        setSize(500,500);
        
        f = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,15);
       
        l1 = new JLabel("Edit Student");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.BLACK);
        
        l2 = new JLabel("Name");
        l3 = new JLabel("Email");
        l4 = new JLabel("Course");
        l5 = new JLabel("Fee");
        l6 = new JLabel("Paid");
        l7 = new JLabel("Due");
        l8 = new JLabel("Address");
        l9 = new JLabel("Country");
        l10 = new JLabel("Contact");
        l11 = new JLabel("roll no");
        
        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();
        tf10 = new JTextField();
        ch =  new Choice();
        
        try{
            ConnectionClass obj = new ConnectionClass();
//            String q = "Select rollno from Students where rollno = "+roll+";"; 
               String q = "Select rollno from Students";
               ResultSet rest = obj.stm.executeQuery(q);
               while(rest.next()){
                   ch.add(rest.getString("rollno"));
               }
        }catch(Exception exe){
            exe.printStackTrace();
        }
        
        b1 = new JButton("Edit Student");
        b2 = new JButton("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,0,0));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(12,2,10,10));
       
        p2.add(l11);
        p2.add(ch);
        
        p2.add(l2);
        p2.add(tf1);
        
        p2.add(l3);
        p2.add(tf2);
        
        p2.add(l4);
        p2.add(tf3);
        
        p2.add(l5);
        p2.add(tf4);
        
        p2.add(l6);
        p2.add(tf5);
        
        p2.add(l7);
        p2.add(tf6);
        
        p2.add(l8);
        p2.add(tf7);
        
        p2.add(l9);
        p2.add(tf8);
        
        p2.add(l10);
        p2.add(tf9);
      
        p2.add(b1);
        p2.add(b2);
        
        setLayout(new BorderLayout(0,0));
        add(p1,"North");
        add(p2,"Center");
        
        ch.addMouseListener(new MouseAdapter()
        {
                @Override
                public void mouseClicked(MouseEvent arg0){
                    try{
                    ConnectionClass obj1 = new ConnectionClass();
                    int roll = Integer.parseInt(ch.getSelectedItem());
                    
               String q1 = "Select * from Students where rollno ="+roll;
               ResultSet rest1 = obj1.stm.executeQuery(q1);
               while(rest1.next()){
                   tf1.setText(rest1.getString("name"));
                   tf2.setText(rest1.getString("email"));
                   tf3.setText(rest1.getString("course"));
                   tf4.setText(rest1.getString("fee"));
                   tf5.setText(rest1.getString("paid"));
                   tf6.setText(rest1.getString("due"));
                   tf7.setText(rest1.getString("address"));
                   tf8.setText(rest1.getString("country"));
                   tf9.setText(rest1.getString("contact"));
               }
                    }
                    catch(Exception eee){
                        eee.printStackTrace();
                    }
                }
        
        });
    }
    public void actionPerformed(ActionEvent e){
            int roll = Integer.parseInt(ch.getSelectedItem());
            String name = tf1.getText();
            String email = tf2.getText();
            String course = tf3.getText();
            String fee = tf4.getText();
            String paid = tf5.getText();
            String due = tf6.getText();
            String add = tf7.getText();
            String country = tf8.getText();
            String contact = tf9.getText();
        if(e.getSource()==b1){
                     try{
                ConnectionClass obj2 = new ConnectionClass();
                String q = "Update Students set name = '"+name+"' ,email = '"+email+"',course ='"+course+"',fee ='"+fee+"',paid =' "+paid+"' ,due = '"+due+"',address = '"+add+"',country = '"+country+"',contact = '"+contact+"' where rollno =  "+roll;
                int a = obj2.stm.executeUpdate(q);
                if(a==1){
                   JOptionPane.showMessageDialog(null,"Data Inserted Successfully!!!");
                   this.setVisible(false);
                }
                else{
                   JOptionPane.showMessageDialog(null,"Data Insertion Unsuccessful!");
                   this.setVisible(true);
                   new AdminSection().setVisible(true);
                }
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(e.getSource()==b2){
            new AccountantSection().setVisible(true);
            this.setVisible(false);
        }
    
    }
    public static void main(String[] args) {
        new EditStudent().setVisible(true);
    }
}
