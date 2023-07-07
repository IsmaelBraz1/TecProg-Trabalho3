package Model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Controller.Jogador;
import Controller.Mensagem;

public class Conexao {
	private Jogador jogadorAlterado;
	public Conexao(Mensagem msg){
		try {
			//Declarara socket cliente
			Socket conexao = new Socket("127.0.0.1",500);
			Mensagem mensagem = msg;
			//fluxo de dados para envio
			ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
			saida.writeObject(mensagem);
			if(mensagem.operacao == 1) {
				//Recebe o obejto novamente do servidor
				ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
				jogadorAlterado = (Jogador) entrada.readObject();
				devolverModificacoes(mensagem.jogador);
			}
			if(mensagem.operacao == 3) {
				ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
				Mensagem recebida = new Mensagem();
				recebida =  (Mensagem) entrada.readObject();
				msg.dica = recebida.dica;
			}
			if(mensagem.operacao == 5) {
				ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
				Mensagem recebida = new Mensagem();
				recebida =  (Mensagem) entrada.readObject();
				msg.todosEscolheram = recebida.todosEscolheram;
			}
			if(mensagem.operacao == 6) {
				ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
				Mensagem recebida = new Mensagem();
				recebida =  (Mensagem) entrada.readObject();
				msg.cartasRodada = recebida.cartasRodada;
			}
			if(mensagem.operacao == 7) {
				ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
				jogadorAlterado = (Jogador) entrada.readObject();
				devolverModificacoes(mensagem.jogador);
			}
			if(mensagem.operacao == 8) {
				ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
				Mensagem recebida = new Mensagem();
				recebida =  (Mensagem) entrada.readObject();
				msg.todosVotaram = recebida.todosVotaram;
			}
			if(mensagem.operacao == 9) {
				ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
				jogadorAlterado = (Jogador) entrada.readObject();
				devolverModificacoes(mensagem.jogador);
			}
			if(mensagem.operacao == 10) {
				ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
				Mensagem recebida = new Mensagem();
				recebida =  (Mensagem) entrada.readObject();
				msg.pontuacao = recebida.jogador.getPontos();
			}
			conexao.close();
		} catch (Exception e) {
			System.out.println("erro durante a conexao"+e);
		}
	}
	
	public void devolverModificacoes(Jogador jogador) {
		jogador.setId(jogadorAlterado.getId());
		jogador.setDica(jogadorAlterado.getDica());
		jogador.setCartaEscolhida(jogadorAlterado.getCartaEscolhida());
		jogador.setCartas(jogadorAlterado.getCartas());
		jogador.setJogadorDaVez(jogadorAlterado.isJogadorDaVez());
		jogador.setNome(jogadorAlterado.getNome());
		jogador.setPontos(jogadorAlterado.getPontos());
		jogador.setVotoDaVez(jogadorAlterado.getVotoDaVez());
	}
}
