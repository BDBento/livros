package br.com.livros.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.livros.dao.util.Conexao;
import br.com.livros.modelo.Livro;


public class LivroDAO {
	
	private Connection connection;
	
	private void conectar() throws SQLException {
		if (connection == null || connection.isClosed()) {
			connection = Conexao.getConexao();
		}
	}

	private void desconectar() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
		}
	}
		
	public Livro inserirLivro(Livro livro) throws SQLException {
		String sql = "INSERT INTO livro (nome, autor, categoria)"
				+ " VALUES (?, ?, ?)";		    
		
		conectar();

		PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, livro.getNome());
		statement.setString(2, livro.getAutor());
		statement.setString(3, livro.getCategoria());
		
		statement.executeUpdate();
		
		ResultSet resultSet = statement.getGeneratedKeys();
		long id = 0;
		if(resultSet.next())
			id = resultSet.getInt("id");
		statement.close();

		desconectar();
		
		livro.setId(id);
		return livro;
	}
	
	public List<Livro> listarTodosLivros() throws SQLException {
		
		String sql = "SELECT * FROM livro";

		conectar();		
		List<Livro> listaLivros = new ArrayList<Livro>();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);			

		while (resultSet.next()) {
			long id = resultSet.getLong("id");//1
			String nome = resultSet.getString("nome");
			String autor = resultSet.getString("autor"); 
			String categoria = resultSet.getString("categoria");
			
			Livro livro = new Livro(nome, autor, categoria);
			livro.setId(id);			
			listaLivros.add(livro);
		}
		resultSet.close();
		statement.close();
		desconectar();
		return listaLivros;
	}
	
	
	public boolean apagarLivro(Livro livro) throws SQLException {
	
		String sql = "DELETE FROM livro WHERE id = ?";
		
		conectar();
        
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, livro.getId());
        
        boolean linhaApagada = statement.executeUpdate() > 0;
        statement.close();
        
        desconectar();
        
        return linhaApagada;
           
        }
	
	
	public Livro buscarLivro(long id) throws SQLException {
	Livro livro = null;
	
	String sql = "SELECT * FROM livro WHERE id = ?";
	
	conectar();
	
	PreparedStatement statement = connection.prepareStatement(sql);
    statement.setLong(1, id);
	
    ResultSet resultSet = statement.executeQuery();
    
    if (resultSet.next()) {
    	
		String nome = resultSet.getString("nome");
		String autor = resultSet.getString("autor");
		String categoria = resultSet.getString("categoria"); 
		
		livro = new Livro(nome, autor, categoria);
		livro.setId(id);		
		
	}
    resultSet.close();
    statement.close();
    
    desconectar();
    
    return livro;
	}
	
	public boolean editarLivro(Livro livro) throws SQLException {
		String sql = "UPDATE livro SET nome = ?, autor = ?, categoria = ?"
				+ " WHERE id = ?";
		
		conectar();
	
		
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, livro.getNome());
		statement.setString(2, livro.getAutor());
		statement.setString(3, livro.getCategoria());
		statement.setLong(4, livro.getId());

		boolean linhaAlterada  = statement.executeUpdate() > 0;
		statement.close();
		desconectar();
		
		return linhaAlterada;
	}
}
	



