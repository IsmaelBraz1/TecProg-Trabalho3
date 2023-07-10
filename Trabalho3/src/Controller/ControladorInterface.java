package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import View.FacadeGUI;
import View.TelaPrincipal;
import View.include.Error;
import View.include.IPInput;
import Model.*;

public class ControladorInterface {
	private static ControladorInterface instance;
	public Jogador jogador;
	public boolean isHost;
	public String ip;
	public ArrayList<String> cartasRodada;
	public String dicaDaVez = "";
	private FacadeGUI facade;
	
	public ControladorInterface() {
		cartasRodada = new ArrayList<String>();
		this.facade = new FacadeGUI(TelaPrincipal.getInstance());
	}
	
	public static ControladorInterface getInstance() {
		if(instance == null) {
			instance = new ControladorInterface();
			return instance;
		}
		return instance;
	}

	// metodo usado quando o cliente fizer login
	public void novoJogador(String nome) {
		jogador = new Jogador(nome);
		this.facade.connectAndHostScreen();
	}

	//se o jogador escolher a opcao host
	public void iniciarHost() {
		Servidor servidor = new Servidor(5000);
		servidor.start();
		Mensagem msg = new Mensagem();
		msg.jogador = jogador;
		msg.operacao = 1;
		new Conexao(msg, "127.0.0.1");
		this.facade.GameScreen(jogador);
	}

	//se o clinete escolher a opcao "junte se a um amigo"
	public void iniciarCliente() {
		this.ip = new IPInput().getIP();
		Mensagem msg = new Mensagem();
		msg.jogador = jogador;
		msg.operacao = 1;
		new Conexao(msg, this.ip);
		this.facade.GameScreen(jogador);
	}

	// metodo usado quando o jogador da vez escolher a carta e a dica
	public void EnviarCartaDica(String carta, String dica) {
		if(carta == null) {
			new Error("Você deve escolher uma carta!");
			return;
		}
		if(dica == null || dica.isEmpty()) {
			new Error("Você deve dar uma dica!");
			return;
		}
		jogador.setCartaEscolhida(carta);
		jogador.setDica(dica);
		Mensagem msg = new Mensagem();
		msg.carta = carta;
		msg.dica = dica;
		msg.operacao = 2;
		new Conexao(msg, ip);
		this.facade.waitOthersSelect();
		this.facade.setMessage("Espere os outros jogadores escolherem.");
	}

	// metodo que deve ser chamado pelos demais jogadores para receber a dica
	public void receberDica() {
		Mensagem msg = new Mensagem();
		msg.operacao = 3;
		new Conexao(msg, ip);
		if(msg.dica == null) {
			return;
		}
		dicaDaVez = msg.dica;
		jogador.setDicaDaVez(msg.dica);
		this.facade.SelectionByOtherPlayers(true, msg.dica);
	}

	// metodo para ser usado quando o jogador escolher a carta
	public void enviarCarta(String carta) {
		jogador.setCartaEscolhida(carta);
		Mensagem msg = new Mensagem();
		msg.carta = carta;
		msg.operacao = 4;
		new Conexao(msg, ip);
		if(todosEscolheram()) {
			this.facade.VotationScreen();
			this.pegarCartasRodada();
			this.facade.setCardsToVotation(this.cartasRodada);
		}
	}

	// metodo que da autorizacao (quando for true) para que o jogo mostre a tela
	// para votacao
	public Boolean todosEscolheram() {
		Mensagem msg = new Mensagem();
		msg.operacao = 5;
		new Conexao(msg, ip);
		if (msg.todosEscolheram)
			return true;
		else
			return false;
	}

	// metodo para ser chamado na tela da votacao (retorna as cartas escolhidas
	// pelos jogadores)
	public void pegarCartasRodada() {
		Mensagem msg = new Mensagem();
		msg.operacao = 6;
		new Conexao(msg, ip);
		cartasRodada = msg.cartasRodada;
	}

	// metodo a ser chamado quando o jogador votar
	public void enviarVotoDaVez(String votoDaVez) {
		jogador.setVotoDaVez(votoDaVez);
		Mensagem msg = new Mensagem();
		msg.operacao = 7;
		msg.jogador = this.jogador;
		new Conexao(msg, ip);
		try {
			if(this.todosVotaram()) {
				this.setarPontuacao();
				this.facade.RestartGame();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// da autorizacao (true) para prosseguir o jogo depois que todos votarem
	public Boolean todosVotaram() {
		Mensagem msg = new Mensagem();
		msg.operacao = 8;
		new Conexao(msg, ip);
		if (msg.todosVotaram)
			return true;
		else
			return false;
	}

	// inicia a proxima rodada
	public void proximaRodada() {
		Mensagem msg = new Mensagem();
		msg.operacao = 9;
		msg.jogador = this.jogador;
		new Conexao(msg, ip);
	}

	// atribui a pontuacao dos jogadores apos cada rodada (deve ser usado antes do
	// metodo proximaRodada() )
	public void setarPontuacao() {
		Mensagem msg = new Mensagem();
		msg.operacao = 10;
		msg.jogador = this.jogador;
		new Conexao(msg, ip);
		jogador.setPontos(msg.pontuacao);
		this.facade.setPlayer(this.jogador);
	}
}
