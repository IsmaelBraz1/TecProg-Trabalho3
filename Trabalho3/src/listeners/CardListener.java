package listeners;

import java.awt.event.*;

import View.include.Card;

public class CardListener implements MouseListener {
	private String card; 
	private Card cardGUI;
	
	public CardListener(String card, Card cardGUI) {
		this.card = card;
		this.cardGUI = cardGUI;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicou");		
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.cardGUI.mark();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.cardGUI.unmark();
	}

}
