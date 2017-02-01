package br.com.alexandreafonso.template.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public abstract class SegurancaConfigAdapter extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/webjars/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/desenvolvedor").hasRole("VISUALIZAR_PAG_DESENVOLVEDOR")
				.antMatchers("/gerente").hasRole("VISUALIZAR_PAG_GERENTE")
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login").permitAll()
			.and()
			.logout()
			.and()
			.rememberMe();
	}
}