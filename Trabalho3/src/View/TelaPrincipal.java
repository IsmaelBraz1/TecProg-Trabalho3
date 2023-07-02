package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame{
	public TelaPrincipal() {
		this.setSize(1000, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		JPanel painelInferior = new JPanel();
		painelInferior.setLayout(new GridLayout(1,2));
		JTextField inputDica = new JTextField();
		painelInferior.add(inputDica);
		painelInferior.add(new JButton("enviar"));
		this.add(new PainelCartas(), BorderLayout.CENTER);
		this.add(painelInferior, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
}
