//製作中 大平
package com.example.demo.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.display.login.LoginUser;
import com.example.demo.entity.display.login.LoginUserDetailsImpl;

/**
 * UserDetailsServiceの実装クラス
 * Spring Securityでのユーザー認証に使用する
 */
@Service
@Transactional
public class UserService implements UserDetailsService {
	@Autowired
	LoginUserDao loginUserDao;
	
	@Autowired
HttpSession session;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// 認証を行うユーザー情報を格納する
//		try {
		LoginUser loginUser = loginUserDao.findUser(userName);
		System.out.println("LOGINUSER INSTANCE");

//		String KindOfAdmin = null;

		// 入力したユーザーIDから認証を行うユーザー情報を取得する
		// 処理内容は省略
		if (loginUser == null) {
			System.out.println("アカウントがありません");
			session.setAttribute("Error_message", "ログイン失敗");
			
			throw new UsernameNotFoundException("userName" + userName + "was not found in the database");
		}else {
			session.setAttribute("Error_message", null);
		}
		
//		}catch(UsernameNotFoundException e) {
//			System.out.println(e);
//		}
		//adminの名前の付与
//		if (user.getAdmin_flg() == 1) {
//			KindOfAdmin = "ADMIN";
//		} else if (user.getAdmin_flg() == 0) {
//			KindOfAdmin = "USER";
//		}
//
//		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
//		GrantedAuthority authority = new SimpleGrantedAuthority(KindOfAdmin);
//		grantList.add(authority);
//
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		
		loginUser.setPass( encoder.encode(loginUser.getPass()));
//
//		// ユーザー情報が取得できたらSpring Securityで認証できる形で戻す
//		UserDetails userDetails = (UserDetails) new User(user.getUser_name(), encoder.encode(user.getPass()),
//				grantList);

		return new LoginUserDetailsImpl(loginUser);
	}

}
