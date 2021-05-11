package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Escritor {

	public void escribirHistoricoGeneral(String[][]HistoricoGeneral) {

		try {
			Path path = Paths.get("historico");

			if (!Files.exists(path)) 		           
				Files.createDirectory(path);

			FileWriter fich = new FileWriter("historico\\historico.csv");
			fich.write("Primer Producto,Segundo Producto,Fecha,Porcentaje");
			for (int i=0;i<HistoricoGeneral.length;i++) {
			fich.write("\n"+HistoricoGeneral[i][0]+","+HistoricoGeneral[i][1]+","+HistoricoGeneral[i][2]+","+HistoricoGeneral[i][3]);
			}
			fich.close();

		} catch (IOException ex) {
			System.err.println("No se puede leer del archivo");
			System.exit(-1);
		}
	}

	public void escribirHistoricoLocal(String[][]HistoricoGeneral, String NIF) {
		
	}
}
