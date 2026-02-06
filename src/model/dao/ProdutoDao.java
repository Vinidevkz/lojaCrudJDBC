package model.dao;

import java.util.List;

import model.entities.Categoria;
import model.entities.Produto;

public interface ProdutoDao {
	void insert(Produto produto);
	void update(Produto produto);
	void deleteByID(Integer id);
	Produto findById(Integer id);
	List<Produto> findByCategory(Categoria categoria);
	List<Produto> findAll();
}
