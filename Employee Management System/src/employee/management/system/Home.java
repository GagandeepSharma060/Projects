
package employee.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
public class Home extends JFrame implements ActionListener{
    
    JButton remove;
    JButton view;
    JButton add;
    JButton update;
    Home(){
        
     
        setLayout(null);
        
         ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 620, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img= new JLabel(i3);
        img.setBounds(0,0,1120,630);
        add(img);  
        
        JLabel hding = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        hding.setBounds(200,20,700,70);
         hding.setFont(new Font("serif",Font.PLAIN,40));
        hding.setForeground(Color.WHITE);
        img.add(hding);
        
        
        //add button
         add = new JButton("Add Employee");
        add.setBounds(230,280,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.white);
        img.add(add);
        
          view = new JButton("View Employees");
        view.setBounds(750,280,150,40);
        view.setBackground(Color.BLACK);
        view.addActionListener(this);
        view.setForeground(Color.white);
        img.add(view);
        
             update = new JButton("Update Employee");
        update.setBounds(230,480,150,40);
        update.setBackground(Color.BLACK);
         update.addActionListener(this);
        update.setForeground(Color.white);
        img.add(update);
        
          remove = new JButton("Remove Employee");
        remove.setBounds(750,480,150,40);
         remove.addActionListener(this);
        remove.setBackground(Color.BLACK);
        remove.setForeground(Color.white);
        img.add(remove);
        
               

        
        
           setSize(1120,630);
        setLocation(250,100);
        
        setVisible(true);
        
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==view)
        {
            setVisible(false);
            new view();
        }
        else if(ae.getSource()==add)
        {
            
            setVisible(false);
            new Add();
            
        }
        else if(ae.getSource()==update)
        {
            setVisible(true);
            new view();
        }
        else if(ae.getSource()==remove)
        {
            setVisible(false);
           new remove(); 
        }
    }
    
    public static void main(String args[])
    {
         new Home();
    }
    
}
