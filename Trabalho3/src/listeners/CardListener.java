package listeners;

import View.include.Card;

public abstract class CardListener {
	private String card; 
	private Card cardGUI;
	
	public CardListener(String card) {
		this.card = card;
		this.cardGUI = null;
	}
	
	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public Card getCardGUI() {
		return cardGUI;
	}

	public void setCardGUI(Card cardGUI) {
		this.cardGUI = cardGUI;
	}
}
