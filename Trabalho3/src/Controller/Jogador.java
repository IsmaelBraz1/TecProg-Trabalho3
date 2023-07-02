package Controller;

public class Jogador {
	private int id;
	private String nome;
	private int pontos;
	private String[] cartas;
	private String cartaEscolhida;
	private boolean jogadorDaVez;
	public Jogador(int id, String nome) {
		super();
		this.id = id;
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
	
	
}
