package Model;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.*;
import java.util.Scanner;
import Controller.*;
public class Cliente {
	
	private Jogador jogadorAlterado;
	public Cliente(Jogador jogador){
		try {
			//Declarara socket cliente
			Socket cliente = new Socket("127.0.0.1",500);
			System.out.println("cliente incializado");
			
			Jogador ObjJogador = jogador;
			//fluxo de dados para envio
			ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
			saida.writeObject(ObjJogador);
			
			//Recebe o obejto novamente do servidor
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			jogadorAlterado = (Jogador) entrada.readObject();
			System.out.println(jogadorAlterado.getDica());
			devolverModificacoes(jogador);
			//jogador = jogadorAlterado;
			//jogador.setDica(jogadorAlterado.getDica());
 			cliente.close();
			System.out.println("cliente finalizado");
		} catch (Exception e) {
			System.out.println("erro durante a conexao");
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
