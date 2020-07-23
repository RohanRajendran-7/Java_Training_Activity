package codeRefactored.assignment2;
import java.util.Scanner;


interface Bank{
	final int initBal = 10000;
	final int minBal = 5000;

	static void dispMessage() {
		System.out.println("Transaction Successful");
	}
	void deposit(int num);
	void checkbalance();
	void withdraw(int var) throws InsufficientBalance;
}

class userChoice implements Bank{
	
	private static int bal;
	private Scanner scan = new Scanner(System.in);
	
	
	
	public userChoice() {
		userChoice.bal=Bank.initBal;
		Bank.dispMessage();
	}
	@Override
	public void deposit(int num) {
		userChoice.bal += num ; 
		Bank.dispMessage();		
	}

	@Override
	public void checkbalance() {
		System.out.println("Your account Balance:" + userChoice.bal);
		
	}

	@Override
	public void withdraw(int var) throws InsufficientBalance {
		if(userChoice.bal < var) {
			throw new InsufficientBalance("Insufficient Balance, Withdraw attempt failed");
		}
		else {
			userChoice.bal -= var;
			Bank.dispMessage();
		}
	}	
	
	
	public void checkOption(byte ch) throws InsufficientBalance {
		int var,temp ;
		System.out.println("Enter your choice- 1.Withdraw");
		System.out.println("2. deposit \n 3. Check balance");
		temp = scan.nextByte();		
		switch(temp) {
		case 1 :
			System.out.println("enter amount");
			var = scan.nextInt();
			if(ch==1 && var>Bank.minBal) {
				throw new InsufficientBalance("The limit is 5000, Withdraw attempt failed");
			} else
				try {
					withdraw(var);
				} catch (InsufficientBalance e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			break;
		case 2 :
			System.out.println("enter amount");
			temp = scan.nextInt();
			this.deposit(temp);
			break;
		case 3:
			this.checkbalance();
			break;
		default:
			throw new InsufficientBalance("enter vaid option");
			
			
			
		}
	}


	
}


public class assignment {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String var= "y";
		System.out.println("------------------welcome------------------------");
		System.out.println("Select your type of account \n 1. Savings \n 2. Current ");
		byte choice = scan.nextByte();
		
		
		userChoice ch = new userChoice();
		while(var.equalsIgnoreCase("y")) {
			try {
				ch.checkOption(choice);
			} catch (InsufficientBalance e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());;
			}
			System.out.println("enter y to continue,  n to exit");
			var=scan.next();
		}

				
		
		
	}	

}
