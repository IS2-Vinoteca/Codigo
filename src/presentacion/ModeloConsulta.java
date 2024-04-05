package presentacion;

import java.awt.*;
import javax.swing.*;

import integracion.DAOImpVino;

public class ModeloConsulta extends JDialog {

    public ModeloConsulta(JFrame parent) {
        super(parent, "Consultar vinos", true);
        initGUI();
        pack();
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

        btnConsulta.addActionListener(e -> {
            String nombreVino = txtNombreVino.getText();     
            //DAOImpVino realiza la consulta
            DAOImpVino consultaVino = new DAOImpVino();
            String resultado = consultaVino.realizarConsulta(nombreVino);
            txtAreaResultado.setText(resultado);

        });

        mainPanel.add(lblNombreVino);
        mainPanel.add(txtNombreVino);
        mainPanel.add(btnConsulta);
        mainPanel.add(new JScrollPane(txtAreaResultado));

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Cambio aquí
        setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(null);
    }



}


