package com.example.demo.entity.common;

import java.sql.Date;

import lombok.Data;

@Data
public class Contact {

	private Integer inquiry_id;
	private Integer user_id;
	private Integer category_id;
	private String inquiry_contents;
	private Date inquiry_day;
	private String user_name;
	private String mail;




}
