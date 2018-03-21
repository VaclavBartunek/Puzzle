import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*; //ABSOLUTE VALUE
import java.util.*; // random 


public class Bart implements ActionListener { // specification of class
	
	private int score=0;
	private int prevRow=0;
	private int prevCol=0;
	private int[] index =new int[12];	// index is changed as the posiotion of picture changes
	private  JFrame f1 = new JFrame("Puzzle Game");   //create a blank window
	
	private JPanel p0 = new JPanel(); // main big panel
	private JPanel p1 = new JPanel(); //is inside p0 panel
	private JPanel p2 = new JPanel(); //is inside p0 panel- Status line
	
	private JButton[] b = new JButton[12];
	private JButton greyButton;     //redundant
    private int posOfBlackTile= 0; 

	private JButton newGameBut = new JButton("New Game");
	private JLabel l1 = new  JLabel("    Let's start");  
	
	private GridLayout g = new GridLayout(3,4); 
	private GridLayout g1 = new GridLayout(1,2);
	
	HighScores highScoreTable= new HighScores();
	
	
	
	public Bart() //constructor
	{	
		
		p2.add(newGameBut); 
		p2.add(l1); 
		p2.setSize(444,20);
		p2.setLayout(g1);
		
		p0.add(p1);
		p0.add(p2);
		p0.setLayout(null);
		p0.setSize(444,360+20);

		int i=0;
		for(int c=0;c<4;c++)
		{		
			for(int r=0;r<3;r++)
			{
				ImageIcon ic = new ImageIcon("bart"+i+".jpg");
				b[i] = new JButton(ic);	
				p1.add(b[i]);
				b[i].addActionListener(this);
				index[i]= i;
				i=i+1;				 
			}	
		}
		greyButton = b[0];
		
		p1.setSize(444,360); 
		p1.setLocation(0,20); 
		p1.setLayout(g);
		
		f1.setContentPane(p0);
		f1.setSize(444,360+20);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);    
		
		newGameBut.addActionListener(this);
		

	}
	
	// check if the order of pics os 0-11= end of game
	private void checkPositionOfTiles()
	{
		for(int i=0; i<=11; i++)
		{		
			if(index[i] != i)
			{ 
				return;
			}  
		}
		System.out.println("Game is won" );			
		f1.setVisible(false); 
	}
	
	/* // beg
	private int getRandomNumberInRange(int min, int max) 
	{
	if (min >= max)
	{
		throw new IllegalArgumentException("max must be greater than min");
	}
	Random r = new Random();
	return r.nextInt((max - min) + 1) + min;	
	}
	
	 */ // end
	
	
	public void actionPerformed(ActionEvent e)
	{
	/*    // beg
	if (e.getSource() == newGameBut)	
	{
		int numOfClicks= getRandomNumberInRange(20, 100);
		for (int i=0; i< numOfClicks; i++)
		{
			int picPosition= getRandomNumberInRange(0,11);
			b[picPosition].doClick();
		}	
	}	
		
	else
	{
	*/   //end	
	int x=0; //position of black tile
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
						
						System.out.println("gray before Index at " +posOfBlackTile+ " = " + index[posOfBlackTile]);
						System.out.println("tile Index at " +x+ " = " + index[x]);
						int tempIndex= index[x]; //swap index
						index[x]= index[posOfBlackTile];
						index[posOfBlackTile]= tempIndex;
						System.out.println("gray after Index at " +posOfBlackTile+ " = " + index[posOfBlackTile]);
						System.out.println("tile Index at " +x+ " = " + index[x]);
						
						//System.out.println("col" + col);
						//System.out.println("row" + row);
						//System.out.println(x);
						System.out.println("prev row " + prevRow);
						System.out.println("this row   " + row);
						
						prevRow=row;
						prevCol=col;
						foundTile=true;	
						highScoreTable.incrementScore();   //increment score every time tile is clicked
						l1.setText(" Score:  " + highScoreTable.getScore() );	
						posOfBlackTile= x; 
						checkPositionOfTiles();
						break;
					}
				}	
			x=x+1;
			}
		} 
	}
	//	}  //this
		
}
