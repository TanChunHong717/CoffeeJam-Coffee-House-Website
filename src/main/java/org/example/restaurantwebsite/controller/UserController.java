package org.example.restaurantwebsite.controller;

import com.github.pagehelper.PageInfo;
import org.example.restaurantwebsite.pojo.User;
import org.example.restaurantwebsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/user/page/{pageNum}")
    public String getUserPage(@PathVariable("pageNum") Integer pageNum, Model model) {
        PageInfo<User> page = userService.getUserPage(pageNum);
        model.addAttribute("page", page);
        return "user_list";
    }

    @PutMapping("/profile/update")
    public String userProfile(HttpSession session, User user) {
        userService.updateUser(user);
        return "redirect:/profile";
    }
}
