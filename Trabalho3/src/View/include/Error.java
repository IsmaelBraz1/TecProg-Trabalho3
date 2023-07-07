package View.include;

import javax.swing.JOptionPane;

public class Error extends JOptionPane {
	
	public Error(String message) {
		this.showMessageDialog(this, message,"error",JOptionPane.ERROR_MESSAGE);
	}
}
