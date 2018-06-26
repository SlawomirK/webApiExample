package zad1;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class WalutyKraje {
private final String plik="KrajeWaluty.txt";

public WalutyKraje() {
	
}
//zwraca waluty używane w określonych krajach z dołączonego pliku
public String WalutaKraju(String kraj) {
	String waluta="";
	try {
		Scanner in=new Scanner(Paths.get(plik));
		String line;
		while(in.hasNextLine()) {
			line=in.nextLine();
			if(line.equals(kraj)) {
			for(int i=0;i<5;i++) {
				line=in.nextLine();
			}
			waluta=in.next();
			break;
			}
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return waluta;
}
}
