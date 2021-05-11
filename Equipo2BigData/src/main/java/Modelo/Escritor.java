package Modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Escritor {

	public void escribirHistoricoGeneral(String[][]HistoricoGeneral) {

		try {
			Path path = Paths.get("historico");

			if (!Files.exists(path)) 		           
				Files.createDirectory(path);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HHmmss");
			Calendar cal = Calendar.getInstance();
						
			String DiaHora =dateFormat.format(cal.getTime());

			FileWriter fich = new FileWriter("historico\\AlgoritmoNaiveBayesGeneral-"+DiaHora+".csv");
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
		
		try {
			Path path = Paths.get("historico");

			if (!Files.exists(path)) 		           
				Files.createDirectory(path);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HHmmss");
			Calendar cal = Calendar.getInstance();
						
			String DiaHora =dateFormat.format(cal.getTime());

			FileWriter fich = new FileWriter("historico\\AlgoritmoNaiveBayesEspecifico-"+DiaHora+"-"+NIF+".csv");
			fich.write("Primer Producto,Segundo Producto,Fecha,Porcentaje,NIF");
			for (int i=0;i<HistoricoGeneral.length;i++) {
			fich.write("\n"+HistoricoGeneral[i][0]+","+HistoricoGeneral[i][1]+","+HistoricoGeneral[i][2]+","+HistoricoGeneral[i][3]+","+NIF);
			}
			fich.close();

		} catch (IOException ex) {
			System.err.println("No se puede leer del archivo");
			System.exit(-1);
		}
	}
			
}

