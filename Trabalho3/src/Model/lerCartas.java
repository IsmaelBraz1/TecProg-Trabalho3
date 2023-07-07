package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class lerCartas {
	private ArrayList<String> lista;

	public lerCartas() {
		lista = new ArrayList<String>();
		try {
			FileReader arquivo = new FileReader("cartas/cartas.txt");
			try (BufferedReader leitura = new BufferedReader(arquivo)) {
				while (leitura.ready()) {
					lista.add(leitura.readLine());
				}
			}
		} catch (Exception e) {
		}
	}
	public ArrayList<String> getLista() {
		return lista;
	}
}
