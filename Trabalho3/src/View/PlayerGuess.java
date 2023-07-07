package View;

import java.awt.*;

import javax.swing.*;

import View.include.*;
import View.include.Error;
import View.style.*;

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
		this.panel = new CardsPanel();
		this.add(this.panel,c);
		
		c.gridy = 2;
		c.gridwidth = 1;
		c.insets = new Insets(20, 0, 0, 0);
		c.anchor = c.PAGE_START;
		this.tip =  new StyleLabel("A dica é : Lorem Ipsun dolor sit...");
		this.add(this.tip,c);
		
		
		this.send = new JButton("Escolher");
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
		this.add(this.update,c);
	}
	
}
