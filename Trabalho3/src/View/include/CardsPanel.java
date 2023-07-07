package View.include;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import View.style.StylePanel;
import listeners.CardChoosed;
import listeners.CardGuess;
import listeners.CardListener;
import listeners.CardListeners;
import listeners.CardVotation;

public class CardsPanel extends StylePanel {
		private ArrayList<Card> cards;
		private CardListeners listenerEnum;
		private MouseListener listener;
		
	public CardsPanel(CardListeners listener) {
		this.listenerEnum = listener;
		String[] cards = new String[] {"img/aluno.png","img/bug.png","img/C3po.png","img/r2d2.png","img/bb8.png","img/C3po.png"};
		//cards = null;
		this.cards = new ArrayList<Card>();
		this.setPreferredSize(new Dimension(1060,390));
		this.setCartas(cards);
	}
	
	public void setCartas(String[] filepathCards ) {
		if(filepathCards == null) 
			return;
		
		for (String filepath : filepathCards) {
			CardListener cardListener = cardListener(this.listenerEnum, filepath);
			Card card = new Card(filepath,cardListener);
			this.cards.add(card);
			this.add(card);
		}
	}
	
	//não é uma boa prática
	public CardListener cardListener(CardListeners cardListener, String filepath) {
		if(cardListener == cardListener.CARDCHOOSED)
			return new CardChoosed(filepath);
		if(cardListener == cardListener.CARDGUESS)
			return new CardGuess(filepath);
		if(cardListener == cardListener.CARDVOTATION)
			return new CardVotation(filepath);
		return null;
	}
}