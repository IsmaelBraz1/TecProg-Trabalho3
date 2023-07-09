package listeners;

import java.awt.event.*;

import View.include.Card;
import View.include.CardsPanel;

public class CardChoosed extends CardListener implements MouseListener {
	private String card; 
	private CardsPanel panel;
	
	public CardChoosed(String card,CardsPanel panel) {
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
