package com.example.demo.mapper.update;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.common.User;



@Mapper
public interface UpdateMapper {
	void updateUser(User user);
	void deleteUser(int id);
}
