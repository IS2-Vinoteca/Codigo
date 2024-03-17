package presentacion;

import java.io.IOException;


import javax.swing.SwingUtilities;

public class Main {
	
	private static Controller control;
	
	private static void startGUIMode(Controller control) throws IOException {
				
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new MainWindow();
			}
		});
	}
	
	public static void main(String[] args) {
		
		control = new Controller(new MainWindow());
	}
	
	
}