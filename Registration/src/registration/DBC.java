package registration;

import java.sql.*;
import javax.swing.JOptionPane;

public class DBC 
{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public int flag = 0;
    
    DBC()
    {        
        try 
        {           
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB","root","");
            st = con.createStatement();
        } catch (Exception e) 
        {
            System.out.println(e);
        }
        
    }

    public void RegIns(String queryIns) 
    {
        try 
        {
            st.executeUpdate(queryIns);
            JOptionPane.showMessageDialog(null, "Registration Complete");
        } catch (SQLException e)        
        {
            JOptionPane.showMessageDialog(null, "Registration not successfull");
        }
        
    }

    public void Login(String queryLogin, String userName, String Password) 
    {
        
        try
        {
            rs = st.executeQuery(queryLogin);
            
            while(rs.next()) 
            {
                String TuserName = rs.getString(1);
                String TPassword = rs.getString(3);
                
                if(userName.equals(TuserName) && Password.equals(TPassword)) 
                {
                    JOptionPane.showMessageDialog(null, "Welcome!!!");
                    flag = 1;
                    new AfterLogin();
                }
                
            }
            if(flag==0) 
            {
                JOptionPane.showMessageDialog(null, "You Thief");
            }
            
        } catch(Exception e) 
            
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }

}
