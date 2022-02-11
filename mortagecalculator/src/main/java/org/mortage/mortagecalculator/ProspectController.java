package org.mortage.mortagecalculator;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;

/**
 * @author Rickard Hellström
 *
 * Class for controlling the RESTful requests from users
 */
@Controller
public class ProspectController {
	// Reading the prospects from the prospects.txt file
	private List<Prospect> prospectList = MortageCalculator.readProspectFile("files/prospects.txt");
	
	/**
	 * Method that handles get requests from /prospect.
	 * 
	 * @param model 	stores attributes that are used with an html template to create a view
	 * @return 			a view for the user create a new prospect 
	 */
	@GetMapping("/prospect")
	public String prospectForm(Model model) {
		/* adds an empty prospect to the view for creating a prospect
		 * the attributes of the Prospect object is filled by the user when they
		 * fill the form in the view. 
		 */
		model.addAttribute("prospect", new Prospect());
		return "prospect";
	}
	
	/**
	 * Method that handles get requests from /showprospects.
	 * 
	 * @param model		stores attributes that are used with an html template to create a view
	 * @return 			a view that shows all of the prospects saved
	 */
	@GetMapping("/showprospects")
	public String showProspects(Model model) {
		// Add the prospect list to the view
		model.addAttribute("prospects", prospectList);
	    return "showprospect";
	}
	
	/**
	 *  Method that handles post requests from /showprospects.
	 * 
	 * @param prospect	a prospect the user just had created with the /prospect view
	 * @param model		stores attributes that are used with an html template to create a view
	 * @return 			a view that shows the all of the prospects saved including the new one created
	 */
	@PostMapping("/showprospects")
	public String submitProspect(@ModelAttribute Prospect prospect, Model model) {
		// Calculates mortage and updates prospect attribute of the new Prospect object
		MortageCalculator.updateProspect(prospect, prospectList.size() + 1);
		// Add the new prospect to the prospect list
		prospectList.add(prospect);
		// Add the prospect list to the view
		model.addAttribute("prospects", prospectList);
	    return "showprospect";
	}
	
}