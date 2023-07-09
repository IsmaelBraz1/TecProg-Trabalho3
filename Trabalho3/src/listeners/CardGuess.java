package listeners;

import java.awt.event.*;

import View.include.Card;
import View.include.CardsPanel;

public class CardGuess extends CardListener implements MouseListener {
	private String card; 
	private Card cardGUI;
	private CardsPanel panel;
	
	public CardGuess(String card,CardsPanel panel) {
		super(card);
		this.panel = panel;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		panel.markCard(this.getCardGUI());
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.getCardGUI().entered(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.getCardGUI().entered(false);
	}

}