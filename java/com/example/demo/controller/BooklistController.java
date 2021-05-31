//製作：高安さん
//パス：直接
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping(value = { "/", "/mypage" })
	public String mypage(@AuthenticationPrincipal LoginUserDetailsImpl user, Model model) {

		LoginUser loginUser = user.getLoginUser();
		int user_id = loginUser.getUser_id();
		//ログインユーザー情報の注入
		model.addAttribute("loginUser", loginUser);

		System.out.println(loginUser);
		//書籍リストの注入
		model.addAttribute("books", booklistService.findAll_MypageBooks(user_id));
		return "/pages/mypage";
	}

	//書籍タイトル・著者検索
	@PostMapping("/myseach")
	public String findOne(@ModelAttribute Book book, Model model) {

		String keyword = book.getTitle();
		model.addAttribute("seach", booklistService.findtitle(keyword));

		model.addAttribute("seachs", booklistService.findauthor(keyword));

		return "/pages/mypage";
	}

	//headerの確認：大平
	//	@GetMapping("/header")
	//	public String tmp(Model model) {
	//
	//		
	//		return "/pages/header";
	//	}

}
