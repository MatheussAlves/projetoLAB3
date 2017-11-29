package br.ucb.enums;

public enum Tipo {
	LIVRO("Livro"),ARTIGO("Artigo");
	private String tipoLivro;
	

	Tipo(String tipo){
		setTipoLivro(tipo);
	}
	
	public String getTipoLivro() {
		return tipoLivro;
	}



	public void setTipoLivro(String tipoLivro) {
		this.tipoLivro = tipoLivro;
	}



}
