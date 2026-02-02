package model.dao;

import model.dao.impl.ClienteDaoJDBC;
import model.dao.impl.ProdutoDaoJDBC;

public class DaoFactory {
	public static ClienteDao createClienteDao() {
		return new ClienteDaoJDBC();
	}
	
	public static ProdutoDao createProdutoDao() {
		return new ProdutoDaoJDBC();
	}
}
