package Controller;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		System.out.println("jogador 3");
		try {Thread.sleep(5000);} catch (InterruptedException e) {}
		ControladorInterface inter = new ControladorInterface();
		inter.novoJogador("jogador 3");
		inter.iniciarCliente("127.0.0.1");
		boolean verifica = false;
		while (true) {
			if (inter.jogador.isJogadorDaVez()) {
				System.out.println(inter.jogador.getNome() + " é o jogador da vez");
				inter.EnviarCartaDica("img/bb9", "é um robo");
				try {Thread.sleep(10000);} catch (InterruptedException e) {}
			}else {
				while (inter.dicaDaVez.equals("")) {
					inter.receberDica();
					if(!inter.dicaDaVez.equals(""))
						System.out.println("a dica é : "+ inter.dicaDaVez);
					
				}
				inter.enviarCarta("carta1");
			}
			
			
			while (verifica == false) {
				if (inter.todosEscolheram() == true)
					verifica = true;
				else
					verifica = false;
			}

			inter.pegarCartasRodada();
			ArrayList<String> cartasRodada = inter.cartasRodada;
			System.out.println("as opcoes de voto sao: ");
			for (int i = 0; i < cartasRodada.size(); i++) {
				System.out.println(cartasRodada.get(i));
			}
			inter.enviarVotoDaVez("carta1");
			verifica = false;
			while (verifica == false) {
				if (inter.todosVotaram() == true)
					verifica = true;
				else
					verifica = false;
			}

			System.out.println("a pontuacao do jogador foi: " + inter.jogador.getPontos());

			inter.proximaRodada();
			try {Thread.sleep(10000);} catch (InterruptedException e) {}
		}
	}
}
