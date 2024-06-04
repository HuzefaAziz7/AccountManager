// This Class contains The MainMenu.

import java.sql.PreparedStatement;

public class MainMenu extends AccManager {
	
	static AccMethods AccMetd = new AccMethods() ;
	
	static public void Menu() {
		
		String Menu = "\nFor Credit, Press 1 \n"
				+ "For Debit, Press 2 \n"
				+ "To Check Your Account Balance, Press 3 \n"
				+ "For Last Transaction, Press 4 \n" 
				+ "For Last 10 Transactions, Press 5 \n"
				+ "To Display all Credits, Press 6 \n"
				+ "To Display all Debits, Press 7\n" 
				+ "To Exit, Press 8 \n" ;
		
		System.out.println("Please Enter your choice : \n" ) ;
		int option = 0 ;
		do {
			
			System.out.println(Menu);
			option = scan.nextInt();
			
			switch (option) {
			case 1 : 
				System.out.println("You've Chosen the Credit Method. " ); 
				AccMetd.Credit();
				AccMetd.InsertLastTrans();
				break;
			case 2 : 
				System.out.println("You've Chosen the Debit Method : " ); 
				AccMetd.Debit();
				AccMetd.InsertLastTrans();
				break;
			case 3 :
				System.out.println("Your Account Balance is : " + CurBalance );
				break;
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
				AccMetd.TotalDorC() ;
				break;
			case 8 : 
				System.out.print("Total Credit : +"); 
				AccMetd.TotalCredit();
				break;
			case 9 : 
				System.out.print("Total Debit : -");
				AccMetd.TotalDebit();
				break; 
			case 10 : 
				System.out.println("You've Exited the Program.. Thank You.");
				System.exit(0);
				break ;
				
			default : 
				System.out.println("Please Enter a valid option : " );
			} // Switch 
		} while (option != 6); // Do 
	} // Menu Method 
}
