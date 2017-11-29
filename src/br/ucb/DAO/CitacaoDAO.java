package br.ucb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucb.entidades.Citacao;
import br.ucb.entidades.Materia;



public class CitacaoDAO {
	private Connection cf;
	private PreparedStatement stm;
	private String query;	
	
	
	public void salvar(Citacao citacao){
		query = "INSERT INTO citacao(TEXTO, DATA, PAGINA, ID_MATERIA, ID_USUARIO) values(?, ?, ?, ?, ?)";
				
		cf = ConnectionFactory.getConnection();
		try{
			stm = cf.prepareStatement(query);
			stm.setString(1,citacao.getTexto());
			stm.setString(2,citacao.getData());
			stm.setInt(3, citacao.getPagina());
			stm.setInt(4,citacao.getId_materia());
			stm.setInt(5,citacao.getId_usuario());
			stm.execute();
			stm.close();
			cf.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public List<Citacao> listar(){
		ArrayList<Citacao> citacoes = new ArrayList<>();
		query = "SELECT * FROM citacao";
		cf = ConnectionFactory.getConnection();
		try{
			stm = cf.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				Citacao citacao = new Citacao();
				citacao.setData(rs.getString("data"));
				citacao.setTexto(rs.getString("texto"));
				citacao.setId(rs.getInt("idCitacao"));
				citacao.setPagina(rs.getInt("pagina"));
				citacao.setId_materia(rs.getInt("id_materia"));
				citacao.setId_usuario(rs.getInt("id_usuario"));
				citacoes.add(citacao);
			}
			stm.close();
			cf.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return citacoes;
	}
	public List<Citacao> listarDoUsuario(int idUsuario){
		ArrayList<Citacao> citacoes = new ArrayList<>();
		query = "SELECT * FROM citacao WHERE id_usuario =? ";
		cf = ConnectionFactory.getConnection();
		try{
			stm.setInt(1,idUsuario);
			stm = cf.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				Citacao citacao = new Citacao();
				citacao.setData(rs.getString("data"));
				citacao.setTexto(rs.getString("texto"));
				citacao.setId(rs.getInt("idCitacao"));
				citacao.setId_materia(rs.getInt("id_materia"));
				citacao.setId_usuario(rs.getInt("id_usuario"));
				citacoes.add(citacao);
			}
			System.out.println("entrou");
			stm.close();
			cf.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return citacoes;
	}
	
	
	
}
