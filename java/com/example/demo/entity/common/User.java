package com.example.demo.entity.common;

import lombok.Data;

@Data
public class User {
	private int user_id;
	private String user_name;
	private String mail;
	private String pass;
	private int admin_flg;
	private String join_day;
	private String entry_day;
	private String updatetime;
	private int isdeleted;
}
