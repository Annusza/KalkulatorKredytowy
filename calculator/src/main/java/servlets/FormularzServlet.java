package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LogikaFormularza;

@WebServlet("/formularz")
public class FormularzServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// response.setContentType("text/html;charset=UTF-8");
		handleRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// response.setContentType("text/html;charset=UTF-8");
		handleRequest(request, response);

	}


	public static void pisz(HttpServletResponse response, String string)
			throws IOException {
		response.getWriter().write(string);
		
	}

	private void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<html><head><meta charset=\"UTF-8\"></head><body><br/><br/>");


		Double kwota = null;
		Double raty = null;
		Double oprocentowanie = null;
		Double oplata = null;
		try {
			kwota = LogikaFormularza.wyciagnijDoubleZRequest(request, "kwota");
			raty = LogikaFormularza.wyciagnijDoubleZRequest(request, "raty");
			oprocentowanie = LogikaFormularza.wyciagnijDoubleZRequest(request, "oprocentowanie");
			oplata = LogikaFormularza.wyciagnijDoubleZRequest(request, "oplata");

		} catch (Exception e) {

			pisz(response, "Formularz</body></html>");

			return;
		}

		pisz(response, "<h2>Formularz rat kredytu</h2>");
		pisz(response,
				"<table border=\"2\"><tr><th>Nr raty</th><th>Kwota kapitału</th><th>Kwota odsetek</th><th>Opłaty stałe</th><th>Całkowita kwota raty</th></tr>");

		boolean stala = request.getParameter("rodz_rat").equals("stala");
		List<List<Double>> lista = LogikaFormularza.obliczRatyStale(kwota, raty, oprocentowanie,
				oplata, stala);
		for (int i = 0; i < lista.size(); i++) {

			pisz(response, "<tr>");

			for (int j = 0; j < lista.get(i).size(); j++) {

				pisz(response, "<td>");
				pisz(response, "" + lista.get(i).get(j));
				pisz(response, "</td>");
			}

			pisz(response, "</tr>");
		}
		pisz(response, "</table><br/></body></html>");
	}


}
