package com.greenfox.error.model.config;

import com.greenfox.error.model.model.UserService;
import com.greenfox.error.model.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by aze on 25/10/17.
 */
@Controller
public class AppController {

    @Autowired
    UserService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("new_user", new User());
        model.addAttribute("yolo", service.getAll());
        return "index";
    }

    @PostMapping("/app")
    public String create() {
        service.save(new User());
        return "redirect:/";
    }
}