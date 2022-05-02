import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.File; 
import java.util.Scanner;

public class bal implements ActionListener{
	
		JTextField t1;
		JButton b2, b3, b4;
		JFrame f2;
		public static String bal=null;
		
		bal(){
			
			JPanel p2 = new JPanel();
			f2 = new JFrame("Balance");
			f2.setSize(400, 300);
			f2.setLocationRelativeTo(null);
			f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f2.add(p2);
			p2.setLayout(null);
			
			JLabel titleLabel = new JLabel("Your Available Balance is:");
			JPanel titlePane = new JPanel();
			titlePane.add(titleLabel);
			f2.add("North",titlePane);
			
			
			t1= new JTextField(10);
			t1.setBounds(100, 20, 165, 25);
			t1.setEditable(false);
			p2.add(t1);
		
			b2= new JButton("Check Balance");
			b2.setBounds(80, 70, 300, 25);
			b2.setSize(200, 40);
			p2.add(b2);
		
			b3= new JButton("Back");
			b3.setBounds(80, 130, 50, 25);
			b3.setSize(80, 40);
			p2.add(b3);
		
		
			b4= new JButton("EXIT");
			b4.setBounds(200, 130, 100, 25);
			b4.setSize(80, 40);
			p2.add(b4);
		
		
			f2.show();
		}
		
		public void actionPerformed(ActionEvent e) {

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.. Balance Value Read
String balance1=null;
try {
	  File myObj2 = new File("balance.txt");
	  Scanner myReader2 = new Scanner(myObj2);
	  while (myReader2.hasNextLine()) {
        balance1 = myReader2.nextLine();
        //System.out.println(balance1);
      }
	  myReader2.close();
    } catch (FileNotFoundException t) {
      System.out.println("An error occurred.");
      t.printStackTrace();
    }				
//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 
        if(e.getSource()==b2){  
            //System.out.println("balance");
			
			System.out.println("Your balance is "+balance1+"\n");
			try {
			File balFile = new File("balance.txt");
			Scanner balScn = new Scanner(balFile);
			while (balScn.hasNextLine()) {
				bal = balScn.nextLine();
				System.out.println("Balance : " + bal);
				new bal();
				//JOptionPane.showMessageDialog(null,"Your Balance is : Rs." + bal);
				}
				balScn.close();
			} catch (FileNotFoundException t) {
				System.out.println("An error occurred.");
				t.printStackTrace();
				JOptionPane.showMessageDialog(null,"ERROR - Cant Find balance Database file","Attention..!!",JOptionPane.WARNING_MESSAGE);
				f2.dispose();
				new tr();
			}	
			t1.setText(balance1); 
			
        }else if(e.getSource()==b3){  
            System.out.println("Back");
			f2.dispose();
			new login();
		}else if(e.getSource()==b4){  
            System.out.println("EXIT");
			f2.dispose();
			new end(); 
			//System.exit(0);
        	
        } 	

	}
	public static void main(String[] args) {
		new bal();
	} 

}