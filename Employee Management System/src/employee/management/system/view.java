package employee.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
public class view extends JFrame implements ActionListener {
    
    JTable table;
    Choice choice;
    JButton searchButton,print,update, back;
    
    view(){
        
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JLabel search = new JLabel("Search by ID");
        search.setBounds(30,20,150,20);
        search.setBackground(Color.WHITE);
        search.setForeground(Color.WHITE);
        add(search);
       
        choice = new Choice();
        choice.setBounds(180,20,150,150);
        add(choice);
        
        table = new JTable();
        
        try{
            
            Conn c= new Conn();
            
        ////////////
            ResultSet rs= c.stm.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            //table.setBackground(Color.BLACK);
            
           
            
        }catch(Exception e)
        {
            e.printStackTrace();   
        
        }
        
         try{
            
            Conn c= new Conn();
            
        ////////////
            ResultSet rs= c.stm.executeQuery("select * from employee");
            //table.setModel(DbUtils.resultSetToTableModel(rs));
            //table.setBackground(Color.BLACK);
            
            while(rs.next())
            {
                choice.add(rs.getString("ID"));
                
                
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();   
        
        }
        
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(30,100,840,520);
        add(sp);
        
        searchButton = new JButton("Search");
        searchButton.setBounds(30,70,80,20);
        searchButton.addActionListener(this);
           searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.white);
        add(searchButton);
        
        
          print = new JButton("Print");
        print.setBounds(145,70,80,20);
        print.addActionListener(this);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.white);
        add(print);
        
        
           update = new JButton("Update");
        update.setBounds(265,70,80,20);
        update.addActionListener(this);
         update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        add(update);
        
        
           back = new JButton("Back");
        back.setBounds(385,70,80,20);
        back.addActionListener(this);
         back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        add(back);
        
        
        
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
            
    
    
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==searchButton)
        {
            
            String query = "select * from employee where ID ='"+choice.getSelectedItem()+"'";
            
            try{
                
                Conn c= new Conn();
                ResultSet rs= c.stm.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception ee)
            {
                
            }
            
        }else  if(ae.getSource()==print)
        {
            try{
                
                table.print();
                
            }catch(Exception ee)
            {
                
            }
        }else if(ae.getSource()==update)
        {
            setVisible(false);
            new update(choice.getSelectedItem());
            
            
        }else if(ae.getSource()==back)
        {
            setVisible(false);
            new Home();
        }
        
        
    }
    public static void main(String[] args)
    {
        new view();
        
    }
    
    
    
}
