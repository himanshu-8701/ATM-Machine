package bank.mangement.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class miniStatement extends JFrame {

    String pinnumber;

    miniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        setTitle("Mini Statement");

        JLabel bank = new JLabel("HDFC BANK");
        bank.setBounds(150, 20, 300, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 100);
        add(mini);
        JLabel balance = new JLabel();
        balance.setBounds(20, 300, 300, 100);
        add(balance);

        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from login where  pin_number='5544'");
            while (rs.next()) {
//            card.setText("card number : " + rs.getString("card_number"));
                card.setText("Card number : " + rs.getString("card_number").substring(0, 4) + "XXXXXXXX" + rs.getString("card_number").substring(12));

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        int bal = 0;
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select * from bank where  pin='5544'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp:&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp:&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");

                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));

                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
                balance.setText("your current balance is Rs.="+bal);
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
//    setUndecorate(true);
        setVisible(true);
    }

    public static void main(String args[]) {
        new miniStatement("");

    }

}
