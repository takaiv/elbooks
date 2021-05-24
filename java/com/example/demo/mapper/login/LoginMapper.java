package com.example.demo.mapper.login;



import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.display.login.LoginUser;

@Mapper
public interface LoginMapper{

    LoginUser findUser(String user_name);

}
