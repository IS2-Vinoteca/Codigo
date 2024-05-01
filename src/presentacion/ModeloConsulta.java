package presentacion;

import javax.swing.*;
import negocio.SAImpVino;


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
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(mainPanel);
        
       
        SAImpVino saImpVino = new SAImpVino();

        JLabel lblNombreVino = new JLabel("Nombre del Vino:");
        JTextField txtNombreVino = new JTextField(20);
        JButton btnConsulta = new JButton("Consultar");
        JTextArea txtAreaResultado = new JTextArea(10, 30);
        txtAreaResultado.setEditable(false); // Hacer el área de texto de resultado no editable

        btnConsulta.addActionListener(e -> {
            String nombreVino = txtNombreVino.getText();            
            String resultado = saImpVino.realizarConsultaVino(nombreVino);
            txtAreaResultado.setText(resultado);
        });
        
     //   mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Crear un panel para los controles y establecer espacios entre ellos
        JPanel controlPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        controlPanel.add(lblNombreVino);
        controlPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        controlPanel.add(txtNombreVino);

        mainPanel.add(controlPanel);
        mainPanel.add(btnConsulta);
        mainPanel.add(new JScrollPane(txtAreaResultado));
        
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnConsulta);

        JPanel resultPanel = new JPanel();
        resultPanel.add(new JScrollPane(txtAreaResultado));

        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(btnPanel, BorderLayout.CENTER);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);


        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Cambio aquí
        setPreferredSize(new Dimension(400, 300));
        pack();
    }
}
