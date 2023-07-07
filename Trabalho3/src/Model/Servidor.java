package Model;

import java.net.ServerSocket;

public class Servidor {

	public static void main(String[] args) {
		try (ServerSocket servidor = new ServerSocket(500)) {
			System.out.println("servidor iniciado");
			while (true) {
				FluxoDados fluxo = new FluxoDados(servidor.accept());
				fluxo.start();
			}
		} catch (Exception e) {
			System.out.println("erro no servidor"+e);
		}
	}

}
