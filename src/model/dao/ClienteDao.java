package model.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import model.entities.Cliente;

public interface ClienteDao {
	void insert(Cliente cliente);
	void update(Cliente cliente);
	void deleteByID(Integer id);
	Cliente findById(Integer id) throws FileNotFoundException, IOException;
	List<Cliente> findAll();
}
