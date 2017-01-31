package br.com.alexandreafonso.template.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alexandreafonso.template.model.Grupo;
import br.com.alexandreafonso.template.model.Permissao;

public interface Permissoes extends JpaRepository<Permissao, Long> {
	
	List<Permissao> findByGruposIn(Grupo grupo);

}
