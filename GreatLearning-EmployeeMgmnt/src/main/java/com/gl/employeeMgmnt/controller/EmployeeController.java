package com.gl.employeeMgmnt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gl.employeeMgmnt.model.Employee;
import com.gl.employeeMgmnt.service.EmployeeService;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	EmployeeService empService;
	private boolean update = false;
	private int index ;

	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}

	@GetMapping("/")
	public String showEmpList(Model model) {
		model.addAttribute("emps", empService.getAllEmployees());
		return "employees-list";
	}

	@GetMapping("/addEmployee")
	public String createEmp(Model model) {
		model.addAttribute("employee", new Employee());
		return "employee";
	}

	@PostMapping("/saveEmp")
	public String saveEmp(Model model, @ModelAttribute("employee") Employee employee) {
		empService.saveEmployee(employee);
		if (update)
			empService.deleteEmployeeById(index);
		return "redirect:/employees/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmp(Model model, @PathVariable int id) {
		empService.deleteEmployeeById(id);
		return "redirect:/employees/";
	}

	@GetMapping("/update/{id}")
	public String updateEmp(Model model, @PathVariable int id) {
		Employee employee = empService.getEmployeeById(id);
		model.addAttribute("employee", employee);
		update = true;
		index = id;
		return "employee";
	}
}
