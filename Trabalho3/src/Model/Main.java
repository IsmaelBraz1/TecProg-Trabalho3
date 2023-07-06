package Model;
import Controller.*;
public class Main {
	public static void main(String[] args) {
		ControladorInterface inter1 = new ControladorInterface();
		inter1.novoJogador("jogador 1");
		if(inter1.jogador.isJogadorDaVez()) {
			System.out.println(inter1.jogador.getNome()+" é o jogador da vez");
			inter1.EnviarCartaDica("img/bb9", "é um robo");
		}
		try {
			//Thread.sleep(10000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		int i=0;
		if(inter1.todosEscolheram() == true) {
			System.out.println("todos escolheram :)");
			
		}
		/*for(int i=0;i<5;i++) {
			System.out.println(inter1.jogador.getCartas()[i]);
		}
		/*ControladorInterface inter3 = new ControladorInterface();
		inter3.novoJogador("jogador 3");
		ControladorInterface inter4 = new ControladorInterface();
		inter4.novoJogador("jogador 4");
		try {
			Thread.sleep(15000);
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		//ListaJogadores lista = ListaJogadores.getInstance();
		//lista.getListaJogadores().get(0).getNome();
		//ControladorGeral geral = new ControladorGeral();
		//System.out.println(lista.getListaJogadores().get(0).getNome());
		/*//Cliente cliente1 = new Cliente();
		//Cliente cliente3 = new Cliente("oi, sou o cliente 3");
		ControladorGeral control = new ControladorGeral();
		control.AdicionarJogador("jogador 1");
		control.AdicionarJogador("jogador 2");
		control.AdicionarJogador("jogador 3");
		control.AdicionarJogador("jogador 4");
		control.AdicionarJogador("jogador 5");
		ControladorGeral control1 = new ControladorGeral();
		for(int i = 0;i<5;i++) {
			if(control.getJogadores().getListaJogadores().get(i).isJogadorDaVez()) {
				System.out.println(control1.getJogadores().getListaJogadores().get(i).getNome());
			}
		}
		control.proximaRodada();
		new Cliente(control.getJogadores().getListaJogadores().get(2));
		//control.AdicionarJogador("jogador 6");
		//control.AdicionarJogador("jogador 7");
	//	control.AdicionarJogador("jogador 8");
		//control.AdicionarJogador("jogador 9");
		//control.AdicionarJogador("jogador 10");
		for(int i = 0;i<5;i++) {
			if(control.getJogadores().getListaJogadores().get(i).isJogadorDaVez()) {
				System.out.println(control1.getJogadores().getListaJogadores().get(i).getNome());
			}
		}
	*/	
	}
}
