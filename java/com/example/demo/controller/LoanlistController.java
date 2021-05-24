package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.LoanlistService;



@Controller
public class LoanlistController {

	@Autowired
	LoanlistService loanlistService;

//  貸出一覧表示 localhost:8059/loanlist
	@RequestMapping("/loanlist")
	public String mypage(Model model) {
		model.addAttribute("loans", loanlistService.findAll());
		return "/pages/loanlist";
	}

}
