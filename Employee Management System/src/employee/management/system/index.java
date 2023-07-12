package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class index extends JFrame implements ActionListener{
    
    index(){
        
        getContentPane().setBackground(Color.BLACK);
         setLayout(null);
         
        JLabel hding = new JLabel("Employee Management System");
        hding.setBounds(180,30,1200,80);
        hding.setFont(new Font("serif",Font.PLAIN,60));
        hding.setForeground(Color.WHITE);
       
        add(hding);
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 700, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(50,100,1050,500);
        add(img);
        
        
        JButton cnt= new JButton("Click to Continue");
        cnt.setBounds(400,400,300,70);
        cnt.addActionListener(this);
        img.add(cnt);
        
        
        setSize(1170,650);
        setLocation(200,50);
        
        //pack();
       
        //setResizable(true);
        setVisible(true);
        
        //To flicker heading
//        while(true)
//        {
//            hding.setVisible(false);
//            
//            try{
//                Thread.sleep(500);
//            }catch(Exception e)
//            {
//                
//            }
//            
//            hding.setVisible(true);
//             try{
//                Thread.sleep(1000);
//            }catch(Exception e)
//            {
//                
//            }
 //       }
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        setVisible(false);
        new Login();
        
    }
    
    public static void main(String[] args)
    {
        
         new index();
        
        
    }
    
}
