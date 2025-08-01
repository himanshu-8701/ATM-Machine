
package bank.mangement.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class deposit extends JFrame implements ActionListener  {
    
    JButton deposit,back,exit;
    JTextField amount;
    String pinnumber;
    
    deposit(String pinnumber){
        
    this.pinnumber=pinnumber;
    setLayout(null);
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));

    Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0,0,900,900);
    add(image);
    
    
    JLabel text=new JLabel("Enter the account you want to deposit");
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System",Font.BOLD,16));
    text.setBounds(180,300,400,20);
    image.add(text);
    
    amount=new JTextField();
    amount.setFont(new Font("System",Font.BOLD,14));
    amount.setBounds(170,350,320,20);
    image.add(amount);
    
    deposit=new JButton("Deposit");
    deposit.setBounds(355,475,150,30);
    deposit.addActionListener(this);
    image.add(deposit);
    
    back=new JButton("back");
    back.setBounds(355,515,150,30);
    back.addActionListener(this);
    image.add(back);
    
    setSize(900,900);
    setLocation(350,0);
    setVisible(true);
        
    
    }
    
    public void actionPerformed (ActionEvent ae){
   
    if(ae.getSource()==deposit){
        String number =amount.getText();
        Date date=new Date();
        if(number.equals("")){
            
        
        JOptionPane.showMessageDialog(null,"Please Enter the amount you want to deposit");
        }else{
           try{
             conn c=new conn();
             String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+number+"' )";
             c.s.executeUpdate(query);
             
             JOptionPane.showMessageDialog(null,"You have successfully entered "+number + "Rs");
           }catch(Exception e){
               System.out.println(e);
                       
           }
        }
        
        
    }
    else if(ae.getSource()==back){
          setVisible(false);
          new transaction(pinnumber).setVisible(true);
    }
    
    }    
    
    public static void main(String arg[]){
    new deposit("");
    
    
    }
    
}
