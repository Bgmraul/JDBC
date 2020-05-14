package acciones;
import aplicacionJDBC.*;
import javax.swing.JOptionPane;


public class NuevoUsuario {

	public static void main(String[] args) {
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre: ");
		String apellidos = JOptionPane.showInputDialog("Introduce tu apellido: ");
		String email = JOptionPane.showInputDialog("Introduce tu email: ");
		String contrasena = JOptionPane.showInputDialog("Introduce tu contrasena: ");

		Usuario.insertar(nombre, apellidos, email, contrasena);
		Usuario usuarios[]  = Usuario.listar();
		Usuario.borrar(usuarios[0].getId());
		Usuario usuario_actualizado = usuarios[usuarios.length - 2];
		usuario_actualizado.setNombre("Morfeo");
		usuario_actualizado.setEmail("ejemplo@email.com");
		usuario_actualizado.actualizarBD();
	}
}
