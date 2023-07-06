package View.include;

import java.awt.*;
import java.awt.image.*;

import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;

import View.style.StylePanel;
import listeners.CardListener;

public class Card extends JLabel {
	private ImageIcon cardImage;
	private final Color colorOverlaySelect = new Color(0, 0, 0, 150);
	private boolean mark;
	private boolean lock;
	
	public Card(String imageFilePath) {
		this.lock(true);
		ImageIcon imageCard = new ImageIcon(imageFilePath);
		this.cardImage = new ImageIcon(imageCard.getImage().getScaledInstance(150, 240, java.awt.Image.SCALE_SMOOTH ));
		this.addMouseListener(new CardListener(imageFilePath,this));
		this.setIcon(this.cardImage);
		this.repaint();
	
	}
	
	public void mark(boolean state) {
		this.mark = state;
		this.repaint();
	}
	
	
	public void lock(boolean state) {
		this.lock = state;
		if(state) {
			this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}else {
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}
		this.repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
		if(lock) {
			g2.drawImage(this.lockImageOverlay(), 0, 0, null);
		}else {
			if(mark) {
				 g2.setColor(this.colorOverlaySelect);
			     g2.fillRect(0, 0, getWidth(), getHeight());
			}
		}
        g2.dispose();
	}
	
	public Image lockImageOverlay() {
		String filepath = "img/lock_card.png";
		
		try {
			BufferedImage lockImage = ImageIO.read(new File(filepath));
			int height = lockImage.getHeight();
			int width = lockImage.getWidth();
			BufferedImage bufImage = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
			int [] imagePixels = lockImage.getRGB(0, 0, width, height, null, 0, width);
			
			for(int i=0;i<height*width;i++) {
				int pixel = imagePixels[i];
				pixel = pixel & 0x80ffffff;
				imagePixels[i] = pixel;
			}
			bufImage.setRGB(0, 0, width, height, imagePixels, 0, width);
		
			return bufImage.getScaledInstance(150, 240, BufferedImage.SCALE_SMOOTH);
		} catch (Exception e) {
			return null;
		}
		
		
	}
}
