package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;
import model.LogikaFormularza;

import org.junit.Test;
import org.mockito.Mockito;

import servlets.FormularzServlet;

public class TestFormularz extends Mockito {
	
	
	@Test
	public void rataKredytuLiczySiePrawidlowo() throws IOException{
		String komunikat = "Metoda obliczRatyStale powinna obliczac ";
	List<List<Double>> x = LogikaFormularza.obliczRatyStale(420000d, 6d, 3d, 0d, true);
	assertEquals(komunikat, 69_563.77d, x.get(0).get(1), 0.01);


	}
	

	
}
