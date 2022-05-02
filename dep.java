import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File; 
import java.util.Scanner;

public class dep implements ActionListener{
	
	JTextField t1;  
    JButton b2,b3;
	public static JFrame f2;
	public static String bal=null;
	
	dep(){
	
		
		JPanel p2 = new JPanel();
		p2.setBackground(Color.orange);
		f2 = new JFrame("Deposit");
		f2.setSize(400, 300);
		f2.setLocationRelativeTo(null);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.add(p2);
		p2.setLayout(null);
			
			JLabel titleLabel = new JLabel("Enter Amount to Deposit!");
			titleLabel.setFont(new Font("calibri", 1, 22));
			JPanel titlePane = new JPanel();
			titleLabel.setForeground(Color.red);
			titlePane.setBackground(Color.YELLOW);
			titlePane.add(titleLabel);
			f2.add("North",titlePane);
			
			
			JLabel l1 = new JLabel("Amount:");
			l1.setBounds(40, 20, 80, 25);
			p2.add(l1);
			
			t1= new JTextField(10);
			t1.setBounds(100, 20, 165, 25);
			p2.add(t1);
		
			b2= new JButton("Deposit");
			b2.setBounds(95, 100, 50, 25);
			b2.setSize(80, 40);
			b2.setBackground(Color.GREEN);
			b2.setForeground(Color.blue);
			b2.addActionListener(this);
			p2.add("East", b2);
		
			b3= new JButton("Back");
			b3.setBounds(200, 100, 50, 25);
			b3.setSize(80, 40);
			b3.setBackground(Color.GREEN);
			b3.setForeground(Color.blue);
			b3.addActionListener(this);
			p2.add("North", b3);
		
		
			
		
		
		
		f2.show();
	}
	public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b3)
		{
			System.out.println("Back Button ok");
			f2.dispose();
			new tr();
		}
		else 
		{
			//#######################(Read Balance)##########
			try {
			File balFile = new File("balance.txt");
			Scanner balScn = new Scanner(balFile);
			while (balScn.hasNextLine()) {
				bal = balScn.nextLine();
				System.out.println("Balance : " + bal);
				}
				balScn.close();
			} catch (FileNotFoundException t2) {
				System.out.println("An error occurred.");
				t2.printStackTrace();
				JOptionPane.showMessageDialog(null,"ERROR - Cant Find  \" balance.txt \"  file. ","Attention..!!",JOptionPane.WARNING_MESSAGE);
				f2.dispose();
				new tr();
			}
			//#################################
			System.out.println("Deposit Button ok");
			String ReadWithdraw = t1.getText();
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>(Convert string to float)>>>>>>>>>>>>>>>>>>>>>>>>>	
			Float balance1 = Float.parseFloat(bal);
			Float amount = Float.parseFloat(ReadWithdraw);
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
						
				balance1 = balance1 + amount;
				
				//#######################(Store Balance)##########
				String balances =String.valueOf(balance1); // balance value convert to String value	
					
					try {
						FileWriter ReWriteBalance = new FileWriter("balance.txt");
						ReWriteBalance.write(balances);
						ReWriteBalance.close();
						System.out.println("Successfully wrote "+balances+ " Value to the file.");
					} catch (IOException ett) {
						System.out.println("An error occurred.");
						ett.printStackTrace();
						}
					
					//##################################################
				
				
				JOptionPane.showMessageDialog(null, "Deposit Successfully.");
				f2.dispose();
				new tr();
				
		
		}
	}
	
	public static void main (String[] args){ 
	
	new dep();
	}

}