/* 
 
 Today's Tasks : 
  
	1. Update the Bank Balance Feature. 

 Progress Report :
 
*/

import java.util.Scanner ;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AccManager {
	
	
	static Connection MyCon = null ;
	static Statement MyStmt = null ;
	// static PreparedStatement MyPreStmt = null ; 
	static ResultSet MyRS = null ;
	static PreparedStatement PSUpdate = null ; 
	static ArrayList<Integer> LastTrans = new ArrayList<Integer>();
	static AccBalance Bal = new AccBalance();
	static Scanner scan = new Scanner(System.in); 
	static int CurBalance = Bal.GetBalance(); // Assigning Bal.GetBalance to CurBalance (Current Balance) for easy use.
	static int LastAmount;

	public static void main(String[] args) {
		
		{ try {
			// Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/AccManager" ;
			String username = "root" ;
			String password = "root1203503" ;
			
			// Get Connection to Database 
			MyCon = DriverManager.getConnection(dbUrl, username , password); 
			System.out.println("Database Connection is Successful.");
			
			// Create A Statement 
			MyStmt = MyCon.createStatement(); 
		} // Try.
		
		catch (Exception exc) {
			exc.printStackTrace(); 
		} // Catch. 
		} // JDBC Connection.
		
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