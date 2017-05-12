/* @author  Mamoutou Sangare 
 * comp 132 lab 5
 * created on Monday 23, 2015, 4:00 pm
 *Purpose: This program Prompt the user to enter day,
 * month and year of a given date and then calculate 
 * the date following the date given by the user.
 * It also detects wrong (ex: month =13) and displays
 * an error message by asking the user to enter correct 
 * date
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TomorrowDate extends JFrame
  implements ActionListener {
	
  JLabel dayL, monthL,yearL;
  private JTextField  dayT, monthT, yearT;
  
  public static void main(String[] args) {
    TomorrowDate frame = new TomorrowDate();
    frame.setSize(400,400);
    frame.createGUI();
    frame.setVisible(true);
  }

  private void createGUI() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    Container window = getContentPane();
    window.setLayout(new FlowLayout() );
    
    dayL = new JLabel("Enter the day for today's date");
    window.add(dayL);
    dayT = new JTextField(13);
    window.add(dayT);
    dayT.addActionListener(this);

    monthL = new JLabel("Enter the month for today's date");
    window.add(monthL);
    monthT = new JTextField(13);
    window.add(monthT);
    monthT.addActionListener(this);
    
     yearL = new JLabel ("Enter the year for today's date");
     window.add(yearL);
     yearT = new JTextField(13);
     window.add(yearT);
     yearT.addActionListener(this);
  }

  public void actionPerformed(ActionEvent event) {
	 int day;      // day, month and year declaration
	 int month;   
	 int year;   
	 String inputString;//used to read an input
     int maxDays; //max days for a specific month
     
    inputString = dayT.getText(); //get the input from the first textfield
    day = Integer.parseInt(inputString);

    inputString = monthT.getText();  //get the input from the second textfield
    month = Integer.parseInt(inputString);  //converting string into an integer
     
    inputString = yearT.getText();  //get the input from the third textfield
    year = Integer.parseInt(inputString);  //converting string into an integer
   
    maxDays = calculateMaxDaysInMonth (month,year);   //calling method to calculate
    calculateNextDay(maxDays,day,month,year);   // tomorrow date
 }
  private int calculateMaxDaysInMonth (int month,int year) {    
            // calculate the maximum days for each month
      int maxDays=0;
 
      switch(month){
            
      case 1:            // months with 31 days
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
          
          maxDays = 31;
          break;

      case 4:           // month with 30 days 
      case 6:
      case 9:
      case 11:

          maxDays = 30;
          break;
                // calculate the maximum days for February 
      case 2:  // determines if there is a leap year first 
          if ( (year % 4 == 0 && year % 100 != 0)
               || (year % 400 == 0) ){      
              maxDays = 29;
             // JOptionPane.showMessageDialog(null,maxDays);
          }
          else{
              maxDays = 28;
          }
          break;

      default:   //shows "Invalid Input" when Input month>12 or month<1 
        JOptionPane.showMessageDialog(null,"Invalid month");
          break;
      }
          return maxDays;            
  }
      // method to calculate next day, month, year
  private void calculateNextDay (int maxDays, int todayDayCal,
		   int todayMonthCal,int todayYearCal) {
	  // check for correct input before doing any calculation
  if (! ((todayYearCal <= 0)||(todayDayCal <= 0)||(todayDayCal > maxDays))){
       if (todayDayCal < maxDays){
          todayDayCal = todayDayCal + 1;
       }
       else if ((todayDayCal == maxDays) && (todayMonthCal < 12)){
         todayMonthCal = todayMonthCal + 1;     
         todayDayCal = 1;            //increases month by 1 resets day to 1
       } 
       else {
          todayYearCal= todayYearCal + 1;
          todayMonthCal = 1;    //increases year by 1(resets day and month to 1)
          todayDayCal = 1;
       }
       
      JOptionPane.showMessageDialog(null,"(Day/month/year)"+"\n"+ "Tomorrow Date is:" + todayDayCal+ "/" 
    	       + todayMonthCal +"/"+ todayYearCal+ "\n"+ "Max Days of this month is:" +  maxDays);
              // show tomorrow Date output date output
     
  } else {
	JOptionPane.showMessageDialog(null,"Error,please enter the correct date for today");
  } // inform the users to enter a valid input if they enter a wrong input
 }
}

