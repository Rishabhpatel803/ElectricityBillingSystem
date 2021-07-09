package src;

import java.awt.*;
import javax.swing.*;

class splash extends Thread
{
    JFrame frame;
    JLabel picLabel= new JLabel(new ImageIcon("img\\splash_logo.jpg"));
    JProgressBar progressBar=new JProgressBar();
    JLabel nameLabel;

    splash()
    {
        createGUI();
        addLogo();
        addProgressBar();
        runningPBar();
    }

    public void createGUI(){
        frame=new JFrame("Electricity Billing System");
        frame.getContentPane().setLayout(null);
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.decode("#E5E5E5"));
        frame.setVisible(true);
    }

    public void addLogo()
    {
        picLabel.setBounds(0, 0, 500, 300);
        frame.add(picLabel);
    }

    public void addProgressBar()
    {
        progressBar.setBounds(50,220,400,20);
        progressBar.setBorderPainted(false);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.decode("#1D3557"));
        progressBar.setValue(0);
        frame.add(progressBar);
    }

    public void runningPBar()
    {
        int i=0;
        while( i<=100)
        {
            try{
                Thread.sleep(50);
                progressBar.setValue(i);
                i++;
                if(i==100){
                    new login();
                    frame.dispose();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new splash();
    }
}