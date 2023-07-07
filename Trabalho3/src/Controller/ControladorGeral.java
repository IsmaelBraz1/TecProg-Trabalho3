package Controller;

import java.util.ArrayList;
import java.util.Collections;

public class ControladorGeral {
	private ListaJogadores jogadores;
	private SorteioCartas sorteio;
	private static int sequencia = 2;
	private static int ControledeAcesso = 0;
	private int qtdVotos;
	private String cartaDaVez;
	private String dicaDaVez;
	private ArrayList<String> cartasDaRodada;
	private static ControladorGeral instance = null;

	public ControladorGeral() {
		super();
		this.jogadores = ListaJogadores.getInstance();
		this.sorteio = SorteioCartas.getInstance();
		this.cartasDaRodada = new ArrayList<String>();
		qtdVotos = 0;
	}

	public static ControladorGeral getInstance() {
		if (instance == null) {
			instance = new ControladorGeral();
		}
		return instance;
	}

	public void AdicionarJogador(Jogador jogador) {
		jogadores.NovoJogador(jogador);
		jogador.setCartas(sorteio.sorteio());
		if (jogadores.getListaJogadores().get(1).getId() == 1)
			jogadores.getListaJogadores().get(1).setJogadorDaVez(true);
	}

	public void proximaRodada(Jogador jogador) {
		if (ControledeAcesso == 0) {
			SorteioCartas.jaForamSorteados.clear();
			cartasDaRodada.clear();
		}
		jogador.setCartas(sorteio.sorteio());
		for (int i = 1; i < jogadores.getListaJogadores().size(); i++) {
			if (jogador.isJogadorDaVez()) {
				jogador.setPontos(jogadores.getListaJogadores().get(i).getPontos());
				jogadores.getListaJogadores().get(i).setJogadorDaVez(false);
				jogador.setJogadorDaVez(false);
			}
		}
		for (int i = 1; i < jogadores.getListaJogadores().size(); i++) {
			if (jogadores.getListaJogadores().get(i).getId() == sequencia && jogador.getId() == sequencia) {
				jogadores.getListaJogadores().get(i).setJogadorDaVez(true);
				jogador.setJogadorDaVez(true);
			}
		}
		ControledeAcesso++;
		if (ControledeAcesso == jogadores.getListaJogadores().size() - 1) {
			sequencia++;
			ControledeAcesso = 0;
		}
		if(sequencia == jogadores.getListaJogadores().size()-1)
			sequencia = 1;
	}

	public void CartaDicaDaVez(Mensagem msg) {
		this.cartaDaVez = msg.carta;
		this.dicaDaVez = msg.dica;
		cartasDaRodada.add(cartaDaVez);
	}

	public void receberCartas(Mensagem msg) {
		cartasDaRodada.add(msg.carta);
	}

	public void VerificarEscolheram(Mensagem msg) {
		if (1 + cartasDaRodada.size() == jogadores.getListaJogadores().size())
			msg.todosEscolheram = true;
		else
			msg.todosEscolheram = false;
	}

	public void VerificarTodosVotaram(Mensagem msg) {
		if (qtdVotos == jogadores.getListaJogadores().size() - 2)
			msg.todosVotaram = true;
		else
			msg.todosVotaram = false;
	}

	public ArrayList<String> getCartasDaRodada() {
		Collections.shuffle(cartasDaRodada);
		return cartasDaRodada;
	}

	public void ComputarVotosJogadores(Mensagem msg) {
		qtdVotos++;
		if (msg.jogador.getVotoDaVez().equals(this.cartaDaVez)) {
			for (int j = 1; j < jogadores.getListaJogadores().size(); j++) {
				if (jogadores.getListaJogadores().get(j).isJogadorDaVez()) {
					jogadores.getListaJogadores().get(j)
							.setPontos(jogadores.getListaJogadores().get(j).getPontos() + 1);
				}
			}
		}
	}

	public void getPontuacao(Mensagem msg) {
		for (int j = 1; j < jogadores.getListaJogadores().size(); j++) {
			if (jogadores.getListaJogadores().get(j).getId() == msg.jogador.getId()) {
				msg.jogador.setPontos(jogadores.getListaJogadores().get(j).getPontos());
			}
		}
	}

	public String getCartaDaVez() {
		return cartaDaVez;
	}

	public String getDicaDaVez() {
		return dicaDaVez;
	}
}