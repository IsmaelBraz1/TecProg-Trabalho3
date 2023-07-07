package View.include;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import View.style.StylePanel;

public class Name extends StylePanel {
	public Name() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JLabel nameLabel = new JLabel("Insira seu nome:");
		nameLabel.setForeground(this.colorText);
		JTextField nameField = new JTextField(20);
		JButton nextButton  = new JButton("Avançar");
		
		c.insets =  new Insets(5, 0, 5, 0);
		c.gridy = 0;
		this.add(nameLabel,c);
		c.anchor = GridBagConstraints.BASELINE;
		c.gridy = 1;
		this.add(nameField,c);
		c.gridy = 2;
		this.add(nextButton,c);
	}
}
