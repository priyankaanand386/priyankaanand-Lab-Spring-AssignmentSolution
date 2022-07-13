package com.studentmgmt.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.studentmgmt.model.Student;
import com.studentmgmt.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	public StudentService studentService;

	@RequestMapping("/list")
	public String getAllStudents(Model model) {
		List<Student> allStudents = studentService.findAllStudents();
		model.addAttribute("Students", allStudents);
		return "list-students";
	}
	
	
	@RequestMapping("/showFormForAdd")
	public String addNewStudent(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "student-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String editStudent(
			@RequestParam Integer studentId,
			Model model) {
		Student student = studentService.findStudentById(studentId);
		model.addAttribute("Student", student);
		return "student-form";
	}
	
	@RequestMapping("/save")
	public String saveStudent(@ModelAttribute Student student) {
		studentService.saveStudent(student);
		return "redirect:/students/list";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam Integer studentId) {
		studentService.deleteStudentById(studentId);
		return "redirect:/students/list";
	}
	
	@RequestMapping("/403")
	public ModelAndView notFound(Principal user) {
		ModelAndView model = new ModelAndView();
		if(user != null) {
			model.addObject("msg", "Hi "+user.getName()+", you don't have permission to perform this action");
		}else {
			model.addObject("msg", "Hi, you don't have permission to perform this action");
		}
		model.setViewName("403");
		return model;
	}
	

}
