package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class remove extends JFrame implements ActionListener {
    
    Choice choice= new Choice();
    JButton delete,back;
    remove()
    {
        setLayout(null);
       
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,400);
        setLocation(300,150);
        
        JLabel id = new JLabel("Emplyee ID:");
        id.setBounds(50,50,100,30);
        add(id);
        
        choice = new Choice();
        choice.setBounds(200,50,150,30);
        add(choice);
        
        
         
        try{
            
            Conn c= new Conn();
            String query = "select * from employee";
            
           ResultSet rs= c.stm.executeQuery(query);
           
           while(rs.next())
           {
               
               choice.add(rs.getString("ID"));
               
               
           }
            
        }catch(Exception ee)
        {
            
            
            
        }
        
         
        JLabel name = new JLabel("Name:");
        name.setBounds(50,100,100,30);
        add(name);
        
         
        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
        
        JLabel phn = new JLabel("Phone No:");
        phn.setBounds(50,150,100,30);
        add(phn);
        
         
        JLabel lblphn = new JLabel();
        lblphn.setBounds(200,150,100,30);
        add(lblphn);
        
         
        JLabel email = new JLabel("Email:");
        email.setBounds(50,200,100,30);
        add(email);
        
         
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200,200,100,30);
        add(lblemail);
        
        
        
         try{
            
            Conn c= new Conn();
            String query = "select * from employee where ID='"+choice.getSelectedItem()+"'";
            
           ResultSet rs= c.stm.executeQuery(query);
           
           while(rs.next())
           {
               
               lblname.setText(rs.getString("name"));
                lblphn.setText(rs.getString("phone"));
                 lblemail.setText(rs.getString("email"));
                 // lblname.setText(rs.getString("name"));
               
           }
            
        }catch(Exception ee)
        {
            
            
            
        }
         

         choice.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            
            
             try{
            
            Conn c= new Conn();
            String query = "select * from employee where ID='"+choice.getSelectedItem()+"'";
            
           ResultSet rs= c.stm.executeQuery(query);
           
           while(rs.next())
           {
               
               lblname.setText(rs.getString("name"));
                lblphn.setText(rs.getString("phone"));
                 lblemail.setText(rs.getString("email"));
                 // lblname.setText(rs.getString("name"));
               
           }
            
        }catch(Exception ee)
        {
            
            
            
        }
            
            
            
        }
        
        
    });
         
         delete= new JButton("Delete");
         delete.setBounds(80,300,100,30);
         delete.setBackground(Color.BLACK);
         delete.setForeground(Color.WHITE);
         delete.addActionListener(this);
         add(delete);
         
         
         
         
         back= new JButton("Back");
          back.setBounds(220,300,100,30);
         back.setBackground(Color.BLACK);
         back.setForeground(Color.WHITE);
         back.addActionListener(this);
         add(back);
         
         
         
           ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        JLabel img= new JLabel(i3);

        img.setBounds(350,0,600,380);
        add(img);
         
         
        
        
        
        setVisible(true);
        
    }
    
   
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==delete)
        {
            
            try{
                
                Conn c= new Conn();
                String query= "delete from employee where ID = '"+choice.getSelectedItem()+"'";
                c.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Deletion Successful");
                setVisible(false);
                new Home();
                
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }else{
            
            setVisible(false);
            new Home();
        }
    }
    public static void main(String args[])
    {
       new remove();
    }
}
