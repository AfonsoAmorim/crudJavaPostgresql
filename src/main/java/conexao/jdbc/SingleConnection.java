package conexao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String banco = "jdbc:postgresql://localhost:5432/posjava";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;

	public SingleConnection() {
		conectar();
	}

	static {
		conectar();
	}

	public static void conectar() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
				System.out.println("Rodou");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Não rodou");
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
