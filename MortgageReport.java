package codeRefactored;

import java.text.NumberFormat;

public class MortgageReport {

	private MortgageCalculator calculator;
	private final NumberFormat currency;

	public MortgageReport(MortgageCalculator calculator) {
		this.calculator = calculator;
		currency = NumberFormat.getCurrencyInstance();
	}

	public void printMortgage() {
		double mortgage = calculator.calculateMortgage();
		String mortgageFormatted = currency.format(mortgage);
		System.out.println("Mortgage : " + mortgageFormatted);
	}

	public void printPaymentSchedule() {
		for (double balance : calculator.getRemainingBalances()) {
			System.out.println(currency.format(balance));
		}
	}

}