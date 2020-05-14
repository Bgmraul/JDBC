package aplicacionJDBC;

import java.sql.*;

public class ConexionBD {
	private static Connection conexion = null;
	
    // Private constructor suppresses 
    private ConexionBD(){}

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instanciación múltiple 
    private synchronized static void createInstance() {
		  try{
      	if (conexion == null) { 
         	conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/juegocarreras", "root", "");
       	}
		  }catch(Exception e) {	
		  	System.out.println("No Conecta");
			  e.printStackTrace();
	  	}
    }

    public static Connection getInstance() {
        if (conexion == null) createInstance();
        return conexion;
    }
}
