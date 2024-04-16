package presentacion;

import javax.swing.*;
import integracion.DAOImpVino;
import java.awt.*;

public class ModeloConsulta extends JDialog {

    private static final long serialVersionUID = 1L;

    public ModeloConsulta(JFrame parent) {
        super(parent, "Consultar vinos", true);
        initGUI();
        setLocationRelativeTo(parent);
    }

    private void initGUI() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        setContentPane(mainPanel);

        JLabel lblNombreVino = new JLabel("Nombre del Vino:");
        JTextField txtNombreVino = new JTextField(20);
        JButton btnConsulta = new JButton("Consultar");
        JTextArea txtAreaResultado = new JTextArea(10, 30);
        txtAreaResultado.setEditable(false); // Hacer el área de texto de resultado no editable

        btnConsulta.addActionListener(e -> {
            String nombreVino = txtNombreVino.getText();
            DAOImpVino consultaVino = new DAOImpVino();
            String resultado = consultaVino.realizarConsultaVino(nombreVino);
            txtAreaResultado.setText(resultado);
        });

        // Crear un panel para los controles y establecer espacios entre ellos
        JPanel controlPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        controlPanel.add(lblNombreVino);
        controlPanel.add(txtNombreVino);

        mainPanel.add(controlPanel);
        mainPanel.add(btnConsulta);
        mainPanel.add(new JScrollPane(txtAreaResultado));

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Cambio aquí
        setPreferredSize(new Dimension(400, 300));
        pack();
    }
}
