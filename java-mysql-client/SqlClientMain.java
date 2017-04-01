import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlClientMain {

	private static final String USER = "root";
	private static final String PASSWORD = "retelab";

	public static void main(String[] args) throws SQLException, ClassNotFoundException  {
		final String url = "jdbc:mysql://hostname:3306/golf?useSSL=false";

		Class.forName("com.mysql.jdbc.Driver");

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
