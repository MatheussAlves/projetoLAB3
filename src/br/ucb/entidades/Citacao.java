package br.ucb.entidades;

public class Citacao {
	private Integer id_usuario;
	private Integer id_materia;
	private String data;
	private String texto;
	private Integer id;
	private int pagina;
	
	
	
	
	public int getPagina() {
		return pagina;
	}
	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	public Integer getId_materia() {
		return id_materia;
	}
	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
	
	
	
	
	
}	
