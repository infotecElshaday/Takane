package br.com.takane.exceptions;

public class TakaneException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TakaneException() {

	}

	public TakaneException(String message) {
		super(message);
	}

}
