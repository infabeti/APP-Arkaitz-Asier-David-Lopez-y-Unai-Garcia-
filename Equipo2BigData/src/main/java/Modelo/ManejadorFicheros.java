package Modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ManejadorFicheros {
	
	public void escribirHistorico(String[][]historicoGeneral, FileWriter fich) {
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
	
	public String crearCarpeta(String direccion) {
		Path path = Paths.get("historico");
		String diaHora = "";
		try {
			if (!Files.exists(path)){
				Files.createDirectory(path);
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HHmmss");
			Calendar cal = Calendar.getInstance();
			diaHora = dateFormat.format(cal.getTime());
		}
		catch(Exception e) {
			System.err.println("No se puede crear el directorio");
		}
		return diaHora;
		
	}

}

