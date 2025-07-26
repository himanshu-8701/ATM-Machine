
package bank.mangement.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class signup2 extends JFrame implements ActionListener{
    String formno;
    JTextField  pan, addhar;
    JButton next;
    JRadioButton  yes, no, eyes, eno;
    JComboBox religion, category, occupation, edu, income;
            
    signup2(String formno){
        this.formno=formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE2");
        
        JLabel additionalDetails = new JLabel("Page 2: ADDITIONAL DETAILS");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD,22));
       additionalDetails.setBounds(260,80,400,30);
        add(additionalDetails);
        
        JLabel name = new JLabel("RELIGON: ");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100,140,200,30);
        add(name);
        
        String valReligion[] = {"Hindu","Muslim","Christian","Sikh","Parsi","Buddhism"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel cname = new JLabel("CATEGORY: ");
        cname.setFont(new Font("Raleway", Font.BOLD,20));
        cname.setBounds(100,190,200,30);
        add(cname);
        
        String valCategory[] = {"Genral","OBC","SC","ST","Others"};
        category = new JComboBox(valCategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel inc = new JLabel("INCOME: ");
        inc.setFont(new Font("Raleway", Font.BOLD,20));
        inc.setBounds(100,240,200,30);
        add(inc);
        
        String valIncome[] = {"NULL","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        income = new JComboBox(valIncome);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);
        
        JLabel education = new JLabel("EDUCATION ");
        education.setFont(new Font("Raleway", Font.BOLD,20));
        education.setBounds(100,290,200,30);
        add(education);
        
        JLabel qual = new JLabel("QUALIFICATION: ");
        qual.setFont(new Font("Raleway", Font.BOLD,20));
        qual.setBounds(100,320,300,30);
        add(qual);
        
        String Education[] = {"Non-Graduate","Graduate","Post-Graduate","Docatrate","Others"};
        edu = new JComboBox(Education);
        edu.setBounds(300,310,400,30);
        edu.setBackground(Color.WHITE);
        add(edu);
       
        JLabel status = new JLabel("OCCUPATION: ");
        status.setFont(new Font("Raleway", Font.BOLD,20));
        status.setBounds(100,390,300,30);
        add(status);
        
        String occuValues[] = {"Salaried","Self-Employeed","Bussinessman","Retired","Student"};
        occupation = new JComboBox(occuValues);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        
        
        JLabel address = new JLabel("PAN NUMBER: ");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100,440,300,30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD,14));
        pan.setBounds(300,440,400,30); 
        add(pan);
        
        JLabel adhar = new JLabel("ADHAR NUMBER: ");
        adhar.setFont(new Font("Raleway", Font.BOLD,20));
        adhar.setBounds(100,490,300,30);
        add(adhar);
        
        addhar = new JTextField();
        addhar.setFont(new Font("Raleway", Font.BOLD,14));
        addhar.setBounds(300,490,400,30); 
        add(addhar);
        
        JLabel state = new JLabel("SENIOR CITIZEN: ");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100,540,300,30);
        add(state);
        
        yes =new JRadioButton("Yes");
        yes.setBounds(400,540,90,30);
        yes.setBackground( Color.WHITE);
        add(yes);
        
        no=new JRadioButton("No");
        no.setBounds(500,540,90,30);
        no.setBackground( Color.WHITE);
        add(no);
       
        ButtonGroup group=new ButtonGroup();
        group.add(yes);
        group.add(no);
       
        JLabel account = new JLabel("EXISTING ACCOUNT: ");
        account.setFont(new Font("Raleway", Font.BOLD,20));
        account.setBounds(100,590,300,30);
        add(account);
        
        eyes =new JRadioButton("Yes");
        eyes.setBounds(400,590,90,30);
        eyes.setBackground( Color.WHITE);
        add(eyes);
        
        eno=new JRadioButton("NO");
        eno.setBounds(500,590,90,30);
        eno.setBackground( Color.WHITE);
        add(eno);
       
        ButtonGroup exgroup=new ButtonGroup();
        exgroup.add(eyes);
        exgroup.add(eno);

        next=new JButton ("Next");
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
    
    public void actionPerformed(ActionEvent e){
       
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) edu.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        
         String senior = null;
        if(yes.isSelected()){
            senior= "Yes";
        }
        else if(no.isSelected()){
            senior = "NO";
        }
        
         String existing = null;
        if(eyes.isSelected()){
            existing = "Yes";
        }
        else if(eno.isSelected()){
            existing = "NO";
        }
       
        String eaddhar = addhar.getText();
        String epan = pan.getText();
   
        
        try{
            conn c = new conn();
            String query = "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+eaddhar+"','"+epan+"','"+senior+"','"+existing+"')";

            c.s.executeUpdate(query);
          
            
            
        }
        catch(Exception a){
           System.out.println(a);
        }

              
   }
    public static void main(String args[]){
        new signup2("");
    }
}

