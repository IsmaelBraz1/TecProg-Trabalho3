package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.ControladorInterface;
import View.PlayerGuess;

public class UpdatePlayerGuess implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ControladorInterface.getInstance().receberDica();
	}

}
