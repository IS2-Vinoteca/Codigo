
package presentacion;
import javax.swing.*;

import integracion.DAOImpUsuario;
import negocio.TUsuario;
import java.awt.*;

public class AddUsuario extends JDialog {

    private JTextField nombreField;
    private JTextField tipoField;
    private JTextField empresaField;

    public AddUsuario(JFrame parent) {
        super(parent, "Añadir Nuevo Usuario", true);
        initGUI();
        pack();
        setLocationRelativeTo(parent);
    }

    private void initGUI() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        JLabel nombreLabel = new JLabel("Nif:");
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
        agregarButton.addActionListener(e -> {
            // Obtener los datos ingresados
            String nif = nombreField.getText();
            String nombre = tipoField.getText();
            String email = empresaField.getText();

            // Crear un nuevo usuario con los datos ingresados
            DAOImpUsuario nuevoUsuario = new DAOImpUsuario();
            TUsuario new_user = new TUsuario(nif, nombre, email);

            // Guardar el nuevo usuario en la base de datos
            int resultado = nuevoUsuario.crearUsuario(new_user);

            // Verificar el resultado de la operación
            if (resultado > 0) {
                // La inserción fue exitosa
                JOptionPane.showMessageDialog(null, "El usuario ha sido añadido con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // La inserción falló
                JOptionPane.showMessageDialog(null, "Error al agregar usuario", "Error", JOptionPane.ERROR_MESSAGE);
            }
            // Cerrar el diálogo
            dispose();
        });

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.addActionListener(e -> dispose());

        panel.add(agregarButton);
        panel.add(cancelarButton);

        add(panel);
    }
}
