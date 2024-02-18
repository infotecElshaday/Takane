package br.com.takane.response;

public class TakaneResponse {

	private String mensagem;
	private boolean status;

	public TakaneResponse(String mensagem, boolean status) {
		this.mensagem = mensagem;
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
