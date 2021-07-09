package src;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener{
    JPanel signupPanel;
    JTextField userName, name, choice;
    JPasswordField password;
    Choice c1;
    JButton createBtn, backBtn;
    signup(){
        setBounds(600, 250, 700, 400);
        setTitle("Electricity Billing System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        signupPanel = new JPanel();
        signupPanel.setBounds(30, 30, 650, 300);
        signupPanel.setLayout( null);
        signupPanel.setBackground(Color.WHITE);
        signupPanel.setForeground(new Color(34, 139, 34));
        signupPanel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(173, 216, 230)));
        add(signupPanel);
        
        JLabel loginLabel = new JLabel("Username");
        loginLabel.setForeground(Color.DARK_GRAY);
        loginLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        loginLabel.setBounds(100, 50, 100, 20);
        signupPanel.add(loginLabel);
        
        userName = new JTextField();
        userName.setBounds(260, 50, 150, 20);
        signupPanel.add(userName);
        
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setForeground(Color.DARK_GRAY);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameLabel.setBounds(100, 90, 100, 20);
        signupPanel.add(nameLabel);
        
        name = new JTextField();
        name.setBounds(260, 90, 150, 20);
        signupPanel.add(name);
        
        
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setForeground(Color.DARK_GRAY);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setBounds(100, 130, 100, 20);
        signupPanel.add(passwordLabel);
        
        password = new JPasswordField();
        password.setBounds(260, 130, 150, 20);
        signupPanel.add(password);
        
        
        JLabel createLabel = new JLabel("Create Account As");
        createLabel.setForeground(Color.DARK_GRAY);
        createLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        createLabel.setBounds(100, 170, 140, 20);
        signupPanel.add(createLabel);
        
        
        JLabel meterLabel = new JLabel("Meter Number");
        meterLabel.setForeground(Color.DARK_GRAY);
        meterLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        meterLabel.setBounds(100, 210, 100, 20);
        meterLabel.setVisible(false);
        signupPanel.add(meterLabel);
        
        choice = new JTextField();
        choice.setBounds(260, 210, 150, 20);
        choice.setVisible(false);
        signupPanel.add(choice);
        
        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(260, 170, 150, 20);
        signupPanel.add(c1);
        
        c1.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent ae){
               String user = c1.getSelectedItem();
               if(user.equals("Customer")){
                   meterLabel.setVisible(true);
                   choice.setVisible(true);
               }else{
                   meterLabel.setVisible(false);
                   choice.setVisible(false);
               }
           } 
        });
        
        
        createBtn = new JButton("Create");
        createBtn.setBackground(Color.BLACK);
        createBtn.setForeground(Color.WHITE);
        createBtn.setBounds(140, 290, 120, 30);
        createBtn.addActionListener(this);
        signupPanel.add(createBtn);
        
        backBtn = new JButton("Back");
        backBtn.setBackground(Color.BLACK);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBounds(300, 290, 120, 30);
        backBtn.addActionListener(this);
        signupPanel.add(backBtn);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img\\signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(450, 30, 250, 250);
        signupPanel.add(l6);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == createBtn){
            String username = userName.getText();
            String Name = name.getText();
            String pwd = new String(password.getPassword());
            String user = c1.getSelectedItem();
            String meter = choice.getText();
            try{
                Conn c = new Conn();
                String str = null;
                if(user.equals("Admin")){
                    str = "insert into login values('"+meter+"', '"+username+"', '"+Name+"', '"+pwd+"', '"+user+"')";
                }else{
                    str = "update login set username = '"+username+"', name = '"+Name+"', password = '"+pwd+"', user = '"+user+"' where meter_no = '"+choice.getText()+"'";
                }
                
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                this.setVisible(false);
                new login();
            }catch(Exception e){
                
            }
        } else if(ae.getSource()== backBtn){
            this.setVisible(false);
            new login();
        }
    }
}
