// This Class contains The MainMenu.

import java.sql.PreparedStatement;

public class MainMenu extends AccManager {
	
	static public void Menu() {
		
		String Menu = "\nFor Credit, Press 1 \n"
				+ "For Debit, Press 2 \n"
				+ "To Check Your Account Balance, Press 3 \n"
				+ "For Last Transaction, Press 4 \n" 
				+ "For Last 10 Transactions, Press 5 \n"
				+ "To Display all Credits, Press 6 \n"
				+ "To Display all Debits, Press 7\n"
				+ "To Display Total Credit or Debit, Press 8 \n"
				+ "To Display Average Spend, Press 9 \n"
				// + "\n"
				+ "To Exit, Press 10 \n" ;
		
		System.out.println("Please Enter your choice : \n" ) ;
		int option = 0 ;
		do {
			
			System.out.println(Menu);
			option = scan.nextInt();
			
			switch (option) { 
			case 4 : 
				System.out.println("Your Last Transaction was : " + LastAmount) ;
				break;
			case 5 :
				System.out.println("Your Last 10 Transactions were : ") ;
				AccMetd.LastTenTrans();
				break;
			case 6 : 
				System.out.println("Display all Credits : ");
				AccMetd.DisplayCredit();
				break;
			case 7 : 
				System.out.println("Display all Debits : ");
				AccMetd.DisplayDebit();
				break;
			case 8 : 
				System.out.println("Display Total Credit/Debit : ");
				AccMetd.TotalDorC() ;
				break;
			case 9 : 
				System.out.print("Average Spend : ");
				AccMetd.AvgSpend();
				break;
			case 10 : 
				System.out.println("You've Exited the Program.. Thank You.");
				System.exit(0);
				break ;
				
			default : 
				System.out.println("Please Enter a valid option : " );
			} // Switch 
		} while (option != 10); // Do 
	} // Menu Method 
}
