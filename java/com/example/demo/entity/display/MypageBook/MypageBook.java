package com.example.demo.entity.display.MypageBook;

import com.example.demo.entity.common.Book;

import lombok.Data;

@Data
public class MypageBook extends Book{
	private String loan_day;
	private String plan_day;
}
