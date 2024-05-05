package com.studentmanagement.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.studentmanagement.entity.Student;
import com.studentmanagement.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	@RequestMapping("/getAllStudent")
	public String getAllStudent(Model model) {
		List<Student> listStudent = studentService.getAllStudent();
		model.addAttribute("studentfrnt", listStudent);
		return "students";
	}

	@GetMapping("/students/addform")
	public String createStudentForm(Model model) {
		Student s1 = new Student();
		model.addAttribute("student", s1);
		return "new_student";
	}

	@PostMapping("/addstudent")
	public String addstudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
//		if(studentService.getStudent(student.getStudentId()) != null)
		if (student.getStudentId() > 0) {
			studentService.addStudent(student);
			return "redirect:/getAllStudent";
		} else {
			return "typemismatch_handling";
		}
	}

	@GetMapping("/students/editform/{studentId}")
	public String editStudentForm(@PathVariable("studentId") int studId, Model model) {
		Student studdb = studentService.getStudent(studId);
		model.addAttribute("student", studdb);
		return "edit_student";
	}

	@PostMapping("/updatestudent/{id}")
	public String updateStudent(@PathVariable("id") int studId, @ModelAttribute("student") Student student) {
		studentService.updateStudent(studId, student);
		return "redirect:/getAllStudent";
	}

	@GetMapping("/deletestudent/{id}")
	public String deleteStudent(@PathVariable("id") int studId) {
		studentService.deleteStudent(studId);
		return "redirect:/getAllStudent";
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "you do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

}
