package Model;

import java.util.ArrayList;

import Controller.*;

public class Main {
	public static void main(String[] args) {
		ControladorInterface inter1 = new ControladorInterface();
		inter1.novoJogador("jogador 1");
		boolean verifica = false;
		//while (true) {
			if (inter1.jogador.isJogadorDaVez()) {
				System.out.println(inter1.jogador.getNome() + " é o jogador da vez");
				inter1.EnviarCartaDica("img/bb9", "é um robo");
			}else {
				while ( inter1.dicaDaVez.equals("")) {
					inter1.receberDica();
					if(!inter1.dicaDaVez.equals(""))
						System.out.println("a dica é : "+ inter1.dicaDaVez);
				}
			}

			
			while (verifica == false) {
				if (inter1.todosEscolheram() == true)
					verifica = true;
				else
					verifica = false;
			}

			inter1.pegarCartasRodada();
			ArrayList<String> cartasRodada = inter1.cartasRodada;
			System.out.println("as opcoes de voto sao: ");
			for (int i = 0; i < cartasRodada.size(); i++) {
				System.out.println(cartasRodada.get(i));
			}

			verifica = false;
			while (verifica == false) {
				if (inter1.todosVotaram() == true)
					verifica = true;
				else
					verifica = false;
			}

			System.out.println("a pontuacao do jogador foi: " + inter1.jogador.getPontos());

			inter1.proximaRodada();

		///}
	}
}
