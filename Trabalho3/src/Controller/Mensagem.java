package Controller;

import java.io.Serializable;

public class Mensagem implements Serializable {
	public Jogador jogador;
	public String carta;
	public String dica;
	public int operacao;
	public boolean todosEscolheram = false;
}
