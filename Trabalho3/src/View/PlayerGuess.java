package View;

import java.awt.*;

import javax.swing.*;

import View.include.*;
import View.include.Error;
import View.style.*;
import listeners.CardListeners;
import listeners.PlayerGuessSend;
import listeners.UpdatePlayerGuess;

public class PlayerGuess extends StylePanel {
	private JButton update;
	private JButton send;
	private HeaderGame header;
	private CardsPanel panel;
	private StyleLabel tip;
	
	public PlayerGuess() {
		this.setPreferredSize(new Dimension(1060,550));
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 2;
		c.gridy = 1;
		c.insets = new Insets(50, 0, 0, 0);
		this.panel = new CardsPanel(CardListeners.CARDGUESS);
		this.add(this.panel,c);
		
		c.gridy = 2;
		c.gridwidth = 1;
		c.insets = new Insets(20, 0, 0, 0);
		c.anchor = c.PAGE_START;
		this.tip =  new StyleLabel("");
		this.add(this.tip,c);
		
		
		this.send = new JButton("Escolher");
		this.send.addActionListener(new PlayerGuessSend(this));
		this.send.setEnabled(false);
		c.insets = new Insets(0, 10, 25, 10);
		c.anchor = c.LAST_LINE_END;
		c.gridwidth = 1;
		c.weightx = 1;
		
		
		c.gridy = 3;
		c.gridx = 1;
		this.add(this.send,c);
		
		c.gridx =0;
		c.anchor = c.LAST_LINE_START;
		this.update = new JButton("Atualizar");
		this.update.addActionListener(new UpdatePlayerGuess());
		this.add(this.update,c);
	}

	public CardsPanel getPanel() {
		return panel;
	}
	
	public StyleLabel getTipLabel() {
		return this.tip;
	}
	
	public void waitForChoosedPlayer(boolean state) {
		this.panel.lockAllCards(state);
		this.send.setEnabled(!state);
	}
}
