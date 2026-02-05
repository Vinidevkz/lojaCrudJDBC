package model.dao.impl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.CategoriaDao;
import model.entities.Categoria;
import model.entities.Cliente;

public class CategoriaDaoJDBC implements CategoriaDao {
	
	private Connection conn;

	@Override
	public void insert(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByID(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("SELECT * FROM produtos WHERE id = ?");
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Categoria categoria = new Categoria(); 
				categoria.setId(rs.getInt("id"));
				categoria.setCategoria(rs.getString("nome"));

				return categoria;
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
	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
