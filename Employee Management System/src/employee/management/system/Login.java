package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tf;
    JTextField tf1;
    Login(){
        
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel id = new JLabel("Username");
        id.setBounds(40,70,100,30);
        id.setForeground(Color.WHITE);
        add(id);
        
         tf= new JTextField();
        tf.setBounds(150,70,150,30);
        add(tf);
        
        JLabel pswrd = new JLabel("Password");
        pswrd.setBounds(40,130,100,30);
        
         pswrd.setForeground(Color.WHITE);
         
        add(pswrd);
        
          JButton login= new JButton("Login");
        login.setBounds(150,200,150,30);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        JLabel img= new JLabel(i3);

        img.setBounds(350,30,200,200);
        add(img);
        
        
        
          
         tf1= new JTextField();
        tf1.setBounds(150,130,150,30);
        add(tf1);
        
        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent ae)
    {
        try{
            
            String userName= tf.getText();
            String password= tf1.getText();
            Conn c= new Conn();
            String query = "select * from login where username='"+userName+"' and password = '"+password+"'"; 
            
           ResultSet rs= c.stm.executeQuery(query);
           if(rs.next())
           {
               
               setVisible(false);
               new Home();
              
               
               
           }else{
               
               JOptionPane.showMessageDialog(null,"Invalid Username/Password");
               setVisible(false);
               
           }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args)
    {
        new Login();
    }
}
