package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConexion {

	private static String db_ = "base_de_datos";
	private static String login_ = "root";
	private static String password_ = "Oskitar2301";
	private static String url_ = "jdbc:mysql://localhost:3306/" + db_;
	private static Connection connection_;
	private static Statement st_ = null;

	public static void main(String args[]) {
		
		try {

			//Class.forName("com.mysql.cj.jdbc.Driver");
			connection_ = DriverManager.getConnection(url_, login_, password_);
			if (connection_ != null) {
				st_ = connection_.createStatement();
				System.out.println("Conexion a base de datos " + db_ + " OK.");
			} else
				System.out.println("Conexion fallida . ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}