package zad1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {

	private final String[] STRONY_DO_PRZESZUKANIA = { "http://www.nbp.pl/kursy/kursya.html",
			"http://www.nbp.pl/kursy/kursyb.html" };
	private String podanaWaluta;

	//
	public HtmlParser(String podanaWaluta) {
		// TODO Auto-generated constructor stub
		this.podanaWaluta = podanaWaluta;
	}

	public HtmlParser() {

	}

	// doc.select("b:contains(Pantry/Catering)").first().parent().children().get(1).text();
	public double pobranieStronyHTML() {
		String el = null;
		Element element = null;
		if (podanaWaluta.equals("PLN")) {
			JOptionPane.showMessageDialog(null,
					"kurs PLN do PLN to 1 chyba że mamy galopującą inflację ;-)\n Spróbuj z inną walutą.");
		} else {
			for (int i = 0; i < STRONY_DO_PRZESZUKANIA.length; i++) {
				try {
					Document doc = Jsoup.connect(STRONY_DO_PRZESZUKANIA[i]).get();
					element = doc.getElementsContainingOwnText(podanaWaluta).next().last();					
									
						el = element.text().replace(",", ".");// problem z ,/.
						break;					

				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Błąd połączenia ze stroną w HtmlParser.pobranieStronyHtml");
					e.printStackTrace();
				}
			}
		}
		
		return Double.parseDouble(el);

	}
/*
	public String getWaluteObowiazujacaW(String kraj)  {
		final String url = "https://www.ups.com/worldshiphelp/WS19/PLK/AppHelp/Codes/Country_Territory_and_Currency_Codes.htm";
		Document doc1 = null;
		try {
			doc1 = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Element element=doc1.select("td:contains(kraj)").first();
		String waluta=element.text();
		System.out.println("waluta "+element);
		return waluta;
	}*/
}