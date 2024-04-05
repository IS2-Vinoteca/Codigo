package presentacion;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    //private ModeloConsulta modeloConsulta;
    private MenuPrincipalWindow menuPrincipal;
	private Controller controller;
   
    
    public MainWindow() {
    	super("Malbec") ; 
    	controller = new Controller(this);
    	initGUI() ; 
    }
   
    
    private void initGUI() {
    	mainPanel = new JPanel( ) ; 
    	mainPanel.setLayout(new BoxLayout( mainPanel, BoxLayout.Y_AXIS)) ;
		setContentPane(mainPanel) ; 
	
		
		JLabel bienvenida= new JLabel("Bienvenid@, empieza a gestionar tu academia de superheroes!");
		bienvenida.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.add(bienvenida) ; 
		
		JButton menu = new JButton("Menu Principal") ; 
		menu.addActionListener((e)->{
			controller.showMenuPrincipalWindow();
			dispose();
		}) ; 
		
		menu.setAlignmentX(CENTER_ALIGNMENT) ; 
		
		mainPanel.add(menu) ; 
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500) ) ;

    	pack() ; 
    	setLocationRelativeTo(null) ; 
    	
    }
    
    
}
