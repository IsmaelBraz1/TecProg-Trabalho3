package Controller;

import java.io.Serializable;
import java.util.ArrayList;

public class Mensagem implements Serializable {
	private static final long serialVersionUID = 1L;
	public Jogador jogador;
	public int IDjogador;
	public String carta;
	public String dica;
	public String votoDaVez;
	public int operacao;
	public int pontuacao;
	public boolean todosEscolheram = false;
	public boolean todosVotaram = false;
	public ArrayList<String> cartasRodada;
}
