package View;

import java.awt.*;

import javax.swing.JPanel;

import View.include.Header;
import View.include.MultiplayerSetup;
import View.include.Name;
import View.include.Waiting;
import View.style.StylePanel;

public class Menu extends StylePanel {
	CardLayout cards;
	JPanel panelCard;
	
	public Menu() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridy = 0;
		this.add(new Header(),c);
		c.gridy = 1;
		
		this.panelCard = new JPanel();
		
		panelCard.setLayout(this.cards = new CardLayout());
		
		panelCard.add(new Name(),"NAME");
		panelCard.add(new MultiplayerSetup(),"SETUP");
		panelCard.add(new Waiting(), "WAITING");
		
		this.add(panelCard,c);
		
		cards.show(panelCard,"NAME");
		this.setPreferredSize(new Dimension(300,260));
	}
	
	public void getNameScreen() {
		cards.show(this.panelCard,"NAME");
	}
	
	public void getSetupScreen() {
		cards.show(this.panelCard,"SETUP");
	}
	
	public void getWaitingScreen() {
		cards.show(this.panelCard,"WAITING");
	}
}
