package com.nnk.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
	@RequestMapping("/")
	public String home(Model model) {
		//TODO: LOGGER
		return "home";
	}

	@RequestMapping("/admin/home")
	public String adminHome(Model model) {
		//TODO: LOGGER
		return "redirect:/bidList/list";
	}


}
