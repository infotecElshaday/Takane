package br.com.takane.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.takane.modeloDto.ContatoDto;
import br.com.takane.servicos.ContatoServicos;
import br.com.takane.utilidades.ContatoPaginacao;
import br.com.takane.utilidades.TakaneConstante;

@RestController
@RequestMapping("/takane")
public class ContatoController {

	@Autowired
	private ContatoServicos contatoServicos;

	@GetMapping(" ")
	public ContatoPaginacao listarContato(
			@RequestParam(value = "numPag", defaultValue = TakaneConstante.NUMERO_PAGINA_PADRAO, required = false) int numPagina,
			@RequestParam(value = "tamPag", defaultValue = TakaneConstante.TAMANHO_PAGINA_PADRAO, required = false) int tamPagina,
			@RequestParam(value = "sortBy", defaultValue = TakaneConstante.ORDENAÇÃO_PADRAO, required = false) String ordenarPor,
			@RequestParam(value = "sortDir", defaultValue = TakaneConstante.ORDENACAO_DIRETORIO, required = false) String sortDir) {
		return contatoServicos.listarContato(numPagina, tamPagina, ordenarPor, sortDir);
	}

	@PostMapping("/salvar")
	public ResponseEntity<ContatoDto> salvarContato(@RequestBody ContatoDto contatoDto) {
		return new ResponseEntity<>(contatoServicos.salvarContato(contatoDto), HttpStatus.CREATED);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<ContatoDto> buscarContato(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<>(contatoServicos.buscarContato(id), HttpStatus.OK);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<ContatoDto> editarContato(@PathVariable(name = "id") Long id,
			@RequestBody ContatoDto contatoDto) {
		return new ResponseEntity<>(contatoServicos.editarContato(id, contatoDto), HttpStatus.OK);
	}

	@DeleteMapping("/excluir/{id}")
	public ResponseEntity<String> excluirContato(@PathVariable(name = "id") Long id) {
		contatoServicos.excluirContato(id);
		return new ResponseEntity<>("Contato excluido com sucesso...", HttpStatus.OK);
	}
}
