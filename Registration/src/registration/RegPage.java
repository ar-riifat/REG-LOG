package registration;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RegPage extends JFrame 
{
    JPanel Hpanel;
    JLabel Htxt, l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton btn1, btn2;
    String userName, Email, Password, ConPass, Number, Address, queryIns;
    
     RegPage()
     {
         setSize(500,520);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(3);
         setLayout(null);
         
         JPanel Hpanel = new JPanel();
         Hpanel.setBackground(Color.LIGHT_GRAY);
         Hpanel.setBounds(0,0,490,50);
         add(Hpanel);
         
         JLabel Htxt = new JLabel("Registration Form");
         Htxt.setFont((new Font("Arial", Font.BOLD,30)));
         Hpanel.add(Htxt);
         
         
         JTextField t1 = new JTextField();
         t1.setBounds(180,80,280,30);
         add(t1);
         
         JLabel l1 = new JLabel("Name");
         l1.setBounds(100,80,33,33);
         add(l1);
         
         JTextField t2 = new JTextField();
         t2.setBounds(180,130,280,30);
         add(t2);
         
         JLabel l2 = new JLabel("Email");
         l2.setBounds(100,130,31,31);
         add(l2);
         
         JTextField t3 = new JTextField();
         t3.setBounds(180,180,280,30);
         add(t3);
         
         JLabel l3 = new JLabel("Password");
         l3.setBounds(78,165,60,60);
         add(l3);
         
         JTextField t4 = new JTextField();
         t4.setBounds(180,230,280,30);
         add(t4);
         
         JLabel l4 = new JLabel("Confirm Password");
         l4.setBounds(40,185,120,120);
         add(l4);
         
         JTextField t5 = new JTextField();
         t5.setBounds(180,280,280,30);
         add(t5);
         
         JLabel l5 = new JLabel("Phone Number");
         l5.setBounds(60,250,88,88);
         add(l5);
         
         JTextField t6 = new JTextField();
         t6.setBounds(180,330,280,30);
         add(t6);
         
         JLabel l6 = new JLabel("Address");
         l6.setBounds(90,315,60,60);
         add(l6);
         
         JButton btn1 = new JButton("Submit");
         btn1.setBounds(100,400,74,35);
         add(btn1);
         
         JButton btn2 = new JButton("Login");
         btn2.setBounds(300,400,74,35);
         add(btn2);        
         
         btn2.addActionListener(new ActionListener() 
         {
             
             @Override
             public void actionPerformed(ActionEvent e) 
             {
                 dispose();
                 new LogPage();
             }
             
         });
         
         btn1.addActionListener(new ActionListener() 
         {
             @Override
             public void actionPerformed(ActionEvent e) 
             {  
                 
                 userName = t1.getText();
                 Email = t2.getText();
                 Password = t3.getText();
                 ConPass = t4.getText();
                 Number = t5.getText();
                 Address = t6.getText();

                 
                 //RegexValidationforRegistration                 
                 String userNameRegex = "^[a-zA-Z .]+$";
	            
	         String emailRegex = "^[a-z0-9]+@[a-z]+.[a-z]+$";
	            
	         String mobileRegex = "(\\+88)?-?01[3-9]\\d{8}";
	            
	         String passRegex = "(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%&*()]).{6,20}";
                
	            
	         if(!Pattern.matches(userNameRegex, userName))
                 {
	             JOptionPane.showMessageDialog(null, "Only char is allowed!!");
	         }
	            
	         else if(!Pattern.matches(emailRegex, Email))
                 {
                     JOptionPane.showMessageDialog(null, "In-valid Email!!");                   
                 }                  
	            
	            
	         else if(!Pattern.matches(passRegex, Password))
                 {
	             JOptionPane.showMessageDialog(null, "At least 1 digit, 1 lower, 1 upper, 1 special char and length 6-20 required");
	         }
                
	         else if(!ConPass.equals(Password))
                 {
	             JOptionPane.showMessageDialog(null, "Password and confirm password is not matching!!");
	         }
                
	         else if(!Pattern.matches(mobileRegex, Number))
                 {
	             JOptionPane.showMessageDialog(null, "In-valid Mobile Number!!");
	         }
                
	         else if(Address.equals(""))
                 {
	             JOptionPane.showMessageDialog(null, "In valid address");
	         }
	            
	         else 
                 {                   
                     DBC db = new DBC();
                     queryIns = "INSERT INTO `db`(`Username`, `Email`, `Password`, `ConPass`, `Number`, `Address`) VALUES ('"+userName+"','"+Email+"','"+Password+"','"+ConPass+"','"+Number+"','"+Address+"')";
                     db.RegIns(queryIns);	            	                 
                 }
             }                         
         });
         
        setVisible(true);
        
     } 
     
}
