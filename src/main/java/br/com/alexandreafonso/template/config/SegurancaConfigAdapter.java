package br.com.alexandreafonso.template.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public abstract class SegurancaConfigAdapter extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/resources/**", "/webjars/**").permitAll()
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