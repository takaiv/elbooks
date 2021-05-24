package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.common.Contact;
import com.example.demo.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	ContactService contactService;

//	画面表示 localhost:8059/contact
	@RequestMapping("/contact")
	public String contact(Model model) {
		return "/pages/contact";
	}

//	問い合わせ追加
	@PostMapping("/contactadd")
	public String addcontact(@ModelAttribute Contact contact, Model model) {


		contactService.save(contact);

		return "redirect:/contact/";
	}

}
