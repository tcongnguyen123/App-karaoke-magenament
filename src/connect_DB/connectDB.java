package connect_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
	public static Connection con;
	private static connectDB instance = new connectDB();
	public static connectDB getInstance() {
		return instance;
	}
	public void connect() throws SQLException {
		String url = "jdbc:sqlserver://localhost:1433;databasename=QLKaraoke";
		String user = "sa";
		String pass = "0973129264a";
		con = DriverManager.getConnection(url, user, pass);
	}
	
	public void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() {
		return con;
	}
}
