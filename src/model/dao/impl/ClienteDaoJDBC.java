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
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("INSERT INTO clientes (id, nome, email) VALUES (?, ?, ?)");
			
			ps.setInt(1, cliente.getId());
			ps.setString(2, cliente.getName());
			ps.setString(3, cliente.getEmail());
			
			ps.executeUpdate();
			
			System.out.println("Cliente cadastrado com sucesso.");
			
		}catch (SQLException e) {
			e.getStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
		
	}

	@Override
	//Update name:
	public void update(Cliente cliente) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("UPDTE clientes SET nome = ? WHERE id = ?");
			
			ps.setString(1, cliente.getName());
			ps.setInt(2, cliente.getId());
			
			rs = ps.executeQuery();
			
			System.out.println("Usuario atualizado com sucesso.Linhas afetadas: " + rs);

		}catch (SQLException e) {
			e.getStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteByID(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("DELETE FROM clientes WHERE id = ?");
			
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			System.out.println("Usuario deletado com sucesso. Linhas afetadas: " + rs);
			
		}catch (SQLException e) {
			e.getStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Cliente findById(Integer id) throws FileNotFoundException, IOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("SELECT * FROM clientes WHERE id = ?");
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Cliente cliente = new Cliente(); 
				cliente.setId(rs.getInt("id"));
				cliente.setName(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				
				return cliente;
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
