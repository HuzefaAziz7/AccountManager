// This Class contains all the Methods : Credit, Debit, InsertLastTrans, LastTenTrans, InsertCredit, DisplayCredit, 
public class AccMethods extends AccManager 
{	
	static String Date = null ;
	static int Amount ; 
	static String Notes = null ; 
	
	static public int Credit() {
		System.out.println("Enter The Date : (YYYY-MM-DD) ");
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
		System.out.println("Please Enter The Amount to be Debited : " ); 
		int Amount = scan.nextInt(); // Amount to be entered by the user for debit. 
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
	
	static public void InsertCredit(String ICDates , int ICAmount, String ICNotes) { 
		
		try {
		
			// Create Prepared Statement for Credit :
			PSUpdate = MyCon.prepareStatement("insert into Credit values(?,?,?)");
			System.out.println("Entering Data.... Please Wait ");
			PSUpdate.setString(1, ICDates);
			PSUpdate.setDouble(2, ICAmount);
			PSUpdate.setString(3, ICNotes);
			int rowsAffected = PSUpdate.executeUpdate();
			
		} // Try.		
		
		catch (Exception exc) {
			exc.printStackTrace();
		} // Catch. 
	} // InsertCredit Method.
	
	static public void InsertDebit(String ICDates , int ICAmount, String ICNotes) { 
			
			try {
			
				// Create Prepared Statement for Credit :
				PSUpdate = MyCon.prepareStatement("insert into Debit values(?,?,?)");
				System.out.println("Entering Data.... Please Wait ");
				PSUpdate.setString(1, ICDates);
				PSUpdate.setDouble(2, ICAmount);
				PSUpdate.setString(3, ICNotes);
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
				System.out.println(MyRS.getString("Date") + " , "+ MyRS.getString("Amount") + " , " + MyRS.getString("Notes")); } 
		} // Try.
		
		catch (Exception exc) {
				exc.printStackTrace();
		} // Catch. 
		
	} // DisplayCredit.
	
} // Class End.

