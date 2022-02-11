package org.mortage.mortagecalculator;

/**
 * @author Rickard Hellström
 *
 *	A prospect class represent a prospect for a new loan
 */
public class Prospect {
	private String customer;
	private double totalLoan;
	private double interest;
	private int years;
	// prospect is a string that represent the whole prospect and is shown to the user 
	private String prospect;
	
	/**
	 * Constructor for creating an empty new prospect
	 */
	public Prospect() { }
	
	/**
	 * Constructor for creating a prospect with all of the info for calculating a mortage
	 * 
	 * @param customer	name of the customer taking a loan
	 * @param totalLoan	the amount of money being loaned
	 * @param interest	the annual interest rate
	 * @param years		the years until the loan is supposed to be paid
	 */
	public Prospect(String customer, double totalLoan, double interest, int years) {
		this.customer = customer;
		this.totalLoan = totalLoan;
		this.interest = interest;
		this.years = years;
	}
	
	/**
	 * Get method for getting the customer
	 * 
	 * @return 			name of the customer taking a loan
	 */
	public String getCustomer() {
		return this.customer;
	}
	
	/**
	 *  Get method for getting the total loan amount of the prospect
	 * 
	 * @return 			the amount of money being loaned
	 */
	public double getTotalLoan() {
		return this.totalLoan;
	}
	
	/**
	 * Get method for getting the annual interest rate
	 * 
	 * @return 			the annual interest rate
	 */
	public double getInterest() {
		return this.interest;
	}
	
	/**
	 * Get method for getting the the years until the loan is supposed to be paid
	 * 
	 * @return 			the years until the loan is supposed to be paid
	 */
	public int getYears() {
		return this.years;
	}
	
	/**
	 * Get method for getting a string that represent the prospect for the user
	 * Example: "Prospect 1: 'customer' wants to borrow 'totalLoan' € 
	 * 			for a period of 'years' years and pay 'fixed monthly payment' € each month"
	 * 
	 * @return 			string that represent the whole prospect
	 */
	public String getProspect() {
		return this.prospect;
	}
	
	/**
	 * Set method for setting the customer
	 * 
	 * @param customer	name of the customer taking a loan
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
	/**
	 *  Set method for setting the total loan amount of the prospect
	 * 
	 * @param totalLoan	the amount of money being loaned
	 */
	public void setTotalLoan(double totalLoan) {
		this.totalLoan = totalLoan;
	}
	
	/**
	 * Set method for setting the annual interest rate
	 * 
	 * @param interest	the annual interest rate
	 */
	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	/**
	 * Set method for Setting the the years until the loan is supposed to be paid
	 * 
	 * @param years		the years until the loan is supposed to be paid
	 */
	public void setYears(int years) {
		this.years = years;
	}
	
	
	/**
	 * Set method for setting a string that represent the prospect for the user
	 * Example: "Prospect 1: 'customer' wants to borrow 'totalLoan' € 
	 * 			for a period of 'years' years and pay 'fixed monthly payment' € each month"
	 * 
	 * @param prospect	string that represent the whole prospect
	 */
	public void setProspect(String prospect) {
		this.prospect = prospect;
	}
	
}