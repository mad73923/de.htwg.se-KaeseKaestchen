
public abstract class UI {
	
	KaeseKaestchen theControl;
	
	public	UI(KaeseKaestchen pTheControl){
		theControl = pTheControl;
	}
	
	abstract public void paintPlayingField();
	abstract public void showWelcomeScreen();

}
