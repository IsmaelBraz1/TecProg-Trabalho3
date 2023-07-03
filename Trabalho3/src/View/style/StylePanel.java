package View.style;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class StylePanel extends JPanel {
	protected final Color colorText = Color.decode("#ebf0f7");
	public StylePanel() {
		this.setBackground(Color.BLACK);
	}
}
