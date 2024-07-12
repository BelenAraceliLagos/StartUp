package cl.praxis.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection con = null;

	private Conexion() {

		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/startup", "postgres", "isidora");

			boolean isValid = con.isValid(50000);

			System.out.println(isValid ? "Test ok Postgres" : "Test failed Postgres");
		} catch (ClassNotFoundException | SQLException ex) {
			System.out.println("Error al conectar con la BD: " + ex.getMessage());
		}

	}

	public static Connection getCon() {
		if (con == null) {
			new Conexion();
		}
		return con;
	}


}
