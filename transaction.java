

package bank.mangement.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import java.util.*;

public class transaction  extends JFrame implements ActionListener{
    JButton deposit, withdrawl,fastcash,minist,pinchange,balancecheck,exit;
    String pinnumber;
    transaction(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel image=new JLabel(i3); 
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please select your transction");
        text.setBounds(225,300,7000,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit =new JButton ("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl =new JButton ("Withdrawl");
        withdrawl.setBounds(350,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash =new JButton ("Fast cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        minist =new JButton ("Mini Statement");
        minist.setBounds(350,450,150,30);
        minist.addActionListener(this);
        image.add(minist);
        
        pinchange =new JButton ("Pin Change");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balancecheck =new JButton ("Balance Check");
        balancecheck.setBounds(350,485,150,30);
        balancecheck.addActionListener(this);
        image.add(balancecheck);
        
        exit =new JButton ("Exit");
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
    }
    else if(ae.getSource()==deposit){
    new deposit(pinnumber).setVisible(true);
    }
    else if(ae.getSource()==withdrawl){
    new withdrawl(pinnumber).setVisible(true);
    }
    else if(ae.getSource()==fastcash){
        setVisible(false);
    new fast_cash(pinnumber).setVisible(true);
    }else if(ae.getSource()==pinchange){
        setVisible(false);
    new PinChange(pinnumber).setVisible(true);
    }else if(ae.getSource()==balancecheck){
        setVisible(false);
    new BalanceEnquriry(pinnumber).setVisible(true);
    }else if(ae.getSource()==minist){
        setVisible(false);
    new miniStatement(pinnumber).setVisible(true);
    }
    
    }
    
    public static void main (String args[]){
    new transaction("");
    }
    
}
