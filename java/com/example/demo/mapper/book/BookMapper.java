package com.example.demo.mapper.book;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.common.Book;

@Mapper
@Repository
@Component
public interface BookMapper {

	List<Book> findAll();

	void save(Book book);

	Book findOne(Long bookId);

	void delete(Long bookId);

	void update(Book book);

	List<Book> maxbook();

}
