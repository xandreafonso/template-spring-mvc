package br.com.alexandreafonso.template.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alexandreafonso.template.model.Grupo;
import br.com.alexandreafonso.template.model.Usuario;

public interface Grupos extends JpaRepository<Grupo, Long> {
	
	List<Grupo> findByUsuariosIn(Usuario usuario);

}
