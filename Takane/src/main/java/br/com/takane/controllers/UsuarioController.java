package br.com.takane.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.takane.modelDTO.UsuarioDTO;
import br.com.takane.servicos.UsuarioServicos;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioServicos usuarioServicos;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> listar() {
		List<UsuarioDTO> usuarios = usuarioServicos.listar();
		return new ResponseEntity<List<UsuarioDTO>>(usuarios, HttpStatus.FOUND);
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ResponseEntity<UsuarioDTO> salvar(@Valid @RequestBody UsuarioDTO usuarioDTO) {
		UsuarioDTO salvar = usuarioServicos.salvar(usuarioDTO);
		return new ResponseEntity<UsuarioDTO>(salvar, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioDTO> buscar(@PathVariable(value = "id") Long id) {
		UsuarioDTO buscar = usuarioServicos.buscar(id);
		return new ResponseEntity<UsuarioDTO>(buscar, HttpStatus.OK);
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UsuarioDTO> editar(@PathVariable(value = "id") Long id, @RequestBody UsuarioDTO usuarioDTO) {
		UsuarioDTO editar = usuarioServicos.editar(id, usuarioDTO);
		return new ResponseEntity<UsuarioDTO>(editar, HttpStatus.OK);
	}

	@RequestMapping(value = "/excluir/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> excluir(@PathVariable(value = "id") Long id) {
		String status = usuarioServicos.excluir(id);
		return new ResponseEntity<String>(status, HttpStatus.OK);
	}

}
