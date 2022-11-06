package br.com.takane.utilidades;

import java.util.List;

import br.com.takane.modeloDto.ContatoDto;

public class ContatoPaginacao {

	private List<ContatoDto> conteudoLista;
	private int numeroPagina;
	private int tamanhoPagina;
	private long totalElementos;
	private int totalPaginas;
	private boolean ultimaPagina;

	public ContatoPaginacao() {

	}

	public List<ContatoDto> getConteudoLista() {
		return conteudoLista;
	}

	public void setConteudoLista(List<ContatoDto> conteudoLista) {
		this.conteudoLista = conteudoLista;
	}

	public int getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	public int getTamanhoPagina() {
		return tamanhoPagina;
	}

	public void setTamanhoPagina(int tamanhoPagina) {
		this.tamanhoPagina = tamanhoPagina;
	}

	public long getTotalElementos() {
		return totalElementos;
	}

	public void setTotalElementos(long totalElementos) {
		this.totalElementos = totalElementos;
	}

	public int getTotalPaginas() {
		return totalPaginas;
	}

	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}

	public boolean isUltimaPagina() {
		return ultimaPagina;
	}

	public void setUltimaPagina(boolean ultimaPagina) {
		this.ultimaPagina = ultimaPagina;
	}

}
