package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class JDBC_insert {

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

      int nFil = s.executeUpdate("INSERT INTO EMPLEADOS (id, nombre, apellido, puesto) VALUES "
              + "('8', 'Rodrigo', 'Garcia','Seguridad'),"
              + "('9', 'Enrique', 'Rodriguez', null),"
              + "('10', 'Paco', 'Andujar','Informatico'),"
              + "('11','Sergio', 'Perez', 'Informatico');");

      System.out.println(nFil + " Filas insertadas.");

    } catch (SQLException e) {
      muestraErrorSQL(e);
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }

}