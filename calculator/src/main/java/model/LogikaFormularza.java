package model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class LogikaFormularza {
	
	public static List<List<Double>> obliczRatyStale(Double kwota, Double raty,
			Double oprocentowanie, Double oplata, boolean stala) {

		List<List<Double>> listaRat = new ArrayList<List<Double>>();
		List<Double> listaCzesci = new ArrayList<Double>();
		Double sumaCzesci = 0.0;
		Double kwotaRaty;
		for (int i = 1; i <= raty; i++) {

			double mianownik = Math.pow(1 + ((oprocentowanie / 100.0) / 12),
					raty - i + 1);

			double czesc = 1 / mianownik;
			listaCzesci.add(czesc);
			sumaCzesci += czesc;
		}

		kwotaRaty = kwota / sumaCzesci;

		for (int i = 1; i <= raty; i++) {
			List<Double> wiersz = new ArrayList<Double>();
			double numerRaty = (double) i;
			wiersz.add(numerRaty);
			if (stala == true) {

				double kwotaKapitalu = (listaCzesci.get(i - 1)) * kwotaRaty;
				wiersz.add(kwotaKapitalu);
				double kwotaOdsetek = kwotaRaty - kwotaKapitalu;
				wiersz.add(kwotaOdsetek);
				double oplatyStale = oplata;
				wiersz.add(oplatyStale);
				double calkowitaKwotaRaty = kwotaRaty + oplatyStale;
				wiersz.add(calkowitaKwotaRaty);

			} else {

				double kwotaKapitalu = kwota / raty;
				wiersz.add(kwotaKapitalu);
				double kwotaPozostalaDoSplaty = (kwota / raty) * (raty - i + 1);
				double kwotaOdsetek = (kwotaPozostalaDoSplaty * (oprocentowanie / 100.0)) / 12;
				wiersz.add(kwotaOdsetek);
				double oplatyStale = oplata;
				wiersz.add(oplatyStale);
				double calkowitaKwotaRaty = kwotaKapitalu + kwotaOdsetek
						+ oplatyStale;
				wiersz.add(calkowitaKwotaRaty);

			}
			listaRat.add(wiersz);
		}
		return listaRat;
	}
	public static double wyciagnijDoubleZRequest(HttpServletRequest request,
			String nazwa) {
		return Double.parseDouble(request.getParameter(nazwa)
				.replaceAll(",", ".").replaceAll(" ", ""));
	}

}
