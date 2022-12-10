package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.service.RatingService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class RatingController {
    private static final Logger logger = LogManager.getLogger(RatingController.class);
    @Autowired
    private RatingService ratingService;

    @RequestMapping("/rating/list")
    public String home(Model model)
    {
        model.addAttribute("ratings", ratingService.findAll());
        //TODO: VERIFIER
        logger.info("affichage de tous les Ratings");

        return "rating/list";
    }

    @GetMapping("/rating/add")
    public String addRatingForm(Rating rating) {
        //TODO: VERIFIER
        logger.info("affichage page d'ajout rating");
        return "rating/add";
    }

    @PostMapping("/rating/validate")
    public String validate(@Valid Rating rating, BindingResult result, Model model) {

        ratingService.save(rating);
        model.addAttribute("ratings", ratingService.findAll());
        //TODO: A FAIRE

        return "rating/add";
    }

    @GetMapping("/rating/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("rating", ratingService.findById(id));
        //TODO: A VERIFIER
        logger.info("affichage d'un Rating");

        return "rating/update";
    }

    @PostMapping("/rating/update/{id}")
    public String updateRating(@PathVariable("id") Integer id, @Valid Rating rating,
                             BindingResult result, Model model) {

        rating.setId(id);
        ratingService.save(rating);
        model.addAttribute("ratings", ratingService.findAll());
        //TODO: A VERIFIER
        logger.info("modification d'un Rating");

        return "redirect:/rating/list";
    }

    @GetMapping("/rating/delete/{id}")
    public String deleteRating(@PathVariable("id") Integer id, Model model) {

        ratingService.deleteById(id);
        //TODO: A VERIFIER
        logger.info("suppression d'un Rating");


        return "redirect:/rating/list";
    }
}
