
//製作途中 大平
package com.example.demo.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.UserService;

//@Profile("production") // これ
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		return bcpe;
	}

	//WebSecurityの設定
	@Override
	public void configure(WebSecurity web) throws Exception {
		// spring securityで無視するリクエストパスを設定 / **より下の階層は自由にアクセス可能
		web.ignoring().antMatchers("/css/**", "/images/**", "/js/**", "/scss/**");
	}

	//HttpSecurityの設定
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/index").permitAll() // 認証なしでアクセス可能なパス
				//.antMatchers("/css/**", "/images/**", "/js/**", "/scss/**").permitAll() // 
				//.antMatchers("/admin/**").hasRole("ADMIN")// admin権限を持ったアカウントのみがアクセス可能(階層はまだ無し)
				.anyRequest().authenticated()//それ以外は認証が必要
				.and()
				.formLogin()
				.loginPage("/pages/login") // ログインのビュー
				.loginProcessingUrl("/mypage") //AuthenticationConfigurationが暗黙のうちに呼ばれて認証処理が実行される
				.usernameParameter("username")
				.passwordParameter("pass")
				.defaultSuccessUrl("/mypage")//何も入力がない場合のみ/mypageに飛ぶ//リダイレクトできる
//				.successForwardUrl("/mypage")//ログイン後必ず/mypageに飛ぶ//リダイレクトしようとするとフォーム再送信になりエラーが出る
				.failureUrl("/pages/login?error")
				.permitAll()
				.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/pages/login?logout")
				.permitAll()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

	//AuthenticationManagerBuildeの設定(AuthenticationConfigurationのメソッドのオーバーライド？)
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 認証するユーザーをauthに設定する
		auth.userDetailsService(userService)
				// 入力値をbcryptでハッシュ化した値でパスワード認証を行う
				.passwordEncoder(passwordEncoder());
	}
}