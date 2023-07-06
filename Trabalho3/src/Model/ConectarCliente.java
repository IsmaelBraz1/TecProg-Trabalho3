package Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import Controller.*;
public class ConectarCliente extends Thread{
	Socket cliente;
	public ConectarCliente(Socket cli) {
		this.cliente = cli;
	}
	
	public void run() {
		try {
			System.out.println("Cliente conectado com thread ("+this.getId()+")  :" + cliente.getInetAddress());
			
			//fluxo de dados do cliente para comunicar e enviar o objeto
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			
			//pega o objeto(jogador) vindo do cliente
			Jogador objeto = (Jogador) entrada.readObject();
			System.out.println(objeto.getNome() +" id: " +objeto.getId());
			
			//faz as alteracoes no objeto
			ControladorGeral control = ControladorGeral.getInstance();
			 control.AdicionarJogador(objeto);
			//control.defineJogadorVez(objeto);
			
			ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
			saida.writeObject(objeto);
			//Thread.sleep(10000);
			cliente.close();
			System.out.println("cliente finalizado("+this.getId()+")   " + cliente.getInetAddress());
		} catch (Exception e) {
		}
		
	}
}
