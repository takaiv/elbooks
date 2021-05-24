package com.example.demo.entity.common;

import java.sql.Date;

import lombok.Data;

@Data
public class Book {

	private Integer book_id;
	private String title;
	private String author;
	private Integer category_id;
	private Integer max_num;
	private Date entry_day;
	private Date updatetime;
	private Integer isdeleted;
	private Integer page;


	
}
