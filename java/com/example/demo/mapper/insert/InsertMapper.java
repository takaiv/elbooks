package com.example.demo.mapper.insert;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.common.User;



@Mapper
public interface InsertMapper {
	void insertUser(User user);
}
