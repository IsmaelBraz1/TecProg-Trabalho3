package Controller;

public class Main {

	public static void main(String[] args) {
		ListaJogadores lista1 = ListaJogadores.getInstance();
		//System.out.println(lista1.numJogadores());
		ListaJogadores lista2 = ListaJogadores.getInstance();
		//System.out.println(lista2.numJogadores());
		ListaJogadores lista3 = ListaJogadores.getInstance();
		//System.out.println(lista3.numJogadores());
		lista1.NovoJogador("jogador1");
		lista2.NovoJogador("jogador2");
		lista1.NovoJogador("jogador3");
		lista2.definirSequencia();
		System.out.println(lista3.getListaJogadores().get(2).getNome());
	}

}
