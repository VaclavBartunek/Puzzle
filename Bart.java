import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*; //ABSOLUTE VALUE


public class Bart implements ActionListener { // specification of class
	
	int score=0;
		
	JFrame f1 = new JFrame("Puzzle Game");   //create a blank window
	
	JPanel p0 = new JPanel(); 
	JPanel p1 = new JPanel(); //is inside p0 panel
	JPanel p2 = new JPanel(); //is inside p0 panel
	
	JButton[] b = new JButton[12];
	JButton greyButton;     //why?
	
	JLabel l1 = new  JLabel("Let's start");  

	GridLayout g = new GridLayout(3,4); 
	
	HighScores highScoreTable= new HighScores();
	

	
	public Bart() //constructor
	{	
		p2.add(l1); 
		p2.setSize(444,20);
		p0.add(p1);
		p0.add(p2);
		p0.setLayout(null);
		p0.setSize(444,360+20);
		f1.setContentPane(p0);
		
			
		int i=0;
		for(int c=0;c<4;c++)
		{		
			for(int r=0;r<3;r++)
			{
				ImageIcon ic = new ImageIcon("bart"+i+".jpg");
				b[i] = new JButton(ic);	
				p1.add(b[i]);
				b[i].addActionListener(this);
				i=i+1;
			}	
		}
		greyButton = b[0];
		
		p1.setSize(444,360);  //new
		p0.add(p1);  //new
		p1.setLocation(0,20); 
		
		p1.setLayout(g);
		//f1.setContentPane(p1);

		f1.setSize(444,360+20);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);    
		
		
	//	b.getScore();
	//	System.out.println("Your score is" + );
	
	
	}

	int prevRow=0;
	int prevCol=0;
	
	
	public void actionPerformed(ActionEvent e)
	{
	int x=0;
	boolean foundTile = false;
  
		for(int row=0;row<3;row++)
		{		
			if(foundTile)
				break;
			for(int col=0;col<4;col++)
			{ 
				if(e.getSource() == b[x]) // getSource= the object on which the action occured
				{     
					if(((prevRow == row-1 || prevRow == row+1) && prevCol==col) || ((prevCol == col-1 || prevCol == col +1 )&& prevRow == row ))
					{					  
						Icon temporaryIcon = b[x].getIcon();  //?
						b[x].setIcon(greyButton.getIcon());
						greyButton.setIcon(temporaryIcon);
						greyButton = b[x];
						
						//System.out.println("col" + col);
						//System.out.println("row" + row);
						//System.out.println(x);

						System.out.println("prev row " + prevRow);
						System.out.println("this row   " + row);
						
						prevRow=row;
						prevCol=col;
						foundTile=true;	
						highScoreTable.incrementScore();   //increment score every time tile is clicked
							
						break;
					}
				}	
			x=x+1;
			}
		} 
	}
		
}
