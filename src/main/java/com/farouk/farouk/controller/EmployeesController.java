package com.farouk.farouk.controller;

import com.farouk.farouk.model.Employees;
import com.farouk.farouk.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeesController {
    @Autowired
    private EmployeesService service;

    @GetMapping("/")
    public String home(Model model) {
        List<Employees> employees = service.getAllEmployees();
        model.addAttribute("employees", employees);
        return "home";  // nom de ton fichier Thymeleaf : home.html
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employees());
        return "addEmployee"; // Thymeleaf attend addEmployee.html
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employees employee) {
        service.save(employee);
        return "redirect:/"; // Redirection vers la page d’accueil
    }


}
