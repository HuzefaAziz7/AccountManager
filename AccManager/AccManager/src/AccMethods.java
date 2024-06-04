/* This Class contains all the Methods : Credit, Debit, InsertLastTrans, LastTenTrans, 
										 InsertCredit, DisplayCredit, TotalCredit, TotalDebit 
*/

import java.sql.CallableStatement;
import java.util.concurrent.Callable;

public class AccMethods extends AccManager 
{	
	static String Date = null ; 
	static int Amount ; 
	static String Notes = null ;
	static String Credit = "Credit";
	static String Debit = "Debit";
	// static Callable MyCallStmt = null ; 
	
	static public int Credit() {
		System.out.println("Enter Date (YYYY-MM-DD) : ");
		Date = scan.next();
		System.out.println("Enter The Amount : ") ;
		Amount = scan.nextInt();
		System.out.println("Enter Remarks : ");
		Notes = scan.next();
		System.out.println("The Amount you have entered is : " + Amount);
		System.out.println("Your Previous Balance was : " + CurBalance);
		CurBalance += Amount ;
		Bal.SetBalance(CurBalance); 
		System.out.println("Your New Balance is : " + CurBalance);
		InsertCredit(Date,Amount,Notes);
		return LastAmount = Amount ;
		
	} // Credit Method 
	
	static public int Debit() {
		System.out.println("Enter Date (YYYY-MM-DD) : ");
		Date = scan.next();
		System.out.println("Please Enter The Amount to be Debited : " );
		Amount = scan.nextInt();
		System.out.println("Enter Remarks : ");
		Notes = scan.next();
		System.out.println("The Amount you have entered is : " + Amount);
		System.out.println("Your Previous Balance was : " + CurBalance);
		if (CurBalance >= Amount) { // IF Current Balance is More/Equal to the Amount.
			
			CurBalance = CurBalance - Amount ; // Amount is Subtracted from Current Balance.
			Bal.SetBalance(CurBalance);
			System.out.println("Your New Balance is : " + CurBalance ) ;
		}
		
		else {
			System.out.println("You Don't have the entered amount. " ); 
			System.out.println("Your Balance is : " + CurBalance ) ; 
			
		}
		InsertDebit(Date,Amount,Notes);
		return LastAmount = Amount ;
	} // Debit Method.
	
	static public void InsertLastTrans() {
		int InLastTrans = LastAmount ; 
		LastTrans.add(InLastTrans);
	} // Inserting Last Transaction into The LastTrans[] ArrayList.
		
	static public void LastTenTrans() {
		int x = 0 ; 
		for (int i=0;i<LastTrans.size();i++) {
			x = i+1;
			System.out.println("Your No." + x + " Transaction was ₹" + LastTrans.get(i) +".");	
		}
	} // LastTenTrans Method
	
	static public void InsertCredit(String Date, int Amount, String Notes) { 
 
		try {
			
			// Create Prepared Statement for Credit :
			PSUpdate = MyCon.prepareStatement("insert into Credit values(?,?,?)");
			System.out.println("Entering Data.... Please Wait ");		
			PSUpdate.setString(1, Date);
			PSUpdate.setDouble(2, Amount);
			PSUpdate.setString(3, Notes);
			int rowsAffected = PSUpdate.executeUpdate();
			
		} // Try.		
		
		catch (Exception exc) {
			exc.printStackTrace();
		} // Catch. 
	} // InsertCredit Method.
	
	static public void InsertDebit(String Date, int Amount, String Notes) { 
		 
		try {
			
			// Create Prepared Statement for Credit :
			PSUpdate = MyCon.prepareStatement("insert into Debit values(?,?,?)");
			System.out.println("Entering Data.... Please Wait ");	
			PSUpdate.setString(1, Date);
			PSUpdate.setDouble(2, Amount);
			PSUpdate.setString(3, Notes);
			int rowsAffected = PSUpdate.executeUpdate();
			
		} // Try.		
		
		catch (Exception exc) {
			exc.printStackTrace();
		} // Catch. 
	} // InsertDebit Method.
	
	static public void DisplayCredit() {
		
		try { 
			// Execute a SQL Query 
			MyRS = MyStmt.executeQuery("Select * from Credit");
				
			// Process the ResultSet 
			while (MyRS.next()) {
				System.out.println(MyRS.getString("Date") + " , " + MyRS.getString("Amount") + " , " + MyRS.getString("Notes")); } 
		} // Try.
		
		catch (Exception exc) {
				exc.printStackTrace();
		} // Catch. 
		
	} // DisplayCredit.
	
	static public void DisplayDebit() {
		
		try { 
			// Execute a SQL Query 
			MyRS = MyStmt.executeQuery("Select * from Debit");
				
			// Process the ResultSet 
			while (MyRS.next()) {
				System.out.println(MyRS.getString("Date") + " , " + MyRS.getString("Amount") + " , " + MyRS.getString("Notes")); } 
		} // Try.
		
		catch (Exception exc) {
				exc.printStackTrace();
		} // Catch. 
	} // DisplayCredit.
	
	static public void TotalCredit() {
		try { 
			// Execute a SQL Query 
			MyRS = MyStmt.executeQuery("CALL get_TotalCredit()");
				
			// Process the ResultSet 
			while (MyRS.next()) {
				System.out.println(MyRS.getString("SUM(Amount)")); } 
			
			
		} // Try.
		
		catch (Exception exc) {
				exc.printStackTrace();
		} // Catch. 
	} // TotalCredit. 
	
	static public void TotalDebit() {
		try { 
			// Execute a SQL Query 
			MyRS = MyStmt.executeQuery("CALL get_TotalDebit()");
				
			// Process the ResultSet 
			while (MyRS.next()) {
				System.out.println(MyRS.getString("SUM(Amount)")); } 
		} // Try.
		
		catch (Exception exc) {
				exc.printStackTrace();
		} // Catch. 
	} // TotalCredit.
	
	static public void TotalDorC() {
		
		System.out.print("Enter 1 for Credit or Enter 2 for Debit..?"); 
		try { 
			CallableStatement MyCallStmt = MyCon.prepareCall("{ call get_TotalDorC (?) }") ;
			
			String D_or_C = scan.next() ;
			MyCallStmt.setString(1, D_or_C);
			MyCallStmt.execute();
			
			int x = Integer.parseInt(D_or_C);
			if (x == 1) {
				System.out.print("Total Credit : +") ;
			}
			else if (x == 2) {
				System.out.print("Total Debit : -") ;	
			}
			
			MyRS = MyCallStmt.getResultSet() ;
			while (MyRS.next()) {
				System.out.println(MyRS.getString("TotalAmount")); }
		} // Try.
		
		catch (Exception exc) {
				exc.printStackTrace();
		} // Catch.
		
	} // TotalDorC.
	
} // Class End.

