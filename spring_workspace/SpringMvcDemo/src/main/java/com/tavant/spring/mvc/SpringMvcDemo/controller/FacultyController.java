package com.tavant.spring.mvc.SpringMvcDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tavant.spring.mvc.SpringMvcDemo.entity.Faculty;
import com.tavant.spring.mvc.SpringMvcDemo.service.FacultyService;

@Controller
@RequestMapping("/faculty")
public class FacultyController {
	
	@Autowired
	private FacultyService service;
	
	@GetMapping("/list")
	public String listFaculties(Model model) {
		List<Faculty> theFaculties = service.listAll();
		model.addAttribute("faculties", theFaculties);
		return "list-faculties";
	}
	
	@GetMapping("/showForm")
	public String showForm(Model model) {
		Faculty f = new Faculty();
		model.addAttribute("faculty", f);
		return "faculty-form";
	}
	
	@PostMapping("/saveFaculty")
	public String saveFaculty(@ModelAttribute("faculty") Faculty faculty) {
		service.saveFaculty(faculty);
		return "redirect:/faculty/list";
	}
}












