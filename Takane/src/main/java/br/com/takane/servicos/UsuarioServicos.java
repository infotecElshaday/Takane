package br.com.takane.servicos;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.takane.exceptions.RecursoNotFoundException;
import br.com.takane.model.Usuario;
import br.com.takane.modelDTO.UsuarioDTO;
import br.com.takane.repositorios.UsuarioRepositorio;

@Service
@Transactional
public class UsuarioServicos {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	private ModelMapper modelMapper;

	public List<UsuarioDTO> listar() {
		List<Usuario> usuarios = usuarioRepositorio.findAll();
		List<UsuarioDTO> usuariosDTO = usuarios.stream().map(usuario -> modelMapper.map(usuario, UsuarioDTO.class))
				.collect(Collectors.toList());
		return usuariosDTO;
	}

	public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
		Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
		Usuario salvar = usuarioRepositorio.save(usuario);
		return modelMapper.map(salvar, UsuarioDTO.class);
	}

	public UsuarioDTO editar(Long id, UsuarioDTO usuarioDTO) {
		Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new RecursoNotFoundException("Usuário", "id", id));
		usuario.setNome(usuarioDTO.getNome());
		usuario.setCidade(usuarioDTO.getCidade());
		usuario.setEmail(usuarioDTO.getEmail());
		usuario.setTelefone(usuarioDTO.getTelefone());
		Usuario editar = usuarioRepositorio.save(usuario);
		return modelMapper.map(editar, UsuarioDTO.class);
	}

	public UsuarioDTO buscar(Long id) {
		Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new RecursoNotFoundException("Usuário", "id", id));
		return modelMapper.map(usuario, UsuarioDTO.class);
	}

	public String excluir(Long id) {
		Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new RecursoNotFoundException("Usuário", "id", id));
		usuarioRepositorio.delete(usuario);
		return "Usuário " + usuario.getNome() + " excluido com sucesso.";
	}
}
