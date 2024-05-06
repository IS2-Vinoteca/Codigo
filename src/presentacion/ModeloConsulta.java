package presentacion;

import javax.swing.*;
import java.awt.*;
import negocio.SAImpVino;

public class ModeloConsulta extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private JComboBox<String> comboBox;
    private JTextField txtField;
    private JButton btnConsulta;
    private JTextArea txtAreaResultado;
    private JPanel consultaPanel;
    private String[] opciones = {"Nombre del Vino", "Bodega", "Año", "Precio", "Porcentaje de Alcohol", "Sabor"};

    public ModeloConsulta(JFrame parent) {
        super(parent, "Consultar vinos", true);
        initGUI();
        setLocationRelativeTo(parent);
    }
   

    private void initGUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);
        mainPanel.setPreferredSize(new Dimension(400, 200));
        
        comboBox = new JComboBox<>(opciones);
        comboBox.setSelectedIndex(0);
        comboBox.addActionListener(e -> {
            String selected = (String) comboBox.getSelectedItem();
            mostrarPanelConsulta(selected); // Cambiado de consultar(selected) a mostrarPanelConsulta(selected)
        });

        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.add(comboBox);

        mainPanel.add(comboBoxPanel, BorderLayout.NORTH);

        pack();
    }

    private void mostrarPanelConsulta(String selected) {
        // Limpia el mainPanel antes de mostrar el nuevo panel de consulta
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
        
        mainPanel.setPreferredSize(new Dimension(400, 200));

        consultaPanel = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel(selected + ":");
        txtField = new JTextField(15);
        btnConsulta = new JButton("Consultar");
        btnConsulta.addActionListener(e -> {
            consultar(selected);
        });
        
        txtAreaResultado = new JTextArea(10, 15);
        txtAreaResultado.setEditable(false); // Para evitar que el usuario modifique el resultado

        JPanel panelConsulta = new JPanel(new FlowLayout());
       
        panelConsulta.add(txtField);
        panelConsulta.add(btnConsulta);

        consultaPanel.add(lbl, BorderLayout.WEST);
        consultaPanel.add(panelConsulta, BorderLayout.CENTER);
        consultaPanel.add(txtAreaResultado, BorderLayout.SOUTH);

        mainPanel.add(consultaPanel, BorderLayout.NORTH);
        
        
        // Ajusta el tamaño de la ventana para que quepa todo el contenido
        pack();
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void consultar(String selected) {
        String consulta = txtField.getText();
        SAImpVino saImpVino = SAImpVino.getInstance();
        String resultado = "";

        switch (selected) {
            case "Nombre del Vino":
                resultado = saImpVino.realizarConsultaVino(consulta);
                break;
            case "Bodega":
                resultado = saImpVino.realizarConsultaBodega(consulta);
                break;
            case "Año":
                resultado = saImpVino.realizarConsultaYear(Integer.parseInt(consulta));
                break;
            case "Precio":
                String[] precios = consulta.split(",");
                resultado = saImpVino.realizarConsultaPrecio(Double.parseDouble(precios[0]),
                        Double.parseDouble(precios[1]));
                break;
            case "Porcentaje de Alcohol":
                resultado = saImpVino.realizarConsultaAlcohol(Double.parseDouble(consulta));
                break;
            case "Sabor":
                resultado = saImpVino.realizarConsultaTaste(consulta);
                break;
        }

        txtAreaResultado.setText(resultado);
    }
}