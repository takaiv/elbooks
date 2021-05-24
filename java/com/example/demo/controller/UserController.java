package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.common.User;
import com.example.demo.mapper.display.DisplayMapper;
import com.example.demo.mapper.insert.InsertMapper;
import com.example.demo.mapper.update.UpdateMapper;



@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	DisplayMapper displayMapper;
	@Autowired
	InsertMapper insertMapper;
	@Autowired
	UpdateMapper updateMapper;

	@GetMapping("/list")
	public String users(@ModelAttribute User user,Model model) {
		model.addAttribute("userList",displayMapper.findUser());
		return "pages/user_list";
	}

	@PostMapping("/add")
	public String userAdd(@ModelAttribute User user) {
		insertMapper.insertUser(user);
		return "redirect:/user/list";
	}

	@PostMapping("/edit")
	public String userEdit(@ModelAttribute User user,@RequestParam int userId) {
		user.setUser_id(userId);
		updateMapper.updateUser(user);
		return "redirect:/user/list";
	}

	@PostMapping("/delete")
	public String userDrop(@ModelAttribute User user,@RequestParam int userId) {
		updateMapper.deleteUser(userId);
		return "redirect:/user/list";
	}

}