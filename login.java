import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.io.File; 

public class login implements ActionListener{
	
	JFrame f1;
	JLabel userLabel;
	JTextField userText;
	JLabel passwordLabel;
	JPasswordField passwordText;
	JButton button;
	JLabel success;
	public String user="Dinesh";
	public String pw="Dinesh1234";
	
	
	login(){
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.YELLOW);
		f1 = new JFrame("Automated Teller Machine");
		f1.setSize(400, 300);
		f1.setLocationRelativeTo(null);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.add(p1);
		
		p1.setLayout(null);
		
		userLabel = new JLabel("UserName:");
		userLabel.setBounds(40, 40, 80, 25);
		p1.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(110, 40, 165, 25);
		p1.add(userText);
		
		passwordLabel = new JLabel("password:");
		passwordLabel.setBounds(40, 90, 80, 25);
		p1.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(110, 90, 165, 25);
		p1.add(passwordText);
		
		button = new JButton("LOGIN");
		button.setBounds(200, 140, 80, 25);
		button.addActionListener(this);
		button.setBackground(Color.red);
		button.setForeground(Color.black);
		p1.add(button);
		
		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		p1.add(success);
		
		
		
		
		f1.show();
	}


	
	public void actionPerformed(ActionEvent e) {
		
	if(e.getSource()==button){
				
		String readTXT=userText.getText();
		String pwRead=passwordText.getText();
		
			//###################################(DATA input for txt file)##############################
		try {
			FileWriter AccName = new FileWriter("User_Name.txt");
				AccName.write(readTXT);
				AccName.close();
				
		} catch (IOException ett) {
				System.out.println("An error occurred.");
				ett.printStackTrace();
		}
	//################################(DATA read from txt file)#################################
				try {
			FileWriter AccPw = new FileWriter("Acnt.PW.txt");
				AccPw.write(pwRead);
				AccPw.close();
				
		} catch (IOException ett) {
				System.out.println("An error occurred.");
				ett.printStackTrace();
		}
	//##################################################################

		
		if(user.equalsIgnoreCase(readTXT) && pw.equalsIgnoreCase(pwRead))
		{		

		JOptionPane.showMessageDialog(null,"You are sucessfully login");
			f1.dispose();
			new tr();
			
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Incorect Password Or Username");
		}
	}
	else 
	{
		JOptionPane.showMessageDialog(null,"ERROR");
	}


		
	}
		public static void main(String[] args) {
		new login();
	}
	
	
}

