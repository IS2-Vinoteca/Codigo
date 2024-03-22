package presentacion;

public class Controller {

	private MainWindow mainWindow;
	private ModeloConsulta modelo;
	
	public Controller(MainWindow mainWindow) {
		
		this.mainWindow = mainWindow;
		this.modelo = new ModeloConsulta(); // Crear instancia del modelo
		
	}
	
	public void showMenuPrincipalWindow() {
		new MenuPrincipalWindow(this);
	}
}