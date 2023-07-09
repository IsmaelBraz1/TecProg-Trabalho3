package View.include;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;

import View.style.StylePanel;
import listeners.HostAGame;
import listeners.JoinAGame;

public class MultiplayerSetup extends StylePanel {
	
	public MultiplayerSetup() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(5, 0, 5, 0);
		c.anchor = GridBagConstraints.WEST;
		c.weightx  =2;
		JButton hostGameButton = new JButton("Host o jogo");
		hostGameButton.addActionListener(new HostAGame());
		this.add(hostGameButton,c);
		c.gridy = 1;
		JButton joinGameButton = new JButton("Junte-se a um jogo");
		joinGameButton.addActionListener(new JoinAGame());
		this.add(joinGameButton,c);
	}
}
