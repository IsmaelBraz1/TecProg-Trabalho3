package listeners;

import java.awt.event.*;

import View.include.Card;

public class CardVotation extends CardListener implements MouseListener {
	
	public CardVotation(String card) {
		super(card);
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
		this.getCardGUI().mark(true);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.getCardGUI().mark(false);
	}

}