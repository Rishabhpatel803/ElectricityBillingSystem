package src;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateInformation extends JFrame implements ActionListener{
    JTextField addressField, cityField, stateField, emailField, phoneField;
    JLabel l11, l12;
    JButton updateBtn, backBtn;
    String meter;
    UpdateInformation(String meter){
        this.meter = meter;
        setBounds(500, 220, 1050, 450);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel title = new JLabel("UPDATE CUSTOMER INFORMATION");
        title.setBounds(110, 0, 400, 30);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(title);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 70, 100, 20);
        add(l1);
        
        l11 = new JLabel();
        l11.setBounds(230, 70, 200, 20);
        add(l11);
        
        JLabel l2 = new JLabel("Meter Number");
        l2.setBounds(30, 110, 100, 20);
        add(l2);
        
        l12 = new JLabel();
        l12.setBounds(230, 110, 200, 20);
        add(l12);
        
        JLabel l3 = new JLabel("Address");
        l3.setBounds(30, 150, 100, 20);
        add(l3);
        
        addressField = new JTextField();
        addressField.setBounds(230, 150, 200, 20);
        add(addressField);
        
        JLabel l4 = new JLabel("City");
        l4.setBounds(30, 190, 100, 20);
        add(l4);
        
        cityField = new JTextField();
        cityField.setBounds(230, 190, 200, 20);
        add(cityField);
        
        JLabel l5 = new JLabel("State");
        l5.setBounds(30, 230, 100, 20);
        add(l5);
        
        stateField = new JTextField();
        stateField.setBounds(230, 230, 200, 20);
        add(stateField);
        
        JLabel l6 = new JLabel("Email");
        l6.setBounds(30, 270, 100, 20);
        add(l6);
        
        emailField = new JTextField();
        emailField.setBounds(230, 270, 200, 20);
        add(emailField);
        
        JLabel l7 = new JLabel("Phone");
        l7.setBounds(30, 310, 100, 20);
        add(l7);
        
        phoneField = new JTextField();
        phoneField.setBounds(230, 310, 200, 20);
        add(phoneField);
        
        updateBtn = new JButton("Update");
        updateBtn.setBackground(Color.BLACK);
        updateBtn.setForeground(Color.WHITE);
        updateBtn.setBounds(70, 360, 100, 25);
        updateBtn.addActionListener(this);
        add(updateBtn);
        
        backBtn = new JButton("Back");
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBounds(230, 360, 100, 25);
        backBtn.addActionListener(this);
        add(backBtn);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+meter+"'");
            while(rs.next()){
                l11.setText(rs.getString(1));
                l12.setText(rs.getString(2));
                addressField.setText(rs.getString(3));
                cityField.setText(rs.getString(4));
                stateField.setText(rs.getString(5));
                emailField.setText(rs.getString(6));
                phoneField.setText(rs.getString(7));
                
            }
        }catch(Exception e){}
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img\\update.jpg"));
        Image i2  = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l8  = new JLabel(i3);
        l8.setBounds(550, 50, 400, 300);
        add(l8);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == updateBtn){
            String s3 = addressField.getText();
            String s4 = cityField.getText();
            String s5 = stateField.getText();
            String s6 = emailField.getText();
            String s7 = phoneField.getText();
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set address = '"+s3+"', city = '"+s4+"', state = '"+s5+"', email = '"+s6+"', phone = '"+s7+"' where meter = '"+meter+"'");
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                this.setVisible(false);
                
            }catch(Exception e){}
            
        }else if(ae.getSource() == backBtn){
            this.setVisible(false);
        }
    }
}