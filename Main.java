package codeRefactored;

public class Main {

	public static void main(String[] args) {

		System.out.println("----------- Mortage Calculator ---------");

		int principal = (int) Console.readNumber("Enter Principal : ", 1000, 1_000_000);
		float annualInterest = (float) Console.readNumber("Enter Annual Interest : ", 1, 30);
		byte years = (byte) Console.readNumber("Enter Period (Years) :", 1, 30);

		MortgageCalculator calculator = new MortgageCalculator(principal, annualInterest, years);
		
		MortgageReport report = new MortgageReport(calculator);
		report.printMortgage();
		report.printPaymentSchedule();

	}

}