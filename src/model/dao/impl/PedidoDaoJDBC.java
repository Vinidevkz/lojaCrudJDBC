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
import model.dao.PedidoDao;
import model.entities.Cliente;
import model.entities.Pedidos;

public class PedidoDaoJDBC implements PedidoDao {
	
	private Connection conn;

	@Override
	public void insert(Pedidos pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Pedidos pedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByID(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedidos findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			ps = conn.prepareStatement("SELECT * FROM produtos WHERE id = ?");
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Pedidos pedido = new Pedidos(); 
				pedido.setId(rs.getInt("id"));
				pedido.setIdCLiente(rs.getInt("idCliente"));
				pedido.setIdProduto(rs.getInt("idProduto"));
				
				return pedido;
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
	public List<Pedidos> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
