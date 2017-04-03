package hu.bme.mit.dockerlab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlClientMain {

	private static final String USER = "root";
	private static final String PASSWORD = "retelab";
	private static final String HOSTNAME = "127.0.0.1"; // TODO set this hostname
	private static final int PORT = 3306;

	public static void main(String[] args) throws SQLException {
		final String url = String.format(
			"jdbc:mysql://%s:%d/golf?useSSL=false",
			HOSTNAME,
			PORT
		);

		try (final Connection connection = DriverManager.getConnection(url, USER, PASSWORD)) {
			try (final Statement statement = connection.createStatement()) {
				try (ResultSet rs = statement.executeQuery("SELECT * FROM golf")) {
					while (rs.next()) {
						System.out.println(rs.getString(1));
					}
				}
			}
		}

	}

}
