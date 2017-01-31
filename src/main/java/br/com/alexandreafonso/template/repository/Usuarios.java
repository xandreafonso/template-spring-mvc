package br.com.alexandreafonso.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alexandreafonso.template.model.Usuario;

public interface Usuarios extends JpaRepository<Usuario, Long> {

	Usuario findByLogin(String login);
}
