// This Class contains Account Balance.
class AccBalance extends AccManager {
	private int AccBalance = 0; // Private = Restricted Access
	
	public int GetBalance() {
		//System.out.println("Your Balance is " + AccBalance);
		return AccBalance ;
	}
	
	public int SetBalance(int AccBalance) {
		this.AccBalance = AccBalance ;
		return this.AccBalance ;
	}
	
	
} // Class End 
