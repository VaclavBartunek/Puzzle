import javax.swing.*;
import java.awt.event.*;    //action listeners
import java.awt.*;
import java.io.*;

public class HighScores implements ActionListener { // specification of class
		
		
	private int score= 0;	
	
		
		
	private JFrame f1 = new JFrame("HIGH SCORES");   //create a blank window
	JPanel p1 = new JPanel();
	
	
	
	GridLayout myLayout = new GridLayout(11,2); 
	

	JLabel l1 = new  JLabel("hello");
	JLabel l2 = new  JLabel("hello");
	JLabel l3 = new  JLabel("hello");
	JLabel l4 = new  JLabel("hello");
	
	
	JLabel l11 = new  JLabel("YOUR NAME");
	JTextField tf1= new JTextField("Type your name"); 
	
	public HighScores() //constructor
	{
		p1.setLayout(myLayout);
		
        l1.setText(" My text");  
        l2.setText(" My text");  
        l3.setText(" My text");  
        l4.setText(" My text");  
      
		f1.setContentPane(p1);
		f1.setSize(400,300);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);  
		
		p1.setLayout(myLayout);
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		
		p1.add(l11);
		p1.add(tf1);
		
		
		tf1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("The text entered is :["+ tf1.getText()+"]");	
		try{
			FileWriter fw = new FileWriter("Storage.txt",true);
			fw.write(tf1.getText()+"\n");
			fw.close();
		}
		catch(IOException ex){
			System.out.println("Did not find the file");	
		}
	}
	
	public int getScore()
	{
		return score;
	}	
	
	public void incrementScore()
	{
		score=score+1;
		//System.out.println("Your score is" + score);	
	}		
		
		
		 
}
