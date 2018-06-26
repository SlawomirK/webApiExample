/**
 *
 *  @author Kobyliński Sławomir S12410
 *
 */

package zad1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class Service {// trzeba dostarczyć tu waluty
	private String kraj, miasto;
	private String waluta = "",walutaKraju="";

	public String getKraj() {
		return kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}

	
	public Service(String string) {
		// TODO Auto-generated constructor stub
		kraj = string;
		walutaKraju=new WalutyKraje().WalutaKraju(kraj);
		
	}

	// pobieranie z serwera
	public String returnFromSerwer(URL url) {
		String line;
		StringBuilder response = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			response = new StringBuilder();
			while ((line = in.readLine()) != null) {
				response.append(line);
			}
			in.close();
		} catch (Exception exc) {
			
			exc.printStackTrace();
			return null;
		}
		return response.toString();
	}

	public String getWeather(String miasto) {
		this.miasto = miasto;

		URL url = null;
		try {
			url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + miasto + "," + kraj
					+ "&APPID=9563c15b038a7ed16c478d006acba005 ");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block

			
			e.printStackTrace();
		}
		//String wynik = "Pogoda dla miasta " + miasto + "\n";
		return  new JsonParser<Object>(returnFromSerwer(url)).sformatujPogode();
	}

	public Double getRateFor(String waluta) {// ile waluty kraju za walutę
		// TODO Auto-generated method stub
		this.waluta = waluta;
		
		if (!waluta.isEmpty()) {
			URL url;
			String kursyWaluty = null;
			try {
				url = new URL("http://data.fixer.io/api/latest?access_key=4803e976fed7ceb6c0d7621db6c74238&symbols="
						+ waluta + "," + walutaKraju);
				kursyWaluty = returnFromSerwer(url);
			
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
			return new JsonParser(kursyWaluty,waluta,walutaKraju).poszukiwanyWynik();
					//doObliczen.get(waluta) / doObliczen.get(walutaKraju);
		} // np kurs pln/usd
		else {
		System.exit(0);
			return null;
		}
	}

	public Double getNBPRate() {
		// TODO Auto-generated method stub	
			return new HtmlParser(waluta).pobranieStronyHTML();				
	}

	public String getMiasto() {
		return miasto;
	}

	public void setMiasto(String miasto) {
		this.miasto = miasto;
	}

	public String getWaluta() {
		return waluta;
	}

	public void setWaluta(String waluta) {
		this.waluta = waluta;
	}

	public String getWalutaKraju() {
		return walutaKraju;
	}

	public void setWalutaKraju(String walutaKraju) {
		this.walutaKraju = walutaKraju;
	}
}
