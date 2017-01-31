package br.com.alexandreafonso.template.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.alexandreafonso.template.security.JpaUserDetailsService;

@EnableWebSecurity
public class SegurancaUserDetailsConfig extends SegurancaConfigAdapter {
	
	@Autowired
	private JpaUserDetailsService ssUserDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.userDetailsService(ssUserDetailsService)
			.passwordEncoder(passwordEncoder);
	}
}
