package br.com.techcurso.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

	public static Connection getConnection() {
	
			try {
				return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
			} catch(SQLException e){
				throw new RuntimeException(e);
			}

	}

}
