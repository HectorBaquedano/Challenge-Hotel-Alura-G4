package jdbc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.factory.ConnectionFactory;

public class Usuarios {
	private String nombre;
	private String contraseña;
	
	public Usuarios(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}	
	
	public static boolean validarUsuarios(String nombre, String contraseña) {
		ConnectionFactory con = new ConnectionFactory();
		Connection connect = con.recuperaConexion();
		try {
			final PreparedStatement statement = connect.prepareStatement("SELECT * FROM usuarios WHERE nombre=? AND contraseña=?");
			try(statement){
				statement.setString(1, nombre);
				statement.setString(2, contraseña);
				
				statement.execute();
				
				final ResultSet resultSet = statement.executeQuery();
				return resultSet.next();
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
