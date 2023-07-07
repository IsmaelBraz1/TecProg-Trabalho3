package Controller;

import java.util.ArrayList;
import java.util.Collections;

public class ListaJogadores {
	private ArrayList<Jogador>listaJogadores;
	private static ListaJogadores instance = null;
	private static int identificador = 1;
	public ListaJogadores() {
		listaJogadores = new ArrayList<Jogador>();
		listaJogadores.add(null);
	}
    public static ListaJogadores getInstance() {
        if (instance == null) {
            instance = new ListaJogadores();
        }
        return instance;
    }
    public void NovoJogador(Jogador jogador) {
    	jogador.setId(identificador);
    	listaJogadores.add(jogador);
    	identificador++;
    }
    
    public ArrayList<Jogador> getListaJogadores() {
		return listaJogadores;
	}
}
