package View.include;

import java.awt.*;
import java.util.ArrayList;

import View.style.StylePanel;

public class CardsPanel extends StylePanel{
		private ArrayList<Card> cards;
	public CardsPanel() {
		String[] cards = new String[] {"img/aluno.png","img/bug.png","img/C3po.png","img/r2d2.png","img/bb8.png","img/C3po.png"};
		this.cards = new ArrayList<Card>();
		this.setPreferredSize(new Dimension(1060,410));
		this.setCartas(cards);
	}
	
	public void setCartas(String[] filepathCards ) {
		if(filepathCards == null) 
			return;
		for (String filepath : filepathCards) {
			Card card = new Card(filepath);
			this.cards.add(card);
			this.add(card);
		}
	}
}