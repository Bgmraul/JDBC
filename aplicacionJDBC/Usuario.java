package aplicacionJDBC;

import java.sql.*;
import java.util.ArrayList;

public class Usuario {
	int id;
	String nombre, apellidos, email, contrasena;

	public Usuario(int id, String nombre, String apellidos, String email, String contrasena) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.contrasena = contrasena;
	}

	public static void borrar(Integer id) {
		String query = ("DELETE FROM usuario WHERE id_usuario = " + id.toString());

		PreparedStatement consulta;
		try {
			consulta = ConexionBD.getInstance().prepareStatement(query);
			consulta.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Usuario[] listar() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		String query = ("SELECT id_usuario,nombre,apellidos,email,pass from usuario");

		Statement consulta;
		try {
			consulta = ConexionBD.getInstance().createStatement();

			ResultSet rs = consulta.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id_usuario");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				String email = rs.getString("email");
				String contraseña = rs.getString("pass");

				usuarios.add(new Usuario(id, nombre, apellidos, email, contraseña));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios.toArray(new Usuario[0]);
	}

	public static void insertar(String nombre, String apellidos, String email, String contrasena) {
		String query = ("INSERT into usuario (nombre, apellidos, email, pass)" + " values (?, ?, ?, ?)");

		PreparedStatement consulta;
		try {
			consulta = ConexionBD.getInstance().prepareStatement(query);

			consulta.setString(1, nombre);
			consulta.setString(2, apellidos);
			consulta.setString(3, email);
			consulta.setString(4, contrasena);

			consulta.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void actualizarBD() {
		String query = ("UPDATE usuario SET nombre=?, apellidos=?, email=?, pass=? Where id_usuario =" + this.id);
		PreparedStatement consulta;

		try {
			consulta = ConexionBD.getInstance().prepareStatement(query);

			consulta.setString(1, this.nombre);
			consulta.setString(2, this.apellidos);
			consulta.setString(3, this.email);
			consulta.setString(4, this.contrasena);

			consulta.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public int getId() {
		return this.id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}
