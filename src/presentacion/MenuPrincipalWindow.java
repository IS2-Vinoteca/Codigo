package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		JButton nuevoUsuarioButton = new JButton("Añadir Nuevo Usuario");
        nuevoUsuarioButton.setAlignmentX(CENTER_ALIGNMENT);
        nuevoUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirDialogoNuevoUsuario();
            }
        });
        mainPanel.add(nuevoUsuarioButton);
        
        JButton consulta_vinos = new JButton("Consultar vinos");
        consulta_vinos.setAlignmentX(CENTER_ALIGNMENT);
        consulta_vinos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	abrirDialogoConsulta();
            }
        });
        mainPanel.add(consulta_vinos);
        
		pack() ;
		setLocationRelativeTo(null) ; 
		setVisible(true) ; 
	}
	
    private void abrirDialogoNuevoUsuario() {
    	AddUsuario nuevoUsuario = new AddUsuario(this);
        nuevoUsuario.setVisible(true);
    }

    private void abrirDialogoConsulta() {
        ModeloConsulta consulta = new ModeloConsulta(this);
        consulta.setVisible(true);
    }
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
