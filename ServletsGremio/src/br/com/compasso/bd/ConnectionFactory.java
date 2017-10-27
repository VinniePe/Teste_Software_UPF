package br.com.compasso.bd;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory implements Serializable {
	
	private static Connection connection;
	private static String ipDb = "localhost";
	private static String portDb = "5432";
	private static String db = "GremioEcommerce";
	private static String user = "postgres";
	private static String password = "masterkey";
	private static String stringConnection;
	
	private ConnectionFactory(){
		
	}
	
	public static Connection getConnection() throws SQLException{
		if (connection == null){
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			stringConnection = 
					String.format(
							"jdbc:postgresql://%s:%s/%s",
							ipDb, portDb, db);
			connection = DriverManager.getConnection(
					stringConnection,
					user,
					password);
		}
		return connection;
	}
}
