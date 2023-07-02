package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Controller.*;
public class PainelCartas extends JPanel{
	public PainelCartas() {
		this.setLayout(new GridLayout(1,6));
		this.setBackground(Color.cyan);
		String[] Cartas = new SorteioCartas().sorteio();
		JLabel carta1 = new JLabel();
		JLabel carta2 = new JLabel();
		JLabel carta3 = new JLabel();
		JLabel carta4 = new JLabel();
		JLabel carta5 = new JLabel();
		JLabel carta6 = new JLabel();
		carta1.setIcon(new ImageIcon(Cartas[0]));
		carta2.setIcon(new ImageIcon(Cartas[1]));
		carta3.setIcon(new ImageIcon(Cartas[2]));
		carta4.setIcon(new ImageIcon(Cartas[3]));
		carta5.setIcon(new ImageIcon(Cartas[4]));
		this.add(carta1);
		this.add(carta2);
		this.add(carta3);
		this.add(carta4);
		this.add(carta5);
		this.add(carta6);
	}
}
