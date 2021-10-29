package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdate {
	  public static void muestraErrorSQL(SQLException e) {
		    System.err.println("SQL ERROR mensaje: " + e.getMessage());
		    System.err.println("SQL Estado: " + e.getSQLState());
		    System.err.println("SQL codigo especifico: " + e.getErrorCode());
		  }

		  public static void main(String[] args) {

		    String basedatos = "base_de_datos";
		    String host = "localhost";
		    String port = "3306";
		    String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		    String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
		    String user = "root";
		    String pwd = "Oskitar2301";

		    try (
		            Connection c = DriverManager.getConnection(urlConnection, user, pwd);
		            Statement s = c.createStatement()) {

		      int nFil = s.executeUpdate("UPDATE empleados SET puesto='Programador' WHERE puesto = 'Informatico'");

		      System.out.println(nFil + " Empleado actualizado .");

		    } catch (SQLException e) {
		      muestraErrorSQL(e);
		    } catch (Exception e) {
		      e.printStackTrace(System.err);
		 }
	}

}