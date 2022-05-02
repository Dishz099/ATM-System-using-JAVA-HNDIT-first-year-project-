import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.io.File; 

public class end implements ActionListener{
	
	JFrame f1;
	JButton b1;
	JPanel p1;
	JLabel l;
	
	
	end(){
		p1 = new JPanel();
		p1.setBackground(Color.ORANGE);
		f1 = new JFrame("END");
		f1.setSize(400, 300);
		f1.setLocationRelativeTo(null);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.add(p1);
		p1.setLayout(null);
		
		
		
		l= new JLabel("THANK YOU! COME AGAIN!");
		l.setBounds(110, 50, 300, 100);
		p1.add(l);
		
		b1= new JButton("EXIT");
		b1.addActionListener(this);
		b1.setBounds(150, 180, 100, 25);
		b1.setSize(80, 40);
		b1.setBackground(Color.GREEN);
		b1.setForeground(Color.red);
		p1.add(b1);
		
		
		f1.show();
		
	}
		
	public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1)
		{
			System.out.println("exit Button Clicked");
			System.exit(0);
		}
	}
		public static void main(String[] args) {
		new end();
	}
	
}