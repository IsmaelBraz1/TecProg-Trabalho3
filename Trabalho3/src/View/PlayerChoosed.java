package View;

import java.awt.*;

import javax.swing.*;

import View.include.*;
import View.style.*;

public class PlayerChoosed extends StylePanel{
	private JButton send;
	private JTextField fieldTip;
	
	public PlayerChoosed() {
		this.setPreferredSize(new Dimension(1060,550));
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridwidth = 2;
		c.gridy = 1;
		c.insets = new Insets(50, 0, 0, 0);
		this.add(new CardsPanel(),c);
		
		this.fieldTip = new JTextField(80);
		this.fieldTip.setPreferredSize(new Dimension(50,24));
		this.send = new JButton("Enviar");
		c.gridy = 2;
		c.anchor = c.LINE_START;
		c.insets = new Insets(0, 15, 15, 0);
		this.add(new StyleLabel("Escreva uma dica aos outros jogadores:"),c);
		
		c.insets = new Insets(0, 0, 25, 0);
		c.anchor = c.PAGE_START;
		c.gridwidth = 1;
		c.weightx = 1;
		c.gridy = 3;
		this.add(this.fieldTip,c);
		
		c.gridx = 1;
		this.add(this.send,c);
	}
}


