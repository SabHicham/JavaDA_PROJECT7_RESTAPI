package com.nnk.springboot.controllers;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
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
public class CurveController {

    private static final Logger logger = LogManager.getLogger(CurveController.class);


    @Autowired
    private CurvePointRepository curvePointRepository;
    @RequestMapping("/curvePoint/list")
    public String home(Model model)
    {
        model.addAttribute("curves", curvePointRepository.findAll());
        logger.info("affichage de tous les Curvess");
        return "curvePoint/list";
    }

    @GetMapping("/curvePoint/add")
    public String addBidForm(CurvePoint bid) {
        logger.info("affichage page d'ajout curve");
        return "curvePoint/add";
    }

    @PostMapping("/curvePoint/validate")
    public String validate(@Valid CurvePoint curvePoint, BindingResult result, Model model) {
        // TODO: check data valid and save to db, after saving return Curve list
        curvePointRepository.save(curvePoint);
        model.addAttribute("curves", curvePointRepository.findAll());


        return "curvePoint/add";
    }

    @GetMapping("/curvePoint/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("curve", curvePointRepository.findById(id).get());
        logger.info("affichage d'un CurvePoint");

        return "curvePoint/update";
    }

    @PostMapping("/curvePoint/update/{id}")
    public String updateBid(@PathVariable("id") Integer id, @Valid CurvePoint curvePoint,
                             BindingResult result, Model model) {
        curvePoint.setId(id);
        curvePointRepository.save(curvePoint);
        model.addAttribute("curves", curvePointRepository.findAll());
        logger.info("modification d'un CurvePoint");

        return "redirect:/curvePoint/list";
    }

    @GetMapping("/curvePoint/delete/{id}")
    public String deleteBid(@PathVariable("id") Integer id, Model model) {
        curvePointRepository.deleteById(id);
        logger.info("suppression d'un curvePoint");

        return "redirect:/curvePoint/list";
    }
}
