/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.mangement.system;
 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.sql.Connection;

public class signup1 extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField,FnameTextField,EnameTextField,AnameTextField,CitynameTextField,SnameTextField,pdTextField;
    JRadioButton male,female,married,unmarried,others;
    JDateChooser dateChooser;
    
    signup1(){
        
        
        setLayout(null);
        Random ran=new Random();
        
        random=Math.abs((ran.nextLong()%900L)+100L);
        
        JLabel formno=new JLabel("APPLICATION FORM NO. "+random);
        formno.setFont(new Font("Railway",Font.BOLD,30));
        formno.setBounds(180,20,600,40);
        add(formno);
        
        JLabel personalDetails=new JLabel("Page:Personal Details ");
        personalDetails.setFont(new Font("Railway",Font.BOLD,22));
        personalDetails.setBounds(250,80,400,30);
        add(personalDetails);
        
        JLabel name=new JLabel("Name: ");
        name.setFont(new Font("Railway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Railway",Font.BOLD,14));
        nameTextField.setBounds(300,145,300,30);
        add(nameTextField);
        
        JLabel FatherName=new JLabel("Father Name :  ");
        FatherName.setFont(new Font("Railway",Font.BOLD,22));
        FatherName.setBounds(100,190,200,30);
        add(FatherName);
        
        FnameTextField=new JTextField();
        FnameTextField.setFont(new Font("Railway",Font.BOLD,14));
        FnameTextField.setBounds(300,195,300,30);
        add(FnameTextField);
        
        JLabel DOB=new JLabel("DOB :  ");
        DOB.setFont(new Font("Railway",Font.BOLD,22));
        DOB.setBounds(100,240,200,30);
        add(DOB);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,300,30);
        dateChooser.setForeground(new Color(105,105,105));
        add (dateChooser);
        
        JLabel gender=new JLabel("Gender :  ");
        gender.setFont(new Font("Railway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground( Color.WHITE);
        add(male);
        female=new JRadioButton("Female");
        female.setBounds(400,290,70,30);
        female.setBackground( Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email=new JLabel("Email :  ");
        email.setFont(new Font("Railway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);
        
        
        EnameTextField=new JTextField();
        EnameTextField.setFont(new Font("Railway",Font.BOLD,14));
        EnameTextField.setBounds(300,345,300,30);
        add(EnameTextField);
        
        JLabel maridialStaus=new JLabel("MaridialStaus :  ");
        maridialStaus.setFont(new Font("Railway",Font.BOLD,22));
        maridialStaus.setBounds(100,390,200,30);
        add(maridialStaus);
        
        married=new JRadioButton("Married");
        married.setBounds(300,390,90,30);
        married.setBackground( Color.WHITE);
        add(married);
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(400,390,90,30);
        unmarried.setBackground( Color.WHITE);
        add(unmarried);
        
        others=new JRadioButton("Others");
        others.setBounds(500,390,70,30);
        others.setBackground( Color.WHITE);
        add(others);
        
        ButtonGroup MSgroup=new ButtonGroup();
        MSgroup.add(married);
        MSgroup.add(unmarried);
        MSgroup.add(others);
       
        JLabel address=new JLabel("Address:  ");
        address.setFont(new Font("Railway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);
        
        AnameTextField=new JTextField();
        AnameTextField.setFont(new Font("Railway",Font.BOLD,14));
        AnameTextField.setBounds(300,445,300,30);
        add(AnameTextField);
        
        JLabel city=new JLabel("City :  ");
        city.setFont(new Font("Railway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);
        
        CitynameTextField=new JTextField();
        CitynameTextField.setFont(new Font("Railway",Font.BOLD,14));
        CitynameTextField.setBounds(300,495,300,30);
        add(CitynameTextField);
        
        JLabel state=new JLabel("State :  ");
        state.setFont(new Font("Railway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);
        
        SnameTextField=new JTextField();
        SnameTextField.setFont(new Font("Railway",Font.BOLD,14));
        SnameTextField.setBounds(300,545,300,30);
        add(SnameTextField);
        
        JLabel pc=new JLabel("Pin Code :  ");
        pc.setFont(new Font("Railway",Font.BOLD,22));
        pc.setBounds(100,590,200,30);
        add(pc);
        
        pdTextField=new JTextField();
        pdTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pdTextField.setBounds(300,595,300,30);
        add(pdTextField);

        JButton next=new JButton ("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno=" "+random; //long;
        String name=nameTextField.getText();//setText;
        String fname=FnameTextField.getText();
        String dob=((JTextField )dateChooser.getDateEditor().getUiComponent()).getText(); 
        String gender=null;
        if(male.isSelected()){
        gender="Male";
        
        }
        else if(female.isSelected()){
        gender="Female";
        
        }
        String email=EnameTextField.getText();
        String maritial=null;
        if(married.isSelected()){
        maritial="Married";
        
        }
        else if(unmarried.isSelected()){
        maritial="Unmarried";
        
        }else if(others.isSelected()){
        maritial="Others";
        
        }
        String address=AnameTextField.getText();
        String city=CitynameTextField.getText();
        String state=SnameTextField.getText();
        String pin=pdTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }
            if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Father Name is Required");
            }
            if(maritial.equals("")){
                JOptionPane.showMessageDialog(null,"Marritial status is Required");
            }
            if(EnameTextField.equals("")){
                JOptionPane.showMessageDialog(null,"Email is Required");
            }
            if(pdTextField.equals("")){
                JOptionPane.showMessageDialog(null,"Pin is Required");
            }
            else{
                conn c=new conn();
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+maritial+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new signup2(formno).setVisible(true);
                  
            }
        }catch(Exception e){
            System.out.println(e);
            
            
        }
        
             
     }
    public static void main(String args[]){
        new signup1();
    }
}
