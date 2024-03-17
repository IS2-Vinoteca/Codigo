package presentacion;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.*;


public class MainWindow extends JFrame{
 
	private static final long serialVersionUID = 1L;


	private JLabel logo  ; 
	private JPanel mainPanel;
	private Controller controller;

    public MainWindow() {
    	super("Soul Agency") ; 
    	controller = new Controller(this);
    	initGUI() ; 
    	System.out.printf("hol");
    }
   
    
    private void initGUI() {
    	mainPanel = new JPanel( ) ; 
    	mainPanel.setLayout(new BoxLayout( mainPanel, BoxLayout.Y_AXIS)) ;
		setContentPane(mainPanel) ; 
		
		 logo = new  JLabel() ; 
		ImageIcon lo = new ImageIcon("./resources/images/logo.png") ; 
		 Image imagen = lo.getImage();
		Image imagenRedimensionada = imagen.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	    ImageIcon  logo_final = new ImageIcon(imagenRedimensionada);
	    logo.setAlignmentX(CENTER_ALIGNMENT);  
		logo.setIcon(logo_final);
		
   
		mainPanel.add(logo)   ; 
		
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
		
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500) ) ;

    	pack() ; 
    	setLocationRelativeTo(null) ; 
    	
    }

}
