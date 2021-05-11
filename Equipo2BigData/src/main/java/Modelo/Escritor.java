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
			
		Path path = Paths.get("C:\\eclipse-workspace\\APP-Arkaitz-Asier-David-Lopez-y-Unai-Garcia-\\Equipo2BigData\\historico");

	    if (!Files.exists(path)) 		           
	            Files.createDirectory(path);
	    
	    FileWriter fich = new FileWriter("C:\\eclipse-workspace\\APP-Arkaitz-Asier-David-Lopez-y-Unai-Garcia-\\Equipo2BigData\\historico\\historico.csv");
	    
	    fich.write(HistoricoGeneral[0][0]+","+HistoricoGeneral[0][1]);
		
		fich.close();
		
		} catch (IOException ex) {
			System.err.println("No se puede leer del archivo");
			System.exit(-1);
		}
		
	}
	
}
