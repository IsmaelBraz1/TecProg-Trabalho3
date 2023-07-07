package View.include;

import javax.swing.JLabel;

import View.style.StylePanel;

public class Waiting extends StylePanel {
	public Waiting() {
		JLabel text  = new JLabel("<html><h3>Esperando por jogadores...</h3></html>");
		text.setForeground(this.colorText);
		this.add(text);
	}
}
