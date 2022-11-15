package com.soit.soitfaculty;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.soit.soitfaculty.entity.Faculty;
import com.soit.soitfaculty.service.FacultyService;

@Controller
@RequestMapping("/Faculties")
public class FacultyController {
	/**
	 * 
	 */
	//upload Faculty info
	//private List<Faculty> theFaculties;
	
	//@PostConstruct
	//private void loadData() {
		
		//Create falculties
		//Faculty fac1 = new Faculty(1, "Kelly", "Miller", "kelly@uc.edu");
		//Faculty fac2 = new Faculty(2, "Robbert", "Lee", "Robbert@uc.edu");
		//Faculty fac3 = new Faculty(3, "laura", "West", "laura@uc.edu");
		
		//create our list
		//theFaculties = new ArrayList();
		
		//add to our list
		//theFaculties.add(fac1);
		//theFaculties.add(fac2);
		//theFaculties.add(fac3);
		
		
	//}
	
	//ServerStuff
	public FacultyService facultyService;
	public FacultyController (FacultyService theFacultyService) {
		facultyService = theFacultyService;
	}
	
	//Mapping for '/list'
	@GetMapping("/list")
	public String listFaculties(Model theModel) {
		//Retrive faculties from the database
		List<Faculty> theFaculties = facultyService.findAll();
		//Add Faculties to the spring model 
		theModel.addAttribute("faculties", theFaculties);
		return "faculties/list-faculties";
	}
	@GetMapping("/viewAddForm")
	public String viewAddForm(Model theModel) {
		//Model attribute for data binding
		Faculty theFaculty = new Faculty();
		theModel.addAttribute("faculty", theFaculty);
		return "faculties/faculty-form";
	}
	@PostMapping("/save")
	public String saveFaculty(@ModelAttribute("faculty") Faculty theFaculty) {
		//Register the faculty 
		facultyService.save(theFaculty);
		//block the duplicates submission for accidental refresh
		
		return "redirect:/Faculties/list";
	}
}
