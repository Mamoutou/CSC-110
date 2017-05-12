
/*Calculate and display the change and the number of coins
 * MoneyDialogBox.java
 * @author  Mamoutou Sangare 
 * Created on January 25 , 2014, 1:00 PM
 * Purpose: this progam prompts the user for the input in cents and then
 *calculate how much change is to be returned, using the lowest number of coins
 */
package Labs;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class  MoneyDialog extends JFrame
        implements ActionListener {

    private JButton button;//when cliked conversion MoneyDialogBox is performed

    public static void main(String[] args) {
        MoneyDialog frame = new MoneyDialog();
        frame.setSize(400, 300);
        frame.createGUI();
        frame.setVisible(true);
    }

    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        button = new JButton("Press me");
        window.add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        int totalCents;
        int dollars;
        int quarter, dime, nickel, pennies;       // variable declaration
        int totalChangeRemainig, centsRemaining;
        String totalCentsString;
        String itemCostString;
        itemCostString =JOptionPane.showInputDialog("Enter your items cost, "
                                                          + "in cents");
        dollars = Integer.parseInt(itemCostString);//convert input to an integer

        totalCentsString = JOptionPane.showInputDialog("Enter your amount,"
                                                          + " in cents");
        totalCents = Integer.parseInt(totalCentsString);
                                                          
        totalChangeRemainig = totalCents - dollars;//calculates cents remaining
        quarter = totalChangeRemainig / 25;   // calculates number of quarters
        centsRemaining = totalChangeRemainig % 25;
        dime = centsRemaining / 10;               //calculates number of dimes
        centsRemaining = centsRemaining % 10;
        nickel = centsRemaining / 5;           // calculate number of nickels
        pennies = centsRemaining % 5;          // calculate number of pennies

        JOptionPane.showMessageDialog(null,"Items cost: " + dollars + " \n " +
            "Amount inserted in cents:" + totalCents + " \n " + "Change is:"
            + totalChangeRemainig + " \n " + "  number of quarters:" +
            quarter + " \n"+ "   number of dimes: " + dime + " \n " + 
            "  number of nickels: " + nickel + " \n " + "  number of pennies:"
            + pennies);
    }
}
