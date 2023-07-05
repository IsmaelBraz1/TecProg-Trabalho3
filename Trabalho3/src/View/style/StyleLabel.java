package View.style;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class StyleLabel extends JLabel{
	protected final Color colorText = Color.decode("#ebf0f7");
	
	public StyleLabel(String text) {
		super(text);
		this.setFont(new Font("Arial", Font.BOLD, 14));
		this.setForeground(this.colorText);
	}
	
	public StyleLabel(String text, int size) {
		super(text);
		this.setFont(new Font("Arial", Font.BOLD, size));
		this.setForeground(this.colorText);
	}
}
