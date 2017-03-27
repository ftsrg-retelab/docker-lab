package hu.bme.mit.dockerlab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlClientMain {

	private static final String USER = "root";
	private static final String PASSWORD = "retelab";

	public static void main(String[] args) throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/golf?allowMultiQueries=true&useSSL=false";

		try (final Connection connection = DriverManager.getConnection(url, USER, PASSWORD)) {
			try (final Statement statement = connection.prepareStatement("SELECT * FROM golf LIMIT 10")) {
				try (ResultSet rs = statement.executeQuery(url)) {
					while (rs.next()) {
						System.out.println(rs);
					}
				}
			}
		}

	}

}
