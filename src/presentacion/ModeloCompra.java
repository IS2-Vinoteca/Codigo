package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import negocio.Ventas;
import negocio.Vino;

public class ModeloCompra extends JFrame{

	private static final long serialVersionUID = 1L;
    //private JPanel mainPanel;
//    private Controller controller;
	private List<Vino> carritoCompras;
	private int cantidad;
	private Ventas venta;

    public ModeloCompra(JFrame parent) {
		super();
		initGUI();
		//pack();
		carritoCompras = new ArrayList<>();
		venta = new Ventas();
		setLocationRelativeTo(parent);
	}
    private void initGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(CENTER_ALIGNMENT); // Centrado horizontal
        setContentPane(mainPanel);

        // Cambiar el color de fondo del panel principal para simular una vinoteca
      //  mainPanel.setBackground(new Color(128, 0, 0));

        mainPanel.add(Box.createVerticalStrut(30));

        // Panel para el título "COMPRAR VINOS"
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(128, 0, 0)); 
        titlePanel.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(titlePanel);

        JLabel titleLabel = new JLabel("COMPRAR VINOS");
        titleLabel.setForeground(Color.WHITE); // Texto en blanco
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Fuente y tamaño del texto
        titlePanel.add(titleLabel);

        mainPanel.add(Box.createVerticalStrut(20));

        // Panel para el catálogo de vinos
        JPanel catalogPanel = new JPanel();
        catalogPanel.setLayout(new GridLayout(0, 3)); // 3 columnas para mostrar vinos
        catalogPanel.setAlignmentX(CENTER_ALIGNMENT);
        catalogPanel.setBackground(Color.GRAY); // Color gris

        // Agregar pestañas para cada vino en el catálogo
        //chequear con el catalogo
        Vino v = new Vino();
        List<Vino> listaVinos = v.buscarVinos();
        System.out.println(listaVinos.toString());
        for (int i = 1; i <= 9; i++) {
        	//"Vino " + listaVinos.get(i).getType(), "Descripción del vino " + listaVinos.get(i).getDescription())
            catalogPanel.add(createWineTab(listaVinos.get(i)));
        }
        mainPanel.add(catalogPanel);

        mainPanel.add(Box.createVerticalStrut(30));

        // Botón "Confirmar Compra"
        JButton confirmButton = new JButton("Confirmar Compra");
        confirmButton.setAlignmentX(CENTER_ALIGNMENT);
        confirmButton.setBackground(new Color(128, 0, 0)); // Color bordo
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(confirmButton.getFont().deriveFont(Font.BOLD));
        confirmButton.setPreferredSize(new Dimension(200, 40)); // Tamaño uniforme
        mainPanel.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carritoCompras.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El carrito de compras está vacío");
                } else {
                    // Aquí mandamos los datos al SAVentas para gestionar la venta
                    Ventas ventas = new Ventas();
                    for (Vino vino : carritoCompras) {
                        ventas.registrarVenta(new Date(), vino.getWine(), venta.getCantidad(), vino.getPrice());
                    }
                    JOptionPane.showMessageDialog(null, "Compra realizada con éxito");
                    carritoCompras.clear(); // Limpiamos el carrito después de confirmar la compra
                }
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();
       // setLocationRelativeTo(null);
    }

    //  crear una pestaña de vino con título y descripción
    private JPanel createWineTab(Vino v) {
    	//Vino vino = new Vino();
    	
        JPanel tabPanel = new JPanel();
        tabPanel.setBackground(Color.GRAY); // Fondo gris
        tabPanel.setBorder(BorderFactory.createLineBorder(new Color(128, 0, 0), 1)); // Borde bordo
        tabPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel(v.getWine(), SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente y tamaño del título
        titleLabel.setForeground(Color.WHITE); // Texto en blanco
        tabPanel.add(titleLabel, BorderLayout.NORTH);

        JTextArea descriptionArea = new JTextArea(v.getDescription());
        descriptionArea.setEditable(false); // No editable
        descriptionArea.setLineWrap(true); // Ajuste de línea
        descriptionArea.setWrapStyleWord(true); // Ajuste de palabra
        descriptionArea.setBackground(Color.GRAY); // Fondo gris
        descriptionArea.setForeground(Color.WHITE); // Texto en blanco
        tabPanel.add(descriptionArea, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.setBackground(Color.GRAY);

        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        buttonPanel.add(spinner);

        JButton addButton = new JButton("Agregar al Carrito");
        addButton.setBackground(new Color(128, 0, 0));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(addButton.getFont().deriveFont(Font.BOLD));
        buttonPanel.add(addButton);

        tabPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Agregar lógica para agregar el vino al carrito
            	int cantidad = (int) spinner.getValue();
            	venta.setCantidad(cantidad);
            	//vino que seleccionamos
            	carritoCompras.add(v);
            	
            }
        });

        return tabPanel;
    }
}
