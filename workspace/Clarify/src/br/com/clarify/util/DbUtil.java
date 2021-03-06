package br.com.clarify.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {

	private static Connection connection;

	private DbUtil() {

	}

	public static Connection getConnection() {

		if (connection != null)
			return connection;

		else {
			try {
				Properties prop = new Properties();
				InputStream imputStream = DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
				prop.load(imputStream);

				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String usuario = prop.getProperty("usuario");
				String senha = prop.getProperty("senha");

				Class.forName(driver);
				connection = DriverManager.getConnection(url, usuario, senha);

			} catch (IOException e) {
				System.out.println("Arquivo properties n�o localizado \n" + e.getMessage());
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Driver n�o localizado \n" + e.getMessage());
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("Erro na conex�o \n" + e.getMessage());
				e.printStackTrace();
			}
		}

		return connection;
	}

}
