package presentacion;

//nuevo
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.*;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    
    //private ModeloConsulta modeloConsulta;
   // private MenuPrincipalCliente menuPrincipal;
	private Controller controller;
   
    
    public MainWindow() {
    	super("Malbec") ; 
    	controller = new Controller(this);
    	initGUI() ; 
    }
   
    
    private void initGUI() {
    	mainPanel = new JPanel( ) ; 
    	mainPanel.setLayout(new BoxLayout( mainPanel, BoxLayout.Y_AXIS)) ;
    	mainPanel.setAlignmentX(CENTER_ALIGNMENT); // Centrado horizontal
		setContentPane(mainPanel) ; 
	
		//mainPanel.setBackground(new Color(128, 0, 0));
		

		mainPanel.add(Box.createVerticalStrut(30));
		//panel para poner el titulo adentro
		JPanel bienve = new JPanel();
		bienve.setLayout(new BoxLayout(bienve, BoxLayout.X_AXIS));
		bienve.setBackground(new Color(128, 0, 0));
		mainPanel.add(bienve);
		
		JLabel bienvenida= new JLabel("BIENVENIDOS A MALBEC");
		bienvenida.setAlignmentX(CENTER_ALIGNMENT);
		bienvenida.setForeground(Color.WHITE);
		bienvenida.setOpaque(true);
		bienvenida.setBackground(new Color(128, 0, 0));
		bienvenida.setPreferredSize(new Dimension(500, 50));
		bienvenida.setHorizontalAlignment(SwingConstants.CENTER);  
		bienvenida.setFont(new Font(bienvenida.getFont().getName(), Font.BOLD, 24)); 
		bienve.add(bienvenida) ; 
		
		mainPanel.add(Box.createVerticalStrut(50));
		
		JButton cliente = new JButton("CLIENTES") ;
		cliente.setAlignmentX(CENTER_ALIGNMENT) ;
		cliente.setBackground(Color.GRAY); // Fondo blanco
		cliente.setForeground(Color.WHITE); // Texto negro
		cliente.setFont(cliente.getFont().deriveFont(Font.BOLD)); // Texto en negrita
		mainPanel.add(cliente) ;
		
		mainPanel.add(Box.createVerticalStrut(20));
		
		JButton adm = new JButton("ADMINISTRADOR") ;
		adm.setAlignmentX(CENTER_ALIGNMENT) ;
		adm.setBackground(Color.GRAY); // Fondo blanco
		adm.setForeground(Color.WHITE); // Texto negro
		adm.setFont(adm.getFont().deriveFont(Font.BOLD)); // Texto en negrita
		mainPanel.add(adm) ;

		mainPanel.add(Box.createVerticalStrut(20));
		
		JButton empleado = new JButton("EMPLEADO") ;
		empleado.setAlignmentX(CENTER_ALIGNMENT) ;
		empleado.setBackground(Color.GRAY); // Fondo blanco
		empleado.setForeground(Color.WHITE); // Texto negro
		empleado.setFont(empleado.getFont().deriveFont(Font.BOLD)); // Texto en negrita
		mainPanel.add(empleado) ;
       

		cliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.showMenuPrincipalCliente();
            	MainWindow.this.setVisible(false);
            }
        });
		
		empleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.showMenuPrincipalEmpleado();
            	MainWindow.this.setVisible(false);
            }
        });
		
		adm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.showMenuPrincipalAdm();
            	MainWindow.this.setVisible(false);
            }
        });
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500) ) ;

    	pack() ; 
    	setLocationRelativeTo(null) ; 
    	
    }

    
    
    
}
