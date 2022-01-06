package registration;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LogPage extends JFrame 
{
    JTextField t1, t2;
    JButton btn1, btn2;
    JPanel HPanel;
    JLabel l1, l2;
    String userName, Password, queryLogin;
    
    LogPage()
    {
        setSize(500,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        setLayout(null);
        
        JPanel HPanel = new JPanel();
        HPanel.setBackground(Color.LIGHT_GRAY);
        HPanel.setBounds(0,0,490,50);
        add(HPanel);
         
        JLabel Htxt = new JLabel("Login Form");
        Htxt.setFont((new Font("Arial", Font.BOLD,30)));
        HPanel.add(Htxt);
       
        JTextField t1 = new JTextField();
        t1.setBounds(180,80,280,30);
        add(t1);
        
        JLabel l1 = new JLabel("Username");
        l1.setBounds(70,65,60,60);
        add(l1);
        
        JTextField t2 = new JTextField();
        t2.setBounds(180,180,280,30);
        add(t2);
        
        JLabel l2 = new JLabel("Password");
        l2.setBounds(70,165,60,60);
        add(l2);
        
        JButton btn1 = new JButton("Submit");
        btn1.setBounds(100,280,74,35);
        add(btn1);
        
        JButton btn2 = new JButton("Register");
        btn2.setBounds(300,280,85,35);
        add(btn2);
        
        
        setVisible(true);
        
        btn1.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e) 
            {
  
                userName = t1.getText();
                Password = t2.getText();
                
                DBC db = new DBC();
                queryLogin = "SELECT * FROM `db`";
                db.Login(queryLogin,userName,Password);

                
//                dispose();
//                new AfterLogin();
                
            }            
        });
        
        btn2.addActionListener(new ActionListener() 
        {
             
             @Override
             public void actionPerformed(ActionEvent e) 
             {
                 dispose();
                 new RegPage();
             }
             
         });
        
    }
    
    
}
