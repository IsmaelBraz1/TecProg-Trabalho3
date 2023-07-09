package View;

import java.awt.*;

import javax.swing.*;

import View.include.*;
import View.style.*;

public class Game extends StylePanel{
	private HeaderGame header;
	private JPanel body;
	private CardLayout cardLayout;
	protected PlayerChoosed playerChoosed;
	protected PlayerGuess playerGuess;
	protected PlayerVotation playerVotation;
	
	public Game() {
		this.setPreferredSize(new Dimension(1060,650));
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = c.PAGE_START;
		c.gridy = 0;
		this.header = new HeaderGame();
		this.add(this.header,c);
		
		c.gridy = 1;
		c.anchor = c.CENTER;
		this.body = new JPanel();
		this.playerChoosed = new PlayerChoosed();
		this.playerGuess = new PlayerGuess();
		this.playerVotation = new PlayerVotation();
		
		this.body.setLayout(cardLayout = new CardLayout());
		this.body.add(this.playerChoosed,"CHOOSED");
		this.body.add(this.playerGuess,"GUESS");
		this.body.add(this.playerVotation,"VOTATION");
		
	
		this.add(this.body,c);
		cardLayout.show(body, "GUESS");
	}
	
	public HeaderGame getHeader() {
		return this.header;
	}
	
	public void setPlayerChoosedScreen() {
		cardLayout.show(this.body, "CHOOSED");
	}
	
	public void setPlayerGuessScreen() {
		cardLayout.show(this.body, "GUESS");
	}
	
	public void setPlayerVotationScreen() {
		cardLayout.show(this.body, "VOTATION");
	}
	
}
