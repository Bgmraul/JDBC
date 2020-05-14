package aplicacionJDBC;
import java.sql.*;

public class Coche {
	int id, vel_max, aceleracion, peso, control;
	String marca, modelo;
	public Coche(int id, int vel_max, int aceleracion, int peso, int control, String marca, String modelo) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.vel_max = vel_max;
		this.aceleracion = aceleracion;
		this.peso = peso;
		this.control = control;
	}
	
	public void consultaCoches(String apodo){
		
		Connection acceso = ConexionBD.getInstance();
		try {
			
			/*String query = ("SELECT id_usuario from piloto where apodo = " + apodo);
			PreparedStatement consulta = acceso.prepareStatement(query);*/
			Statement resultado = acceso.createStatement();
			ResultSet miResultset = resultado.executeQuery("SELECT id_usuario from piloto where apodo = El Quinto");
			
			while(miResultset.next()) {
				
				System.out.println(miResultset.getString("apodo"));
			}
		}catch(Exception e) {
			System.out.println("No Conecta");
			e.printStackTrace();
		}
		
	}
	
	ConexionBD conexion;
}
