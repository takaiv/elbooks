package com.example.demo.mapper.book_a;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.common.Book;
import com.example.demo.entity.display.lendingbook.LendingBook;

@Mapper
public interface BookMapper_a {

	/**
	 * select
	 * */
	// 書籍一覧表示検索
	List<Book> selectAllBook();
	
	// 借りている書籍一覧検索
	List<LendingBook> returnSelect();

	//レンタルしたい書籍検索
	LendingBook selectOneBook(Integer book_id);

	//レンタルしている書籍検索
	LendingBook selectOneLendingBook(Integer returnBookId, int user_id);
	/**
	 * /select
	 * */
	
	
	/**
	 * insert
	 * */
	// 貸出 t_loanに書籍を登録
	public void insert(LendingBook lendingBook);

	// 返却 t_Historyにt_loanの書籍を登録
	public void returnInsert(LendingBook lendingBook);

	/**
	 * /insert
	 * */

	
	/**
	 * update
	 * */
	public void update(Book book);

	/**
	 * /update
	 * */

	/**
	 * delete
	 * */
	//delete
	public void returnDelete(LendingBook lendingBook);
	/**
	 * /delete
	 * */

}
