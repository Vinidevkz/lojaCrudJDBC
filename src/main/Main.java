package main;

import java.io.FileNotFoundException;
import java.io.IOException;

import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;
import model.entities.Cliente;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//pegando produto por id:
		ProdutoDao produtoDao = DaoFactory.createProdutoDao();
		Produto produto = produtoDao.findById(2);
		
		System.out.println(produto);
		
		//criando novo cliente:
		ClienteDao clienteDao = DaoFactory.createClienteDao();
		
		Cliente cliente = new Cliente(2, "Jonas", "jonas@gmail.com");
		clienteDao.insert(cliente);
		
		//pegando cliente pelo id:
		Cliente cliente1 = clienteDao.findById(2);
		System.out.println(cliente1);
		
	}

}
