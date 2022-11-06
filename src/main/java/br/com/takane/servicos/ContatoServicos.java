package br.com.takane.servicos;

import br.com.takane.modeloDto.ContatoDto;
import br.com.takane.utilidades.ContatoPaginacao;

public interface ContatoServicos {

	public ContatoPaginacao listarContato(int numPagina, int tamPagina, String ordenarPor, String sortDir);

	public ContatoDto salvarContato(ContatoDto contatoDto);

	public ContatoDto editarContato(Long id, ContatoDto contatoDto);

	public ContatoDto buscarContato(Long id);

	public void excluirContato(Long id);
}
