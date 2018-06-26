/**
 *
 *  @author Kobyliński Sławomir S12410
 *
 */

package zad1;

import java.awt.EventQueue;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		Service s = new Service("Poland");
		String weatherJson = s.getWeather("Warsaw");
		
		Double rate1=s.getRateFor("USD");		
		Double rate2 = s.getNBPRate();	
		
		
		// ...
		// część uruchamiająca GUI	
		
	new Controler(new MojeGui(),s);	        
	}
}
