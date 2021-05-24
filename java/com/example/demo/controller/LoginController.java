//作成担当：大平
//作成日：2021年４月22日
//更新日：無し
//内容：loginとlogout画面の表示

package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.display.login.LoginUser;
import com.example.demo.entity.display.login.LoginUserDetailsImpl;
import com.example.demo.service.LoginUserDao;

@Controller
@RequestMapping("/pages")
//mypageにアクセス
public class LoginController {

	@Autowired
	LoginUserDao loginUserDao;

	/**
	 * user書籍一覧
	 * */
	@RequestMapping(value = "/my_page")
	private String init(@AuthenticationPrincipal LoginUserDetailsImpl user, Model model) {
//		@AuthenticationPrincipal LoginUserDetailsImpl user,
		// @AuthenticationPrincipal LoginUserDetailsImpl user はUserDetailsが実装されているクラスの情報を持ってこれるアノテーション

		LoginUser loginUser=user.getLoginUser();

		model.addAttribute("loginUser", loginUser);

		System.out.println(user);

		System.out.println(loginUser);

		return "/pages/my_page";//ちゃんと階層を指定すること
	}
	/**
	 *  /user書籍一覧
	 * */

	/**
	 * loginページ
	 * */
	//ログインページにアクセス
	@GetMapping("/login")
	public String Login() {
		return "pages/login.html";
	}
	/**
	 * /loginページ
	 * */


	/**
	 * logoutページ
	 * */
	//ログアウトページにアクセス
	@GetMapping("/logout")
	public String Logout() {
		return "pages/logout.html";
	}

	//headerページにアクセス
		@GetMapping("/header")
		public String Header() {
			return "pages/header.html";
		}


	/**
	 * /logoutページ
	 * */

}