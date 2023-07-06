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
		//ControladorInterface inter = new ControladorInterface();
		//ListaJogadores lista = new ListaJogadores();
		//lista.getListaJogadores().get(0).getNome();
		//ControladorGeral geral = new ControladorGeral();
		//System.out.println(lista.getListaJogadores().get(0).getNome());
		
		/*inter.novoJogador("jogador 1");
		inter.novoJogador("jogador 2");
		inter.novoJogador("jogador 3");
		inter.novoJogador("jogador 4");
		try {
			Thread.sleep(15000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		/*ListaJogadores lista1 = ListaJogadores.getInstance();
		//System.out.println(lista1.numJogadores());
		ListaJogadores lista2 = ListaJogadores.getInstance();
		//System.out.println(lista2.numJogadores());
		ListaJogadores lista3 = ListaJogadores.getInstance();
		//System.out.println(lista3.numJogadores());
		lista1.NovoJogador("jogador1");
		lista2.NovoJogador("jogador2");
		lista1.NovoJogador("jogador3");
		lista2.definirSequencia();
		System.out.println(lista3.getListaJogadores().get(2).getNome());*/
	}

}
