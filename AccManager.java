/* 
 Today's Tasks : Link MySQL and make a Database.

 Progress Report :
*/

import java.util.Scanner ;
import java.util.ArrayList;

public class AccManager {
	
	static ArrayList<Integer> LastTrans = new ArrayList<Integer>();
	static AccBalance Bal = new AccBalance();
	static Scanner sc = new Scanner(System.in); 
	static int CurBalance = Bal.GetBalance(); // Assigning Bal.GetBalance to CurBalance (Current Balance) for easy use.
	static int LastAmount ;

	public static void main(String[] args) {
		MainMenu MainMenu = new MainMenu();
		MainMenu.Menu();
	} // Main Class
	
} // Program.

/* Main Features/Changes to be made : 
   
 */

/* Side Features that can be added : 
	1. Average Spend.
	2. Total Credit.
	3. Total Debit.
	4. Spend Limit. (how much money allowed to spend).
	5. Spend can be categorized into types of spending. (ex: school, ration, outings etc).
	6. Ordinal Numbers for Transactions History.
	7. User can search for Transactions.
	
*/