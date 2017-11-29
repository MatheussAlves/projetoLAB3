package br.ucb.entidades;

public class Comentario {
	private Integer id_usuario;
	private Integer id_citaçao;
	private String comentario;
	private Integer id;
	
	
	
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
	public Integer getId_citaçao() {
		return id_citaçao;
	}
	public void setId_citaçao(Integer id_citaçao) {
		this.id_citaçao = id_citaçao;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
	
}
