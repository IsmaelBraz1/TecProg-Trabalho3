package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.ControladorInterface;

public class PlayerChoosed implements ActionListener{
	private View.PlayerChoosed screen;
	
	public PlayerChoosed(View.PlayerChoosed screen) {
		this.screen = screen;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String tip = null;
		String cardFilepath = null;
		try {
			tip = this.screen.getFieldTip().getText();
			cardFilepath = this.screen.getPanel().getMarkCard().getListener().getCard();
		} catch (Exception e2) {
			// TODO: handle exception
		}
		ControladorInterface.getInstance().EnviarCartaDica(cardFilepath, tip);
		
	}

}
