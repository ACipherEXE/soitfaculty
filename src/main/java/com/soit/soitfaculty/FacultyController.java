package com.soit.soitfaculty;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import com.soit.soitfaculty.model.Faculty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {
	/**
	 * 
	 */
	//upload Faculty info
	private List<Faculty> theFaculties;
	
	@PostConstruct
	private void loadData() {
		
		//Create falculties
		Faculty fac1 = new Faculty(1, "Kelly", "Miller", "kelly@uc.edu");
		Faculty fac2 = new Faculty(2, "Robbert", "Lee", "Robbert@uc.edu");
		Faculty fac3 = new Faculty(3, "laura", "West", "laura@uc.edu");
		
		//create our list
		theFaculties = new ArrayList();
		
		//add to our list
		theFaculties.add(fac1);
		theFaculties.add(fac2);
		theFaculties.add(fac3);
		
		
	}
	
	
	//Mapping for '/list'
	@GetMapping("/list")
	public String listFaculties(Model theModel) {
		//Add Faculties to the spring model 
		theModel.addAttribute("faculties", theFaculties);
		return "list-faculties";
	}
	
}
