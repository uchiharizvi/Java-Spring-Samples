package com.kavish.tutorials.controller;

import com.kavish.tutorials.entity.User;
import com.kavish.tutorials.service.UserService;
import com.kavish.tutorials.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import cn.apiclub.captcha.Captcha;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        User user = new User();
        getCaptcha(user);
        model.addAttribute("user", user);
        return "registerUser";
    }

    @PostMapping("/save")
    //TODO check usage of ModelAttribute
    public String saveUser(@ModelAttribute User user, Model model) {
        if (user.getCaptcha().equalsIgnoreCase(user.getHiddenCaptcha())) {
            userService.createUser(user);
            model.addAttribute("message", "User Registered Successfully!");
            return "redirect:allUsers";
        } else {
            model.addAttribute("message","Invalid Captcha");
            getCaptcha(user);
            model.addAttribute("user", user);
        }
        return "registerUser";
    }

    @GetMapping("/allUsers")
    public String getAllUsers(Model model) {
        List<User> userList= userService.getAllUsers();
        model.addAttribute("userList", userList);
        return "listUsers";
    }

    private void getCaptcha(User user) {
        Captcha captcha = CaptchaUtil.createCaptcha(240, 70);
        user.setHiddenCaptcha(captcha.getAnswer());
        user.setCaptcha("");//value entered by user
        user.setRealCaptcha(CaptchaUtil.encodeCaptcha(captcha));
    }
}
