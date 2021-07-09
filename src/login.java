package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login {
    JFrame loginFrame;
    JLabel l1,l2,l3, l4;
    JTextField tf1;
    JPasswordField pf2;
    JButton login,cancel, signup;
    JPanel p1,p2,p3,p4;
    Choice c1;

    login(){
        loginFrame=new JFrame("Electricity Billing System");
        loginFrame.setLayout(null);
        loginFrame.getContentPane().setBackground(Color.WHITE);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        l1 = new JLabel("Username");
        l1.setBounds(300, 20, 100, 20);
        loginFrame.add(l1);
        l2 = new JLabel("Password");
        l2.setBounds(300, 60, 100, 20);
        loginFrame.add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(400, 20, 150, 20);
        loginFrame.add(tf1);
        pf2 = new JPasswordField(15);
        pf2.setBounds(400, 60, 150, 20);
        loginFrame.add(pf2);
        
        l4 = new JLabel("Logging in as");
        l4.setBounds(300, 100, 100, 20);
        loginFrame.add(l4);
        
        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(400, 100, 150, 20);
        loginFrame.add(c1);
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("img\\login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        login = new JButton("Login", new ImageIcon(i1));
        login.setBounds(330, 160, 100, 20);
        login.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{        
                    Conn c = new Conn();
                    String a  = tf1.getText();
                    String b  = new String(pf2.getPassword());
                    String user = c1.getSelectedItem();
                    String q  = "select * from login where username = '"+a+"' and password = '"+b+"' and user = '"+user+"'";
                    ResultSet rs = c.s.executeQuery(q);
                    if(rs.next()){
                        String meter = rs.getString("meter_no");
                        new project(meter, user);
                        loginFrame.setVisible(false);
                        loginFrame.dispose();
    
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid login");
                        tf1.setText("");
                        pf2.setText("");
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                    System.out.println("error: "+e);
                }
            }
        });
        loginFrame.add(login);
        
        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("img\\cancel.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        cancel = new JButton("Cancel",new ImageIcon(i2));
        cancel.setBounds(450, 160, 100, 20);
        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                loginFrame.getDefaultCloseOperation();
                loginFrame.dispose();
            }
        });
        loginFrame.add(cancel);
        
        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("img\\signup.png"));
        Image i4 = ic4.getImage().getScaledInstance(16, 16,Image.SCALE_DEFAULT);
        signup = new JButton("Signup",new ImageIcon(i4));
        signup.setBounds(380, 200, 130, 20);
        signup.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new signup().setVisible(true);
                loginFrame.dispose();
            }
        });
        loginFrame.add(signup);

        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("img\\second.jpg"));
        Image i3 = ic3.getImage().getScaledInstance(250, 250,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l3 = new JLabel(icc3);
        l3.setBounds(0, 0, 250, 250);
        loginFrame.add(l3);
        
        loginFrame.setLayout(new BorderLayout());
        loginFrame.setSize(640,300);
        loginFrame.setLocation(600,300);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        
    }
    
}

