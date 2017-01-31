package br.com.alexandreafonso.template.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

//@EnableWebSecurity
public class SegurancaEmMemoriaConfig extends SegurancaConfigAdapter {
	
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.inMemoryAuthentication()
			.withUser("alexandre").password("123")
				.roles("VISUALIZAR_PAG_DESENVOLVEDOR")
			.and()
			.withUser("afonso").password("123")
				.roles("VISUALIZAR_PAG_GERENTE", "VISUALIZAR_PAG_DESENVOLVEDOR");
	}
}