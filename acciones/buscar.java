package acciones;
import javax.swing.JOptionPane;

import aplicacionJDBC.*;
public class buscar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre: ");
		
		Coche.consultaCoches(nombre);
	}

}
