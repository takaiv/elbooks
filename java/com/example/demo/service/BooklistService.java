package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.common.Book;
import com.example.demo.entity.display.MypageBook.MypageBook;
import com.example.demo.mapper.booklist.BooklistMapper;



@Service
public class BooklistService {

	@Autowired
	BooklistMapper booklistMapper;

//	本一覧表示
	public List<Book> findAll() {

		return booklistMapper.findAll();
	}

//	書籍名で検索
	public List<MypageBook> findtitle(String keyword) {

		return booklistMapper.findtitle(keyword);
	}

//	著者名で検索
	public List<MypageBook> findauthor(String keyword) {

		return booklistMapper.findauthor(keyword);
	}

	public List<MypageBook> findAll_MypageBooks(int user_id) {
		
		return booklistMapper.findAll_MypageBooks(user_id);
	}

}
