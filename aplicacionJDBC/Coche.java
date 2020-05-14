package aplicacionJDBC;
import java.sql.*;
import java.util.ArrayList;

public class Coche {
	int id_coche, vel_max, aceleracion, peso, control;
	String marca, modelo;

	public Coche( int id_coche,  int vel_max, int aceleracion, int peso,  int control, String marca,  String modelo) {
		this.id_coche = id_coche;
		this.marca = marca;
		this.modelo = modelo;
		this.vel_max = vel_max;
		this.aceleracion = aceleracion;
		this.peso = peso;
		this.control = control;
	}

	public static void borrar(Integer id) {
		String query = ("DELETE FROM coche WHERE id_coche = " + id.toString());

		PreparedStatement consulta;
		try {
			consulta = ConexionBD.getInstance().prepareStatement(query);
			consulta.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Coche[] listar() {
		ArrayList<Coche> coches = new ArrayList<Coche>();

		String query = ("SELECT id_coche,marca,modelo,vel_max, aceler, peso from coche");

		Statement consulta;
		try {
			consulta = ConexionBD.getInstance().createStatement();

			ResultSet rs = consulta.executeQuery(query);

			while (rs.next()) {
				int id_coche = rs.getInt("id_coche");
				int vel_max = rs.getInt("vel_max");
				int aceler = rs.getInt("pass");
				int peso = rs.getInt("peso");
				int control = rs.getInt("control");
				String marca = rs.getString("marca");
				String modelo = rs.getString("modelo");

				coches.add(new Coche(id_coche, vel_max, aceler, peso, control,marca, modelo));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coches.toArray(new Coche[0]);
	}

}
