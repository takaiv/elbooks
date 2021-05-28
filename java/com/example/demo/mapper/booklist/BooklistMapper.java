package com.example.demo.mapper.booklist;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.common.Book;
import com.example.demo.entity.display.MypageBook.MypageBook;




@Mapper
public interface BooklistMapper {

//	本一覧表示
	List<Book> findAll();

//	書籍名で検索
	List<MypageBook> findtitle(String keyword);

//	著者名で検索
	List<MypageBook> findauthor(String keyword);

	List<MypageBook> findAll_MypageBooks(int user_id);

}
