package View;

import Controller.ControladorInterface;
import listeners.NameMenu;

public class FacadeGUI {
	private TelaPrincipal screen;
	private NameMenu nameListener;
	
	public FacadeGUI(TelaPrincipal screen) {
		this.screen = screen;
		
	}
	
	public void nameWelcomeScreen() {
		this.screen.setMenu();
		this.screen.getMenu().getNameScreen();
	}
	
	public void connectAndHostScreen() {
		this.screen.setMenu();
		this.screen.getMenu().getSetupScreen();
	}
	
	public void waitingGameScreen() {}
	
	public void GameScreen() {
		
	}
	
	public void unlockSelectCards() {}
	
	public void setCards() {}
	
	public void setMessage() {}
	
	public void setPoints() {}
	
	public void setName() {}
	
	public void VotationScreen() {}
	
	public void RevealCard() {}
}
