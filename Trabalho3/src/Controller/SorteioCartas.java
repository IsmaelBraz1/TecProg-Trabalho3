package Controller;

import java.util.ArrayList;
import java.util.Random;

import Model.lerCartas;

public class SorteioCartas {
	private static SorteioCartas instance = null;
	public String[] cartas;
	public static ArrayList<Integer> jaForamSorteados;
	public SorteioCartas() {
		cartas = new String[6];
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
		for(int i = 0; i < 6;) {
			cartaSorteada = random.nextInt(18);
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
