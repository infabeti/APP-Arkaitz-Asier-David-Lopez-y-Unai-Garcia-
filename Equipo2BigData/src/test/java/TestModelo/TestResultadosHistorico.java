package TestModelo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import Modelo.ResultadosHistorico;

public class TestResultadosHistorico {
	
	private ResultadosHistorico comb;
	private int codAl1 = 1;
	private int codAl2 = 2;
	private String fecha = "1-1-2021";
	private float probabilidad = (float) 1.3;
	
	@Test
	public void testConstructor() {
		comb = new ResultadosHistorico(codAl1, codAl2, fecha, probabilidad);
		assertEquals(codAl1,comb.getCodAl1());
		assertEquals(codAl2,comb.getCodAl2());
		assertEquals(fecha,comb.getFecha());
		assertEquals(probabilidad,comb.getProbabilidad(),0);
	}
	
	@Test
	public void testSetCodAl1() {
		comb = new ResultadosHistorico(codAl1, codAl2, fecha, probabilidad);
		comb.setCodAl1(codAl2);
		assertEquals(codAl2, comb.getCodAl1());
	}
	
	@Test
	public void testSetCodAl2() {
		comb = new ResultadosHistorico(codAl1, codAl2, fecha, probabilidad);
		comb.setCodAl2(codAl1);
		assertEquals(codAl1, comb.getCodAl2());
	}
	
	@Test
	public void testSetFecha() {
		comb = new ResultadosHistorico(codAl1, codAl2, fecha, probabilidad);
		comb.setFecha("2-2-2020");
		assertEquals("2-2-2020", comb.getFecha());
	}
	
	@Test
	public void testSetProbabilidad() {
		comb = new ResultadosHistorico(codAl1, codAl2, fecha, probabilidad);
		comb.setProbabilidad((float) 1.1);
		assertEquals((float) 1.1, comb.getProbabilidad(),0);
	}
	
	@Test
	public void testToString() {
		comb = new ResultadosHistorico(codAl1, codAl2, fecha, probabilidad);
		assertEquals("1 2 1-1-2021 1.3", comb.toString());
	}
	
}
