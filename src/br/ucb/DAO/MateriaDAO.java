package br.ucb.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucb.entidades.Materia;
import br.ucb.enums.Tipo;


public class MateriaDAO {
	private Connection cf;
	private PreparedStatement stm;
	private String query;
	
	public void salvar(Materia materia){
		query = "INSERT INTO materia(AUTOR, TITULO, EDITORA, TIPO) VALUES (?, ?, ?, ?)";
		cf = ConnectionFactory.getConnection();
		try{
			stm = cf.prepareStatement(query);
			stm.setString(1, materia.getAutor());
			stm.setString(2, materia.getNome());
			stm.setString(3, materia.getEditora());
			//stm.setInt(4, materia.getPagina());
			stm.setString(4, materia.getTipo().name());
			stm.execute();
			stm.close();
			cf.close();
		}catch(SQLException e){
			e.printStackTrace();
		}	
	}
	public List<Materia> listar(){
		
		ArrayList<Materia> materias = new ArrayList<Materia>();
		query = "SELECT * FROM materia";
		cf = ConnectionFactory.getConnection();
		try{
			stm = cf.prepareStatement(query);
			ResultSet rs = stm.executeQuery(query);
			while(rs.next()){
				Materia materia = new Materia();
				Tipo tipo;
				materia.setAutor(rs.getString("autor"));
				materia.setEditora(rs.getString("editora"));
				materia.setNome(rs.getString("titulo"));
				//materia.setPagina(rs.getInt("pagina"));
				materia.setId(rs.getInt("idLivro"));
				tipo = Enum.valueOf(Tipo.class,rs.getString("tipo"));
				materia.setTipo(tipo);
				//tipo = Enum.valueOf(Tipo.class, rs.getString("tipo"));
				//materia.setTipo(tipo);
				materias.add(materia);
			}
			stm.close();
			cf.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return materias;
	}
	public void deletar(int id){
		query = "delete from materia where idLivro=?";
		cf = ConnectionFactory.getConnection();
		try{
			stm = cf.prepareStatement(query);
			stm.setInt(1, id);
			stm.executeQuery();
			stm.close();
			cf.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void update(Materia materia){
		query = "update materia set AUTOR = ?, TITULO = ?, EDITORA = ?, TIPO = ? where id = ?";
		cf = ConnectionFactory.getConnection();
		try{
			stm = cf.prepareStatement(query);
			stm.setString(1, materia.getAutor());
			stm.setString(2, materia.getNome());
			stm.setString(3, materia.getEditora());
			//stm.setInt(4, materia.getPagina());
			stm.setString(5, materia.getTipo().name());
			stm.setInt(6, materia.getId());
			stm.executeQuery();
			stm.close();
			cf.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
}
