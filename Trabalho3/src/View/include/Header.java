package View.include;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

import View.style.StylePanel;

public class Header extends StylePanel {
	
	public Header() {
		String headerText = "<htmL>"
				+ "<h1>Jogo de Cartas</h1>\n"
				+ "<hr>\n"
				+ "<strong>Ismael</strong>\n"
				+ "<strong>Pedro</strong>\n"
				+ "<strong>Marcelo</strong>\n"
				+ "<strong>Caio</strong>\n"
				+ "</html>";
		
		JLabel title = new JLabel(headerText);
		title.setForeground(this.colorText);
		title.setFont(new Font("Serif", Font.PLAIN, 14));
		title.setPreferredSize(new Dimension(200, 100));
		this.add(title);
		this.setVisible(true);
		
	}
}
