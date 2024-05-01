package presentacion;

import java.io.IOException;

import javax.swing.SwingUtilities;


public class Main {
	
	/*
	 * 
	 * HAY QUE SEPARAR LA CLASE MODELOCONSULTA EN DBCONNECTION, EN DAOVINO IMPLEMENTAR METODO DE CONSULTA
	 */
	
	private static Controller control;
	
	private static void startGUIMode(Controller control) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Aquí creamos una instancia de la ventana principal y la hacemos visible
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });
    }
	
	public static void main(String[] args) {
		
		control = new Controller(new MainWindow());
		/*DBConnection dbConnection = new DBConnection();
		dbConnection.executeQuery();*/
		
		 try {
	            startGUIMode(control); // Llamamos al método startGUIMode() para iniciar la interfaz gráfica
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}
	
	
	
	
}