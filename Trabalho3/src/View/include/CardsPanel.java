package View.include;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import View.style.StylePanel;
import listeners.CardChoosed;
import listeners.CardGuess;
import listeners.CardListener;
import listeners.CardListeners;
import listeners.CardVotation;

public class CardsPanel extends StylePanel {
		private ArrayList<Card> cards;
		private Card markCard;
		private CardListeners listenerEnum;
		private MouseListener listener;
		
	public CardsPanel(CardListeners listener) {
		//String[] cards = new String[] {"img/aluno.png","img/bug.png","img/C3po.png","img/r2d2.png","img/bb8.png","img/C3po.png"};
		this.listenerEnum = listener;
		this.markCard = null;
		cards = null;
		this.cards = new ArrayList<Card>();
		this.setPreferredSize(new Dimension(1060,390));
	}
	
	public void setCartas(ArrayList<String>filepathCards  ) {
		if(filepathCards == null) 
			return;
		
		
		for (Card card : this.cards) {
			this.remove(card);
		}
		
		this.cards = new ArrayList<Card>();
		this.repaint();
		this.revalidate();
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
			return new CardChoosed(filepath,this);
		if(cardListener == cardListener.CARDGUESS)
			return new CardGuess(filepath,this);
		if(cardListener == cardListener.CARDVOTATION)
			return new CardVotation(filepath,this);
		return null;
	}
	
	public void lockAllCards(boolean state) {
		for (Card card : cards) {
			card.lock(state);
		}
	}
	
	public void markCard(Card card) {
		this.markCard = card;
		for (Card cardI : cards) {
			if(cardI == this.markCard) {
				cardI.mark(true);
			}else {
				cardI.mark(false);
			}
		}
	}
	

	public ArrayList<Card> getCards() {
		return cards;
	}

	public Card getMarkCard() {
		return markCard;
	}
	
}