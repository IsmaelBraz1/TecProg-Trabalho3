package View;

import java.awt.*;

import javax.swing.*;

import View.include.Header;
import View.include.Name;

public class TelaPrincipal extends JFrame{
	public TelaPrincipal() {
		super("Jogo de cartas");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new Menu());
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
}
