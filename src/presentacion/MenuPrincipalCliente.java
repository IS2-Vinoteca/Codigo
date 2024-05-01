package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalCliente extends JFrame{

	//private Controller controller;
	private JPanel mainPanel ;
	

	public MenuPrincipalCliente(Controller controller) {
		
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
		
		JLabel Menu = new JLabel ("MENU PRINCIPAL CLIENTES") ;
		Menu.setAlignmentX(CENTER_ALIGNMENT);
		Menu.setForeground(Color.WHITE);
		Menu.setOpaque(true);
		Menu.setBackground(new Color(128, 0, 0));
		Menu.setPreferredSize(new Dimension(500, 50));
		Menu.setHorizontalAlignment(SwingConstants.CENTER);  
		Menu.setFont(new Font(Menu.getFont().getName(), Font.BOLD, 24)); 
		mainPanel.add(Menu) ; 
		 
		mainPanel.add(Box.createVerticalStrut(30));
		 
        JButton consulta_vinos = new JButton("Consultar vinos");
        consulta_vinos.setAlignmentX(CENTER_ALIGNMENT) ;
        consulta_vinos.setBackground(Color.GRAY); // Fondo blanco
        consulta_vinos.setForeground(Color.WHITE); // Texto negro
        consulta_vinos.setFont(consulta_vinos.getFont().deriveFont(Font.BOLD)); // Texto en negrita
        consulta_vinos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	abrirDialogoConsulta();
            }
        });
        mainPanel.add(consulta_vinos);
        mainPanel.add(Box.createVerticalStrut(20));

        JButton comprar_vinos = new JButton("Comprar vinos");
        comprar_vinos.setAlignmentX(CENTER_ALIGNMENT) ;
        comprar_vinos.setBackground(Color.GRAY); // Fondo blanco
        comprar_vinos.setForeground(Color.WHITE); // Texto negro
        comprar_vinos.setFont(comprar_vinos.getFont().deriveFont(Font.BOLD)); // Texto en negrita
        comprar_vinos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	abrirDialogoCompra();
            }
        });
        mainPanel.add(comprar_vinos);
        
		pack() ;
		setLocationRelativeTo(null) ; 
		setVisible(true) ; 
	}
	
    private void abrirDialogoConsulta() {
        ModeloConsulta consulta = new ModeloConsulta(this);
        consulta.setVisible(true);
    }
    
    private void abrirDialogoCompra() {
        ModeloCompra compra = new ModeloCompra(this);
        compra.setVisible(true);
    }
    
    
	private static final long serialVersionUID = 1L;
	

}
