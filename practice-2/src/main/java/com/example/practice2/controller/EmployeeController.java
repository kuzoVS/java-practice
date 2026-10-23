package com.example.practice2.controller;

import com.example.practice2.model.Employee;
import com.example.practice2.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String listEmployees(@RequestParam(required = false) String name,
                                @RequestParam(required = false, defaultValue = "all") String status,
                                Model model) {
        Boolean active = switch (status) {
            case "active" -> true;
            case "inactive" -> false;
            default -> null;
        };
        model.addAttribute("employees", employeeService.search(name, active));
        model.addAttribute("name", name);
        model.addAttribute("status", status);
        return "employees-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getById(id));
        return "employee-form";
    }

    @PostMapping("/add")
    public String saveEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (employee.getEmail() != null && employeeService.emailExists(employee.getEmail())) {
            boolean sameEmployee = employee.getId() != null
                    && employeeService.getById(employee.getId()).getEmail().equals(employee.getEmail());
            if (!sameEmployee) {
                bindingResult.rejectValue("email", "duplicate", "Сотрудник с таким email уже существует");
            }
        }
        if (bindingResult.hasErrors()) {
            return "employee-form";
        }
        if (employee.getActive() == null) {
            employee.setActive(false);
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
