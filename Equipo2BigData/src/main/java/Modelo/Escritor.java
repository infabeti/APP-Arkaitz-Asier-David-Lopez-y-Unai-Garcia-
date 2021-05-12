package Modelo;

import java.io.FileWriter;
import java.io.IOException;

public class Escritor {
	
	public Escritor() {}

	public void escribirHistoricoGeneral(String[][]historicoGeneral, FileWriter fich) {

		try {
			fich.write("Primer Producto,Segundo Producto,Fecha,Porcentaje");
			for (int i=0;i<historicoGeneral.length;i++) {
			fich.write("\n"+historicoGeneral[i][0]+","+historicoGeneral[i][1]+","+historicoGeneral[i][2]+","+historicoGeneral[i][3]);
			}
			fich.close();

		} catch (IOException ex) {
			System.err.println("No se puede leer del archivo");
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
	}
			
}

