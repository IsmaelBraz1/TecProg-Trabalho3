package Model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(500);
			System.out.println("servidor iniciado");

			while (true) {
				// cria uma Thread para o cliente
				// ConectarCliente cc = new ConectarCliente(servidor.accept());
				// cc.start();

				Trafego trafego = new Trafego(servidor.accept());
				trafego.start();
			}
		} catch (Exception e) {
			System.out.println("erro no servidor");
		}
	}

}
