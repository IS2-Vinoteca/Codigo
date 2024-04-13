package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalAdm extends JFrame {

	private static final long serialVersionUID = 1L;

	//private Controller controller;
	private JPanel mainPanel ;
	

	public MenuPrincipalAdm(Controller controller) {
		
		super("Menu") ; 
		//this.controller= controller;
    	initGUI() ;
	}

	private void initGUI() {
		mainPanel = new JPanel( ) ; 
    	mainPanel.setLayout(new BoxLayout( mainPanel, BoxLayout.Y_AXIS)) ;
    	mainPanel.setAlignmentX(CENTER_ALIGNMENT); // Centrado horizontal
		setContentPane(mainPanel) ; 
		mainPanel.setBackground(new Color(128, 0, 0));

		mainPanel.add(Box.createVerticalStrut(30)); 
		
		JLabel Menu = new JLabel ("MENU PRINCIPAL ADMINISTRADOR") ;
		Menu.setAlignmentX(CENTER_ALIGNMENT);
		Menu.setForeground(Color.WHITE);
		Menu.setOpaque(true);
		Menu.setBackground(new Color(128, 0, 0));
		Menu.setPreferredSize(new Dimension(500, 50));
		Menu.setHorizontalAlignment(SwingConstants.CENTER);  
		Menu.setFont(new Font(Menu.getFont().getName(), Font.BOLD, 24)); 
		mainPanel.add(Menu) ; 
		
		
      
		JButton new_usr = new JButton("Agregar usuario");
		new_usr.setAlignmentX(CENTER_ALIGNMENT) ;
		new_usr.setBackground(Color.GRAY); // Fondo blanco
		new_usr.setForeground(Color.WHITE); // Texto negro
		new_usr.setFont(new_usr.getFont().deriveFont(Font.BOLD)); // Texto en negrita
		new_usr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirDialogoNuevoUsuario();
            }
        });
        mainPanel.add(new_usr);
           
        
		pack() ;
		setLocationRelativeTo(null) ; 
		setVisible(true) ; 
	}
	
	  private void abrirDialogoNuevoUsuario() {
	    	AddUsuario nuevoUsuario = new AddUsuario(this);
	        nuevoUsuario.setVisible(true);
	    }
    
}
