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
	private Image image;
	private CardListener listener;
	private Dimension cardSize;
	private boolean mark;
	private boolean lock;
	private boolean enabled;
	
	public Card(String imageFilePath) {
		ImageIcon imageCard = new ImageIcon(imageFilePath);
		try {
			this.image = ImageIO.read(new File(imageFilePath));
		} catch (Exception e) {
			System.out.println("Problema ao ler a imagem da carta");
			return;
		}
		this.listener = new CardListener(imageFilePath,this);
		this.cardSize = new Dimension(150, 240);
		this.setIcon(new ImageIcon(image.getScaledInstance((int)this.cardSize.getWidth(), (int)this.cardSize.getHeight(), java.awt.Image.SCALE_SMOOTH )));
		this.lock(true);	
		this.emphasis(false);
		this.repaint();
		
	}
	
	public void mark(boolean state) {
		this.mark = state;
		this.repaint();
	}
	
	public void SetEnabled (boolean state) {
		if(state) {
			this.enabled = true;
			this.addMouseListener(this.listener);
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}else {
			this.enabled = false;
			this.addMouseListener(null);
			this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}	
	}
	
	public void emphasis(boolean state) {
		if(state) {
			this.cardSize = new Dimension(150, 240);
		}else {
			this.cardSize = new Dimension(113,180);
		}
		
		this.setIcon(new ImageIcon(image.getScaledInstance((int)this.cardSize.getWidth(), (int)this.cardSize.getHeight(), java.awt.Image.SCALE_SMOOTH )));
		this.repaint();
	}
	
	
	public void lock(boolean state) {
		this.lock = state;
		this.SetEnabled(!state);
		this.repaint();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		final Color colorOverlaySelect = new Color(0, 0, 0, 150);
		Graphics2D g2 = (Graphics2D) g.create();
		if(lock) {
			g2.drawImage(this.lockImageOverlay(), 0, 0, null);
		}else {
			if(mark) {
				 g2.setColor(colorOverlaySelect);
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
				pixel = pixel & 0xa0ffffff;
				imagePixels[i] = pixel;
			}
			bufImage.setRGB(0, 0, width, height, imagePixels, 0, width);
		
			return bufImage.getScaledInstance((int)this.cardSize.getWidth(), (int)this.cardSize.getHeight(), BufferedImage.SCALE_SMOOTH);
		} catch (Exception e) {
			return null;
		}
		
		
	}
}
