package com.example.practice3.controller;

import com.example.practice3.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login-form";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {
        if (!userService.authenticate(username, password)) {
            model.addAttribute("error", "Неверный логин или пароль");
            return "login-form";
        }
        session.setAttribute("loggedIn", true);
        session.setAttribute("username", username);
        return "redirect:/students";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register-form";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           Model model) {
        if (username.isBlank() || password.isBlank()) {
            model.addAttribute("error", "Логин и пароль не могут быть пустыми");
            return "register-form";
        }
        if (!userService.register(username, password)) {
            model.addAttribute("error", "Пользователь с таким логином уже существует");
            return "register-form";
        }
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
