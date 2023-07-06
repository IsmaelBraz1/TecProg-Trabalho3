package Controller;

import Model.Conexao;

public class ControladorInterface {
	public Jogador jogador;
	public ControladorInterface() {
		
	}
	
	public void novoJogador(String nome) {
		jogador = new Jogador(nome);
	}
	
	public void EnviarCartaDica(String carta, String dica) {
		jogador.setCartaEscolhida(carta);
		jogador.setDica(dica);
		Mensagem cartaDica = new Mensagem();
		cartaDica.carta = carta;
		cartaDica.dica = dica;
		cartaDica.operacao = 2;
		new Conexao(cartaDica);
	}
	
	public void receberDica() {
		Mensagem msg = new Mensagem();
		msg.operacao = 3;
		new Conexao(msg);
		jogador.setDicaDaVez(msg.dica);
	}
	
	public void enviarCarta(String carta) {
		Mensagem msg = new Mensagem();
		msg.carta = carta;
		msg.operacao = 4;
		new Conexao(msg);
	}
	public Boolean todosEscolheram() {
		Mensagem msg = new Mensagem();
		msg.operacao = 5;
		new Conexao(msg);
		if(msg.todosEscolheram)
			return true;
		else
			return false;
	}
	public void cartaEscolhida(String carta) {
		jogador.setCartaEscolhida(carta);
	}
}
