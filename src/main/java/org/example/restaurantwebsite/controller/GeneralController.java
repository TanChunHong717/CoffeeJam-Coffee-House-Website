package org.example.restaurantwebsite.controller;

import org.example.restaurantwebsite.pojo.User;
import org.example.restaurantwebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class GeneralController {
    UserService userService;

    @Autowired
    public GeneralController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/log/in")
    public String userLogIn(HttpSession session, User user, Model model) {
        boolean login = userService.login(user.getUsername(), user.getPassword());
        if(login){
            session.setAttribute("user", user);
            return "redirect:/";
        } else {
            model.addAttribute("message", "Log In failed. Check username and password");
            return "redirect:/log/in";
        }
    }

    @RequestMapping("/sign/up")
    public String signUp(HttpSession session, User user) {
        userService.registerUser(user);
        session.setAttribute("user", user);
        return "redirect:/";
    }

    @RequestMapping("/admin/log/in")
    public String adminLogIn(HttpSession session, User user, Model model) {
        boolean login = user.getUsername().equals("admin") && user.getPassword().equals("1234");
        if(login){
            session.setAttribute("user", user);
            return "redirect:/admin";
        } else {
            model.addAttribute("message", "Log In failed. Check username and password");
            return "redirect:/log/in/admin";
        }
    }

    @RequestMapping("/log/out")
    public String logout(HttpSession session) {
        session.setAttribute("user", null);
        return "redirect:/";
    }
}
