import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class index extends JFrame implements ActionListener{
	public JButton bt1 = new JButton("Bubble sort");
	public JButton bt2 = new JButton("Insertion sort");
	public JButton bt3 = new JButton("Selection sort");
	//public JButton start = new JButton("Start");
    
    index(){
        
        getContentPane().setBackground(Color.BLACK);
         setLayout(null);
         
        JLabel hding = new JLabel("Sorting Visualizer");
        hding.setBounds(350,100,1200,80);
        hding.setFont(new Font("serif",Font.PLAIN,60));
        hding.setForeground(Color.WHITE);
       
        add(hding);
        
        
//        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(1500, 700, Image.SCALE_DEFAULT);
//        ImageIcon i3= new ImageIcon(i2);
//        JLabel img= new JLabel(i3);
//        img.setBounds(50,100,1050,500);
//        add(img);
        
        
//        JButton cnt= new JButton("Click to Continue");
//        cnt.setBounds(400,400,300,70);
//        cnt.addActionListener(this);
//        img.add(cnt);
//        
        
        setSize(1170,650);
        setLocation(200,50);
        
        //pack();
        bt1.setBackground(Color.WHITE);
        bt1.setForeground(Color.BLACK);
		bt1.addActionListener(this);
		 bt1.setBounds(100,400,150,50);
		add(bt1);
        setVisible(true);
        
        setSize(1170,650);
        setLocation(200,50);
        
        //pack();
        bt2.setBackground(Color.WHITE);
        bt2.setForeground(Color.BLACK);
		bt2.addActionListener(this);
		 bt2.setBounds(500,400,150,50);
		add(bt2);
        setVisible(true);
        
        
        setSize(1170,650);
        setLocation(200,50);
        
        //pack();
        bt3.setBackground(Color.WHITE);
        bt3.setForeground(Color.BLACK);
		bt3.addActionListener(this);
		 bt3.setBounds(900,400,150,50);
		add(bt3);
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
        if( ae.getSource()==bt1)
        {
        	new BubbleSort().main(null);
        	
        }else if(ae.getSource()==bt2)
        {
        	new InsertionSort().main(null);;
        	
        }else {
        	
        	new Selection().main(null);;
        	
        	
        }
      
        
    }
    
    public static void main(String[] args)
    {
        
//    	JFrame frame= new JFrame("");
//		frame.setResizable(false);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		
//		frame.setContentPane(new index());
//		frame.validate();
//		
//		frame.pack();
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
//		
		new index();
         
        
        
    }
    
}