package View.include;

import java.awt.*;

import javax.swing.*;

import Controller.Jogador;
import View.style.StyleLabel;
import View.style.StylePanel;

public class HeaderGame extends StylePanel {
	private final int fontSize = 17;
	private StyleLabel playerStatus;
	private StyleLabel points;
	private StyleLabel message;
	
	public HeaderGame() {
		this.setPreferredSize(new Dimension(1060,100));
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		int horizontalGap = 25;
		c.insets = new Insets(10, horizontalGap, 10, horizontalGap);
		c.weightx  = 0.5;
		
		c.anchor = GridBagConstraints.LINE_START;
		this.playerStatus = new StyleLabel("Você é o jogador da vez!",this.fontSize);
		this.add(this.playerStatus,c);
		
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 1;
		this.message = new StyleLabel("",this.fontSize);
		this.add(this.message,c);
		
		c.anchor = GridBagConstraints.LINE_END;
		c.gridx = 2;
		this.points = new StyleLabel("Pontos: 0",this.fontSize);
		this.add(this.points,c);
	}
	
	public void setMessage(String message) {
		this.message.setText(message);
	}
	
	
	public void setjogador(Jogador player) {
		if(player.isJogadorDaVez()) {
			this.playerStatus.setText("Você é o jogador da vez!");
		}else {
			this.playerStatus.setText(player.getNome());
		}
		
		this.points.setText("Pontos:"+player.getPontos());
	}
}
