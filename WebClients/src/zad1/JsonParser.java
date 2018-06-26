package zad1;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser<var> {
	String jsonTresc, waluta, walutaKraju;

	public JsonParser(String json) {
		jsonTresc = json;
	}

	public JsonParser(String json, String waluta, String walutaKraju) {
		// TODO Auto-generated constructor stub
		jsonTresc = json;
		this.waluta = waluta;
		this.walutaKraju = walutaKraju;
	}

	public String sformatujPogode() {
		// TODO Auto-generated method stub

		JSONParser parser = new JSONParser();
		String tekstSformatowany = "";
		try {
			JSONObject jsonOb = new JSONObject();
			jsonOb = (JSONObject) parser.parse(jsonTresc);
			JSONObject s = (JSONObject) jsonOb.get("main");
			if (!jsonOb.isEmpty()) {
			/*
				tekstSformatowany += "Temperatura: " + s.get("temp") + "F\n";
				tekstSformatowany += "Temp minimalna: " + s.get("temp_min") + "F\n";
				tekstSformatowany += "Temp maks " + s.get("temp_max") + "F\n";
				tekstSformatowany += "Wilgotnosc " + s.get("humidity") + "%\n";
				tekstSformatowany += "Cisnienie " + s.get("pressure") + "hPa\n"+"....";
				
				*/
				//do wymogów zadania wystarczy JSson nie formatowany
				tekstSformatowany=s.toString();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return tekstSformatowany;
	}

	public double poszukiwanyWynik() {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) parser.parse(jsonTresc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject s = (JSONObject) jsonObject.get("rates");
		if(waluta.equals("EUR")) return (double)s.get(walutaKraju)/1.0;
		else if(walutaKraju.equals("EUR")) return 1.0/(double)s.get(waluta);
		else		
		return (double)s.get(walutaKraju)/(double)s.get(waluta);
	}
}
