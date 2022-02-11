package org.mortage.mortagecalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Rickard Hellström
 *
 * Web application that calculates the monthly payment of a loan prospect according to
 * the loan amount, the annual interest and years until it is paid
 * 
 * The application shows the prospects in a list
 * 
 * Uses Spring Web to build the web application and Thymeleaf to display views,
 * created from html templates, to users
 * 
 */
@SpringBootApplication
public class MortagecalculatorApplication {

	/**
	 * Starts application
	 * 
	 * @param args 			the arguments passed when staring the application 
	 */
	public static void main(String[] args) {
		SpringApplication.run(MortagecalculatorApplication.class, args);
	}

}
