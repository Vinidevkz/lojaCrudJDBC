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
import model.dao.ClienteDao;
import model.entities.Cliente;

public class ClienteDaoJDBC implements ClienteDao {
	
	private Connection conn;
	
	public ClienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByID(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente findById(Integer id) throws FileNotFoundException, IOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("SELECT * FROM produtos WHERE id = ?");
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Cliente cliente = new Cliente(); 
				cliente.setId(rs.getInt("id"));
				cliente.setName(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				
			}
			return null;
			
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		

	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
