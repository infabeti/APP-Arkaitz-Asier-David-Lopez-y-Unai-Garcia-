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
<<<<<<< HEAD
			fich.write("Primer Producto,Segundo Producto,Fecha,Porcentaje");
			for (int i=0;i<historicoGeneral.length;i++) {
			fich.write("\n"+historicoGeneral[i][0]+","+historicoGeneral[i][1]+","+historicoGeneral[i][2]+","+historicoGeneral[i][3]);
=======
			Path path = Paths.get("historico");

			if (!Files.exists(path)) 		           
				Files.createDirectory(path);
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HHmmss");
			Calendar cal = Calendar.getInstance();
						
			String DiaHora =dateFormat.format(cal.getTime());

			FileWriter fich = new FileWriter("historico\\AlgoritmoNaiveBayesEspecifico-"+DiaHora+"-"+NIF+".csv");
			fich.write("Primer Producto,Segundo Producto,Fecha,Porcentaje");
			for (int i=0;i<HistoricoGeneral.length;i++) {
			fich.write("\n"+HistoricoGeneral[i][0]+","+HistoricoGeneral[i][1]+","+HistoricoGeneral[i][2]+","+HistoricoGeneral[i][3]);
>>>>>>> 3895ff7ef34e1dfb15bb1c339c09e4b684aed548
			}
			fich.close();

		} catch (IOException ex) {
			System.err.println("No se puede leer del archivo");
		}
	}
			
}

