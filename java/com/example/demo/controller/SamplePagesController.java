package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
@Controller
@RequestMapping("/sample_pages")
public class SamplePagesController {
	//1.ログイン画面 担当：新井
	@GetMapping("/login")
    public String Login() {
    	return "pages/login.html";
    }
	
	//2.マイページ 担当：高安
	@GetMapping("/my_page")
    public String Mypage() {
    	return "pages/my_page.html";
    }
	
	//3.モーダル画面 担当：山内
	@GetMapping("/modal")
    public String Modal() {
    	return "pages/test/book.html";
    }
	
	//4.貸出リスト 担当：新井
	@GetMapping("/book_history")
    public String BookHistory() {
    	return "pages/test/book_history.html";
    }
	
	//5.書籍登録画面 担当：新井
	@GetMapping("/book_add")
    public String BookAdd() {
    	return "pages/test/book_add.html";
    }
	
	//6.書籍編集画面 担当：大平
	@GetMapping("/book_edit")
    public String bookedit() {
    	return "pages/test/book_edit.html";
    }
	
	//7.ユーザー登録画面 担当：大平
	@GetMapping("/user_register")
    public String UserRegister() {
    	return "pages/user_register.html";
    }

	//8.ユーザー編集画面 担当：大平
	@GetMapping("/user_edit")
    public String UserEdit() {
    	return "pages/user_edit.html";
    }
	
	//9.ユーザー一覧画面 担当：原
	@GetMapping("/user_list")
    public String UserList() {
    	return "pages/user_list.html";
    }
	
	//10.ヘッダー 担当：原
	@GetMapping("/header")
    public String Heder() {
    	return "pages/header.html";
    }

	//11.お問い合わせ画面 担当：佐藤
	@GetMapping("/contact")
    public String ContactUs() {
    	return "pages/test/contact.html";
    }

	//12.お問い合わせ一覧画面 担当：佐藤
	@GetMapping("/contact_mgt")
    public String ContactUsMtg() {
    	return "pages/test/contact_mgt.html";
    }

}
