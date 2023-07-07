package View.include;

import javax.swing.*;

public class IPInput extends JOptionPane {
	
	private String ip;
	
	public IPInput() {
		this.ip = this.showInputDialog("Insira o IP:","127.0.0.1");
	}
	
	public String getIP() {
		return this.ip;
	}
}
