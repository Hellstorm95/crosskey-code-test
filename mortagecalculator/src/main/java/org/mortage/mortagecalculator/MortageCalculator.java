package org.mortage.mortagecalculator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

/**
 * A helper class for reading and calculating mortage
 * 
 * @author Rickard Hellström
 */
public class MortageCalculator {
	/**
	 * readProspectFile reads a file with prospect data that is comma separated,
	 * calculate fixed monthly payment, and store the prospects' data in
	 * Prospect objects
	 * 
	 * Data read from file:
	 * customer:	name of customer taking a loan
	 * totalLoan:	the amount of money being loaned
	 * interest:	the annual interest rate
	 * years:		the years until the loan is supposed to be paid
	 * 
	 * 
	 * @param filename	name of the file from which the prospects are read 	
	 * @return			a list of Prospect with all of its attributes filled
	 */
	static List<Prospect> readProspectFile(String filename) {
		
		List<Prospect> prospectList = new ArrayList<Prospect>();
    	try {
    		// creates a csv file parser
    		CSVParser parser = new CSVParserBuilder()
					.withSeparator(',')
					.build();

    		// create file reader. uses utf-8 encoding
    		FileReader fileReader = new FileReader(filename, StandardCharsets.UTF_8);
    		// create csv reader
				CSVReader reader = new CSVReaderBuilder(fileReader)
					.withCSVParser(parser)
					.withSkipLines(1)
					.build();

				// read through the data
		    String[] data = reader.readNext();
		    int i = 1;
		    while (data != null) {
		    	// check if the line read is valid data line
					if (data.length == 4) {
						// replace ',' with ' '
						String customer = data[0].replace(',', ' ');
						double totalLoan = Double.parseDouble(data[1]);
						double interest = Double.parseDouble(data[2]);
						int years = Integer.parseInt(data[3]);
						// create a new prospect with the data read from a line 
						Prospect prospect = new Prospect(customer, totalLoan, interest, years);
						// create a string that represent the prospect and store it in Prospect.prospect
						updateProspect(prospect, i);
						i++;
						// add it to the prospect list
						prospectList.add(prospect);
					}
					data = reader.readNext();
		    }
		    
		    fileReader.close();
		    reader.close();

    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
				e.printStackTrace();
			}
    	
    return prospectList;
	}
	
	/**
	 * Calculates the fixed monthly payment of the prospect
	 * 
	 * @param prospect	the prospect for which the fixed monthly payment is calculated
	 * @return			fixed monthly payment of the prospect
	 */
	static double calculateMortage(Prospect prospect) {
		double U = prospect.getTotalLoan();
		// calculate number of payments
		int p = 12 * prospect.getYears();
		// interest on a monthly based
		double b = prospect.getInterest() / (12*100);
		// fixed monthly payment
		double E = U * (b*pow(1+b,p)) / (pow(1+b,p) - 1);
		
		return E;
	}
	
	/**
	 * Updates the prospect attribute of a Prospect object
	 * 
	 * Uses the other four attributes to create a string that
	 * represents the prospect. The string shows the customer name,
	 * the loan amount, the number of years until the loan is paid,
	 * and fixed monthly payment of the loan
	 * 
	 * @param prospect	the prospect which is updated
	 * @param i			the index of the prospect in the prospect list
	 */
	static void updateProspect(Prospect prospect, int i) {
		// get the fixed monthly payment of prospect
		double E = calculateMortage(prospect);
		
		// formatter for fixed monthly payment
		DecimalFormat df = new DecimalFormat("###.##");
		
		// the string representing the prospect
		String result = 
			"Prospect " 
			+ i
			+ ": "
			+ prospect.getCustomer() 
			+ " wants to borrow " 
			+ prospect.getTotalLoan() 
			+ " € for a period of "
			+ prospect.getYears()
			+ " years and pay "
			+ df.format(E)
			+ " € each month";
		// set the result string as an attribute for the Prospect object
		prospect.setProspect(result);
	}
	
	
	/**
	 * Calculates b raised to the power of e
	 * Can only calculate when the exponent is an integer
	 * 
	 * @param b			the base 
	 * @param e			the exponent
	 * @return			b^e (b raised to the power of e)
	 */
	static double pow(double b, int e) {
		double result = 1;

		while (e != 0) {
			result *= b;
			--e;
		}
		
		return result;
  }
}
