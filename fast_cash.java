/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.mangement.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;

public class fast_cash  extends JFrame implements ActionListener{
    JButton deposit, withdrawl,fastcash,minist,pinchange,balancecheck,exit;
    String pinnumber;
    fast_cash(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel image=new JLabel(i3); 
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Select withdrawl amount");
        text.setBounds(225,300,7000,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit =new JButton ("Rs 100");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl =new JButton ("Rs 200");
        withdrawl.setBounds(350,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash =new JButton ("Rs 500");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        minist =new JButton ("Rs 1000");
        minist.setBounds(350,450,150,30);
        minist.addActionListener(this);
        image.add(minist);
        
        pinchange =new JButton ("Rs 5000");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balancecheck =new JButton ("10000");
        balancecheck.setBounds(350,485,150,30);
        balancecheck.addActionListener(this);
        image.add(balancecheck);
        
        exit =new JButton ("back");
        exit.setBounds(350,520,150,30);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        image.setBounds(0,0,900,900);
        setUndecorated(true);
        setVisible(true);
        
        
    
    }
    
    public void actionPerformed (ActionEvent ae){
    if (ae.getSource()==exit){
        System.exit(0);
    }else{
    String amount=((JButton)ae.getSource()).getText().substring(3);
    conn c=new conn();
    try{
        ResultSet rs=c.s.executeQuery("Select * from bank where pin ='"+pinnumber+"' ");
        int balance =0;
        while(rs.next()){
        if (rs.getString("type").equals("Deposit")){
        balance +=Integer.parseInt(rs.getString("amount"));
        
        
        }
        else{
        balance -=Integer.parseInt(rs.getString("amount"));
        }
        
        
        }
        if(ae.getSource()!=exit && balance<Integer.parseInt(amount)){
        JOptionPane.showMessageDialog(null,"Sorry! Insufficient Balance");
        return;
        }
        Date date=new Date();
        String query="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
        c.s.executeUpdate(query);
        
             
        JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited successfully");
        
        setVisible(false);
        new transaction (pinnumber).setVisible(true);
        
    }catch(Exception e){
      System.out.println(e);  
    }}
   
    }
    
    public static void main (String args[]){
    new fast_cash("");
    }
    
}

