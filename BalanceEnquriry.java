
package bank.mangement.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class BalanceEnquriry extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;
    BalanceEnquriry(String pinnumber){
        setLayout(null);
        this.pinnumber=pinnumber;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back=new JButton ("back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
   conn c=new conn();
   int balance =0;
    try{
        ResultSet rs=c.s.executeQuery("Select * from bank where pin ='"+pinnumber+"' ");
        
        while(rs.next()){
        if (rs.getString("type").equals("Deposit")){
        balance +=Integer.parseInt(rs.getString("amount"));
        
        }else{
        balance -=Integer.parseInt(rs.getString("amount"));
        }
        
        }
        }catch(Exception e){
         System.out.println(e);
         }
        
        JLabel text=new JLabel("Your  Balance amount is Rs : "+balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(220,320,500,35);
        image.add(text);
    
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
      public void actionPerformed(ActionEvent ae){
       
        setVisible(false);
          new transaction(pinnumber).setVisible(true);
    
    }
    
    public static void main(String args[]){
    new BalanceEnquriry("");
    }
    
}
