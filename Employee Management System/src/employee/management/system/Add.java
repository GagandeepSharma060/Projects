package employee.management.system;
import javax.swing.*;
//import javax.*;
import java.awt.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class Add extends JFrame implements ActionListener{
    
    Random ran= new Random();
    int numb= ran.nextInt(99999);
    
    JTextField namef,phnf,fnamef,fsalary,emailf,desf,addressf;
    JLabel idl;
     JDateChooser dobcs;
     JComboBox edub;
     JButton add;
    
    Add(){
        
        getContentPane().setBackground(Color.BLACK);
       setLayout(null);
        
       JLabel hding = new JLabel("Add Employee Detail");
       hding.setBounds(230,30,500,55);
       hding.setForeground(Color.white);
       hding.setFont(new Font("serif",Font.BOLD,45));
       add(hding);
       
       
       JLabel name= new JLabel("Name:");
       name.setBounds(50,150,180,30);
       name.setForeground(Color.WHITE);
       name.setFont(new Font("serif",Font.PLAIN,20));
       add(name);
       
        namef= new JTextField();
       namef.setBounds(170,150,150,30);
       add(namef);
       
       
       
              
       JLabel fname= new JLabel("Father's Name:");
       fname.setBounds(480,150,180,30);
       fname.setForeground(Color.WHITE);
       fname.setFont(new Font("serif",Font.PLAIN,20));
       add(fname);
       
        fnamef= new JTextField();
       fnamef.setBounds(650,150,150,30);
       add(fnamef);
       
       
        JLabel dob= new JLabel("Date of Birth:");
       dob.setBounds(50,250,180,30);
       dob.setForeground(Color.WHITE);
       dob.setFont(new Font("serif",Font.PLAIN,20));
       add(dob);
       
//       JTextField dobf= new JTextField();
//       dobf.setBounds(170,250,150,30);
//       add(dobf);
       
        dobcs= new JDateChooser();
       dobcs.setBounds(170,250,150,30);
       add(dobcs);

       
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
        edub= new JComboBox(cs);
       edub.setBackground(Color.WHITE);
       edub.setBounds(650,450,150,30);
       add(edub);
       

        JLabel des= new JLabel("Designition:");
       des.setBounds(50,550,180,30);
       des.setForeground(Color.WHITE);
       des.setFont(new Font("serif",Font.PLAIN,20));
       add(des);
       
          desf= new JTextField();
       desf.setBounds(170,550,150,30);
       add(desf);
       
       
       JLabel id= new JLabel("ID No :");
       id.setBounds(480,550,180,30);
       id.setForeground(Color.WHITE);
       id.setFont(new Font("serif",Font.PLAIN,20));
       add(id);
       
        idl= new JLabel(numb+" ");
       idl.setBounds(690,550,180,30);
        idl.setFont(new Font("serif",Font.PLAIN,20));
        idl.setForeground(Color.white);
        add(idl);
        
        
        
         add= new JButton("Add Employee");
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
        setLocation(300,0);
        
        
        
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
            
            String name= namef.getText();
            String fname=fnamef.getText();
            String dob=((JTextField) dobcs.getDateEditor().getUiComponent()).getText();
            String salary =fsalary.getText();
            String address= addressf.getText();
            String phn = phnf.getText();
            String des = desf.getText();
            String education= (String)edub.getSelectedItem();
            String idf= idl.getText();
            String email= emailf.getText();
            
            
            try{
                
                Conn conn = new Conn();
                String query = "insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+address+"','"+phn+"','"+email+"','"+education+"','"+des+"','"+idf+"')";
                conn.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Succesfully");
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
        
        new Add();
    }
    
}
