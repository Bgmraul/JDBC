package acciones;
import javax.swing.JOptionPane;

import aplicacionJDBC.*;
public class NuevoCoche {

	public static void main(String[] args) {
		String marca = JOptionPane.showInputDialog("Introduce tu marca: ");
    String modelo = JOptionPane.showInputDialog("Introduce tu modelo: ");
    String vel_max = JOptionPane.showInputDialog("Introduce tu velocidad maxima: ");
    String aceleracion = JOptionPane.showInputDialog("Introduce tu aceleracion: ");
    String peso = JOptionPane.showInputDialog("Introduce tu peso: ");
    String control = JOptionPane.showInputDialog("Introduce tu control: ");

		Coche.insertar(marca, modelo, vel_max, aceleracion, peso, control);
    Coche coches[] = Coche.listar();
    if(coches.length > 1){
        Coche.borrar(coches[0].getId());
		    Coche coche_actualizado = coches[coches.length - 2];
		    coche_actualizado.setMarca("Citroen");
		    coche_actualizado.setModelo("Berlingo");
        coche_actualizado.actualizarBD();
    }
  }
}
