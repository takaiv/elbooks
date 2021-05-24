package com.example.demo.mapper.booklist;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.common.Book;




@Mapper
public interface BooklistMapper {

//	本一覧表示
	List<Book> findAll();

//	書籍名で検索
	List<Book> findtitle(String title);

//	著者名で検索
	List<Book> findauthor(String title);

}
