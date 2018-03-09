import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.lang.*; //ABSOLUTE VALUE

public class Bart implements ActionListener { // specification of class
		
	JFrame f1 = new JFrame("Puzzle Game");   //create a blank window
	JPanel p1 = new JPanel();
	JButton[] b = new JButton[12];
	JButton greyButton;     //why?
		
	GridLayout g = new GridLayout(3,4); 
	
	public Bart() //constructor
	{
		
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
		
		p1.setLayout(g);
		f1.setContentPane(p1);
		f1.setSize(444,360);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);    
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
						break;
					}
				}	
			x=x+1;
			}
		} 
	}
}
