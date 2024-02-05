// Account Manager Database.
import java.sql.* ; 

public class AccDB {{ 
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root" , "root1203503");
		Statement stmt = con.createStatement();
		System.out.println("Inserting Records... ");
		String sql = " Insert into StudentInfo values(40)" ;
		stmt.executeUpdate(sql);
	} // Try.
	
	catch (Exception e) {
		System.out.println(e);
	} // Catch.
	
}} // Class.
