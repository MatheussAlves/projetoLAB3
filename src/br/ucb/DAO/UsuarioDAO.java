package br.ucb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucb.entidades.Usuario;



public class UsuarioDAO {
	private Connection cf;
	private PreparedStatement stm;
	private String query;
	
	public void salvar(Usuario usuario) {
		query = "INSERT INTO usuario(LOGIN, EMAIL, SENHA) VALUES (?, ?, ?)";
		cf = ConnectionFactory.getConnection();
		try {
			stm = cf.prepareStatement(query);
			stm.setString(1, usuario.getLogin());
			stm.setString(2, usuario.getEmail());
			stm.setString(3, usuario.getSenha());
			stm.execute();
			stm.close();
			cf.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Usuario> listar(){
		ArrayList<Usuario> users = new ArrayList<Usuario>();
		query = "SELECT * FROM usuario";
		cf = ConnectionFactory.getConnection();
		try{
			stm = cf.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setEmail(rs.getString("email"));
				usuario.setLogin(rs.getString("login"));
				usuario.setId(rs.getInt("idUsuario"));
				usuario.setSenha(rs.getString("senha"));
				users.add(usuario);
			}
			stm.close();
			cf.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public Usuario buscar(String login){
		Usuario usuario = new Usuario();
		query = "Select * from usuario where login = '"+login+"'";
		cf = ConnectionFactory.getConnection();
		try{
			stm = cf.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			
			usuario.setEmail(rs.getString("email"));
			usuario.setLogin(rs.getString("login"));
			usuario.setSenha(rs.getString("senha"));
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return usuario;
	}
	public Usuario logaUsuario(String login, String senha){
		cf = ConnectionFactory.getConnection();
		query = "select idUsuario, email from usuario where login=? and senha=?";
		try{
			stm = cf.prepareStatement(query);
			stm.setString(1,login);
			stm.setString(2,senha);
			
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("idUsuario"));
				usuario.setLogin(login);
				usuario.setSenha(senha);
				usuario.setEmail(rs.getString("email"));
				
				return usuario;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	public boolean verificaUsuario(String login, String email){
		cf = ConnectionFactory.getConnection();
		int flag=0;
		query = "select idUsuario, email from usuario where login=? or email=?";
		try{
			stm = cf.prepareStatement(query);
			stm.setString(1,login);
			stm.setString(2,email);
			ResultSet rs = stm.executeQuery();
			if(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("idUsuario"));
				usuario.setLogin(login);
				//usuario.setSenha(senha);
				usuario.setEmail(rs.getString("email"));
				flag =1;
			}else{
				 flag=0;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		if(flag==1){
			return true;
		}else{
			return false;
		}
		
	}
}

