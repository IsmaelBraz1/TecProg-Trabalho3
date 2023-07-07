package Model;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Controller.ControladorGeral;
import Controller.*;

public class FluxoDados extends Thread {
	Socket conexao;

	public FluxoDados(Socket conect) {
		this.conexao = conect;
	}

	public void run() {
		try {
			ControladorGeral control = ControladorGeral.getInstance();
			// fluxo de dados do cliente para comunicar e enviar o objeto
			ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());
			// pega o objeto vindo do cliente
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
				ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
				saida.writeObject(objeto);
			}
			if(objeto.operacao == 4) {
				control.receberCartas(objeto);
			}
			if(objeto.operacao == 5) {
				control.VerificarEscolheram(objeto);
				ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
				saida.writeObject(objeto);
			}
			if(objeto.operacao == 6) {
				objeto.cartasRodada = control.getCartasDaRodada();
				ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
				saida.writeObject(objeto);
			}
			if(objeto.operacao == 7) {
				control.ComputarVotosJogadores(objeto);
				ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
				saida.writeObject(objeto.jogador);
			}
			if(objeto.operacao == 8) {
				control.VerificarTodosVotaram(objeto);
				ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
				saida.writeObject(objeto);
			} 
			if(objeto.operacao == 9) {
				control.proximaRodada(objeto.jogador);
				ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
				saida.writeObject(objeto.jogador);
			}
			if(objeto.operacao == 10) {
				control.getPontuacao(objeto);
				ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
				saida.writeObject(objeto);
			}
			conexao.close();
		} catch (Exception e) {
			System.out.println("erro no fluxo de dados "+e);
		}
	}
}
