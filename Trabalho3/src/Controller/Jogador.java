package Controller;

import java.io.Serializable;

import Model.Conexao;

public class Jogador implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String nome;
	private int pontos;
	private String[] cartas;
	private String cartaEscolhida;
	private String dica="";
	private String dicaDaVez="";
	private boolean jogadorDaVez;
	private String votoDaVez;
	private Mensagem msg;
	public Jogador(String nome) {
		super();
		this.nome = nome;
		this.pontos = 0;
		this.jogadorDaVez = false;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public String[] getCartas() {
		return cartas;
	}
	public void setCartas(String[] cartas) {
		this.cartas = cartas;
	}
	public String getCartaEscolhida() {
		return cartaEscolhida;
	}
	public void setCartaEscolhida(String cartaEscolhida) {
		this.cartaEscolhida = cartaEscolhida;
	}
	public boolean isJogadorDaVez() {
		return jogadorDaVez;
	}
	public void setJogadorDaVez(boolean jogadorDaVez) {
		this.jogadorDaVez = jogadorDaVez;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDica() {
		return dica;
	}
	public void setDica(String dica) {
		this.dica = dica;
	}

	public String getDicaDaVez() {
		return dicaDaVez;
	}

	public void setDicaDaVez(String dicaDaVez) {
		this.dicaDaVez = dicaDaVez;
	}

	public String getVotoDaVez() {
		return votoDaVez;
	}

	public void setVotoDaVez(String votoDaVez) {
		this.votoDaVez = votoDaVez;
	}
	
	
}
