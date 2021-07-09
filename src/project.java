package src;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class project {
    String meter;
    Font font=new FontUIResource("Liberatian Serif",30,15);
    project(String meter, String person){
        JFrame projectFrame=new JFrame("Electricity Billing System");
        projectFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        projectFrame.setContentPane(new JLabel(new ImageIcon("img\\background.jpg")));
        this.meter=meter;

        JMenuBar mb  = new JMenuBar();

        JLabel mainLabel=new JLabel("Electricity Billing System");
        mainLabel.setFont(new FontUIResource("Liberatian Serif",Font.BOLD,40));
        mainLabel.setBounds(480, 100, 500, 50);
        projectFrame.add(mainLabel);

        /* ------------------Admin----------------------------------- */

        JButton nCustomer=new JButton(new ImageIcon("img\\nc.jpg"));
        nCustomer.setBounds(140, 200, 200, 100);
        nCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new NewCustomer().setVisible(true);
            }
        });
        JLabel newCustomer=new JLabel("New Customer");
        newCustomer.setFont(font);
        newCustomer.setBounds(190, 305, 100, 30);

        JButton custDetails=new JButton(new ImageIcon("img\\customer.png"));
        custDetails.setBounds(440, 200, 200, 100);
        custDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new CustomerDetails().setVisible(true);
            }
        });
        JLabel customerDetails=new JLabel("Customer Details");
        customerDetails.setFont(font);
        customerDetails.setBounds(480, 305, 150, 30);

        JButton depoDetails=new JButton(new ImageIcon("img\\deposit.png"));
        depoDetails.setBounds(740, 200, 200, 100);
        depoDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new DepositDetails().setVisible(true);
            }
        });
        JLabel depositDetails=new JLabel("Deposit Details");
        depositDetails.setFont(font);
        depositDetails.setBounds(790, 305, 100, 30);

        JButton cBill=new JButton(new ImageIcon("img\\billcalculate.jpg"));
        cBill.setBounds(1040, 200, 200, 100);
        cBill.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new CalculateBill().setVisible(true);
            }
        });
        JLabel calculateBill=new JLabel("Calculate Bill");
        calculateBill.setFont(font);
        calculateBill.setBounds(1090, 305, 100, 30);

        /* ------------------------Customer----------------------------- */

        JButton payBill=new JButton(new ImageIcon("img\\paybill.png"));
        payBill.setBounds(740, 200, 200, 100);
        payBill.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new PayBill(meter).setVisible(true);
            }
        });
        JLabel pBillLabel=new JLabel("Pay Bill");
        pBillLabel.setFont(font);
        pBillLabel.setBounds(790, 305, 100, 30);

        JButton lastBill=new JButton(new ImageIcon("img\\lastbill.jpg"));
        lastBill.setBounds(140, 200, 200, 100);
        lastBill.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new BillDetails(meter).setVisible(true); 
            }
        });
        JLabel lastBillLabel=new JLabel("Bill Details");
        lastBillLabel.setFont(font);
        lastBillLabel.setBounds(190, 305, 100, 30);

        JButton genBill=new JButton(new ImageIcon("img\\generatebill.png"));
        genBill.setBounds(440, 200, 200, 100);
        genBill.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new GenerateBill(meter).setVisible(true);
            }
        });
        JLabel genBillLabel=new JLabel("Generate Bill");
        genBillLabel.setFont(font);
        genBillLabel.setBounds(480, 305, 150, 30);

        JButton calculator=new JButton(new ImageIcon("img\\calculator.png"));
        calculator.setBounds(1040, 200, 200, 100);
        calculator.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    Runtime.getRuntime().exec("calc.exe");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JLabel calculatorLabel=new JLabel("Calculator");
        calculatorLabel.setFont(font);
        calculatorLabel.setBounds(1090, 305, 100, 30);

        JButton calculator1=new JButton(new ImageIcon("img\\calculator.png"));
        calculator1.setBounds(140, 400, 200, 100);
        calculator1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    Runtime.getRuntime().exec("calc.exe");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        JLabel calculatorLabel1=new JLabel("Calculator");
        calculatorLabel1.setFont(font);
        calculatorLabel1.setBounds(190, 505, 100, 30);

        JButton logout=new JButton(new ImageIcon("img\\logout.png"));
        logout.setBounds(1280, 30, 50, 50);
        logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new login();
                projectFrame.dispose();
            }
        });

        JButton about=new JButton(new ImageIcon("img\\about.png"));
        about.setBounds(1300, 650, 30, 30);
        about.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new About().setVisible(true);
            }
        });

        JMenu info = new JMenu("Information");
        JMenuItem info1 = new JMenuItem("Update Information");
        JMenuItem info2 = new JMenuItem("View Information");

        info1.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon41 = new ImageIcon(ClassLoader.getSystemResource("img\\icon4.png"));
        Image image41 = icon41.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        info1.setIcon(new ImageIcon(image41));
        info1.setMnemonic('P');
        info1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        info1.setBackground(Color.WHITE);
        info1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new UpdateInformation(meter).setVisible(true);
            }
        });
        
        info2.setFont(new Font("monospaced",Font.PLAIN,12));
        ImageIcon icon42 = new ImageIcon(ClassLoader.getSystemResource("img\\icon6.png"));
        Image image42 = icon42.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        info2.setIcon(new ImageIcon(image42));
        info2.setMnemonic('L');
        info2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        info2.setBackground(Color.WHITE);
        info2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ViewInformation(meter).setVisible(true);
            }
        });

        info.add(info1);
        info.add(info2);
        mb.add(info);

        if(person.equals("Admin")){
            projectFrame.add(nCustomer);
            projectFrame.add(newCustomer);
            projectFrame.add(custDetails);
            projectFrame.add(customerDetails);
            projectFrame.add(depoDetails);
            projectFrame.add(depositDetails);
            projectFrame.add(cBill);
            projectFrame.add(calculateBill);
            projectFrame.add(calculator1);
            projectFrame.add(calculatorLabel1);
            projectFrame.add(logout);
            projectFrame.add(about);
        }else{
            projectFrame.add(payBill);
            projectFrame.add(pBillLabel);
            projectFrame.add(lastBill);
            projectFrame.add(lastBillLabel);
            projectFrame.add(genBill);
            projectFrame.add(genBillLabel);
            projectFrame.add(calculator);
            projectFrame.add(calculatorLabel);
            projectFrame.setJMenuBar(mb);
            projectFrame.add(logout);
            projectFrame.add(about);
        }

        Dimension screenSize= Toolkit.getDefaultToolkit().getScreenSize();
        projectFrame.setSize(screenSize);
        projectFrame.setLayout(null);
        projectFrame.setVisible(true);
    }
}