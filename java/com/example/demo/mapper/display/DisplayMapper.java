package com.example.demo.mapper.display;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.common.Book;
import com.example.demo.entity.common.Loan;
import com.example.demo.entity.common.User;




@Mapper
public interface DisplayMapper {
	List<Book>findBook();
	List<User>findUser();
	List<Loan>findByLoanUserId (int id);

}
