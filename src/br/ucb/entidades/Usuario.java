package br.ucb.entidades;

public class Usuario {
	private String login;
	private String senha;
	private String email;
	private boolean isLogado;
	private int id;
	
	
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Usuario(){
		
	}
	
	
	
	public boolean isLogado() {
		return isLogado;
	}
	public void setLogado(boolean isLogado) {
		this.isLogado = isLogado;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
