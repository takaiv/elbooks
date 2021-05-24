package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.common.Book;
import com.example.demo.entity.display.lendingbook.LendingBook;
import com.example.demo.mapper.book_a.BookMapper_a;



@Service
public class LendingService {

	@Autowired
	BookMapper_a bookMapper;

	// 貸出
		public void insertBook(LendingBook lendingBook) {
			bookMapper.insert(lendingBook);
		}

		public void updateMax_num(Book book) {
			bookMapper.update(book);
		}

		// 返却
		public void insertReturnBook(int id) {
			bookMapper.returnInsert(id);
		}

		public void returndelete(int book_id) {
			bookMapper.returnDelete(book_id);
		}



}
