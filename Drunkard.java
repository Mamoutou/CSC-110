/*  @author Mamoutou Sangare comp 132, lab 5 
 * created on March 5, 2015
 * Purpose: simulate a drunkard trying to 
 * reach the outskirts of town in 50 
 * or less moves moving in random directions.
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class  DrunkardLab extends 
JFrame implements ActionListener {
	
    private JButton button;
    private JPanel panel;
    private Random random;

    public static void main(String[] args) {
    	 DrunkardLab frame = new  DrunkardLab();
         frame.setSize(500,450);
         frame.createGUI();
         frame.setVisible(true);
    }

    private void createGUI() {
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       Container window = getContentPane();
       window.setLayout(new FlowLayout());

       panel = new JPanel();
       panel.setPreferredSize(new Dimension(400,350));
       panel.setBackground(Color.white);
       window.add(panel);

       button = new JButton("Click here");
       window.add(button);
       button.addActionListener(this);
       random = new Random();
   }
//===========================================
    
   public void actionPerformed(ActionEvent e) {
	   
      Graphics paper = panel.getGraphics();
      
       /* calling the method responsible to draw the 11 vertical lines */
       drawingVerticalLine (paper,20,20);
       
       /* calling the method responsible to draw the 11 horizontal lines */
       drawingHorizontalLines(paper,20,20);
  
       action();  // calling the action method 
   }
//=======================================================
// this method draw the 11 vertical lines

    public void drawingVerticalLine(Graphics paper, int x, int y){ 
    	x = 20;
        int count =1;
        while (count <=11){
      	   paper.drawLine(x, 20, x, 220);
      	   count++;
      	   x =x+20;
      	}
    }
 //========================================================== 
        // this method draw the 11 horizontal lines
      public void drawingHorizontalLines (Graphics paper, int x, int y){ 
    	  y = 20;
    	  int count =1;
    	  while (count <=11){
    		  paper.drawLine(20, y,220,y);
    		  count++;
    		  y = y + 20;
    	  }
      }
 //============================================================     
/* this method draws and move the ball. It also passes
 *  its local variables (x,y, maxMoves)
* to the method result which displays the output  
       */
      public void action() {
          int x = 220 / 2, y = 220 / 2;   //Drunks original x and y position
          int diameter = 10;             //diameter of drunk
          int xStep, yStep;             // distance of each block
          yStep = 20;
          xStep = 20;
          int direction;
          int maxMoves;
         
         Graphics paper = panel.getGraphics();
         paper.setColor(Color.red);//draws drunk's original position
         paper.fillOval(x, y, diameter, diameter);
         delay();

         //test if outskirts of town is reached in 50 or less moves
         for ( maxMoves = 0; maxMoves<=50 && x > 20 && x < 220
                && y>20  && y < 220; maxMoves++) {
        	 
             paper.setColor(Color.white);    //erases previous position
             paper.fillOval(x, y, diameter, diameter); //draw the ball
             direction = random.nextInt(4); //simulates random movement

             if (direction == 0) { //moves drunk south
                 x = x - xStep;
             } else if (direction == 1) { //moves drunk north 
                 x = x + xStep;
             } else if (direction == 2) { //moves drunk east
                 y = y + yStep;
             } else {
                 y = y - yStep; //moves drunk west 
             }

             paper.setColor(Color.red); //draws drunk's final position
             paper.fillOval(x, y, diameter, diameter);
             delay();
             paper.setColor(Color.white);  //erases previous position
             paper.fillOval(x, y, diameter, diameter);
         }
            result(x,y,maxMoves); // passing the parameters to result method
      } 
     //===================================================== 
      /*
       * This  method displays if outskirts of town is
       *  reach and calculates total distance
       */
     public static void result (int xResult, int yResult, int maxMovesResult) {
          if (!( 20 < xResult && xResult > 220 && 20 < yResult 
        		  && yResult > 220) && maxMovesResult <= 50 ) {
          	  JOptionPane.showMessageDialog(
                null, "You luckily made it! \n"+ "You have travelled: "
                 + (maxMovesResult * 100) + " meters");
         } 
         else { 
                  JOptionPane.showMessageDialog(
                   null, "You have failed to reach the outside of the town!");
        }
     }
 //====================================================================================        
         private void delay() {  // this method gives a waiting time of 200
              try {              // millisecond to the program
                  Thread.sleep(200);
              } catch (InterruptedException e) {
              	 
              }
         }
       }
