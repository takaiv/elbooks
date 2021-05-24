package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.common.Book;
import com.example.demo.entity.display.login.LoginUser;
import com.example.demo.entity.display.login.LoginUserDetailsImpl;
import com.example.demo.service.BooklistService;

@Controller
public class BooklistController {

	@Autowired
	BooklistService booklistService;

//	localhost:8080/mypage
	@RequestMapping("/mypage")
	public String mypage(@AuthenticationPrincipal LoginUserDetailsImpl user, Model model) {
		model.addAttribute("books", booklistService.findAll());
		LoginUser loginUser=user.getLoginUser();

		model.addAttribute("loginUser", loginUser);

		System.out.println(user);

		System.out.println(loginUser);
		return "/pages/mypage";
	}

	@PostMapping("/myseach")
	public String findOne(@ModelAttribute Book book, Model model) {

		String title = book.getTitle();

//		タイトル検索
		System.out.println(title);
		model.addAttribute("seach", booklistService.findtitle(title));

		model.addAttribute("seachs", booklistService.findauthor(title));

		return "/pages/mypage";
	}
	
	@GetMapping("/header")
	public String tmp(Model model) {

		
		return "/pages/header";
	}

}
