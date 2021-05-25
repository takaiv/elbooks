package com.example.demo.entity.display.login;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class LoginUser  implements Serializable{


	@NotEmpty(message = "{id}")
	private int user_id;


	@NotEmpty(message = "{name}")
	@Size(max=64)
	private String user_name;

	private String admin_mail;

	@NotEmpty(message = "{pass}")
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