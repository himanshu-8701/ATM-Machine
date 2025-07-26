/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.mangement.system;
import java.sql.*;

public class conn {
    
    Connection c;
    Statement s;
    public conn(){
        try{
           
           c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Himanshu#1234");
           s=c.createStatement();
        }catch (Exception e){
        System.out.println(e);
    }
    }
}
