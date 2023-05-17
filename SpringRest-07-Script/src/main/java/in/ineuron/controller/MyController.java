package in.ineuron.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import in.ineuron.model.Student;

@Controller
public class MyController {
		

	@PostMapping(value = "/submit")
	public String save(Student student , Model model) {
		
		System.out.println("Hello Mangesh bhai");
		System.out.println(student);
		
		model.addAttribute("stud" , student);
		
		return "output";
	}
	
}
