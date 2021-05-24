//レンタルモーダル,返却モーダルの表示

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.mapper.display.DisplayMapper;

@Controller
@RequestMapping("")
public class Book_yController {

	@Autowired
	DisplayMapper displayMapper;

	//レンタルモーダル,返却モーダルの表示
	@GetMapping("/book")
    public String Modal(Model model) {
		model.addAttribute("bookList",displayMapper.findBook());
    	return "pages/book";
    }
//返却機能
	@GetMapping("rental")
    public String BookHistory(Model model) {
		model.addAttribute("rentalList",displayMapper.findByLoanUserId(1));
    	return "pages/book_history";
    }

}