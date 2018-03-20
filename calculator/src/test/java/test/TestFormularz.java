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
//	
//		assertEquals(komunikat, 5d, 5d, 0.01);
		//assertEquals(komunikat, 1, Servlet.zwracam1());

	}
	
//	@Test
//	public void servlet_should_not_greet_the_user_if_the_name_is_null() throws IOException{
//		HttpServletRequest request = mock(HttpServletRequest.class);
//		HttpServletResponse response = mock(HttpServletResponse.class);
//		FormularzServlet servlet = new FormularzServlet();
//		PrintWriter writer = mock(PrintWriter.class);
//		when(response.getWriter()).thenReturn(writer);
//		
//		when(request.getParameter("name")).thenReturn(null);
//		servlet.doPost(request,response);
//		
//		verify(response).sendRedirect("/");
//	}
//	
//	@Test
//	public void servlet_should_not_greet_the_user_if_the_name_is_empty() throws IOException{
//		HttpServletRequest request = mock(HttpServletRequest.class);
//		HttpServletResponse response = mock(HttpServletResponse.class);
//		FormularzServlet servlet = new FormularzServlet();
//		PrintWriter writer = mock(PrintWriter.class);
//		when(response.getWriter()).thenReturn(writer);
//		
//		when(request.getParameter("raty")).thenReturn("");
//		
//		servlet.doPost(request, response);
//		
//		verify(response).sendRedirect("/");
//	}
//	
//	@Test
//	public void servlet_should_not_greet_the_user_if_the_name_is_provided() throws IOException{
//		HttpServletRequest request = mock(HttpServletRequest.class);
//		HttpServletResponse response = mock(HttpServletResponse.class);
//		PrintWriter writer = mock(PrintWriter.class);
//		
//		when(request.getParameter("name")).thenReturn("jan");
//		when(response.getWriter()).thenReturn(writer);
//		
//		new FormularzServlet().doPost(request, response);
//		verify(writer).println("<h1>Hello jan</h1>");
//		
//	}
	
}
