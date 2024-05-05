package presentacion;

import javax.swing.*;

import negocio.SAImpUsuario;
import negocio.TransferUsuario;

import java.awt.*;


//LO JUNTAMOS EN LA CLASE ACCIONESUSUARIO??
public class AddUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private JTextField nombreField;
    private JTextField tipoField;
    private JTextField empresaField;

    public AddUsuario(JFrame parent) {
        super(parent, "Añadir Nuevo Usuario", true);
        initComponents();
        pack();
        setLocationRelativeTo(parent);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 10)); // Aumentar el espacio vertical entre componentes

        JLabel nombreLabel = new JLabel("NIF:");
        nombreField = new JTextField();

        JLabel tipoLabel = new JLabel("Nombre:");
        tipoField = new JTextField();

        JLabel empresaLabel = new JLabel("Email:");
        empresaField = new JTextField();

        panel.add(nombreLabel);
        panel.add(nombreField);
        panel.add(tipoLabel);
        panel.add(tipoField);
        panel.add(empresaLabel);
        panel.add(empresaField);

        JButton agregarButton = new JButton("Agregar");
        agregarButton.addActionListener(e -> agregarUsuario());

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(e -> dispose());

        // Establecer un panel para los botones y agregar espacio entre ellos
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(agregarButton);
        buttonPanel.add(cancelarButton);

        panel.add(new JLabel()); // Espacio vacío para mantener el diseño
        panel.add(buttonPanel); // Agregar el panel de botones

        add(panel);
    }

    private void agregarUsuario() {
        try {
            int nif = Integer.parseInt(nombreField.getText());
            String nombre = tipoField.getText();
            String email = empresaField.getText();

            // Lógica para agregar el usuario a la base de datos
            
            TransferUsuario usuario = new TransferUsuario(nif, nombre, email);
            SAImpUsuario saImpUsuario = new SAImpUsuario(usuario);

            
            if(saImpUsuario.addUsuario(usuario) != -1) {
            	JOptionPane.showMessageDialog(this, "El usuario ha sido añadido con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else {
            	JOptionPane.showMessageDialog(this, "El usuario no ha sido añadido", "Error", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            	
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un NIF válido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
