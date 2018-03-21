import javax.swing.*;  
import java.awt.event.*;    //action listeners
import java.awt.*;
import java.io.*;
import java.util.Vector; // import vectors


public class HighScores implements ActionListener { // specification of class- score table
		
		
	private int score= 0;	
	
	private JFrame f1 = new JFrame("HIGH SCORES");   //create a blank window
	private JPanel p1 = new JPanel();               
	private Vector <String> namesVector  = new Vector <String>(10,2); // store names, if more then 10 args then *2 spaces
	private Vector <Integer> scoresVector  = new Vector <Integer>(10,2); // store scores
	private GridLayout myLayout = new GridLayout(6,2); 
	private JLabel [] myLabels = new JLabel[10];
	private JLabel l11 = new  JLabel("TYPE YOUR NAME");
	private JTextField nameField= new JTextField("Type your name"); 
	
	public HighScores() //constructor
	{
		// creating lables
		for(int i=0;i<10; i++)
		{	
			myLabels[i]  = new JLabel("-");
		}   
	
		p1.setLayout(myLayout);
		readFile();
		
		// set content of labels
		for(int i=0;i<scoresVector.size()*2;i=i+2)
		{
			myLabels[i].setText(namesVector.elementAt(i/2));
			myLabels[i+1].setText(scoresVector.elementAt(i/2).toString());
			if(i==8)
			 break;
		}
	
		f1.setContentPane(p1);
		f1.setSize(400,300);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // DISPOSE_ON_CLOSE
		f1.setVisible(true);  
		
		p1.setLayout(myLayout);
		
		for(int i=0;i<10;i++)
		{
			p1.add(myLabels[i]);
		}   
		
		p1.add(l11);
		p1.add(nameField);
		
		nameField.addActionListener(this);// when enter is pressed it will store the name
		
	}
	// reading previous data from external file
	private void readFile()                            // dohledej vyznam
	{
		try (BufferedReader br = new BufferedReader(new FileReader("Storage.txt")))
		{
			String line;
			boolean readName=true;

			while ((line = br.readLine()) != null)
			{
				if(readName==true)
				{
					namesVector.add(line);				
				}	
				else 
				{
					Integer convScore= Integer.valueOf(line); // convert string into int
					scoresVector.add(convScore); 			  
				}
				readName = !readName;	
			}
		}
		catch(IOException ex)
		{
			System.out.println("Did not find the file");	
		}
	}
	
	public void actionPerformed(ActionEvent e)
	{

		System.out.println("The text entered is :["+ nameField.getText()+"]");	

		// removing name and score from vector if the name is same	
		for(int i=0;i<namesVector.size();i++)
		{
			//System.out.println( nameField.getText() .equals(namesVector.elementAt(i)));	
			if(nameField.getText().equals(namesVector.get(i)) )
			{
				namesVector.remove(i);
				scoresVector.remove(i);
			}
		} 

		// searching for the smallest score value in the vector
		int insertPos = scoresVector.size();
		for(int i=0;i< scoresVector.size();i++)
		{
			if ( score <= scoresVector.get(i))
			{
				System.out.println("Score Vector number "+ i + " is "+ scoresVector.get(i) + " and should be pushed" );
				insertPos = i;
				break;
			}
		}
		scoresVector.insertElementAt(score,insertPos);    //sets current score to i position in scoreVector
		namesVector.insertElementAt(nameField.getText(),insertPos);	
		
		// writing into file
		try{
				/*FileWriter fw = new FileWriter("Storage.txt",true);  // appending behind the file
				fw.write(nameField.getText()+"\n");
				fw.write( score +"\n");
				fw.close();*/
				
				PrintWriter pw = new PrintWriter("Storage.txt");
				for(int i=0;i<scoresVector.size();i++){
				System.out.println("Vector name "+i+"  is "+ namesVector.get(i) + " has score " + scoresVector.get(i) );

				pw.println(namesVector.elementAt(i));
				pw.println(scoresVector.elementAt(i));
			}
			pw.close();				
			
			}
		catch(IOException ex)
		{
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
				 
}
