
/*
* author: Mamoutou Sangare Comp 132, lab 3
* Created on January 2nd, 2015, 11: AM
* This program draws a cross-section of a swimming pool,
 calculates and displays the volume of the pool given its dimensions.
*/

package Labs;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SwimmingPool extends JFrame implements ActionListener {
    
  double width = 5.0;
  int length = 20 ;
  JLabel deepL, shallowL;
  private JPanel panel;
  private JTextField output, deepT, shallowT;
  public static void main(String[] args) {
    SwimmingPool frame = new SwimmingPool();
    frame.setSize(350, 400);
    frame.createGUI();
    frame.setVisible(true);
  }

  private void createGUI() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container window = getContentPane();
    window.setLayout(new FlowLayout());

    panel = new JPanel();
    panel.setPreferredSize(new Dimension(300,300));
    panel.setBackground(Color.white);
    window.add(panel);

    shallowL = new JLabel("Shallow End");
    window.add(shallowL);
    
    shallowT = new JTextField(5);
    window.add(shallowT);
    shallowT.addActionListener(this);
    
    deepL = new JLabel("Deep End");
    window.add(deepL);

    deepT = new JTextField(5);
    window.add(deepT);
    deepT.addActionListener(this);

    output = new JTextField(20);
    window.add(output);
  }

  public void actionPerformed(ActionEvent event) {
    int deepEnd;
    int shallowEnd;
    double volume;
    Graphics paper = panel.getGraphics();
    String inputString;//used to read an input

    inputString = shallowT.getText(); //get the input from the first textfield
    shallowEnd = Integer.parseInt(inputString);

    inputString = deepT.getText();///get the input from the second textfield
    deepEnd = Integer.parseInt(inputString);//converting string into an integer
  
    //============================= Clean the textField to draw a new pool
      paper.setColor(Color.white);
      paper.fillRect(0, 0, 300, 300);
      paper.setColor(Color.black);
    //================================= 
      
    volume = volumeCalcul(shallowEnd, deepEnd); // calculate the volume
    drawPool(paper,40,40,deepEnd,shallowEnd,length); //  draw the pool
   
    output.setText("Volume: " +volume);
  }
  
  private double volumeCalcul(double shallowE, double deepE) {   
      double volume;
      volume= (shallowE+deepE)/2*width*length;
      return volume;
 }
   
   private void drawPool(Graphics paper, int x, int y, int deepEnd,
           int shallowEnd, int length) {
       
      length= length*10;         
      deepEnd = deepEnd*10;
      shallowEnd=shallowEnd*10;
      
      paper.drawLine(x, y, x+length ,y);
      paper.drawLine(x, y, x, y+deepEnd);
      paper.drawLine(x+length, y, x+length, y+shallowEnd);
      paper.drawLine(x, y+deepEnd, x+length, y+shallowEnd);
     
   }
}


