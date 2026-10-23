package com.example.practice3.controller;

import com.example.practice3.model.Student;
import com.example.practice3.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    private boolean isLoggedIn(HttpSession session) {
        return Boolean.TRUE.equals(session.getAttribute("loggedIn"));
    }

    @GetMapping
    public String listStudents(HttpSession session, Model model) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("username", session.getAttribute("username"));
        return "students-list";
    }

    @GetMapping("/add")
    public String showAddForm(HttpSession session, Model model) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }
        model.addAttribute("student", new Student());
        return "students-form";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student, HttpSession session) {
        if (!isLoggedIn(session)) {
            return "redirect:/login";
        }
        if (student.getHasDebt() == null) {
            student.setHasDebt(false);
        }
        studentService.saveStudent(student);
        return "redirect:/students";
    }
}
