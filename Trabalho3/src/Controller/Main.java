package Controller;

public class Main {

	public static void main(String[] args) {
		ControladorInterface inter2 = new ControladorInterface();
		inter2.novoJogador("jogador 2");
		if(inter2.jogador.isJogadorDaVez()) {
			System.out.println(inter2.jogador.getNome()+" é o jogador da vez");
		}
		inter2.receberDica();
		System.out.println(inter2.jogador.getDicaDaVez());
	}
}
