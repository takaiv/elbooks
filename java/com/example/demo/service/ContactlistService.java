package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.common.User;
import com.example.demo.mapper.contact_list.ContactlistMapper;




@Service
public class ContactlistService {

	@Autowired
	ContactlistMapper contactlistMapper;


	public List<User> findAll() {

		return contactlistMapper.findAll();
	}




}
