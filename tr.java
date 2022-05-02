import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File; 
import java.util.Scanner;

public class tr implements ActionListener {
	
	
	JFrame f2;
	JLabel titleLabel;
	JPanel p2,p3;
	JButton b1,b2,b3,b4;
	public static String bal=null;
	
	tr(){
	
			p2 = new JPanel();
			p2.setBackground(Color.ORANGE);
			f2 = new JFrame("Transaction");
			f2.setSize(400, 300);
			f2.setLocationRelativeTo(null);
			f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			p2.setLayout(null);
			
			titleLabel = new JLabel("Select Transaction You Want!");
			titleLabel.setForeground(Color.red);
			titleLabel.setFont(new Font("calibri", 1, 22));
			p3 = new JPanel();
			p3.setBackground(Color.YELLOW);
			p3.add(titleLabel);
			f2.add("North",p3);
			
		
			b1= new JButton("Withdraw");
			b1.setBounds(50, 25, 150, 100);
			b1.setSize(100, 50);
			b1.setBackground(Color.GREEN);
			b1.setForeground(Color.blue);
			b1.addActionListener(this);
			p2.add(b1);
		
			b2= new JButton("Deposit");
			b2.setBounds(50, 100, 100, 25);
			b2.setSize(100, 50);
			b2.setBackground(Color.GREEN);
			b2.setForeground(Color.blue);
			b2.addActionListener(this);
			p2.add(b2);
		
			b3= new JButton("Balance");
			b3.setBounds(225, 25, 150, 100);
			b3.setSize(100, 50);
			b3.setBackground(Color.GREEN);
			b3.setForeground(Color.blue);
			b3.addActionListener(this);
			p2.add(b3);
		
		
			b4= new JButton("EXIT");
			b4.setBounds(225, 100, 100, 25);
			b4.setSize(100, 50);
			b4.setBackground(Color.GREEN);
			b4.setForeground(Color.red);
			b4.addActionListener(this);
			p2.add(b4);
		
		
		
		
		
		f2.add(p2);
		
		f2.show();
	}
		public void actionPerformed(ActionEvent e) {  
			
		
		 if(e.getSource()==b1)
		 {  
            System.out.println("Withdraw");
			f2.dispose();
			new with();
			
				
        }
		else if(e.getSource()==b2)
		{  
            System.out.println("Deposit");
			f2.dispose();
			new dep();
			
        }
		else if(e.getSource()==b3)
		{  
			System.out.println("Balance Button Clicked");
			try {
			File balFile = new File("balance.txt");
			Scanner balScn = new Scanner(balFile);
			while (balScn.hasNextLine()) {
				bal = balScn.nextLine();
				System.out.println("Balance : " + bal);
				JOptionPane.showMessageDialog(null,"Your Balance is : Rs." + bal);
				}
				balScn.close();
			} catch (FileNotFoundException t) {
				System.out.println("An error occurred.");
				t.printStackTrace();
				JOptionPane.showMessageDialog(null,"ERROR - Cant Find balance Database file","Attention..!!",JOptionPane.WARNING_MESSAGE);
				f2.dispose();
				new tr();
			}	
        }
		else
		{  
            System.out.println("EXIT");
			f2.dispose();
			new end(); 
        }  
		
	}
	
	
	public static void main(String[] args){
	
	new tr();
		
	}
}