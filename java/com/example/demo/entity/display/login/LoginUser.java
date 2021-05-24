package com.example.demo.entity.display.login;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;


@Data
public class LoginUser  implements Serializable{


	//    @NonNull
	private int user_id;

	//	@NonNull
	private String user_name;

	//	@NonNull
	private String admin_mail;

	//	@NonNull
	private String pass;

	//	@NonNull
	private int admin_flg;

	//	@NonNull
	private Date join_day;

	//	@NonNull
	private Date entry_day;

	//	@NonNull
	private Date updatetime;

	//	@NonNull
	private int isdeleted;

	
}