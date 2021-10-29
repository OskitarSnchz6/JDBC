package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class JDBC_prepared_statement {

  public static void muestraErrorSQL(SQLException e) {
    System.err.println("SQL ERROR mensaje: " + e.getMessage());
    System.err.println("SQL Estado: " + e.getSQLState());
    System.err.println("SQL código especifico: " + e.getErrorCode());
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
            PreparedStatement sInsert = c.prepareStatement("INSERT INTO EMPLEADOS(id, nombre, apellido, puesto) VALUES (?,?,?,?);")) {

    	 int i=1;
    	 
    	sInsert.setInt(i++, 5);
      sInsert.setString(2, "Oscar");
      sInsert.setString(3, "Garcia");
      sInsert.setString(4, "Limpieza");

      sInsert.executeUpdate();

       i=1;
      sInsert.setInt(i++, 6);
      sInsert.setString(i++, "David");
      sInsert.setString(i++, "Rodriguez");
      sInsert.setNull(i++, Types.INTEGER);

      sInsert.executeUpdate();
      
      i=1;
      sInsert.setInt(i++, 7);
      sInsert.setString(i++, "Pedro");
      sInsert.setString(i++, "Andujar");
      sInsert.setString(i++, "Limpieza");

      sInsert.executeUpdate();

    } catch (SQLException e) {
      muestraErrorSQL(e);
    } catch (Exception e) {
      e.printStackTrace(System.err);
    }
  }
}