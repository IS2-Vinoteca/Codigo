package presentacion;

public class Controller {

	private MainWindow mainWindow;
	
	public Controller(MainWindow mainWindow) {
		
		this.mainWindow = mainWindow;
		
	}
	
	public void showMenuPrincipalWindow() {
		new MenuPrincipalWindow(this);
	}
}