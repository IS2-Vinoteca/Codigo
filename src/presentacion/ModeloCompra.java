package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import negocio.CartonDecorator;
import negocio.MaderaDecorator;
import negocio.SAImpVentas;
import negocio.SAImpVino;
import negocio.TransferVentas;
import negocio.TransferVino;
import negocio.VidrioDecorator;

public class ModeloCompra extends JFrame {

    private static final long serialVersionUID = 1L;
    private List<TransferVino> carritoCompras;
    private TransferVentas venta;

    public ModeloCompra(JFrame parent) {
        super();
        initGUI();
        carritoCompras = new ArrayList<>();
        venta = new TransferVentas();
        setLocationRelativeTo(parent);
    }

    private void initGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setAlignmentX(CENTER_ALIGNMENT);
        setContentPane(mainPanel);
        mainPanel.setPreferredSize(new Dimension(600, 400));
       

        mainPanel.add(Box.createVerticalStrut(30));
        
        
        JLabel titleLabel = new JLabel("COMPRAR VINOS");
        titleLabel.setForeground(new Color(128, 0, 0));
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16)); // Reducir el tamaño del título
        titleLabel.setAlignmentX(CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);

        mainPanel.add(Box.createVerticalStrut(20));

        JPanel catalogPanel = new JPanel();
        catalogPanel.setLayout(new GridLayout(0, 3));
        catalogPanel.setAlignmentX(CENTER_ALIGNMENT);
        catalogPanel.setBackground(Color.GRAY);
        

        //recorremos la lista de vinos y creamos un panel para cada uno
        
        TransferVino v = new TransferVino();
        SAImpVino saImpVino = SAImpVino.getInstance();
        List<TransferVino> listaVinos = saImpVino.realizarConsultaCatalogo();

        for (TransferVino vino : listaVinos) {
            catalogPanel.add(createWineTab(vino));
        }

        //agregamos el scrollpane para poder ver los vinos
        JScrollPane scrollPane = new JScrollPane(catalogPanel);      
        scrollPane.setPreferredSize(new Dimension(600, 200));     
        
        this.addComponentListener(new ComponentAdapter() { //esto es para que el ScrollPane se situa arriba del todo de la tabla
            @Override
            public void componentShown(ComponentEvent e) {
                // Asegura que el JScrollPane se posicione al principio
                scrollPane.getViewport().setViewPosition(new Point(0, 0));
            }
        });
        mainPanel.add(scrollPane);

        mainPanel.add(Box.createVerticalStrut(30));

        JButton confirmButton = new JButton("Confirmar Compra");
        confirmButton.setAlignmentX(CENTER_ALIGNMENT);
        confirmButton.setBackground(new Color(128, 0, 0));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(confirmButton.getFont().deriveFont(Font.BOLD));
        confirmButton.setPreferredSize(new Dimension(200, 40));
        mainPanel.add(confirmButton);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carritoCompras.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El carrito de compras está vacío");
                } else {
                	SAImpVentas saImpVentas = SAImpVentas.getInstance();
                    for (TransferVino vino : carritoCompras) {
                    	saImpVentas.registrarVenta(new Date(), vino.getWine(), venta.getCantidad(), vino.getPrice());
                    }
                    JOptionPane.showMessageDialog(null, "Compra realizada con éxito");
                    carritoCompras.clear();
                }
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));
        pack();
    }

    private JPanel createWineTab(TransferVino v) {
        JPanel tabPanel = new JPanel();
        tabPanel.setBackground(Color.GRAY);
        tabPanel.setBorder(BorderFactory.createLineBorder(new Color(128, 0, 0), 1));
        tabPanel.setLayout(new BorderLayout());
        //tamaño de los cuadritos
        tabPanel.setPreferredSize(new Dimension(180, 160)); // Ajusta el tamaño del panel del vino

        
        JLabel titleLabel = new JLabel(v.getWine(), SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        tabPanel.add(titleLabel, BorderLayout.NORTH);

        
        JTextArea descriptionArea = new JTextArea(v.getDescription());
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setBackground(Color.GRAY);
        descriptionArea.setForeground(Color.WHITE);
        tabPanel.add(descriptionArea, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.setBackground(Color.GRAY);

        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1)); //para que agregue la cantidad de vinos de un tipo
        buttonPanel.add(spinner);
        
        JLabel precio = new JLabel(v.getPrice()+ "");
        buttonPanel.add(precio, BorderLayout.WEST);
        
        JComboBox<String> embotellado = new JComboBox<>(new String[] {"Normal", "Carton", "Madera", "Vidrio"});
        buttonPanel.add(embotellado, BorderLayout.EAST);
        embotellado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) embotellado.getSelectedItem();
                int cantidad = (int)spinner.getValue();
                switch (selected) {
                case "Carton":
                	precio.setText(new CartonDecorator(v).getPrecio() * cantidad +"");
                	break;
                case "Madera":
                	precio.setText(new MaderaDecorator(v).getPrecio() * cantidad+"");
                	break;
                case "Vidrio":
                	precio.setText(new VidrioDecorator(v).getPrecio() * cantidad+"");
                	break;
                default:
                	precio.setText(v.getPrecio() * cantidad +"");
                }
            }
        });
        
        

        JButton addButton = new JButton("Agregar al Carrito");
        addButton.setBackground(new Color(128, 0, 0));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(addButton.getFont().deriveFont(Font.BOLD));
        buttonPanel.add(addButton);

        tabPanel.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cantidad = (int) spinner.getValue();
                String price = precio.getText();
                double precio = Double.parseDouble(price);
                venta.setPrecio(precio);
                venta.setCantidad(cantidad); //se lo mandamos a la clase ventas
                venta.setIncidencia("0");
                carritoCompras.add(v); 
            }
        });

        return tabPanel;
    }
    
    
    
    
}