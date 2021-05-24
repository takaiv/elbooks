package com.example.demo.entity.common;

import lombok.Data;

@Data
public class Loan {
	private int book_id;
	private int user_id;
	private String loan_day;
	private String plan_day;

	private String title;
	private String category;
	private String author;
}
