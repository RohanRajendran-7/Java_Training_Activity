package codeRefactored.assignment2;
import java.util.Scanner;


interface Bank{
	final int initBal = 10000;
	final int minBal = 5000;
	static void errorMessage(String ch) {
		System.out.println(ch);
	}
	
	static void dispMessage() {
		System.out.println("Transaction Successful");
	}
	void deposit(int num);
	void checkbalance();
	void withdraw(int var);
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
	public void withdraw(int var) {
		if(userChoice.bal < var) {
			Bank.errorMessage("Insufficient Balance, Withdraw attempt failed");
			System.exit(0);
		}
		else {
			userChoice.bal -= var;
			Bank.dispMessage();
		}
	}	
	
	
	public void checkOption(byte ch) {
		int var,temp ;
		System.out.println("Enter your choice- 1.Withdraw");
		System.out.println("2. deposit \n 3. Check balance");
		temp = scan.nextByte();		
		switch(temp) {
		case 1 :
			System.out.println("enter amount");
			var = scan.nextInt();
			if(ch==1 && var>Bank.minBal) {
				Bank.errorMessage("The limit is 5000, Withdraw attempt failed");
				break;
			}
			else
				withdraw(var);
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
			Bank.errorMessage("enter vaid option");
			
			
			
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
			ch.checkOption(choice);
			System.out.println("enter y to continue,  n to exit");
			var=scan.next();
		}

				
		
		
	}

}
