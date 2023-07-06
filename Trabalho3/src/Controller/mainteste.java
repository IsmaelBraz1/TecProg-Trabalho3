package Controller;

public class mainteste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ControladorInterface inter3 = new ControladorInterface();
		inter3.novoJogador("jogador 3");
		if(inter3.jogador.isJogadorDaVez()) {
			System.out.println(inter3.jogador.getNome()+" é o jogador da vez");
		}
	}

}
