//担当者：新井さん
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.common.Book;
import com.example.demo.entity.common.History;
import com.example.demo.entity.display.lendingbook.LendingBook;
import com.example.demo.entity.display.login.LoginUserDetailsImpl;
import com.example.demo.mapper.book.BookMapper;
import com.example.demo.mapper.book_a.BookMapper_a;
import com.example.demo.service.LendingService;

@Controller
@RequestMapping("/elbooks")
public class LendingController {

	@Autowired
	BookMapper_a bookMapper;
	@Autowired
	LendingService lendingService;
	@Autowired
	BookMapper bookMapper_hara;

	// 貸出画面
	@GetMapping("/booklist")
	public String booklist(Model model) {
		List<Book> list = bookMapper.select();
		model.addAttribute("Book", list);
		model.addAttribute("lendingBook", new LendingBook());
		return "/pages/booklist";
	}

	/**
	 * 借りる機能
	 * 編集日：2021/5/19
	 * 編集：オオヒラ
	 * コメント：いくつか変更しました。
	 */
	@PostMapping("/book/{book_id}")
	public String insertBook(@AuthenticationPrincipal LoginUserDetailsImpl user,@ModelAttribute LendingBook lendingBook,@ModelAttribute Book book,@PathVariable("book_id") Integer book_id) {
		//user_idをログインユーザーから取得してセット
		lendingBook=bookMapper.selectLengingBookOne(book_id);
		lendingBook.setUser_id(user.getLoginUser().getUser_id());
		
		System.out.println(lendingBook.getUser_id());
		System.out.println(lendingBook.getBook_id());
		
		book.setMax_num(lendingBook.getMax_num()-1) ;
		book.setBook_id(lendingBook.getBook_id());
		
		//サービス呼び出し
		lendingService.updateMax_num(book);
		
		lendingService.insertBook(lendingBook);
		
		//		bookMapper.update(book);
		return "redirect:/mypage";
	}
	/**
	 * /借りる機能
	 */

	// 返却
	@GetMapping("/returnlist")
	public String returnlist(Model model, @ModelAttribute History history) {
		List<LendingBook> list = bookMapper.returnSelect();
		model.addAttribute("LendingBook", list);
		return "/pages/returnlist";
	}

	/**
	 * 機能：返却機能
	 * 作成者：新井さん
	 * 最終編集者：オオヒラ
	 * */
	@PostMapping("/returnbook/{returnBookId}")
	public String returnInsert(@PathVariable("returnBookId") Integer returnBookId,@ModelAttribute LendingBook lendingBook,@AuthenticationPrincipal LoginUserDetailsImpl user) {
		//book_idをセット
		lendingBook.setBook_id(returnBookId);
		
		//user_idをセット
		lendingBook.setUser_id(user.getLoginUser().getUser_id());
		
		//現在の冊数を取得(適切なクラスに変えてください)【】
		Optional<LendingBook> optional = bookMapper.maxnumSelect(lendingBook);
		lendingBook = optional.get();
		
		//冊数+1処理
		int max_num = lendingBook.getMax_num() +1;
		lendingBook.setMax_num(max_num);
		
		//冊数更新処理
		lendingService.updateMax_num(lendingBook);
		
		System.out.println(lendingBook);
		
		//履歴の挿入処理
		lendingService.insertReturnBook(returnBookId);
		
		//レンタルテーブルから削除処理
		lendingService.returndelete(returnBookId);
		
		//メインメニューにリダイレクト
		return "redirect:/mypage";
	}
	/**
	 * /機能：返却機能
	 * */

	@GetMapping("/book")
	public String Book() {

		return "book";
	}

	@GetMapping("/bookAdd")
	public String bookAdd() {

		return "bookAdd";
	}
}
