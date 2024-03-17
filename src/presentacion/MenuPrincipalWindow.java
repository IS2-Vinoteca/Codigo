package presentacion;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuPrincipalWindow extends JFrame{

	private Controller controller;
	private JPanel mainPanel ;
	

	public MenuPrincipalWindow(Controller controller) {
		
		super("Menu") ; 
		this.controller= controller;
    	initGUI() ;
	}

	private void initGUI() {
		mainPanel = new JPanel() ; 
		mainPanel.setLayout(new BoxLayout( mainPanel, BoxLayout.Y_AXIS) ) ;
		setContentPane(mainPanel); 
		 
		
		JLabel Menu = new JLabel ("MENU PRINCIPAL") ;
		Menu.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(Menu) ; 
		
		
//		ContentPanel botones = new ContentPanel(ctrl) ;
//		botones.setAlignmentX(CENTER_ALIGNMENT);
//		mainPanel.add(botones); 
		
		pack() ;
		setLocationRelativeTo(null) ; 
		setVisible(true) ; 
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
