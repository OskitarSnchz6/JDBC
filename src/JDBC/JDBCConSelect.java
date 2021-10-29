package JDBC;

import java.sql.*;

public class JDBCConSelect {
	public static void main(String args[]) {
		try {

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_de_datos", "root", "Oskitar2301");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from empleados");
			while (rs.next())
				System.out
						.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
			con.close();
	} catch (SQLException e) {
			System.out.println(e);
		}
	}
}