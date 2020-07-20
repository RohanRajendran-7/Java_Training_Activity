package codeRefactored;

public class MortgageCalculator {

	private final static byte MONTHS_IN_YEAR = 12;
	private final static byte PERCENT = 100;

	private int principal;
	private float annualInterst;
	private byte years;

	public MortgageCalculator(int principal, float annualInterst, byte years) {
		this.principal = principal;
		this.annualInterst = annualInterst;
		this.years = years;
	}

	public double calculateMortgage() {
		float monthlyInterest = getMonthlyInterest();
		int numberOfPayments = getNumberOfPayments();
		double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
				/ (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
		return mortgage;
	}

	public double calculateBalance(short numberOfPaymentsMade) {
		float monthlyInterest = getMonthlyInterest();
		int numberOfPayments = getNumberOfPayments();
		double balance = principal
				* (Math.pow(1 + monthlyInterest, numberOfPayments)
						- Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
				/ (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
		return balance;
	}

	public double[] getRemainingBalances() {
		int numberOfPayments = getNumberOfPayments();
		var balances = new double[numberOfPayments];
		for (short month = 1; month <= balances.length; month++) {
			balances[month - 1] = calculateBalance(month);
		}
		return balances;
	}

	private float getMonthlyInterest() {
		return annualInterst / PERCENT / MONTHS_IN_YEAR;
	}
	
	private int getNumberOfPayments() {
		return years * MONTHS_IN_YEAR;
	}

}