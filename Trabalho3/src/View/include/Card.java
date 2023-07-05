package View.include;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.*;

import View.style.StylePanel;
import listeners.CardListener;

public class Card extends JLabel {
	private ImageIcon cardImage;
	private final Color colorOverlaySelect = new Color(0, 0, 0, 150);
	private boolean mark;
	
	public Card(String imageFilePath) {
		ImageIcon imageCard = new ImageIcon(imageFilePath);
		this.cardImage = new ImageIcon(imageCard.getImage().getScaledInstance(150, 240, java.awt.Image.SCALE_SMOOTH ));
		this.addMouseListener(new CardListener(imageFilePath,this));
		this.setIcon(this.cardImage);
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.repaint();
	}
	
	public void mark() {
		this.mark = true;
		this.repaint();
	}
	
	public void unmark() {
		this.mark = false;
		this.repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
		if(mark) {
			 g2.setColor(this.colorOverlaySelect);
		     g2.fillRect(0, 0, getWidth(), getHeight());
		}
        g2.dispose();
	}
}
