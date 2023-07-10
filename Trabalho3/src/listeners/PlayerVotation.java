package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.ControladorInterface;

public class PlayerVotation implements ActionListener{
	private View.PlayerVotation screen;
	
	public PlayerVotation(View.PlayerVotation screen) {
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
		ControladorInterface.getInstance().enviarVotoDaVez(cardFilepath);
		
	}

}
