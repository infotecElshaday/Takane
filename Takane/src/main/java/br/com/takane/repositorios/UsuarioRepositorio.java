package br.com.takane.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.takane.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
