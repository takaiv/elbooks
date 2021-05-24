package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.common.Book;
import com.example.demo.mapper.book.BookMapper;


@Service
@Repository
@Component
public class BookService {

	@Autowired(required=true)
		private BookMapper bookMapper;


	  @Transactional(readOnly = true)
	  public List<Book> findAll() {
	    return bookMapper.findAll();
	  }

	 @Transactional
	 public void save(Book book) {
		 bookMapper.save(book);
	 }

	 @Transactional
	 public Book findOne(Long bookId) {
		 return bookMapper.findOne(bookId);
	 }

	 @Transactional
	 public void update(Book book) {
		 bookMapper.update(book);
	 }

	 @Transactional
	 public void delete(Long bookId) {
		 bookMapper.delete(bookId);
	 }


	 @Transactional
	 public List<Book> maxbook() {
		 return bookMapper.maxbook();
	 }




}
