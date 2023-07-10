package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.*;
import View.include.Card;
import listeners.NameMenu;

public class FacadeGUI {
	private TelaPrincipal screen;
	private NameMenu nameListener;
	
	public FacadeGUI(TelaPrincipal screen) {
		this.screen = screen;
		
	}
	
	public void nameWelcomeScreen() {
		this.screen.setMenu();
		this.screen.getMenu().getNameScreen();
	}
	
	public void connectAndHostScreen() {
		this.screen.setMenu();
		this.screen.getMenu().getSetupScreen();
	}
	
	public void waitingGameScreen() {}
	
	public void GameScreen(Jogador player) {
		this.screen.setGame();
		if(player.isJogadorDaVez()) {
			this.screen.getGame().playerChoosed.waitOtherPlayers(false);
			this.screen
			.getGame()
			.setPlayerChoosedScreen();
			this.screen.getGame().playerChoosed.getPanel().setCartas(new ArrayList<>(Arrays.asList(player.getCartas())));
		}else {
			this.screen.getGame().playerGuess.getPanel().setCartas(new ArrayList<>(Arrays.asList(player.getCartas())));
			this.screen
			.getGame()
			.setPlayerGuessScreen();
			this.SelectionByOtherPlayers(false,"");
		}
		this.setPlayer(player);
	}
	
	public void SelectionByOtherPlayers(boolean state, String tip) {
		this.screen
		.getGame()
		.playerGuess
		.waitForChoosedPlayer(!state);
		if(!tip.isEmpty())
			this.setTipToGuess(tip);
	}
	
	public void waitOthersSelect() {
		this.screen.getGame().playerChoosed.waitOtherPlayers(true);
		Timer timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ControladorInterface.getInstance().todosVotaram()) {
					((Timer)e.getSource()).stop();
					RestartGame();
				}
				
			}
		});
		timer.start();
	}
	
	public void setCards(String [] cardsFilepath) {
		
	}
	
	public void setMessage(String message) {
		this.screen.getGame().getHeader().setMessage(message);
	}

	public void setPlayer(Jogador player) {
		this.screen.getGame().getHeader().setjogador(player);
	}
	
	public void setTipToGuess(String tip) {
		this.screen.getGame().playerGuess.getTipLabel().setText("A dica é :"+tip);
	}
	
	public void VotationScreen() {
		this.screen.getGame().setPlayerVotationScreen();
	}
	
	public void setCardsToVotation(ArrayList<String> cardsFilepath) {
		this.screen.getGame().playerVotation.getPanel().setCartas(cardsFilepath);
	}
	
	public void RevealCard(String cardFilepath) {
		
		for (Card card : this.screen.getGame().playerChoosed.getPanel().getCards()) {
			card.emphasis(card.getListener().getCard().equals(cardFilepath) );
			card.SetEnabled(false);
		}
	}
	
	public void RestartGame() {
		this.setMessage("Nova partida iniciando em 10 segundos");
		Timer timer = new Timer(10000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorInterface.getInstance().proximaRodada();
				GameScreen(ControladorInterface.getInstance().jogador);		
				setMessage("");
				((Timer)e.getSource()).stop();
			}
		});
		timer.start();
	}
}
