package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import Controller.ControladorInterface;

public class NameMenu implements ActionListener {
	private JTextField fieldName;

	public NameMenu(JTextField fieldName) {
		this.fieldName = fieldName;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ControladorInterface.getInstance().novoJogador(this.fieldName.getText());
		
		
	} 

}
