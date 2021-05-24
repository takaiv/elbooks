/**
 * 担当者：新井さん
 * */

package com.example.demo.entity.display.lendingbook;

import com.example.demo.entity.common.Book;

//import javax.validation.constraints.NegativeOrZero;

import lombok.Data;

@Data
public class LendingBook extends  Book{
	
//	@NegativeOrZero(message="すでに登録されています") // 何用？
	
	private int user_id;
	
	private String loan_day;
	private String plan_day;
	
	private String category;
	private String title;
	private String author;

}
