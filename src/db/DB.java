package db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	private static Connection conn = null;
	
	//método para realizar a conexão com o banco
	public static Connection getConnection() throws FileNotFoundException, IOException, SQLException {
		if(conn == null) {
			try {
				//pegando a config
				Properties props = loadProperties();
				//pegando a url do banco (localhost):
				String url = props.getProperty("dburl");
				//realizando a conexão:
				conn = DriverManager.getConnection(url, props);
			}catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		System.out.println("-> conexão com o banco de dados feita com sucesso.");
		return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			}catch (SQLException e) {
				throw new DbException(e.getMessage());
			}

		}
	}
	
	//método para pegar a config do banco:
	private static Properties loadProperties() throws FileNotFoundException, IOException {
		//abre o arquivo
		try(FileInputStream fs = new FileInputStream("db.properties")){
			//cria um novo objeto do tipo propriedades
			Properties props = new Properties();
			//atribuido os dados ao objeto
			props.load(fs);
			//retorna os dados:
			return props;
		}catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
}
