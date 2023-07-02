package Controller;

import java.util.ArrayList;
import java.util.Collections;

public class ListaJogadores {
	private ArrayList<Jogador>listaJogadores;
	private static ListaJogadores instance = null;
	private static int numJogadores = 0;
	public ListaJogadores() {
		listaJogadores = new ArrayList<Jogador>();
	}
    public static ListaJogadores getInstance() {
        if (instance == null) {
            instance = new ListaJogadores();
        }
        return instance;
    }
    public void NovoJogador(String nome) {
    	listaJogadores.add(new Jogador(numJogadores,nome));
    	numJogadores++;
    }
    
    public ArrayList<Jogador> getListaJogadores() {
		return listaJogadores;
	}
	public static int numJogadores() {
        return numJogadores;
    }
	public void definirSequencia() {
		Collections.shuffle(listaJogadores);
	}
}
