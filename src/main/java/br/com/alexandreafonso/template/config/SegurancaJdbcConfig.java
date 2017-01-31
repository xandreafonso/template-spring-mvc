package br.com.alexandreafonso.template.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@EnableWebSecurity
public class SegurancaJdbcConfig extends SegurancaConfigAdapter {
	
	public static final String USUARIO_POR_LOGIN = "SELECT login, senha, ativo, nome FROM Usuario"
			+ " WHERE login = ?";
	
	public static final String PERMISSOES_POR_USUARIO = "SELECT u.login, p.nome FROM usuario_permissao up"
			+ " JOIN usuario u ON u.id = up.usuarios_id"
			+ " JOIN permissao p ON p.id = up.permissoes_id"
			+ " WHERE u.login = ?";
	
	public static final String PERMISSOES_POR_GRUPO = "SELECT g.id, g.nome, p.nome FROM grupo_permissao gp"
			+ " JOIN grupo g ON g.id = gp.grupos_id"
			+ " JOIN permissao p ON p.id = gp.permissoes_id"
			+ " JOIN usuario_grupo ug ON ug.grupos_id = g.id"
			+ " JOIN usuario u ON u.id = ug.usuarios_id"
			+ " WHERE u.login = ?";
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder)
			.usersByUsernameQuery(USUARIO_POR_LOGIN)
			.authoritiesByUsernameQuery(PERMISSOES_POR_USUARIO)
			.groupAuthoritiesByUsername(PERMISSOES_POR_GRUPO)
			.rolePrefix("ROLE_");
	}
}
