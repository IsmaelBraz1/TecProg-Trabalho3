package Controller;

import java.util.ArrayList;
import java.util.Collections;

public class ControladorGeral {
	private ListaJogadores jogadores;
	private SorteioCartas sorteio;
	private ArrayList<Jogador> lista;
	private int sequencia;
	private String cartaDaVez;
	private String dicaDaVez;
	private ArrayList<String> cartasDaRodada;
	private static ControladorGeral instance = null;

	public ControladorGeral() {
		super();
		this.jogadores = ListaJogadores.getInstance();
		this.sorteio = SorteioCartas.getInstance();
		this.cartasDaRodada = new ArrayList<String>();
		sequencia = 0;
	}

	public static ControladorGeral getInstance() {
		if (instance == null) {
			instance = new ControladorGeral();
		}
		return instance;
	}

	public void AdicionarJogador(Jogador jogador) {

		// jogador.setCartas(sorteio.sorteio()); //comentado enquanto nao tem mais
		// cartas
		jogadores.NovoJogador(jogador);
		System.out.println("jogador adicionado no geral");
		if (jogadores.getListaJogadores().get(1).getId() == 1)
			jogadores.getListaJogadores().get(1).setJogadorDaVez(true);
	}

	public void CartaDicaDaVez(Mensagem msg) {
		this.cartaDaVez = msg.carta;
		this.dicaDaVez = msg.dica;
		cartasDaRodada.add(cartaDaVez);
		System.out.println("a dica recebida foi: "+this.dicaDaVez);
	}
	
	public void receberCartas(Mensagem msg) {
		cartasDaRodada.add(msg.carta);
	}
	
	public void VerificarEscolheram(Mensagem msg) {
		System.out.println("entrou aqui");
		int a=2;
		if(1+cartasDaRodada.size()==jogadores.getListaJogadores().size()) {
			msg.todosEscolheram = true;
			System.out.println("entrou aqui no true");
		}else {
			msg.todosEscolheram = false;
			System.out.println("entrou aqui no false");
		}
	}
	
	
	public void rodada() {
		lista = jogadores.getListaJogadores();
		Collections.shuffle(lista);
		while (true) {
			for (int i = 0; i < lista.size(); i++) {
				lista.get(i).setJogadorDaVez(false);
				lista.get(i).setCartas(sorteio.sorteio());
			}
			// sequencia da rodada
			for (int i = 0; i < lista.size(); i++) {
				// definicao do jogador da vez da rodada
				Jogador jogadorDaVez = lista.get(i);
				jogadorDaVez.setJogadorDaVez(true);

			}
		}
	}

	public void defineJogadorVez(Jogador jogador) {

		for (int i = 0; i < 5; i++) {
			if (jogador.getId() == sequencia) {
				jogador.setJogadorDaVez(true);
			}
		}
		// sequencia++;
		// Jogador jog = jogador;
		// jogador.setDica("id: "+ jogador.getId()+" Alteracao: a dica é:
		// "+jogador.getNome());
		// return jog;
	}

	public void proximaRodada() {
		sequencia++;
	}

	public void escolherCarta(Jogador jogador, String carta) {
		jogador.setCartaEscolhida(carta);
	}

	public ArrayList<Jogador> getLista() {
		return lista;
	}

	public ListaJogadores getJogadores() {
		return jogadores;
	}

	public String getCartaDaVez() {
		return cartaDaVez;
	}

	public String getDicaDaVez() {
		return dicaDaVez;
	}
	

}
