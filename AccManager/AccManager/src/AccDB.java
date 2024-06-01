// Account Manager Database.

import java.sql.* ; 

public class AccDB extends AccManager {
	
	static Connection MyCon = null ;
	static Statement MyStmt = null ;
	static PreparedStatement MyPreStmt = null ; 
	static ResultSet MyRS = null ;
	static PreparedStatement PSCredit = null ; 
	
	/* 
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
	*/
} // Class.
