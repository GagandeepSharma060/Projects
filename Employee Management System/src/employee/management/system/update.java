package employee.management.system;
import javax.swing.*;
//import javax.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;
import java.sql.*;

public class update extends JFrame implements ActionListener{
    
//    Random ran= new Random();
//    int numb= ran.nextInt(99999);
    
    JTextField namef,phnf,fnamef,fsalary,emailf,desf,addressf,edub;
    JLabel idl;
     JDateChooser dobcs;
   
     JButton add;
    String id;
    update(String id){
        this.id=id;
        
        getContentPane().setBackground(Color.BLACK);
       setLayout(null);
        
       JLabel hding = new JLabel("Update Employee Details");
       hding.setBounds(230,30,500,55);
       hding.setForeground(Color.white);
       hding.setFont(new Font("serif",Font.BOLD,45));
       add(hding);
       
       
       JLabel name= new JLabel("Name:");
       name.setBounds(50,150,180,30);
       name.setForeground(Color.WHITE);
       name.setFont(new Font("serif",Font.PLAIN,20));
       add(name);
       
        JLabel lblname= new JLabel();
       lblname.setBounds(170,150,150,30);
        lblname.setForeground(Color.WHITE);
       add(lblname);
       
       
       
              
       JLabel fname= new JLabel("Father's Name:");
       fname.setBounds(480,150,180,30);
       fname.setForeground(Color.WHITE);
       fname.setFont(new Font("serif",Font.PLAIN,20));
       add(fname);
       
        JLabel fnamelbl= new JLabel();
       fnamelbl.setBounds(650,150,150,30);
        fnamelbl.setForeground(Color.WHITE);
       add(fnamelbl);
       
       
        JLabel dob= new JLabel("Date of Birth:");
       dob.setBounds(50,250,180,30);
       dob.setForeground(Color.WHITE);
       dob.setFont(new Font("serif",Font.PLAIN,20));
       add(dob);
       
//       JTextField dobf= new JTextField();
//       dobf.setBounds(170,250,150,30);
//       add(dobf);
       
        JLabel ldobcs= new JLabel();
       ldobcs.setBounds(170,250,150,30);
       add(ldobcs);

       
         JLabel salary= new JLabel("Salary:");
       salary.setBounds(480,250,180,30);
       salary.setForeground(Color.WHITE);
       salary.setFont(new Font("serif",Font.PLAIN,20));
       add(salary);
       
        fsalary= new JTextField();
       fsalary.setBounds(650,250,150,30);
       add(fsalary);

       
       
        JLabel address= new JLabel("Address:");
       address.setBounds(50,350,180,30);
       address.setForeground(Color.WHITE);
       address.setFont(new Font("serif",Font.PLAIN,20));
       add(address);
       
          addressf= new JTextField();
       addressf.setBounds(170,350,150,30);
       add(addressf);
       
       
       JLabel phn= new JLabel("Phone No:");
       phn.setBounds(480,350,180,30);
       phn.setForeground(Color.WHITE);
       phn.setFont(new Font("serif",Font.PLAIN,20));
       add(phn);
       
        phnf= new JTextField();
       phnf.setBounds(650,350,150,30);
       add(phnf);
       
       
       JLabel email= new JLabel("Email:");
       email.setBounds(50,450,180,30);
       email.setForeground(Color.WHITE);
       email.setFont(new Font("serif",Font.PLAIN,20));
       add(email);
       
          emailf= new JTextField();
       emailf.setBounds(170,450,150,30);
       add(emailf);
       
        JLabel edu= new JLabel("Education Level:");
       edu.setBounds(480,450,180,30);
       edu.setForeground(Color.WHITE);
       edu.setFont(new Font("serif",Font.PLAIN,20));
       add(edu);
       String cs[]= {"" ,"BTech","MBA","BBA","BCA","BSc","MSc","BA","BCom","MCom"};
        edub= new JTextField();
       edub.setBackground(Color.WHITE);
       edub.setBounds(650,450,150,30);
       add(edub);
       

        JLabel des= new JLabel("Designation:");
       des.setBounds(50,550,180,30);
       des.setForeground(Color.WHITE);
       des.setFont(new Font("serif",Font.PLAIN,20));
       add(des);
       
          desf= new JTextField();
       desf.setBounds(170,550,150,30);
       add(desf);
       
       
       JLabel id1= new JLabel("ID No :");
       id1.setBounds(480,550,180,30);
       id1.setForeground(Color.WHITE);
       id1.setFont(new Font("serif",Font.PLAIN,20));
       add(id1);
       
        idl= new JLabel();
       idl.setBounds(690,550,180,30);
        idl.setFont(new Font("serif",Font.PLAIN,20));
        idl.setForeground(Color.white);
        add(idl);
        
        
        try{
            
            Conn c= new Conn();
            String query="select * from employee where ID= '"+id+"'";
            ResultSet rs= c.stm.executeQuery(query);
            
            while(rs.next())
            {
                
                idl.setText(rs.getString("ID"));
                lblname.setText(rs.getString("name"));
                fnamelbl.setText(rs.getString("fname"));
                ldobcs.setText(rs.getString("dob"));
                
                phnf.setText(rs.getString("phone"));
                
                fsalary.setText(rs.getString("salary"));
                emailf.setText(rs.getString("email"));
                desf.setText(rs.getString("Designation"));
                addressf.setText(rs.getString("address"));
                edub.setText(rs.getString("Education"));
                
        
                
                
                
            }
            
            
            
        }catch(Exception ee)
        {
            ee.printStackTrace();
        }
        
        
        
         add= new JButton("Update Details");
        add.setBounds(200,650,200,50);
        add.setFont(new Font("serif",Font.PLAIN,20));
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        
        
        
         JButton back= new JButton("Back");
        back.setBounds(470,650,200,50);
        back.setFont(new Font("serif",Font.PLAIN,20));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        
       
       
       
       
        setSize(900,800);
        setLocation(300,300);
        
        
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
//         JTextField namef,phnf,fnamef,fsalary,emailf,desf,addressf;
//    JLabel id;
//     JDateChooser dobcs;
//     JComboBox edub;
//    
        if(ae.getSource()==add)
        {
            
            //String name= namef.getText();
            //String fname=fnamef.getText();
            //String dob=((JTextField) dobcs.getDateEditor().getUiComponent()).getText();
            String salary =fsalary.getText();
            String address= addressf.getText();
            String phn = phnf.getText();
            String des = desf.getText();
            String education= edub.getText();
            String idf= idl.getText();
            String email= emailf.getText();
            
            
            
            try{
                
                Conn conn = new Conn();
                String query = "update  employee set salary='"+salary+"',address='"+address+"',phone='"+phn+"',email='"+email+"',Education='"+education+"',designation='"+des+"'where ID='"+idf+"'";
                conn.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Succesfully");
                setVisible(false);
                new Home();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
            new Login();
            
        }
        
        
    }
    public static void main(String[] args)
    {
        
        new update("");
    }
    
}
