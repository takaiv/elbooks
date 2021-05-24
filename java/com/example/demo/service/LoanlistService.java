package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.common.Book;
import com.example.demo.mapper.loanlist.LoanlistMapper;




@Service
public class LoanlistService {

	@Autowired
	LoanlistMapper loanlistMapper;

	public List<Book> findAll() {

		return loanlistMapper.findAll();
	}




}
