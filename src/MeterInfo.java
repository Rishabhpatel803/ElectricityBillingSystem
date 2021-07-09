package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MeterInfo extends JFrame implements ActionListener{
    JLabel meternoLabel,meterLocationLabel,metertypeLabel,billtypeLabel,phaseCodeLabel,daysLabel,noteLabel,imgLabel,thirtydaysLabel, defaultdaysLabel, meterLabel;
    Choice c1, c2, c3,c4, c5;
    JButton submitBtn,cancelBtn;
    MeterInfo(String meter){
        setSize(700,500);
        setLocationRelativeTo(null);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173,216,230));
        
        JLabel title = new JLabel("Meter Information");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(title);
        
        meternoLabel = new JLabel("Meter Number");
        meternoLabel.setBounds(100, 80, 100, 20);
        
        meterLabel = new JLabel(meter);
        meterLabel.setBounds(240, 80, 200, 20);
        p.add(meternoLabel);
        p.add(meterLabel);
        
        meterLocationLabel = new JLabel("Meter Location");
        meterLocationLabel.setBounds(100, 120, 100, 20);
        c1 = new Choice();
        c1.add("Outside");
        c1.add("Inside");
        c1.setBounds(240, 120, 200, 20);
        p.add(meterLocationLabel);
        p.add(c1);
        
        metertypeLabel = new JLabel("Meter Type");
        metertypeLabel.setBounds(100, 160, 100, 20);
        c2 = new Choice();
        c2.add("Electric Meter");
        c2.add("Solar Meter");
        c2.add("Smart Meter");
        c2.setBounds(240, 160, 200, 20);
        p.add(metertypeLabel);
        p.add(c2);
        
        phaseCodeLabel = new JLabel("Phase Code");
        phaseCodeLabel.setBounds(100, 200, 100, 20);
        c3 = new Choice();
        c3.add("011");
        c3.add("022");
        c3.add("033");
        c3.add("044");
        c3.add("055");
        c3.add("066");
        c3.add("077");
        c3.add("088");
        c3.add("099");
        c3.setBounds(240, 200, 200, 20);
        p.add(phaseCodeLabel);
        p.add(c3);
        
        billtypeLabel = new JLabel("Bill Type");
        billtypeLabel.setBounds(100, 240, 100, 20);
        c4 = new Choice();
        c4.add("Normal");
        c4.add("Industrial");
        c4.setBounds(240, 240, 200, 20);
        p.add(billtypeLabel);
        p.add(c4);
        
        daysLabel = new JLabel("Days");
        daysLabel.setBounds(100, 280, 100, 20);
        
        thirtydaysLabel = new JLabel("30 Days");
        thirtydaysLabel.setBounds(240, 280, 200, 20);
        p.add(daysLabel);
        p.add(thirtydaysLabel);
        
        noteLabel = new JLabel("Note");
        noteLabel.setBounds(100, 320, 100, 20);
        defaultdaysLabel = new JLabel("By Default Bill is calculated for 30 days only");
        defaultdaysLabel.setBounds(240, 320, 300, 20);
        p.add(noteLabel);
        p.add(defaultdaysLabel);
        
        submitBtn = new JButton("Submit");
        submitBtn.setBounds(120, 390, 100, 25);
        cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(250, 390, 100, 25);
        
        submitBtn.setBackground(Color.BLACK);
        submitBtn.setForeground(Color.WHITE);
        
        cancelBtn.setBackground(Color.BLACK);
        cancelBtn.setForeground(Color.WHITE);
        
        p.add(submitBtn);
        p.add(cancelBtn);
        setLayout(new BorderLayout());
        
        add(p,"Center");
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("img\\hicon1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 300,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        imgLabel = new JLabel(ic2);
        
        
        add(imgLabel,"West");
        //for changing the color of the whole Frame
        getContentPane().setBackground(Color.WHITE);
        
        submitBtn.addActionListener(this);
        cancelBtn.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submitBtn){
            String meter_number = meterLabel.getText();
            String meter_location = c1.getSelectedItem();
            String meter_type = c2.getSelectedItem();
            String phase_code = c3.getSelectedItem();
            String bill_type = c4.getSelectedItem();
            String days = "30";

            String q1 = "insert into meter_info values('"+meter_number+"','"+meter_location+"','"+meter_type+"','"+phase_code+"','"+bill_type+"','"+days+"')";
            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Meter Info Added Successfully");
                this.setVisible(false);

            }catch(Exception ex){
                 ex.printStackTrace();
            }
        }else if(ae.getSource() == cancelBtn){
            this.setVisible(false);
        }
    }
}
