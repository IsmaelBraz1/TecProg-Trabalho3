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
			System.out.println("cliente incializado");
			
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
				System.out.println(recebida.dica);
			}
			if(mensagem.operacao == 5) {
				ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
				Mensagem recebida = new Mensagem();
				recebida =  (Mensagem) entrada.readObject();
				msg.todosEscolheram = recebida.todosEscolheram;
				if(msg.todosEscolheram) {
					System.out.println("true");
				}
				//System.out.println(recebida.dica);
			}
			//jogador = jogadorAlterado;
			//jogador.setDica(jogadorAlterado.getDica());
			conexao.close();
			System.out.println("cliente finalizado");
		} catch (Exception e) {
			System.out.println("erro durante a conexao"+e);
		}
	}
	
	public void devolverModificacoes(Jogador jogador) {
		jogador.setDica(jogadorAlterado.getDica());
		jogador.setCartaEscolhida(jogadorAlterado.getCartaEscolhida());
		jogador.setCartas(jogadorAlterado.getCartas());
		jogador.setJogadorDaVez(jogadorAlterado.isJogadorDaVez());
		jogador.setNome(jogadorAlterado.getNome());
		jogador.setPontos(jogadorAlterado.getPontos());
	}
}
