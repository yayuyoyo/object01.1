package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private DataSource dataSource;

	private static final String USER_SQL = "select" + " user_name," + " password," + " true" + " from" + " m_user"
			+ " where" + " user_name = ?";

	private static final String ROLE_SQL = "select" + " user_name," + " role" + " from" + " m_user" + " where"
			+ " user_name = ?";

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/webjars/**", "/css/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// webjars,css,login,signupはアクセス許可。それ以外は直リンク禁止
		http.authorizeRequests().antMatchers("/webjars/**").permitAll().antMatchers("/css/**").permitAll()
				.antMatchers("/h2-console/**").permitAll().antMatchers("/login").permitAll().antMatchers("/signup")
				.permitAll().antMatchers("/admin").hasAuthority("ROLE_ADMIN").anyRequest().authenticated();

		// ログイン処理
		http.formLogin().loginProcessingUrl("/login")// ログインパス
				.loginPage("/login")// ログインページ
				.failureUrl("/login")// ログイン失敗時のパス
				.usernameParameter("userName")// ログインページのユーザーID
				.passwordParameter("password")// ログインページのパスワード
				.defaultSuccessUrl("/home", true);// ログイン成功後の遷移先

		// ログアウト処理
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutUrl("/logout")
				.logoutSuccessUrl("/login");

		// http.csrf().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(USER_SQL)
				.authoritiesByUsernameQuery(ROLE_SQL).passwordEncoder(passwordEncoder());
	}

}
