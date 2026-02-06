package model.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ProdutoDao;
import model.entities.Categoria;
import model.entities.Produto;

public class ProdutoDaoJDBC implements ProdutoDao {
	
	private Connection conn;

	@Override
	public void insert(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Produto produto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByID(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("SELECT * FROM produtos WHERE id = ?");
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Produto produto = new Produto(); 
				produto.setId(rs.getInt("id"));
				produto.setName(rs.getString("nome"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setIdCategoria(rs.getInt("idCategoria"));
				
				return produto;
			}
			return null;
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Produto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> findByCategory(Categoria categoria) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("SELECT p.* FROM produtos p JOIN categorias c ON p.idCategoria = c.id WHERE p.idCategoria = ?");
			
			ps.setInt(1, categoria.getId());
			
			rs = ps.executeQuery();
			
			List<Produto> listaProdutos = new ArrayList<>();
			
			while(rs.next()) {
				Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getDouble("preco"), rs.getInt("idCategoria"));
				listaProdutos.add(produto);
			}
			
			System.out.println(listaProdutos);
			
		}catch (SQLException e) {
			e.getStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
