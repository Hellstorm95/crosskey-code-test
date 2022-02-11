package org.mortage.mortagecalculator;

import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test class for the logic of the application
 * 
 * @author Rickard Hellström
 *
 */
@SpringBootTest
public class MortagecalculatorApplicationTests {
	
	/**
	 * Unit test for MortageCalculator.readProspectFile()
	 */
	@Test
	public void testReadProspectFile() {
		List<Prospect> prospectList = MortageCalculator.readProspectFile("files/prospects.txt");
		
		assertTrue(prospectList.size() == 4);
		
		assertTrue(prospectList.get(0).getCustomer().equals("Juha"));
		assertTrue(prospectList.get(0).getTotalLoan() == 1000);
		assertTrue(prospectList.get(0).getInterest() == 5);
		assertTrue(prospectList.get(0).getYears() == 2);
		
		assertTrue(prospectList.get(1).getCustomer().equals("Karvinen"));
		assertTrue(prospectList.get(1).getTotalLoan() == 4356);
		assertTrue(prospectList.get(1).getInterest() == 1.27);
		assertTrue(prospectList.get(1).getYears() == 6);
		
		assertTrue(prospectList.get(2).getCustomer().equals("Claes Månsson"));
		assertTrue(prospectList.get(2).getTotalLoan() == 1300.55);
		assertTrue(prospectList.get(2).getInterest() == 8.67);
		assertTrue(prospectList.get(2).getYears() == 2);
		
		assertTrue(prospectList.get(3).getCustomer().equals("Clarencé Andersson"));
		assertTrue(prospectList.get(3).getTotalLoan() == 2000);
		assertTrue(prospectList.get(3).getInterest() == 6);
		assertTrue(prospectList.get(3).getYears() == 4);
		
		assertTrue(
			prospectList.get(0).getProspect().equals("Prospect 1: Juha wants to borrow 1000.0 € for a period of 2 years and pay 43,87 € each month")
		);
		assertTrue(
			prospectList.get(1).getProspect().equals("Prospect 2: Karvinen wants to borrow 4356.0 € for a period of 6 years and pay 62,87 € each month")
		);
		assertTrue(
			prospectList.get(2).getProspect().equals("Prospect 3: Claes Månsson wants to borrow 1300.55 € for a period of 2 years and pay 59,22 € each month")
		);
		assertTrue(
			prospectList.get(3).getProspect().equals("Prospect 4: Clarencé Andersson wants to borrow 2000.0 € for a period of 4 years and pay 46,97 € each month")
		);
	}
	
	/**
	 * Unit test for MortageCalculator.pow()
	 */
	@Test
	public void testPow() {
		assertTrue(MortageCalculator.pow(2,2) == 4);
		assertTrue(MortageCalculator.pow(5,8) == 390625);
		assertTrue(MortageCalculator.pow(2.4,3) == 13.824);
	}
	
	/**
	 * Unit test for MortageCalculator.calculateMortage()
	 */
	@Test
	public void testCalculateMortage() {
		Prospect prospectA = new Prospect("Juha", 1000, 5, 2);
		Prospect prospectB = new Prospect("Karvinen", 4356, 1.27, 6);
		Prospect prospectC = new Prospect("Claes Månsson", 1300.55, 8.67, 2);
		Prospect prospectD = new Prospect("Clarencé Andersson", 2000, 6, 4);
		
		DecimalFormat df = new DecimalFormat("###.##");
		
		assertTrue(df.format(MortageCalculator.calculateMortage(prospectA)).equals("43,87"));
		assertTrue(df.format(MortageCalculator.calculateMortage(prospectB)).equals("62,87"));
		assertTrue(df.format(MortageCalculator.calculateMortage(prospectC)).equals("59,22"));
		assertTrue(df.format(MortageCalculator.calculateMortage(prospectD)).equals("46,97"));
	}
	
	/**
	 * Unit test for MortageCalculator.testUpdateProspect()
	 */
	@Test
	public void testUpdateProspect() {
		Prospect prospectA = new Prospect("Juha", 1000, 5, 2);
		Prospect prospectB = new Prospect("Karvinen", 4356, 1.27, 6);
		Prospect prospectC = new Prospect("Claes Månsson", 1300.55, 8.67, 2);
		Prospect prospectD = new Prospect("Clarencé Andersson", 2000, 6, 4);
		
		List<Prospect> prospectList = new ArrayList<Prospect>();
		prospectList.add(prospectA);
		prospectList.add(prospectB);
		prospectList.add(prospectC);
		prospectList.add(prospectD);
		
		MortageCalculator.updateProspect(prospectA, 1);
		MortageCalculator.updateProspect(prospectB, 2);
		MortageCalculator.updateProspect(prospectC, 3);
		MortageCalculator.updateProspect(prospectD, 4);
		
		assertTrue(
			prospectA.getProspect().equals("Prospect 1: Juha wants to borrow 1000.0 € for a period of 2 years and pay 43,87 € each month")
		);
		assertTrue(
			prospectB.getProspect().equals("Prospect 2: Karvinen wants to borrow 4356.0 € for a period of 6 years and pay 62,87 € each month")
		);
		assertTrue(
			prospectC.getProspect().equals("Prospect 3: Claes Månsson wants to borrow 1300.55 € for a period of 2 years and pay 59,22 € each month")
		);
		assertTrue(
			prospectD.getProspect().equals("Prospect 4: Clarencé Andersson wants to borrow 2000.0 € for a period of 4 years and pay 46,97 € each month")
		);

	}
	
}
