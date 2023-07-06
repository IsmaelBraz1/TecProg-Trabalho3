package Model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Controller.ControladorGeral;
import Controller.*;

public class Trafego extends Thread {
	Socket conexao;

	public Trafego(Socket conect) {
		this.conexao = conect;
	}

	public void run() {
		try {
			ControladorGeral control = ControladorGeral.getInstance();
			System.out.println("Cliente conectado com thread (" + this.getId() + ")  :" + conexao.getInetAddress());
			// fluxo de dados do cliente para comunicar e enviar o objeto
			ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
			// pega o objeto(jogador) vindo do cliente
			Mensagem objeto = (Mensagem) entrada.readObject();
			
			// faz as alteracoes no objeto
			if (objeto.operacao == 1) {
				control.AdicionarJogador(objeto.jogador);
				// devolve o objeto
				ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
				saida.writeObject(objeto.jogador);
			}
			if(objeto.operacao == 2) {
				control.CartaDicaDaVez(objeto);
			}
			if(objeto.operacao == 3) {
				objeto.dica = control.getDicaDaVez();
				System.out.println(objeto.dica);
				ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
				saida.writeObject(objeto);
			}
			if(objeto.operacao == 4) {
				control.receberCartas(objeto);
			}
			if(objeto.operacao == 5) {
				control.VerificarEscolheram(objeto);
				System.out.println("verificou");
				ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
				saida.writeObject(objeto);
			}
			// Thread.sleep(10000);
			conexao.close();
			System.out.println("cliente finalizado(" + this.getId() + ")   " + conexao.getInetAddress());
		} catch (Exception e) {
		}

	}
}
