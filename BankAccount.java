/*This program simulates basic banking transactions
 *
*
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Bank1Constructeur extends JFrame implements ActionListener {
	
	private JButton button;
	private JTextArea output;
	
	public static void main (String[]args){
		Bank1Constructeur frame = new Bank1Constructeur();
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
		output = new JTextArea(20,20); // used to display bank account balances
		window.add(output);
	}
	
	public void actionPerformed (ActionEvent e) {
		BankAccount myAccount, yourAccount;
		
		myAccount = new BankAccount();
		yourAccount = new BankAccount(250);
		
		output.append(myAccount.toString() + "\n");
		output.append(yourAccount.toString() +"\n");
		
		myAccount.deposit(400);
		yourAccount.withdraw(30);
		
		output.append("Account number "+ myAccount.getID() + "-Balance "+ 
		       myAccount.getBalance() + "\n");
		
		output.append("Account number "+ yourAccount.getID() + "-Balance "+ 
			       yourAccount.getBalance() + "\n");
		
		output.append("Number of objects created " + BankAccount.getNum() + "\n");

   }
}

/* this class represents a bank account */
class BankAccount {
	
	private static int num;    // number of accounts created so far
	private int id;      // account ID number
	private int balance;   // the balance of bank account
	
	/* constructeur. Initializes balance to 0. Increments number of objects */
	public BankAccount(){
		balance = 0;
		num++;
		id = num;
	}
	/* constructeur. Initializes balance to value send by the paramater.
	 * Increments number of objects */
	public BankAccount (int amount){
		balance = amount;
		num++;
		id = num;
	}
	
	/* method that return the balance of the account*/
	public int getBalance(){
		return balance;
	}
	/*method that displays information about the account*/
	
	public String toString(){
		String s = "Account number: " + id + "-Balance: " + balance;
		return s;
	}
	/* increment the account's balance by the amount send by the parameter*/
	
	public void deposit (int amount){
		balance +=amount;
	}
	/* Decrement the accont's balance by the amount send by the parameter*/
	
	public void withdraw (int amount){
		balance -= amount;
	}
	/* method that returns the account id number */
	
	public int getID(){
		return id;
	}
	// this method returns the number of accounts created so far 
	
	public static int getNum(){
		return num;
	}
}
 
