package listeners;

import java.awt.event.*;

import View.include.Card;
import View.include.CardsPanel;

public class CardVotation extends CardListener implements MouseListener {
	private CardsPanel panel;
	
	public CardVotation(String card, CardsPanel panel) {
		super(card);
		this.panel = panel;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		this.panel.markCard(this.getCardGUI());	
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