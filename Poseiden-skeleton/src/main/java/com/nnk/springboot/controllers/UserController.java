package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
public class UserController {

    private static final Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    private  BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();



    @RequestMapping("/user/list")
    public String home(Model model) {
        model.addAttribute("users", userService.findUserList());
        logger.info("affichage de tous les Users");
        return "user/list";
    }

    @GetMapping("/user/add")
    public String addUser(User bid) {
        logger.info("affichage page d'ajout User");
        return "user/add";
    }

    @PostMapping("/user/validate")
    public String validate(@Valid User user, BindingResult result, Model model) {

            if (!result.hasErrors()) {
                userService.save(user);
                return "redirect:/user/list";
            }
            return "user/add";
        }


    @GetMapping("/user/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("user", userService.findById(id));

        logger.info("affichage de user id:{}", id);
        return "user/update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUser(@PathVariable("id") Integer id, @Valid User user,
                             BindingResult result, Model model) {


        user.setId(id);
        userService.save(user);
        model.addAttribute("users", userService.findUser());
        logger.info("modification d'un User");
        return "redirect:/user/list";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model) {
        userService.deleteById(id);
        logger.info("suppression user id:{}", id);

        return "redirect:/user/list";
    }


    public void setEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }
}

