package Model;

import java.io.IOException;
import java.net.ServerSocket;

public class Servidor extends Thread {
	ServerSocket servidor;
	public Servidor(int porta) {
		try {
			servidor = new ServerSocket(porta);
		} catch (Exception e) {
			System.out.println("erro no servidor" + e);
		}
	}

	public void run() {
		System.out.println("servidor iniciado");
		while (true) {
			try {
				FluxoDados fluxo = new FluxoDados(servidor.accept());
				fluxo.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
