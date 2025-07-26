
package bank.mangement.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;



public class signup3 extends JFrame implements ActionListener {
    JRadioButton r1, r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
signup3(String formno){
    this.formno=formno;
    setLayout(null);
    JLabel l1=new JLabel("Page3 : Account Details");
    l1.setFont(new Font("Raleway", Font.BOLD,22));
    l1.setBounds(280,40,300,40);
    add(l1);
    
    JLabel type=new JLabel("Account Type");
    type.setFont(new Font("Raleway", Font.BOLD,22));
    type.setBounds(100,100,200,40);
    add(type);
    
    r1=new JRadioButton("Saving Account");
    r1.setBounds(130,140,150,20);
    r1.setBackground( Color.WHITE);
    add(r1);
    
    r2=new JRadioButton("Fixed deposit");
    r2.setBounds(130,170,150,20);
    r2.setBackground( Color.WHITE);
    add(r2);
    
    r3=new JRadioButton("Current Account");
    r3.setBounds(130,200,150,20);
    r3.setBackground( Color.WHITE);
    add(r3);
    
    r4=new JRadioButton("Recurring Deposit Account");
    r4.setBounds(130,230,200,20);
    r4.setBackground( Color.WHITE);
    add(r4);
        
    ButtonGroup account =new ButtonGroup();
    account.add(r1);
    account.add(r2);
    account.add(r3);
    account.add(r4);
    
    JLabel card=new JLabel("Card Number");
    card.setFont(new Font("Raleway", Font.BOLD,22));
    card.setBounds(100,270,200,40);
    add(card);
    
    JLabel number=new JLabel("XXXX-XXXX-XXXX-4165");
    number.setFont(new Font("Raleway", Font.BOLD,22));
    number.setBounds(300,270,300,40);
    add(number);
    
    JLabel information=new JLabel("This is your 16 digit card number");
    information.setFont(new Font("Raleway", Font.BOLD,10));
    information.setBounds(100,300,200,20);
    add(information);
    
    JLabel pin=new JLabel("PIN");
    pin.setFont(new Font("Raleway", Font.BOLD,22));
    pin.setBounds(100,340,200,40);
    add(pin);
    
    JLabel pn=new JLabel("XXXX");
    pn.setFont(new Font("Raleway", Font.BOLD,22));
    pn.setBounds(300,340,300,40);
    add(pn);
    
    JLabel details=new JLabel("This is your 4 digit card pin number");
    details.setFont(new Font("Raleway", Font.BOLD,10));
    details.setBounds(100,370,200,20);
    add(details);
    
    JLabel services=new JLabel("Services");
    services.setFont(new Font("Raleway", Font.BOLD,22));
    services.setBounds(100,420,300,30);
    add(services);
    
    
    c1=new JCheckBox("ATM Card");
    c1.setBackground(Color.WHITE);
    c1.setFont(new Font("Raleway",Font.BOLD,16));
    c1.setBounds(100,470,200,30);
    add(c1);
    
    c2=new JCheckBox("Internet Banking");
    c2.setBackground(Color.WHITE);
    c2.setFont(new Font("Raleway",Font.BOLD,16));
    c2.setBounds(350,470,200,30);
    add(c2);
    
    c3=new JCheckBox("Mobile banking");
    c3.setBackground(Color.WHITE);
    c3.setFont(new Font("Raleway",Font.BOLD,16));
    c3.setBounds(100,510,200,30);
    add(c3);
    
    
    c4=new JCheckBox("Email and SMS alert");
    c4.setBackground(Color.WHITE);
    c4.setFont(new Font("Raleway",Font.BOLD,16));
    c4.setBounds(350,510,200,30);
    add(c4);
    
    
    c5=new JCheckBox("Cheque Book");
    c5.setBackground(Color.WHITE);
    c5.setFont(new Font("Raleway",Font.BOLD,16));
    c5.setBounds(100,550,200,30);
    add(c5);
    
    c6=new JCheckBox("Statement");
    c6.setBackground(Color.WHITE);
    c6.setFont(new Font("Raleway",Font.BOLD,16));
    c6.setBounds(350,550,200,30);
    add(c6);
   

    c7=new JCheckBox("Hered declares that the above entered details are correct to the best of my knowledge");
    c7.setBackground(Color.WHITE);
    c7.setFont(new Font("Raleway",Font.BOLD,16));
    c7.setBounds(100,610,680,30);
    add(c7);
    
    submit=new JButton ("submit");
    submit.setBackground(Color.BLACK);
    submit.setForeground(Color.WHITE);
    submit.setFont(new Font("Raleway",Font.BOLD,14));
    submit.setBounds(260,700,100,30);
    submit.addActionListener(this);
    add(submit);
    
    cancel=new JButton ("Cancel");
    cancel.setBackground(Color.BLACK);
    cancel.setForeground(Color.WHITE);
    cancel.setFont(new Font("Raleway",Font.BOLD,14));
    cancel.setBounds(420,700,100,30);
    cancel.addActionListener(this);
    add(cancel);
    
    
setSize(820,820);
setLocation(350,0);
setVisible(true);
    





}

public void actionPerformed (ActionEvent ae){

if(ae.getSource()==submit){
    String accountType=null;
    if(r1.isSelected()){
    accountType="Saving Account";
    }
    else if(r2.isSelected()){
        accountType="Fixed account";
        
    }else if(r3.isSelected()){
        accountType="Current account";
        
    }else if(r4.isSelected()){
        accountType="Recurring deposit account";
        
    }
    
    Random random =new Random();
    String cardnumber ="" +  Math.abs(random.nextLong()%90000000L+504093600000000L);
    
    String pinnumber =""+Math.abs(random.nextLong()%9000L+1000L);
    
    String facility ="";
    if(c1.isSelected()){
    facility =facility + "ATM number";
    }else if(c2.isSelected()){
    facility=facility+"Internet banking";
    }else if(c3.isSelected()){
    facility=facility+"Mobile banking";
    }else if(c4.isSelected()){
    facility=facility+"Email and SMS banking";
    }else if(c5.isSelected()){
    facility=facility+"Cheque book";
    }else if(c6.isSelected()){
    facility=facility+" Stattement";
    }
    
    
    try{
    if(accountType.equals("")){
        JOptionPane.showMessageDialog(null,"Account Type is required");
    }else {
               conn c=new conn();
               String query1 = "insert into signup3 values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
               String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
 
               c.s.executeUpdate(query1);
               c.s.executeUpdate(query2);
               
               
               JOptionPane.showMessageDialog(null,"card number :"+cardnumber+"\n pin number :"+pinnumber);
               setVisible(false);
               new Login().setVisible(true);
               
    } 
    
    }catch(Exception e){
    System.out.println(e);
    
    }
    
}
else if(ae.getSource()==cancel){
    setVisible(false);
    System.exit(0);
    
}
}



    public static void main(String args[]){
    new signup3("");
    
    }
}
