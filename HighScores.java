import javax.swing.*;
import java.awt.event.*;    //action listeners
import java.awt.*;
import java.io.*;
import java.util.Vector; // import vectors

public class HighScores implements ActionListener { // specification of class
		
		
	private int score= 0;	
	
		
		
	private JFrame f1 = new JFrame("HIGH SCORES");   //create a blank window
	private JPanel p1 = new JPanel();
	private Vector <String> namesVector  = new Vector <String>(10,2); // if more then 10 args then *2 spaces
	private Vector <Long> scoresVector  = new Vector <Long>(10,2);
	
	private GridLayout myLayout = new GridLayout(11,2); 
	
	private	JLabel l1 = new  JLabel("hello");
	private JLabel l2 = new  JLabel("hello");
	private JLabel l3 = new  JLabel("hello");
	private JLabel l4 = new  JLabel("hello");
	
	private JLabel l11 = new  JLabel("YOUR NAME");
	private JTextField nameField= new JTextField("Type your name"); 
	
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
		p1.add(nameField);
		
		nameField.addActionListener(this);
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		namesVector.add(new String(nameField.getText()));	// storing name into vector
		scoresVector.add(new Long(score));	// store score into vector
	
	

	//	System.out.println("The text entered is :["+ nameField.getText()+"]");	
	//  System.out.println("Vector Name 0  is "+ namesVector.get(0) );
	//	System.out.println("Vector Name 1  is "+ namesVector.get(1) );
	//	System.out.println("Vector Score 0  is "+ scoresVector.get(0) );
	//	System.out.println("Vector Score 1  is "+ scoresVector.get(1) );
	//	System.out.println("Are they same" + nameField.getText() == namesVector.get(0));



			// searching for the same name ???
		/*for(int i=0;i<10;i++)
		{

		if(nameField.getText() == namesVector.get(i))
			{
				System.out.println( i + " is position of same name \n" ); 
				System.out.println( nameField.getText() == namesVector.get(i));
				break; 
			}
		} */
		
	/*	
		// searching for the smallest score value
		for(int i=0;i<10;i++)
		{
			//System.out.println("Vector Score  is "+ scoresVector.get(i) );
			if ( score <= scoresVector.get(i))
			{
				System.out.println("Score Vector number "+ i + " is "+ scoresVector.get(i) + " and should be pushed" );
				long temp = scoresVector.get(i);
				scoresVector.set(i,score);    //sets current score to i position 
				temp2= scoresVector(i+1) ;
				ScoresVector(i+1)= temp;
				
			}
			
		}
		
			*/ 
		 
		 
		// writing into file
		try{
			FileWriter fw = new FileWriter("Storage.txt",true);
			fw.write(nameField.getText()+"\n");
			fw.write( score +"\n");
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
		System.out.println("Your score is" + score);	
	}		
		
	
	
	 // if (gameFinished)
		 
}
