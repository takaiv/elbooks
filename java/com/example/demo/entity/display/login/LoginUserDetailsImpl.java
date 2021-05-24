//製作途中 大平

package com.example.demo.entity.display.login;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

//UserDetailsインターフェイスを実装
@Data
public class LoginUserDetailsImpl implements UserDetails {
	/**
	 * フィールドの宣言
	*/
	//LoginUserクラスを格納するフィールドを宣言
	private LoginUser loginUser;

	//権限を格納するフィールドを宣言
	private Collection<GrantedAuthority> authorities;
	/**
	 * /フィールドの宣言
	*/
	
	/**
	 * コンストラクタ
	 * ①loginUserの格納
	 * ②権限(Authority)の付与(Granted)処理(admin_flgをDBに0か1で格納しているため)
	*/
	public LoginUserDetailsImpl(LoginUser loginUser) {
		//①loginUserの格納
		this.loginUser = loginUser;
		//	/①loginUserの格納

		//②権限の付与処理
		//ローカル変数の宣言と初期化
		String role = null;
		//権限の
		if (loginUser.getAdmin_flg() == 1) {
			role = "ADMIN";
		} else if (loginUser.getAdmin_flg() == 0) {
			role = "USER";
		}
		this.authorities = new ArrayList<>();
		this.authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
	}
	/**
	 * /コンストラクタ
	*/

	/**
	 * getter/setterのオーバーライド
	*/

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return loginUser.getPass();
	}

	@Override
	public String getUsername() {
		return loginUser.getUser_name();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {

		if (loginUser.getIsdeleted() == 1) {
			return false;
		}
		return true;
	}
	/**
	 * /getter/setterのオーバーライド
	*/
}
