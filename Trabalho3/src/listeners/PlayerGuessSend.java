package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.ControladorInterface;
import View.PlayerGuess;

public class PlayerGuessSend implements ActionListener {
	private PlayerGuess screen;
	
	public PlayerGuessSend(PlayerGuess screen) {
		this.screen = screen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cardFilepath = null;
		try {
			cardFilepath = this.screen.getPanel().getMarkCard().getListener().getCard();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		ControladorInterface.getInstance().enviarCarta(cardFilepath);
	}

}
