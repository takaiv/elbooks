//担当：原さん
//書籍登録フォームの表示

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.common.Book;
import com.example.demo.service.BookService;

@Controller
// URL/books以降の処理をこちらへ流す
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;

//findAllを使用してisdeleteが0のデータを表示
	@GetMapping("/mypage")
	public String findAll(Model model) {
		model.addAttribute("books", bookService.findAll());
			return "/pages/mypage";
	}

// 書籍新規登録画面
	@GetMapping("/book_add")
	String bookadd() {
		return "/pages/test/book_add";
	}

// URL books/book_addより登録ボタン押下後に以下の処理を流す
// 書籍の新規登録処理
	@PostMapping
	public String create(@ModelAttribute Book book, String file, Model model) {
		bookService.save(book);

	    List<Book> test;
		test = bookService.maxbook();

			return "redirect:/mypage";
	}

//書籍編集画面
	@GetMapping("/ed/{bookId}")
	String editbook(@PathVariable Long bookId, Model model) {
		model.addAttribute("book",bookService.findOne(bookId));
			return "/pages/book_edit";
	}

//書籍の更新を行う
	@GetMapping("/{bookId}/update")
	public String update(@ModelAttribute Book book) {
		bookService.update(book);
			return "redirect:/mypage";
	}

//書籍の削除を行う
	@GetMapping("/{bookId}/delete")
	public String Delete(@PathVariable Long bookId) {
		bookService.delete(bookId);
			return "redirect:/mypage";
	}

}
