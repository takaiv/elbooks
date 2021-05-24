package com.example.demo.mapper.contact_list;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.common.User;



@Mapper
public interface ContactlistMapper {

	List<User> findAll();



}
