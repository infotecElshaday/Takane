package br.com.takane.enumers;

public enum TipoContato {
	
	
	COBRANCA("Cobrança"),
	ENTREGA("Entrega");
	
	private String descricao;
	
	
	private TipoContato(String descricao) {
	  this.descricao = descricao;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}

}
