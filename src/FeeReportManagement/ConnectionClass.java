/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FeeReportManagement;

import java.sql.*;

public class ConnectionClass {
    Connection con;
    Statement stm;
    
    ConnectionClass(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fee","root","samidha");
            stm = con.createStatement();
            if(con.isClosed()){
//                System.out.println("Not connect");

            }
            else{
//                System.out.println("connect");

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new ConnectionClass();
    }
}

