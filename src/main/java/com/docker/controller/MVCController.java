package com.docker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.docker.entity.mysql.User;

@Controller
public class MVCController
{
	@GetMapping("/register")
	public String showForm(Model model) 
	{
		User user = new User();
		model.addAttribute("user", user); // key pair value
		

		return "register_form";
	}
	@PostMapping("/register")
	public String submitForm(@ModelAttribute("user") User user) {
	    System.out.println(user);
	    
	    return "register_success";
	}
}