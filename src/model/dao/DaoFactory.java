package model.dao;

import model.dao.impl.CategoriaDaoJDBC;
import model.dao.impl.ClienteDaoJDBC;
import model.dao.impl.PedidoDaoJDBC;
import model.dao.impl.ProdutoDaoJDBC;

public class DaoFactory {
	public static ClienteDao createClienteDao() {
		return new ClienteDaoJDBC(null);
	}
	
	public static ProdutoDao createProdutoDao() {
		return new ProdutoDaoJDBC();
	}
	
	public static PedidoDao createPedidoDao() {
		return new PedidoDaoJDBC();
	}
	
	public static CategoriaDao createCategoriaDao() {
		return new CategoriaDaoJDBC();
	}
}
