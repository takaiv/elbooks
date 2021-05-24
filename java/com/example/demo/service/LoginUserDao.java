//製作途中 大平
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.display.login.LoginUser;
import com.example.demo.mapper.login.LoginMapper;


@Repository
public class LoginUserDao {

    @Autowired
	LoginMapper mapper;

	public LoginUser findUser(String userName) {
        return mapper.findUser(userName);
    }
    
}