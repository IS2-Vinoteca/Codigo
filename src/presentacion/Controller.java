package presentacion;

public class Controller {

	private MainWindow mainWindow;
	
	public Controller(MainWindow mainWindow) {
		
		this.mainWindow = mainWindow;
		
	}
	
	public void showMenuPrincipalCliente() {
		new MenuPrincipalCliente(this);
	}
	
	public void showMenuPrincipalEmpleado() {
		new MenuPrincipalEmpleado(this);
	}
	
	public void showMenuPrincipalAdm() {
		new MenuPrincipalAdm(this);
	}
	
}