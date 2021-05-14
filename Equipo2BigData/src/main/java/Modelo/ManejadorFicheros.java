package Modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ManejadorFicheros {
	
	public void escribirHistoricoGeneral(String[][]historicoGeneral, FileWriter fich) {
		try {
			fich.write("Primer Producto,Segundo Producto,Fecha,Porcentaje");
			for (int i=0;i<historicoGeneral.length;i++) {
			fich.write("\n"+historicoGeneral[i][0]+","+historicoGeneral[i][1]+","+historicoGeneral[i][2]+","+historicoGeneral[i][3]);
			}

		} catch (IOException ex) {
			System.err.println("No se puede leer del archivo");
		}
		finally {
			try {
				if(fich != null) {
					fich.close();
				}
			}
			catch(Exception e) {
				System.err.println("No se puede leer del archivo");
			}
		}
	}

	public void escribirHistoricoLocal(String[][]historicoGeneral, String NIF, FileWriter fich) {	
		try {
			fich.write("Primer Producto,Segundo Producto,Fecha,Porcentaje");
			for (int i=0;i<historicoGeneral.length;i++) {
			fich.write("\n"+historicoGeneral[i][0]+","+historicoGeneral[i][1]+","+historicoGeneral[i][2]+","+historicoGeneral[i][3]);

			}
			fich.close();

		} catch (IOException ex) {
			System.err.println("No se puede leer del archivo");
		}
		finally {
			try {
				if(fich != null) {
					fich.close();
				}
			}
			catch(Exception e) {
				System.err.println("No se puede leer del archivo");
			}
		}
	}
	
	public void crearCarpeta(String direccion) {
		Path path = Paths.get("historico");
		try {
			if (!Files.exists(path)){
				Files.createDirectory(path);
			}
		}
		catch(Exception e) {
			System.err.println("No se puede crear el directorio");
		}
		
	}

}

