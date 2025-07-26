/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

 class Login extends JFrame implements ActionListener {
     
     JButton login,signup,clear;
     JTextField cardTextField;
     JPasswordField pinTextField;
    
     Login(){
       
       setTitle("AUTOMATED TELLER MACHINE");
       setLayout(null);//to get our custom layout
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//to get get image imoported
       Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//to give image dimensions
       ImageIcon i3 = new ImageIcon(i2);//as we cannot directly import image object as it is not available in swing package so we introduce another function
       JLabel label = new JLabel(i3);
       label.setBounds(70,10,100,100);//this function is used to have custom layout and placing of image accordin to us
       add(label);//to place label on frame
       
       JLabel text = new JLabel("WELCOME TO ATM");
       text.setFont(new Font("Osward",Font.BOLD,38));
       text.setBounds(200,40,400,40);
       add(text);
       
      
       
       JLabel cardno = new JLabel("Card Number: ");
       cardno.setFont(new Font("Railway",Font.BOLD,20));
       cardno.setBounds(120,150,150,30);
       add(cardno);
       
       cardTextField = new JTextField();
       cardTextField.setBounds(300,150,230,30);
       cardTextField.setFont(new Font("Arieal",Font.BOLD,14));
       add(cardTextField);
       
       JLabel pin = new JLabel("PIN: ");
       pin.setFont(new Font("Railway",Font.BOLD,20));
       pin.setBounds(120,220,200,30);
       add(pin);
       
       pinTextField = new JPasswordField();
       pinTextField.setBounds(300,220,230,30);
       add(pinTextField);
       
       login = new  JButton("SIGN IN");
       login.setBounds(300,300,100,30);
       login.setBackground(Color.BLACK);
       login.setForeground(Color.WHITE);
       login.addActionListener(this);
       add(login);
       
       clear = new  JButton("CLEAR");
       clear.setBounds(430,300,100,30);
       clear.setBackground(Color.BLACK);
       clear.setForeground(Color.WHITE);
       clear.addActionListener(this);
       add(clear);
       
       signup = new  JButton("SIGN UP");
       signup.setBounds(300,350,230,30);
       signup.setBackground(Color.BLACK);
       signup.setForeground(Color.WHITE);
       signup.addActionListener(this);
       add(signup);
       
       getContentPane().setBackground(Color.WHITE);//this function is used to change complete frame color
       
         
       setSize(800,450);//this function gives length and breadth of the frame
       setVisible(true);//this shows the frame as by default it is hidden
       setLocation(350,200);
     }
     
     public void actionPerformed(ActionEvent ae){
      if (ae.getSource()== clear){
          cardTextField.setText("");
          
          pinTextField.setText("");         
     }   
      else if(ae.getSource()== login){
          
            conn c=new conn();
            String cardnumber=cardTextField.getText();
            String pinnumber=pinTextField.getText();
            String query="select * from login where card_number = '"+cardnumber+"'and pin_number='"+pinnumber+"'";
           
            try{
            ResultSet rs=c.s.executeQuery(query);
            
            if(rs.next()){
            setVisible(false);
            new transaction(pinnumber).setVisible (true);
            
            }else{
            JOptionPane.showMessageDialog(null,"Incorrect card number or PIN");
            }

            }catch(Exception e){
            System.out.println(e);
            }
              
              }
      
              else if(ae.getSource()==signup){
              setVisible(false);
              new signup1().setVisible(true);
              }
     }
     
    public static void main(String args[]){
     new Login();
 }
}
