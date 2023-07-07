package View.include;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import View.style.StylePanel;
import listeners.NameMenu;

public class Name extends StylePanel {
	private JTextField nameField;
	private JButton nextButton;
	public Name() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JLabel nameLabel = new JLabel("Insira seu nome:");
		nameLabel.setForeground(this.colorText);
		this.nameField = new JTextField(20);
		this.nextButton  = new JButton("Avançar");
		
		c.insets =  new Insets(5, 0, 5, 0);
		c.gridy = 0;
		this.add(nameLabel,c);
		c.anchor = GridBagConstraints.BASELINE;
		c.gridy = 1;
		this.add(nameField,c);
		c.gridy = 2;
		this.add(nextButton,c);
		this.nextButton.addActionListener(new NameMenu(this.nameField));
	}
}
