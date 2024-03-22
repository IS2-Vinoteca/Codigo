package presentacion;

public class Controller {

	private MainWindow mainWindow;
	private ModeloConsulta modelo;
	
	public Controller(MainWindow mainWindow) {
		
		this.mainWindow = mainWindow;
		
	}
	
	public void showMenuPrincipalWindow() {
		new MenuPrincipalWindow(this);
	}
}