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
    	System.out.println("entrou no add da lista "+identificador);
    	//
    	listaJogadores.add(jogador);
    	jogador.setId(identificador);
    	System.out.println(listaJogadores.get(identificador).getNome()+" foi adicionado na lista id: "+listaJogadores.get(identificador).getId());
    	identificador++;
    }
    
    public ArrayList<Jogador> getListaJogadores() {
		return listaJogadores;
	}
	public ArrayList<Jogador> definirSequencia() {
		ArrayList<Jogador> sequencia = listaJogadores;
		Collections.shuffle(sequencia);
		return sequencia;
	}
}
