package View;

import java.awt.*;

import javax.swing.*;

import View.include.Header;
import View.include.HeaderGame;
import View.include.Name;

public class TelaPrincipal extends JFrame{
	private static TelaPrincipal instance;
	private JPanel body;
	private Menu menu;
	private Game game;
	
	private TelaPrincipal() {
		super("Jogo de cartas");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		this.menu = new Menu();
		this.game = new Game();
		
		this.body = this.menu;
		this.add(this.body);
		
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static TelaPrincipal getInstance() {
		if(instance == null) {
			instance = new TelaPrincipal();
			return instance;
		}
		return instance;
	}
	
	public void setMenu() {
		this.remove(this.body);
		this.body = this.menu;
		this.add(this.body);
		this.revalidate();
		this.repaint();
		this.pack();
	}
	
	public void setGame() {
		this.remove(this.body);
		this.body = this.game;
		this.add(this.body);
		this.revalidate();
		this.repaint();
		this.pack();
	}
}
