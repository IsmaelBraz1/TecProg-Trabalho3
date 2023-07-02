package Controller;

import java.util.ArrayList;
import java.util.Random;

public class SorteioCartas {
	private static SorteioCartas instance = null;
	public String[] cartas;
	private static ArrayList<Integer> jaForamSorteados;
	public SorteioCartas() {
		cartas = new String[5];
		jaForamSorteados = new ArrayList<Integer>();
	}
	 public static SorteioCartas getInstance() {
	        if (instance == null) {
	            instance = new SorteioCartas();
	        }
	        return instance;
	    }
	public String[] sorteio() {
		lerCartas ler = new lerCartas();
		
		Random random = new Random();
		int cartaSorteada;
		for(int i = 0; i < 5;) {
			cartaSorteada = random.nextInt(5);
			if(!jaForamSorteados.contains(cartaSorteada)) {
				cartas[i] = ler.getLista().get(cartaSorteada);
				jaForamSorteados.add(cartaSorteada);
				i++;
			}
		}
		return cartas;
	}
	public static ArrayList<Integer> getJaForamSorteados() {
		return jaForamSorteados;
	}
	public static void setJaForamSorteados(ArrayList<Integer> jaForamSorteados) {
		SorteioCartas.jaForamSorteados = jaForamSorteados;
	}
	
	
}
