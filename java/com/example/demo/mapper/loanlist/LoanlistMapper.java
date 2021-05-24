package com.example.demo.mapper.loanlist;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.common.Book;



@Mapper
public interface LoanlistMapper {

	List<Book> findAll();

}
