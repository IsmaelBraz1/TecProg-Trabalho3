package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controller.ControladorInterface;

public class HostAGame implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		ControladorInterface.getInstance().iniciarHost();
		
	}

}
