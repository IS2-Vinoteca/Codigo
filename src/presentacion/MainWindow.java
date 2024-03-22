package presentacion;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel mainPanel;
    private ModeloConsulta modeloConsulta;

    public MainWindow() {
        super("Consulta de Vinos");
        modeloConsulta = new ModeloConsulta();
        initGUI();
    }

    private void initGUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        setContentPane(mainPanel);

        JLabel lblNombreVino = new JLabel("Nombre del Vino:");
        JTextField txtNombreVino = new JTextField(20);
        JButton btnConsulta = new JButton("Consultar");
        JTextArea txtAreaResultado = new JTextArea(10, 30);

        btnConsulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreVino = txtNombreVino.getText();
                String resultado = modeloConsulta.realizarConsulta(nombreVino);
                txtAreaResultado.setText(resultado);
            }
        });

        mainPanel.add(lblNombreVino);
        mainPanel.add(txtNombreVino);
        mainPanel.add(btnConsulta);
        mainPanel.add(new JScrollPane(txtAreaResultado));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}
