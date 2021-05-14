package TestModelo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doThrow;
import org.junit.Before;
import org.junit.Test;

import Modelo.ManejadorFicheros;
import java.io.FileWriter;
import java.io.IOException;

public class TestEscritor {
	
	private ManejadorFicheros escritor = new ManejadorFicheros();
	private FileWriter fileWriterMock = mock(FileWriter.class);
	private String[][] historicoGeneralPrueba = new String[10][4];

	
	@Test
	public void testEscribirHistorico() {
		escritor.escribirHistorico(historicoGeneralPrueba, fileWriterMock);
		try {
			verify(fileWriterMock).close();
		}
		catch(IOException e) { //Necesitamos esta IOException para que se pueda verificar close();
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testEscribirHistoricoExcepcion() {
		try {
			doThrow(IOException.class).when(fileWriterMock).close();
			escritor.escribirHistorico(historicoGeneralPrueba, fileWriterMock);
			verify(fileWriterMock).close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
