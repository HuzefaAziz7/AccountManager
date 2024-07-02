/* This Class contains all the Methods.
*/

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.util.HashMap;
import java.util.concurrent.Callable;

import javax.swing.DefaultComboBoxModel;

import org.mindrot.jbcrypt.BCrypt;

public class AccMethods extends AccManager {
	
	static EmailController EmailCon = new EmailController();
	static PreparedStatement PSUpdate = null ;
	private String VerifyEmail = null ; 
	static String Date = null ; 
	static int Amount ; 
	static String VerificationResult = null ; // Used in ExistingUserLogin().
	static String Notes = null ;
	static CallableStatement MyCallStmt = null ;
	static int TempInt = 0 ;
	static String TempString = null ; 
	static String KindMenu = "Select Category : \n" 
			+ "1. Ration \n" 
			+ "2. Outing \n"
			+ "3. Food \n" 
			+ "4. School \n"
			+ "5. Others "  ;
	static String Kind = null ; 
	// All Methods Begin from here.
	AccMethods() {
		AccManager.DBConnection();
	}
	static public void NewUserLogin(String NewUsername, String NewPassword,String Email) {
		AccManager.DBConnection();
		String HashedPassword = BCrypt.hashpw(NewPassword, BCrypt.gensalt());
		
		try {
			// Prepared Statement for Inserting the Username and HashedPassword into DB.
			PSUpdate = MyCon.prepareStatement(" INSERT INTO IdInfo(Username,UserPassword,Email) VALUES (?,?,?) ");
			PSUpdate.setString(1, NewUsername);
			PSUpdate.setString(2, HashedPassword);
			PSUpdate.setString(3, Email);
			int rowsAffected = PSUpdate.executeUpdate();
			PSUpdate.close();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		} // Catch.
	} // NewUserLogin Method.
	
	static public void ExistingUserLogin(String Username, String Password) {
		AccManager.DBConnection();
		String hashedpassword = null ;

		try {
			PSUpdate = MyCon.prepareStatement(" SELECT Username,UserPassword FROM IdInfo WHERE Username = ? ");
			PSUpdate.setString(1,Username);
            MyRS = PSUpdate.executeQuery();
            if (MyRS.next()) {
            	hashedpassword  = MyRS.getString("UserPassword"); 
            }
			boolean matched = BCrypt.checkpw(Password, hashedpassword);
            if (matched == true) {
            	GUI.lblVerifyStatus.setText("Login Successful.. Please Wait");
            	VerificationResult = "Pass";
            }
        	else {
        		GUI.lblVerifyStatus.setText("Login Failed.. Please try again");
        		VerificationResult = "Fail";
        	}
            PSUpdate.close();
		} // Try.
		
		catch (Exception exc) {
			exc.printStackTrace();
		} // Catch.
	
	} // ExistingUserLogin()
	
	
	static public void InsertLastTrans() { // Changes Needed.
		int InLastTrans = LastAmount ; 
		LastTrans.add(InLastTrans);
	} // Inserting Last Transaction into The LastTrans[] ArrayList.
	
/* Changes Needed. 
	public void LastTenTrans() {
		System.out.println(LastTrans.size()) ;
		for (int i=0;i<LastTrans.size();i++) {
			int x = i+1 ;
			int j = 0 ; 
//			System.out.println("Your No." + x + " Transaction was ₹" + LastTrans.get(i) +".") ;	
			GUI.lblOutput_1.setText("Your No." + x + " Transaction was ₹" + LastTrans.get(i) +".") ;
			while (j<i) {
				
			}
			
		}
		System.out.println(LastTrans.size()) ;
	} // LastTenTrans Method
*/
	
	static public void InsertCredit(String Date, int Amount, String Notes, String Kind) { 
 
		try {
			LastAmount = Amount; 
			InsertLastTrans();
			// Create Prepared Statement for Credit :
			PSUpdate = MyCon.prepareStatement("INSERT INTO Credit VALUES(?,?,?,?)");		
			PSUpdate.setString(1, Date);
			PSUpdate.setDouble(2, Amount);
			PSUpdate.setString(3, Notes);
			PSUpdate.setString(4, Kind);
			int rowsAffected = PSUpdate.executeUpdate();
			
		} // Try.		
		
		catch (Exception exc) {
			exc.printStackTrace();
		} // Catch. 
	} // InsertCredit Method.
	
	static public void InsertDebit(String Date, int Amount, String Notes,  String Kind) { 
		 
		try {
			
			LastAmount = Amount; 
			InsertLastTrans();
			// Create Prepared Statement for Credit :
			PSUpdate = MyCon.prepareStatement("insert into Debit values(?,?,?,?)");	
			PSUpdate.setString(1, Date);
			PSUpdate.setDouble(2, Amount);
			PSUpdate.setString(3, Notes);
			PSUpdate.setString(4, Kind);
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
		
	static public void TotalDorC() { // Total Debit or Credit.
		
		System.out.print("Enter 1 for Credit or Enter 2 for Debit..?"); 
		try { 
			MyCallStmt = MyCon.prepareCall("{ call get_TotalDorC (?) }") ;
			
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
	
	public void BankBalance() {
		
		try {
			// System.out.print("Your Bank Balance : ");
			MyCallStmt = MyCon.prepareCall("{ call get_BankBalance () }") ;  
			MyCallStmt.execute();
			
			MyRS = MyCallStmt.getResultSet() ;
			while (MyRS.next()) {
				MyRS.getString("BankBalance"); 
				CurBalance = Integer.parseInt(MyRS.getString("BankBalance"));
				GUI.lblOutput_1.setText("Your Current Bank Balance : ₹" + CurBalance);
			}
		} // Try.
		
		catch (Exception exc) {
			exc.printStackTrace();
		} // Catch.
	} // BankBalance.
	
	public void AvgSpend() {
		double AvgSpend = 0 ;
		try {
			
			MyCallStmt = MyCon.prepareCall("{ call get_AvgSpend() }") ; 
			MyCallStmt.execute();
			
			MyRS = MyCallStmt.getResultSet();
			while (MyRS.next()) {
				AvgSpend = Double.parseDouble(MyRS.getString("AvgSpend"));
			}
			GUI.lblOutput_1.setText("Your Average Spend : ₹" + AvgSpend);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		} // Catch.
		
	} // Average Spend.
	
	static public void KindMenu() {
		
		int KindValue = scan.nextInt();
		if (KindValue == 1) {
			Kind = "Ration" ;
		}
		else if (KindValue == 2) {
			Kind = "Outing" ;
		}
		else if (KindValue == 3) {
			Kind = "Food" ;
		}
		else if (KindValue == 4) {
			Kind = "School" ;
		}
		else if (KindValue == 5) {
			Kind = "Others" ;
		}
		
	}
	
	public void LastAmount() {
		GUI.lblOutput_1.setText("Your Last Transaction : ₹" + LastAmount);
	} // LastAmount.
	
	public void OthersItemDisplay(String SelectedItem) {
		HashMap<String, Runnable> ItemMap = new HashMap<String, Runnable>();
		ItemMap.put("Bank Balance", this::BankBalance);
		ItemMap.put("Last Transaction", this::LastAmount);
//		ItemMap.put("Last Ten Transaction", this::LastTenTrans);
		ItemMap.put("Average Spend", this::AvgSpend);
		if (ItemMap.containsKey(SelectedItem)) {
			ItemMap.get(SelectedItem).run();
		}
		
	} // OthersItemDisplay. (Menu Panel)
	
	public void ForgotPassword(String Username, String Email) {
    	EmailVerification(Username,Email);
    	if (VerifyEmail.equals("Pass")) {
    		EmailCon.ResetPasswordEmail(Email);
    	} 
    	else if (VerifyEmail.equals("Fail")) {
    		System.out.println("Email/Username Incorrect.");
    	}
    } // Forgot Password.
	
	private void EmailVerification(String Username, String Email)  {
		String DBEmail = null ; 
		System.out.println(Email);
		try {
			PSUpdate = MyCon.prepareStatement(" SELECT Email FROM IdInfo WHERE Username = ? ");
			PSUpdate.setString(1, Username);
			MyRS = PSUpdate.executeQuery();
			if (MyRS.next()) {
				DBEmail = MyRS.getString("Email") ; 
				System.out.println(DBEmail);
				if (DBEmail.equals(Email)) {
					System.out.println("Email Verification Successful");
					VerifyEmail = "Pass" ;
				}
				else {
					VerifyEmail = "Fail" ;
				}
			}
			PSUpdate.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	} // EmailVerification().
	
} // Class End.

