package View;

import java.awt.*;

import javax.swing.*;

import View.include.*;
import View.style.*;

public class Game extends StylePanel{
	private HeaderGame header;
	private JPanel body;
	private CardLayout cardLayout;
	
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
		this.body.setLayout(cardLayout = new CardLayout());
		this.body.add(new PlayerChoosed(),"CHOOSED");
		this.body.add(new PlayerGuess(),"GUESS");
		this.body.add(new PlayerVotation(),"VOTATION");
		
	
		this.add(this.body,c);
		cardLayout.show(body, "GUESS");
	}
	
	public HeaderGame getHeader() {
		return this.header;
	}
}
