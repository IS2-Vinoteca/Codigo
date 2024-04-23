package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuPrincipalEmpleado extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;

    public MenuPrincipalEmpleado(Controller controller) {
        super("Menu");
        initGUI();
    }

    private void initGUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(CENTER_ALIGNMENT); // Centrado horizontal
        setContentPane(mainPanel);
        mainPanel.setBackground(new Color(128, 0, 0));

        mainPanel.add(Box.createVerticalStrut(30));

        JLabel Menu = new JLabel("MENU PRINCIPAL EMPLEADOS");
        
        Menu.setAlignmentX(CENTER_ALIGNMENT);
        Menu.setForeground(Color.WHITE);
        Menu.setOpaque(true);
        Menu.setBackground(new Color(128, 0, 0));
        Menu.setPreferredSize(new Dimension(500, 50));
        Menu.setHorizontalAlignment(SwingConstants.CENTER);
        Menu.setFont(new Font(Menu.getFont().getName(), Font.BOLD, 24));
        mainPanel.add(Menu);

        mainPanel.add(Box.createVerticalStrut(30));
        // Botón para mostrar el listado de ventas
        JButton btnListadoVentas = new JButton("Listado de Ventas");        
        btnListadoVentas.setAlignmentX(CENTER_ALIGNMENT) ;
        btnListadoVentas.setBackground(Color.GRAY); // Fondo blanco
        btnListadoVentas.setForeground(Color.WHITE); // Texto negro
        btnListadoVentas.setFont(btnListadoVentas.getFont().deriveFont(Font.BOLD)); // Texto en negrita
        btnListadoVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar el listado de ventas
                // Puedes llamar a un método en el controlador para manejar esta acción
            	abrirDialogoListado();
            }
        });
        mainPanel.add(btnListadoVentas);

        mainPanel.add(Box.createVerticalStrut(30));
        
        // Botón para mostrar el listado de incidencias
        JButton btnListadoIncidencias = new JButton("Listado de Incidencias");
        btnListadoIncidencias.setAlignmentX(CENTER_ALIGNMENT) ;
        btnListadoIncidencias.setBackground(Color.GRAY); // Fondo blanco
        btnListadoIncidencias.setForeground(Color.WHITE); // Texto negro
        btnListadoIncidencias.setFont(btnListadoVentas.getFont().deriveFont(Font.BOLD));
        
        btnListadoIncidencias.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar el listado de incidencias
                // Puedes llamar a un método en el controlador para manejar esta acción
            	abrirDialogoListadoIncidencias();
            }
        });
        mainPanel.add(btnListadoIncidencias);
        
        

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void abrirDialogoListado() {
    	ModeloVenta ventas = new ModeloVenta(this, "ventas");
    	ventas.setVisible(true);
    }
    private void abrirDialogoListadoIncidencias() {
    	ModeloVenta ventas = new ModeloVenta(this, "incidencias");
    	ventas.setVisible(true);
    }
}
