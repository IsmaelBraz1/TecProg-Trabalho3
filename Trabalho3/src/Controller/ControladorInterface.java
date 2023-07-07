package Controller;

import java.util.ArrayList;
import Model.Conexao;
import View.FacadeGUI;
import View.TelaPrincipal;

public class ControladorInterface {
	private static ControladorInterface instance;
	public Jogador jogador;
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
	//metodo usado quando o cliente fizer login
	public void novoJogador(String nome) {
		jogador = new Jogador(nome);
		this.facade.connectAndHostScreen();
	}
	//metodo usado quando o jogador da vez escolher a carta e a dica
	public void EnviarCartaDica(String carta, String dica) {
		jogador.setCartaEscolhida(carta);
		jogador.setDica(dica);
		Mensagem msg = new Mensagem();
		msg.carta = carta;
		msg.dica = dica;
		msg.operacao = 2;
		new Conexao(msg);
	}
	//metodo que deve ser chamado pelos demais jogadores para receber a dica
	public void receberDica() {
		Mensagem msg = new Mensagem();
		msg.operacao = 3;
		new Conexao(msg);
		dicaDaVez = msg.dica;
		jogador.setDicaDaVez(msg.dica);
	}
	//metodo para ser usado quando o jogador escolher a carta
	public void enviarCarta(String carta) {
		jogador.setCartaEscolhida(carta);
		Mensagem msg = new Mensagem();
		msg.carta = carta;
		msg.operacao = 4;
		new Conexao(msg);
	}
	//metodo que da autorizacao (quando for true) para que o jogo mostre a tela para votacao
	public Boolean todosEscolheram() {
		Mensagem msg = new Mensagem();
		msg.operacao = 5;
		new Conexao(msg);
		if(msg.todosEscolheram)
			return true;
		else
			return false;
	}
	//metodo para ser chamado na tela da votacao (retorna as cartas escolhidas pelos jogadores)
	public void pegarCartasRodada() {
		Mensagem msg = new Mensagem();
		msg.operacao = 6;
		new Conexao(msg);
		cartasRodada = msg.cartasRodada;
	}
	//metodo a ser chamado quando o jogador votar 
	public void enviarVotoDaVez(String votoDaVez) {
		jogador.setVotoDaVez(votoDaVez);
		Mensagem msg = new Mensagem();
		msg.operacao = 7;
		msg.jogador = this.jogador;
		new Conexao(msg);
	}
	//da autorizacao (true) para prosseguir o jogo depois que todos votarem
	public Boolean todosVotaram() {
		Mensagem msg = new Mensagem();
		msg.operacao = 8;
		new Conexao(msg);
		if(msg.todosVotaram)
			return true;
		else
			return false;
	}
	//inicia a proxima rodada
	public void proximaRodada() {
		Mensagem msg = new Mensagem();
		msg.operacao = 9;
		msg.jogador = this.jogador;
		new Conexao(msg);
	}
	//atribui a pontuacao dos jogadores apos cada rodada (deve ser usado antes do metodo proximaRodada() )
	public void setarPontuacao() {
		Mensagem msg = new Mensagem();
		msg.operacao = 10;
		msg.jogador = this.jogador;
		new Conexao(msg);
		jogador.setPontos(msg.pontuacao); 
	}
}
