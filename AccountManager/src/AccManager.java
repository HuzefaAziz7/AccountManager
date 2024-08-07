import java.util.Scanner ;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
// import org.mindrot.jbcrypt.BCrypt;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;


public class AccManager {
	
	 static AccManager AccManager = new AccManager();
	 static CallableStatement MyCallStmt = null ;
	 static AccMethods AccMetd = new AccMethods() ;
	 static Connection MyCon = null ;
	 static Statement MyStmt = null ; 
	 static ResultSet MyRS = null ;
	 static PreparedStatement PSUpdate = null ; 
	 static ArrayList<Integer> LastTrans = new ArrayList<Integer>();
	 static AccBalance Bal = new AccBalance();
	 static Scanner scan = new Scanner(System.in); 
	 static int CurBalance; // 
	 static int LastAmount;
	 static AccSystemGUI GUI = new AccSystemGUI();

	 public static void DBConnection() {

	  	{ try {
			
	  		String dbUrl = "jdbc:mysql://localhost:3306/AccManager" ;
	  		String usernamedb = "root" ;
	  		String passworddb = "root1203503" ;
			
//	  		 Get Connection to Database 
	  		MyCon = DriverManager.getConnection(dbUrl, usernamedb , passworddb); 
			
//	  		 Create A Statement 
	  		MyStmt = MyCon.createStatement();
	  	} // Try.
		
	  	catch (Exception exc) {
	  		exc.printStackTrace(); 
	  	}  } // Catch, JDBC Connection.

	  }
} // Program.

