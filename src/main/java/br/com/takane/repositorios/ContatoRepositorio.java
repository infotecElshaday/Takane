package br.com.takane.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.takane.entidades.Contato;

@Repository
public interface ContatoRepositorio extends JpaRepository<Contato, Long>{

	public Contato findByNome(String nome);
}
