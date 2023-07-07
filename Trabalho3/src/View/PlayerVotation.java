package View;

import java.awt.*;

import View.include.*;
import View.style.*;
import listeners.CardListeners;

public class PlayerVotation extends StylePanel {
	private CardsPanel panel;
	
	public PlayerVotation() {
		this.setPreferredSize(new Dimension(1060,550));
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(50, 10, 40, 0);
		c.anchor = c.PAGE_START;
		StyleLabel text = new StyleLabel("Vote na carta que melhor se encaixa a dica");
		this.add(text,c);
		
		c.insets = new Insets(0, 0, 0, 0);
		c.anchor = c.CENTER;
		c.gridy = 1;
		c.gridwidth = 2;
		this.panel = new CardsPanel(CardListeners.CARDVOTATION);
		this.add(this.panel,c);
	}
	
}
