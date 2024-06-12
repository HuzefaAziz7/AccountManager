/* 
 Today's Tasks : 
			- Update Menu
			- Make Username Password Feature.
*/

import java.util.Scanner ;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class AccManager {
	
	static AccManager AccManager = new AccManager();
	static CallableStatement MyCallStmt = null ;
	static AccMethods AccMetd = new AccMethods() ;
	static Connection MyCon = null ;
	static Statement MyStmt = null ;
	// static PreparedStatement MyPreStmt = null ; 
	static ResultSet MyRS = null ;
	static PreparedStatement PSUpdate = null ; 
	static ArrayList<Integer> LastTrans = new ArrayList<Integer>();
	static AccBalance Bal = new AccBalance();
	static Scanner scan = new Scanner(System.in); 
	static int CurBalance; // 
	static int LastAmount;
	static HashMap<String, String> users = new HashMap<String, String>() ;
	
	static void VerificationSuccess() {
		System.out.println("Verification Success");
	
		{ try {
			// Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/AccManager" ;
			String usernamedb = "root" ;
			String passworddb = "root1203503" ;
			
			// Get Connection to Database 
			MyCon = DriverManager.getConnection(dbUrl, usernamedb , passworddb); 
			System.out.println("Database Connection is Successful.");
			
			// Create A Statement 
			MyStmt = MyCon.createStatement();
		} // Try.
		
		catch (Exception exc) {
			exc.printStackTrace(); 
		}  } // Catch, JDBC Connection.

		AccMetd.BankBalance();
		MainMenu MainMenu = new MainMenu();
		MainMenu.Menu();
	}
	public static void main(String[] args) {
		users.put("huzefa", "aziz");
		users.put("hatim", "hasan");
		users.put("sakina", "hatim");
	
		AccMetd.LoginSystem();
	} // Main Class
	
} // Program.

