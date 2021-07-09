package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PayBill extends JFrame implements ActionListener{
    JLabel meterLabel,nameLabel,monthLabel,unitsLabel,totalBillLabel, statusLabel;
    JLabel meterValueLabel, nameValueLabel, unitsValueLabel, totalBillValueLabel, statusValueLabel;
    JTextField t1;
    Choice c1,c2;
    JButton payBtn,backBtn;
    String meter;
    PayBill(String meter){
        this.meter = meter;
        setLayout(null);
        setBounds(550, 220, 900, 600);
        setLocationRelativeTo(null);
        
        JLabel title = new JLabel("Electricity Bill");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(120, 5, 400, 30);
        add(title);
        
        meterLabel = new JLabel("Meter No");
        meterLabel.setBounds(35, 80, 200, 20);
        add(meterLabel);
        
        JLabel meterValueLabel = new JLabel();
        meterValueLabel.setBounds(300, 80, 200, 20);
        add(meterValueLabel);
        
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(35, 140, 200, 20);
        add(nameLabel);
        
        JLabel nameValueLabel = new JLabel();
        nameValueLabel.setBounds(300, 140, 200, 20);
        add(nameValueLabel);
        
        monthLabel = new JLabel("Month");
        monthLabel.setBounds(35, 200, 200, 20);
        add(monthLabel);
        
        c1 = new Choice();
        c1.setBounds(300, 200, 200, 20);
        c1.add("January");
        c1.add("February");
        c1.add("March");
        c1.add("April");
        c1.add("May");
        c1.add("June");
        c1.add("July");
        c1.add("August");
        c1.add("September");
        c1.add("October");
        c1.add("November");
        c1.add("December");
        add(c1);
        
        
        unitsLabel = new JLabel("Units");
        unitsLabel.setBounds(35, 260, 200, 20);
        add(unitsLabel);
        
        JLabel unitsValueLabel = new JLabel();
        unitsValueLabel.setBounds(300, 260, 200, 20);
        add(unitsValueLabel);
        
        totalBillLabel = new JLabel("Total Bill");
        totalBillLabel.setBounds(35, 320, 200, 20);
        add(totalBillLabel);
        
        JLabel totalBillValueLabel = new JLabel();
        totalBillValueLabel.setBounds(300, 320, 200, 20);
        add(totalBillValueLabel);
        
        statusLabel = new JLabel("Status");
        statusLabel.setBounds(35, 380, 200, 20);
        add(statusLabel);
        
        JLabel statusValueLabel = new JLabel();
        statusValueLabel.setBounds(300, 380, 200, 20);
        statusValueLabel.setForeground(Color.RED);
        add(statusValueLabel);
        
        
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where meter = '"+meter+"'");
            while(rs.next()){
                meterValueLabel.setText(rs.getString("meter"));
                nameValueLabel.setText(rs.getString("name"));
            }
            rs = c.s.executeQuery("select * from bill where meter = '"+meter+"' AND month = 'January' ");
            while(rs.next()){
                unitsValueLabel.setText(rs.getString("units"));
                totalBillValueLabel.setText(rs.getString("total_bill"));
                statusValueLabel.setText(rs.getString("status"));
            }
        }catch(Exception e){}
        
        c1.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent ae){
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from bill where meter = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");
                    while(rs.next()){
                        unitsValueLabel.setText(rs.getString("units"));
                        totalBillValueLabel.setText(rs.getString("total_bill"));
                        statusValueLabel.setText(rs.getString("status"));
                    }
                }catch(Exception e){}
            }
        });
        
        payBtn = new JButton("Pay");
        payBtn.setBounds(100, 460, 100, 25);
        add(payBtn);
        backBtn = new JButton("Back");
        backBtn.setBounds(230, 460, 100, 25);
        add(backBtn);
        
        payBtn.setBackground(Color.BLACK);
        payBtn.setForeground(Color.WHITE);

        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img\\paybill.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l21 = new JLabel(i3);
        l21.setBounds(400, 120, 600, 300);
        add(l21);
        
        payBtn.addActionListener(this);
        backBtn.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == payBtn){
            try{
                Conn c = new Conn();
                c.s.executeQuery("update bill status = 'Paid' where meter = '"+meter+"' AND month = '"+c1.getSelectedItem()+"'");
                
            }catch(Exception e){}
            this.setVisible(false);
            new Paytm(meter).setVisible(true);

        }else if(ae.getSource()== backBtn){
            this.setVisible(false);
        }        
    }
}
