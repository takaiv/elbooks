package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entity.common.User;
import com.example.demo.service.ContactlistService;

@Controller
public class ContactlistController {

	@Autowired
	ContactlistService contactlistService;

//	画面表示  localhost:8059/contactUs_mgt
//	@RequestMapping("/contactUs_mgt")
//	public String contactlist(Model model) {
//		return "/contactUs_mgt";
//	}

	@GetMapping("/contactUs_mgt")
	public String contactlist(@ModelAttribute User user, Model model) {

		model.addAttribute("lists", contactlistService.findAll());

		return "/pages/contactUs_mgt";
	}

}
