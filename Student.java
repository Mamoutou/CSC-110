/* @author  Mamoutou Sangare 
 * comp 132 lab 7
 * created on Thursday March 13, 2015, at 2:00 pm
 *Purpose: the program uses two classes.
 * An application class name student and the other one call MyStudent.
 *The application class uses an object call s1 of type MyStudent and calculates
 *the average of s1 and its highest mark using the method from MyStudent class
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Student extends JFrame 
implements ActionListener {
// test main	
  private JButton button;
  private JTextArea output;
  private MyStudent s1; // declare a student of type MyStudent

  public static void main (String[]args){
    Student frame = new Student();
	frame.setSize(400,300);
	frame.createGUI();
	frame.setVisible(true);
  }
	
  private void createGUI(){
    setDefaultCloseOperation (EXIT_ON_CLOSE);
	Container window =getContentPane();
	window.setLayout(new FlowLayout());
	button = new JButton("Go");
	window.add(button);
	button.addActionListener(this);
	output = new JTextArea(10,15); // used to display the the students' information
	window.add(output);
	s1 = new MyStudent();    //  created a student of type MyStudent
	}
	
  public void actionPerformed (ActionEvent e) {
    s1.setName("Mark");   // passing the name to the method  
    s1.setScore(1, 80);  // passing the test number and mark to the the three methods
    s1.setScore(2, 89);
    s1.setScore(3, 92);
		 
 /* displays the student name, the three test marks, the average and the highest mark*/
    output.setText("Student Name: " + s1.getName() +"\n" + "Test1 = "+
       s1.getScore(1) +"\n" +"Test2 = " + s1.getScore(2) + "\n" +
      "Test3 = " + s1.getScore(3) + "\n" + "Average = "+ s1.average() + "\n"+
       "Highest score = "+ s1.getHighScore());
  }
}
//==============================================================================
/* this class represents a student */
class MyStudent {
	
  private String name; 
  private int test1, test2, test3; // students'tests
	
  public MyStudent(){   //using a constructor initialize the three tests to 0 
    test1 = 0;        //and the name to empty string
	test2 = 0;
	test3 = 0;
	name = " ";
  }
  public void setName( String myName){
	name = myName;       // set the student name
  }
	
  public String getName (){
	return name;    //  return the student name
  }
	
/* this method sets the score of a test to the specified test number
 * from 1 to 3 */
  public void setScore(int testNum, int actualScore){
	if (testNum == 1) {
	  test1 = actualScore;
	}
	else if (testNum == 2){
	  test2 = actualScore;
	} else {
	  test3 = actualScore;
	}
  }
	/* this method return the score of the test*/
  public int getScore(int testNum){ 
	if (testNum == 1){
      testNum = test1;
	}
    else if (testNum == 2){
	   testNum = test2;
	}
	else {
	  testNum = test3;
	}
	return testNum;
  }
    
    // this method calculate the average of the three tests
  public double average(){
	double sum, avera;
	sum = test1 + test2 + test3;
	avera = sum / 3;
	return avera;
  }
  
 //this method compares the three exam marks and return the highest mark
  public int getHighScore(){
	int highScore;
	if (( test1 > test2 ) && (test1 > test3 )){
	   highScore = test1;
	 }
	 else if (( test2 > test1 ) && ( test2 > test3 )){
	   highScore = test2;
	 }
	 else {
	   highScore = test3;
	 }
	 return highScore;
  }
}
 
