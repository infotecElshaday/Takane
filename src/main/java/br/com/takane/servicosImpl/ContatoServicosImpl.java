package br.com.takane.servicosImpl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.com.takane.entidades.Contato;
import br.com.takane.exception.RecursoTakaneNotException;
import br.com.takane.modeloDto.ContatoDto;
import br.com.takane.repositorios.ContatoRepositorio;
import br.com.takane.servicos.ContatoServicos;
import br.com.takane.utilidades.ContatoPaginacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class ContatoServicosImpl implements ContatoServicos {

	@Autowired
	private ContatoRepositorio ContatoRepositorio;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	@Transactional(readOnly = true)
	public ContatoPaginacao listarContato(int numPagina, int tamPagina, String ordenarPor, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(ordenarPor).ascending()
				: Sort.by(ordenarPor).descending();
		Pageable pageable = PageRequest.of(numPagina, tamPagina, sort);
		Page<Contato> listaContatos = ContatoRepositorio.findAll(pageable);
		List<Contato> contatos = listaContatos.getContent();
		List<ContatoDto> conteudoLista = contatos.stream().map(contato -> mapearContatoDto(contato))
				.collect(Collectors.toList());

		ContatoPaginacao paginacao = new ContatoPaginacao();
		paginacao.setConteudoLista(conteudoLista);
		paginacao.setNumeroPagina(listaContatos.getNumber());
		paginacao.setTamanhoPagina(listaContatos.getSize());
		paginacao.setTotalElementos(listaContatos.getTotalElements());
		paginacao.setTotalPaginas(listaContatos.getTotalPages());
		paginacao.setUltimaPagina(listaContatos.isLast());
		return paginacao;
	}

	@Override
	@Transactional
	public ContatoDto salvarContato(ContatoDto contatoDto) {
		Contato contato = mapearContato(contatoDto);
		Contato novoContato = ContatoRepositorio.save(contato);
		ContatoDto mostraContato = mapearContatoDto(novoContato);
		return mostraContato;
	}

	@Override
	@Transactional
	public ContatoDto editarContato(Long id, ContatoDto contatoDto) {
		Contato contato = ContatoRepositorio.findById(id)
				.orElseThrow(() -> new RecursoTakaneNotException("Contato", "id", id));
		contato.setNome(contatoDto.getNome());
		contato.setEmail(contatoDto.getEmail());
		contato.setCep(contatoDto.getCep());
		contato.setEndereco(contatoDto.getEndereco());
		contato.setNumero(contatoDto.getNumero());
		contato.setComplemento(contatoDto.getComplemento());
		contato.setBairro(contatoDto.getBairro());
		contato.setCidade(contatoDto.getCidade());
		contato.setEstado(contatoDto.getEstado());
		contato.setTelefone(contatoDto.getTelefone());
		contato = ContatoRepositorio.save(contato);
		ContatoDto editado = mapearContatoDto(contato);
		return editado;
	}

	@Override
	@Transactional(readOnly = true)
	public ContatoDto buscarContato(Long id) {
		Contato contato = ContatoRepositorio.findById(id)
				.orElseThrow(() -> new RecursoTakaneNotException("Contato", "id", id));
		return mapearContatoDto(contato);
	}

	@Override
	@Transactional
	public void excluirContato(Long id) {
		Contato contato = ContatoRepositorio.findById(id)
				.orElseThrow(() -> new RecursoTakaneNotException("Contato", "id", id));
       ContatoRepositorio.delete(contato);
	}

	private ContatoDto mapearContatoDto(Contato contato) {
		ContatoDto contatoDto = modelMapper.map(contato, ContatoDto.class);
		return contatoDto;
	}

	private Contato mapearContato(ContatoDto contatoDto) {
		Contato contato = modelMapper.map(contatoDto, Contato.class);
		return contato;
	}

}
