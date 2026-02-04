package model.dao;

import java.util.List;

import model.entities.Pedidos;

public interface PedidoDao {
	void insert(Pedidos pedido);
	void update(Pedidos pedido);
	void deleteByID(Integer id);
	Pedidos findById(Integer id);
	List<Pedidos> findAll();
}
