package br.com.takane.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String recurso;
	private String campo;
	private long valor;

	public RecursoNotFoundException(String recurso, String campo, long valor) {
		super(String.format("%s não encontrado com o id: %s", recurso, campo, valor));
		this.recurso = recurso;
		this.campo = campo;
		this.valor = valor;
	}

	public String getRecurso() {
		return recurso;
	}

	public void setRecurso(String recurso) {
		this.recurso = recurso;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

}
