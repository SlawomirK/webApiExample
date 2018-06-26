package zad1;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Controler  {
	MojeGui<?> gui;
	Service s;

	public Controler(MojeGui<?> moje_Gui, Service s) {
		// TODO Auto-generated constructor stub
		gui = moje_Gui;
		this.s = s;
		
		gui.setInKraj(s.getKraj());
		gui.setInMiasto(s.getMiasto());
		gui.setInUSD(s.getWaluta());	
		moje_Gui.inputData(new ServiceLis());
	}

class ServiceLis  implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String kraj="",miasto="",waluta="";
		try {			
			
			kraj=gui.getInKraj();
			miasto=gui.getInMiasto();			
			waluta=gui.getInUSD().getText();
		
			s.setKraj(kraj);
			s.setMiasto(miasto);
			s.setWaluta(waluta);
			
			gui.setZad1odp(s.getWeather(miasto));
			gui.setZad2odp(s.getRateFor(waluta).toString());
			
			gui.setZad3odp(s.getNBPRate());
			gui.setZad4Odp(miasto);
			
			
		}catch(NumberFormatException ex) {
			System.out.println(ex.toString());
			System.out.println("Controler błąd");		
		}
	}
	
}
}
