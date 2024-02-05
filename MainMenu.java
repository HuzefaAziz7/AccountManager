// This Class contains Methods : MainMenu, Credit, Debit, InsertLastTrans, LastTenTrans.
public class MainMenu extends AccManager {
	
	static public void Menu() {
		String Menu = "\nFor Credit, Press 1 \n"
				+ "For Debit, Press 2 \n"
				+ "To Check Your Account Balance, Press 3 \n"
				+ "For Last Transaction, Press 4 \n" 
				+ "For Last 10 Transactions, Press 5 \n"
				+ "To Exit, Press 6 \n" ;
		System.out.println("Please Enter your choice : \n" ) ;
		int option = 0 ;
		do {
			
			System.out.println(Menu);
			option = sc.nextInt();
			
			switch (option) {
			case 1 : 
				System.out.println("You've Chosen the Credit Method. " ); 
				Credit();
				InsertLastTrans();
				break;
			case 2 : 
				System.out.println("You've Chosen the Debit Method : " ); 
				Debit();
				InsertLastTrans();
				break;
			case 3 :
				System.out.println("Your Account Balance is : " + CurBalance );
				break;
			case 4 : 
				System.out.println("Your Last Transaction was : " + LastAmount) ;
				break;
			case 5 :
				System.out.println("Your Last 10 Transactions were : ") ;
				LastTenTrans();
				break;
			case 6 : 
				System.out.println("You've Exited the Program.. Thank You.");
				// System.exit(0);
				break ;
				
			default : 
				System.out.println("Please Enter a valid option : " );
			} // Switch 
		} while (option != 6); // Do 
	} // Menu Method 
	
	static public int Credit() {
		System.out.println("Please Enter The Amount To Be Credited : ");
		int Amount = sc.nextInt(); // Amount to be entered by the user for credit. 
		System.out.println("The Amount you have entered is : " + Amount);
		System.out.println("Your Previous Balance was : " + CurBalance);
		CurBalance += Amount ;
		Bal.SetBalance(CurBalance); // Updated Balance is Set to NewBalance. 
		System.out.println("Your New Balance is : " + CurBalance); 
		return LastAmount = Amount ;
		
	} // Credit Method 
	
	static public int Debit() {
		System.out.println("Please Enter The Amount to be Debited : " ); 
		int Amount = sc.nextInt(); // Amount to be entered by the user for debit. 
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
	} // Inserting Last Transaction into The LastTrans[] Array.
		
	static public void LastTenTrans() {
		int x = 0 ; 
		for (int i=0;i<LastTrans.size();i++) {
			x = i+1;
			System.out.println("Your No." + x + " Transaction was ₹" + LastTrans.get(i) +".");
			
		}
	} // LastTenTrans Method 

}
